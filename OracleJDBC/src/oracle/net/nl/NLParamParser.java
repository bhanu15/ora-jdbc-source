// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(5) braces fieldsfirst noctor nonlb space lnc

package oracle.net.nl;

import java.io.*;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.StringTokenizer;
import java.util.Vector;

// Referenced classes of package oracle.net.nl:
// NLException, NVPair, NVFactory

public class NLParamParser {

    private String filename;
    private Hashtable ht;
    private Vector linebuffer;
    private int filePermissions;
    private int Commentcnt;
    private int nvStringcnt;
    private int Groupcnt;
    private boolean hasComments;
    private boolean hasGroups;
    private String errstr[];
    private int errstrcnt;
    public static final byte IGNORE_NONE = 0;
    public static final byte IGNORE_NL_EXCEPTION = 1;
    public static final byte IGNORE_FILE_EXCEPTION = 2;
    public static final byte NLPASUCC = 1;
    public static final byte NLPAOVWR = 2;
    public static final byte NLPAFAIL = -1;
    private static boolean DEBUG = false;

    public static NLParamParser createEmptyParamParser() {
        return new NLParamParser();
    }

    private NLParamParser() {
        filePermissions = 0;
        Commentcnt = 0;
        nvStringcnt = 0;
        Groupcnt = 0;
        hasComments = false;
        hasGroups = false;
        filename = null;
        ht = new Hashtable(128);
    }

    public NLParamParser(String s) throws IOException, NLException {
        this(s, (byte) 2);
    }

    public NLParamParser(String s, byte byte0) throws NLException, IOException {
        filePermissions = 0;
        Commentcnt = 0;
        nvStringcnt = 0;
        Groupcnt = 0;
        hasComments = false;
        hasGroups = false;
        filename = s;
        ht = new Hashtable(128);
        FileReader filereader = null;
        BufferedReader bufferedreader = null;
        try {
            filereader = new FileReader(s);
            bufferedreader = new BufferedReader(filereader);
            initializeNlpa(bufferedreader, byte0);
        } catch (FileNotFoundException filenotfoundexception) {
            if ((byte0 & 2) == 0) {
                throw new FileNotFoundException(s);
            }
        } finally {
            if (filereader != null) {
                filereader.close();
            }
            if (bufferedreader != null) {
                bufferedreader.close();
            }
        }
    }

    public NLParamParser(Reader reader) throws IOException, NLException {
        this(reader, (byte) 0);
    }

    public NLParamParser(Reader reader, byte byte0) throws IOException, NLException {
        filePermissions = 0;
        Commentcnt = 0;
        nvStringcnt = 0;
        Groupcnt = 0;
        hasComments = false;
        hasGroups = false;
        BufferedReader bufferedreader = new BufferedReader(reader);
        filename = null;
        ht = new Hashtable(128);
        initializeNlpa(bufferedreader, byte0);
    }

    private void initializeNlpa(BufferedReader bufferedreader, byte byte0) throws IOException,
            NLException {
        linebuffer = new Vector(100, 50);
        errstr = new String[50];
        try {
            do {
                String s = bufferedreader.readLine();
                if (s == null) {
                    break;
                }
                linebuffer.addElement(s);
            } while (true);
        } catch (IOException ioexception) {
            if ((byte0 & 2) == 0) {
                throw new IOException("Unable to read a line from : " + filename);
            }
        }
        String s1 = "";
        String s3 = System.getProperty("line.separator");
        String s4 = "";
        String s5 = "";
        for (int i = 0; i < linebuffer.size(); i++) {
            String s2 = (String) linebuffer.elementAt(i);
            if (s2.length() == 0) {
                continue;
            }
            if (s2.charAt(0) == '#') {
                if (s2.indexOf(".ORA Configuration ") != -1
                        || s2.indexOf(" Network Configuration File: ") != -1
                        || s2.indexOf("Generated by") != -1) {
                    if (DEBUG) {
                        System.out.println(s2 + ": this comment ignored");
                    }
                    continue;
                }
                if (s4.length() != 0) {
                    s5 = s5 + s2 + s3;
                    continue;
                }
                s4 = "COMMENT#" + Commentcnt;
                s5 = s2 + s3;
                if (!hasComments) {
                    hasComments = true;
                }
                continue;
            }
            if (s2.charAt(0) == ' ' || s2.charAt(0) == '\t' || s2.charAt(0) == ')') {
                if (s5.length() == 0) {
                    if (s1.length() == 0) {
                        s2 = eatNLPWS(s2);
                    }
                    s2 = checkNLPforComments(s2);
                    if (s2.length() != 0) {
                        s1 = s1 + s2 + s3;
                    }
                    continue;
                }
                if (s1.length() == 0 && s5.length() != 0) {
                    s2 = eatNLPWS(s2);
                    s2 = checkNLPforComments(s2);
                    if (s2.length() != 0 && (byte0 & 1) == 0) {
                        throw new NLException("InvalidChar-04611", "");
                    }
                    continue;
                }
                if (s1.length() != 0 && s5.length() != 0) {
                    s4 = "";
                    s5 = "";
                    s2 = checkNLPforComments(s2);
                    s1 = s1 + s2 + s3;
                }
                continue;
            }
            if (s1.length() == 0 && s5.length() == 0) {
                s2 = checkNLPforComments(s2);
                s1 = s1 + s2 + s3;
                continue;
            }
            if (s1.length() == 0 && s5.length() != 0) {
                s5 = modifyCommentString(s5);
                try {
                    addNLPListElement(s4 + "=" + s5);
                } catch (NLException nlexception2) {
                    errstr[errstrcnt++] = s1;
                    if ((byte0 & 1) == 0) {
                        throw nlexception2;
                    }
                }
                s4 = "";
                s5 = "";
                Commentcnt++;
                s2 = checkNLPforComments(s2);
                s1 = s1 + s2 + s3;
                continue;
            }
            if (s1.length() != 0 && s5.length() == 0) {
                try {
                    addNLPListElement(s1);
                } catch (NLException nlexception3) {
                    errstr[errstrcnt++] = s1;
                    if ((byte0 & 1) == 0) {
                        throw nlexception3;
                    }
                }
                s1 = "";
                s2 = checkNLPforComments(s2);
                s1 = s1 + s2 + s3;
                continue;
            }
            if (s1.length() == 0 || s5.length() == 0) {
                continue;
            }
            try {
                addNLPListElement(s1);
            } catch (NLException nlexception4) {
                errstr[errstrcnt++] = s1;
                if ((byte0 & 1) == 0) {
                    throw nlexception4;
                }
            }
            s1 = "";
            s2 = checkNLPforComments(s2);
            s1 = s1 + s2 + s3;
            s5 = modifyCommentString(s5);
            try {
                addNLPListElement(s4 + "=" + s5);
            } catch (NLException nlexception5) {
                errstr[errstrcnt++] = s1;
                if ((byte0 & 1) == 0) {
                    throw nlexception5;
                }
            }
            s4 = "";
            s5 = "";
            Commentcnt++;
        }

        if (s1.length() != 0) {
            try {
                addNLPListElement(s1);
            } catch (NLException nlexception) {
                errstr[errstrcnt++] = s1;
                if ((byte0 & 1) == 0) {
                    throw nlexception;
                }
            }
            s1 = "";
        }
        if (s5.length() != 0) {
            s5 = modifyCommentString(s5);
            try {
                addNLPListElement(s4 + "=" + s5);
            } catch (NLException nlexception1) {
                errstr[errstrcnt++] = s1;
                if ((byte0 & 1) == 0) {
                    throw nlexception1;
                }
            }
            s4 = "";
            s5 = "";
            Commentcnt++;
        }
    }

    private String modifyCommentString(String s) {
        String s1 = "";
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
            case 40: // '('
                s1 = s1 + "\\(";
                break;

            case 61: // '='
                s1 = s1 + "\\=";
                break;

            case 41: // ')'
                s1 = s1 + "\\)";
                break;

            case 44: // ','
                s1 = s1 + "\\,";
                break;

            case 92: // '\\'
                s1 = s1 + "\\\\";
                break;

            default:
                s1 = s1 + s.charAt(i);
                break;
            }
        }

        return s1;
    }

    private String checkNLPforComments(String s) {
        StringBuffer stringbuffer = new StringBuffer(s.length());
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '#') {
                if (i != 0) {
                    if (s.charAt(i - 1) != '\\') {
                        break;
                    }
                    stringbuffer.append(c);
                } else {
                    return "";
                }
            } else {
                stringbuffer.append(c);
            }
        }

        return stringbuffer.toString();
    }

    private String eatNLPWS(String s) {
        StringBuffer stringbuffer;
        label0: {
            stringbuffer = new StringBuffer(s.length());
            int i = 0;
            boolean flag = false;
            char c;
            label1: do {
                while (!flag) {
                    c = s.charAt(i++);
                    if (c == ' ' && c == '\t') {
                        continue label1;
                    }
                    flag = true;
                    int j = i - 1;
                    while (s.charAt(j) == '\n') {
                        stringbuffer.append(s.charAt(j));
                        j++;
                    }
                }
                break label0;
            } while (c != '\n');
            return "";
        }
        return stringbuffer.toString();
    }

    public void saveNLParams() throws IOException {
        if (this.filename == null)
            return;
        FileWriter localFileWriter = null;
        try {
            localFileWriter = new FileWriter(this.filename);
            String str = "unknown";
            StringTokenizer localStringTokenizer = new StringTokenizer(this.filename,
                    File.separator);
            while (localStringTokenizer.hasMoreTokens())
                str = localStringTokenizer.nextToken();
            writeToStream(localFileWriter, str, this.filename);
        } finally {
            if (localFileWriter != null)
                localFileWriter.close();
        }
    }

    public void writeToStream(Writer writer, String s, String s1) {
        PrintWriter printwriter = null;
        printwriter = new PrintWriter(new BufferedWriter(writer));
        printwriter.println("# " + s + " Network Configuration File: " + s1 + "");
        printwriter.println("# Generated by Oracle configuration tools.");
        printwriter.println("");
        if (hasGroups) {
            saveNLPGroups(printwriter);
        }
        Enumeration enumeration = ht.elements();
        do {
            if (!enumeration.hasMoreElements()) {
                break;
            }
            NVPair nvpair = (NVPair) enumeration.nextElement();
            String s3 = nvpair.toString(0, true);
            if (DEBUG) {
                System.out.println("The initial stringified NVPair is:\n" + s3);
            }
            if (!s3.equals("")) {
                char ac[] = new char[s3.length() - 2];
                s3.getChars(1, s3.length() - 1, ac, 0);
                String s2 = new String(ac);
                if (DEBUG) {
                    System.out.println("The modified NV String is:\n" + s2);
                }
                printwriter.println(s2);
                printwriter.println("");
                ac = null;
            }
        } while (true);
        printwriter.close();
    }

    public void saveNLParams(String s) throws FileNotFoundException, IOException {
        String s1 = filename;
        filename = s;
        saveNLParams();
        filename = s1;
    }

    public String getFilename() {
        return filename;
    }

    public boolean configuredInFile() {
        return filename != null;
    }

    public int getNLPListSize() {
        nvStringcnt = 0;
        Enumeration enumeration = ht.keys();
        do {
            if (!enumeration.hasMoreElements()) {
                break;
            }
            String s = (String) enumeration.nextElement();
            if (s.indexOf("COMMENT") == -1) {
                nvStringcnt++;
            }
        } while (true);
        return nvStringcnt;
    }

    public boolean inErrorList(String s) {
        boolean flag = false;
        if (DEBUG) {
            System.out.println("Entering inErrorList():");
        }
        for (int i = 0; (!flag || i < errstrcnt) && errstrcnt != 0; i++) {
            if (errstr[i].indexOf(s) != -1) {
                flag = true;
            }
        }

        return flag;
    }

    public NVPair getNLPListElement(String s) {
        String s1 = s.toUpperCase();
        return (NVPair) ht.get(s1);
    }

    public String[] getNLPAllNames() {
        int i = getNLPListSize();
        String as[] = new String[i];
        int j = 0;
        Enumeration enumeration = ht.keys();
        do {
            if (!enumeration.hasMoreElements()) {
                break;
            }
            String s = (String) enumeration.nextElement();
            if (s.indexOf("COMMENT") == -1) {
                as[j++] = s;
            }
        } while (true);
        return as;
    }

    public String[] getNLPAllElements() {
        int i = getNLPListSize();
        String as[] = new String[i];
        int j = 0;
        Enumeration enumeration = ht.elements();
        do {
            if (!enumeration.hasMoreElements()) {
                break;
            }
            NVPair nvpair = (NVPair) enumeration.nextElement();
            if (nvpair.getName().indexOf("COMMENT") == -1) {
                String s = nvpair.toString();
                as[j++] = s;
            }
        } while (true);
        return as;
    }

    public byte addNLPListElement(String paramString, Object paramObject) {
        try {
            Object localObject = this.ht.put(paramString, paramObject);
            return (byte) (localObject != null ? 2 : 1);
        } catch (NullPointerException localNullPointerException) {
            if (DEBUG)
                System.out.println(localNullPointerException.getMessage());
        }
        return -1;
    }

    public void addNLPGroupProfile(String as[]) {
        String s = new String("GROUP#" + Groupcnt++);
        String as1[] = as;
        if (!hasGroups) {
            hasGroups = true;
        }
        addNLPListElement(s, as1);
    }

    private String[] getNLPGroupProfile(String s) {
        String s1 = s.toUpperCase();
        return (String[]) ht.get(s1);
    }

    private void saveNLPGroups(PrintWriter printwriter) {
        for (int i = 0; i < Groupcnt; i++) {
            String s = new String("GROUP#" + i);
            String as[] = getNLPGroupProfile(s);
            for (int j = 0; j < as.length; j++) {
                Object obj = null;
                Object obj1 = null;
                NVPair nvpair = null;
                if (DEBUG) {
                    System.out.println("Current Value in Group Profile: " + as[j]);
                }
                if (as[j] == null) {
                    continue;
                }
                nvpair = getNLPListElement(as[j]);
                if (nvpair != null) {
                    String s1 = nvpair.toString(0, true);
                    if (DEBUG) {
                        System.out.println("Parameter Value = " + s1);
                    }
                    char ac[] = new char[s1.length() - 2];
                    s1.getChars(1, s1.length() - 1, ac, 0);
                    String s2 = new String(ac);
                    printwriter.println(s2);
                    printwriter.println("");
                    NVPair nvpair1 = removeNLPListElement(as[j]);
                    if (nvpair1 == null && DEBUG) {
                        System.out.println("saveNLPGroups(): Could notremove param from Hashtable");
                    }
                    ac = null;
                    s2 = null;
                    continue;
                }
                if (DEBUG) {
                    System.out.println("No such Parameter in the Table");
                }
            }

            removeNLPGroupProfile(s);
        }

    }

    public void addNLPListElement(String s) throws NLException {
        char ac[] = new char[s.length() + 2];
        String s1 = "";
        if (DEBUG) {
            System.out.println("Entering Method addNLPListElement\n");
            System.out.println("String to add is: " + s + "");
        }
        s.getChars(0, s.length(), ac, 1);
        if (ac[1] == '(') {
            s1 = s;
        } else {
            ac[0] = '(';
            String s2 = System.getProperty("os.name");
            if (s2.equals("Windows NT") || s2.equals("Windows 95")) {
                if (ac[ac.length - 2] == '/' || ac[ac.length - 2] == '\\') {
                    ac[ac.length - 2] = ')';
                } else {
                    ac[ac.length - 1] = ')';
                }
            } else if (ac[ac.length - 2] == '\\') {
                ac[ac.length - 2] = ')';
            } else {
                ac[ac.length - 1] = ')';
            }
            s1 = new String(ac);
            if (DEBUG) {
                System.out.println("The modified NV String is: " + s1 + "");
            }
        }
        NVFactory nvfactory = new NVFactory();
        NVPair nvpair = nvfactory.createNVPair(s1);
        if (nvpair.getRHSType() == NVPair.RHS_NONE) {
            throw new NLException("NullRHS-04612", nvpair.getName());
        }
        String s3 = nvpair.getName();
        String s4 = s3.toUpperCase();
        nvpair.setName(s4);
        if (DEBUG) {
            System.out.println("The final NV String is: " + nvpair.toString() + "");
        }
        byte byte0 = addNLPListElement(s4, nvpair);
        switch (byte0) {
        default:
            break;

        case 2: // '\002'
            if (DEBUG) {
                System.out.println("The value for the Name: " + s3 + " was overwritten\n");
            }
            break;

        case -1:
            if (DEBUG) {
                System.out.println("The value for the Name: " + s3 + " could not be inserted\n");
            }
            break;
        }
    }

    public NVPair removeNLPListElement(String s) {
        String s1 = s.toUpperCase();
        if (DEBUG) {
            System.out.println("Trying to remove: " + s1 + " from Table");
        }
        Object obj = ht.remove(s1);
        return obj == null ? null : (NVPair) obj;
    }

    public void removeNLPGroupProfile(String s) {
        String s1 = s.toUpperCase();
        if (DEBUG) {
            System.out.println("Trying to remove: " + s1 + " GroupName from Table");
        }
        Object obj = ht.remove(s1);
    }

    public void removeNLPAllElements() {
        ht.clear();
    }

    public String toString() {
        String s = "";
        for (Enumeration enumeration = ht.elements(); enumeration.hasMoreElements();) {
            NVPair nvpair = (NVPair) enumeration.nextElement();
            String s1 = nvpair.toString();
            s = s + s1 + "\n";
        }

        return s;
    }

    public boolean fileHasComments() {
        return hasComments;
    }

    public void println() {
        System.out.println(toString());
    }

    public void setFilePermissions(int i) {
        filePermissions = i;
    }

}
