package oracle.sql;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.Ref;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.sql.Struct;
import java.sql.Time;
import java.sql.Timestamp;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.driver.DatabaseError;

public class OracleSQLOutput
  implements SQLOutput
{
  private StructDescriptor descriptor;
  private Object[] attributes;
  private int index;
  private OracleConnection conn;
  private static final String _Copyright_2004_Oracle_All_Rights_Reserved_ = null;
  public static final boolean TRACE = false;
  public static final boolean PRIVATE_TRACE = false;
  public static final String BUILD_DATE = "Wed_Jun_22_11:18:47_PDT_2005";

  public OracleSQLOutput(StructDescriptor paramStructDescriptor, OracleConnection paramOracleConnection)
    throws SQLException
  {
    this.descriptor = paramStructDescriptor;
    this.attributes = new Object[paramStructDescriptor.getLength()];
    this.conn = paramOracleConnection;
    this.index = 0;
  }

  public STRUCT getSTRUCT()
    throws SQLException
  {
    return new STRUCT(this.descriptor, this.conn, this.attributes);
  }

  public void writeString(String paramString)
    throws SQLException
  {
    this.attributes[(this.index++)] = paramString;
  }

  public void writeBoolean(boolean paramBoolean)
    throws SQLException
  {
    this.attributes[(this.index++)] = new Boolean(paramBoolean);
  }

  public void writeByte(byte paramByte)
    throws SQLException
  {
    this.attributes[(this.index++)] = new Integer(paramByte);
  }

  public void writeShort(short paramShort)
    throws SQLException
  {
    this.attributes[(this.index++)] = new Integer(paramShort);
  }

  public void writeInt(int paramInt)
    throws SQLException
  {
    this.attributes[(this.index++)] = new Integer(paramInt);
  }

  public void writeLong(long paramLong)
    throws SQLException
  {
    this.attributes[(this.index++)] = new Long(paramLong);
  }

  public void writeFloat(float paramFloat)
    throws SQLException
  {
    this.attributes[(this.index++)] = new Float(paramFloat);
  }

  public void writeDouble(double paramDouble)
    throws SQLException
  {
    this.attributes[(this.index++)] = new Double(paramDouble);
  }

  public void writeBigDecimal(BigDecimal paramBigDecimal)
    throws SQLException
  {
    this.attributes[(this.index++)] = paramBigDecimal;
  }

  public void writeBytes(byte[] paramArrayOfByte)
    throws SQLException
  {
    this.attributes[(this.index++)] = paramArrayOfByte;
  }

  public void writeDate(Date paramDate)
    throws SQLException
  {
    this.attributes[(this.index++)] = paramDate;
  }

  public void writeTime(Time paramTime)
    throws SQLException
  {
    this.attributes[(this.index++)] = paramTime;
  }

  public void writeTimestamp(Timestamp paramTimestamp)
    throws SQLException
  {
    this.attributes[(this.index++)] = paramTimestamp;
  }

  public void writeCharacterStream(Reader paramReader)
    throws SQLException
  {
    StringBuffer localStringBuffer = new StringBuffer();

    char[] arrayOfChar = new char[100];
    int i = 0;
    try
    {
      while ((i = paramReader.read(arrayOfChar)) != -1)
      {
        localStringBuffer.append(arrayOfChar, 0, i);
      }

    }
    catch (IOException localIOException)
    {
      DatabaseError.throwSqlException(localIOException);
    }

    String str = localStringBuffer.substring(0, localStringBuffer.length());

    this.attributes[(this.index++)] = str;
  }

  public void writeAsciiStream(InputStream paramInputStream)
    throws SQLException
  {
    StringBuffer localStringBuffer = new StringBuffer();

    byte[] arrayOfByte = new byte[100];
    char[] arrayOfChar = new char[100];
    int i = 0;
    try
    {
      while ((i = paramInputStream.read(arrayOfByte)) != -1)
      {
        for (int j = 0; j < i; j++) {
          arrayOfChar[j] = (char)arrayOfByte[j];
        }
        localStringBuffer.append(arrayOfChar, 0, i);
      }

    }
    catch (IOException localIOException)
    {
      DatabaseError.throwSqlException(localIOException);
    }

    String str = localStringBuffer.substring(0, localStringBuffer.length());

    this.attributes[(this.index++)] = str;
  }

  public void writeBinaryStream(InputStream paramInputStream)
    throws SQLException
  {
    writeAsciiStream(paramInputStream);
  }

  public void writeObject(SQLData paramSQLData)
    throws SQLException
  {
    STRUCT localSTRUCT = null;

    if (paramSQLData != null)
    {
      StructDescriptor localStructDescriptor = StructDescriptor.createDescriptor(paramSQLData.getSQLTypeName(), this.conn);

      SQLOutput localSQLOutput = localStructDescriptor.toJdbc2SQLOutput();

      paramSQLData.writeSQL(localSQLOutput);

      localSTRUCT = ((OracleSQLOutput)localSQLOutput).getSTRUCT();
    }

    writeStruct(localSTRUCT);
  }

  public void writeObject(Object paramObject)
    throws SQLException
  {
    if ((paramObject != null) && ((paramObject instanceof SQLData)))
      writeObject((SQLData)paramObject);
    else
      this.attributes[(this.index++)] = paramObject;
  }

  public void writeRef(Ref paramRef)
    throws SQLException
  {
    this.attributes[(this.index++)] = paramRef;
  }

  public void writeBlob(Blob paramBlob)
    throws SQLException
  {
    this.attributes[(this.index++)] = paramBlob;
  }

  public void writeClob(Clob paramClob)
    throws SQLException
  {
    this.attributes[(this.index++)] = paramClob;
  }

  public void writeStruct(Struct paramStruct)
    throws SQLException
  {
    this.attributes[(this.index++)] = paramStruct;
  }

  public void writeArray(Array paramArray)
    throws SQLException
  {
    this.attributes[(this.index++)] = paramArray;
  }

  public void writeOracleObject(Datum paramDatum)
    throws SQLException
  {
    this.attributes[(this.index++)] = paramDatum;
  }

  public void writeRef(REF paramREF)
    throws SQLException
  {
    this.attributes[(this.index++)] = paramREF;
  }

  public void writeBlob(BLOB paramBLOB)
    throws SQLException
  {
    this.attributes[(this.index++)] = paramBLOB;
  }

  public void writeBfile(BFILE paramBFILE)
    throws SQLException
  {
    this.attributes[(this.index++)] = paramBFILE;
  }

  public void writeClob(CLOB paramCLOB)
    throws SQLException
  {
    this.attributes[(this.index++)] = paramCLOB;
  }

  public void writeStruct(STRUCT paramSTRUCT)
    throws SQLException
  {
    this.attributes[(this.index++)] = paramSTRUCT;
  }

  public void writeArray(ARRAY paramARRAY)
    throws SQLException
  {
    this.attributes[(this.index++)] = paramARRAY;
  }

  public void writeNUMBER(NUMBER paramNUMBER)
    throws SQLException
  {
    this.attributes[(this.index++)] = paramNUMBER;
  }

  public void writeCHAR(CHAR paramCHAR)
    throws SQLException
  {
    this.attributes[(this.index++)] = paramCHAR;
  }

  public void writeDATE(DATE paramDATE)
    throws SQLException
  {
    this.attributes[(this.index++)] = paramDATE;
  }

  public void writeRAW(RAW paramRAW)
    throws SQLException
  {
    this.attributes[(this.index++)] = paramRAW;
  }

  public void writeROWID(ROWID paramROWID)
    throws SQLException
  {
    this.attributes[(this.index++)] = paramROWID;
  }

  public void writeURL(URL paramURL)
    throws SQLException
  {
    DatabaseError.throwUnsupportedFeatureSqlException();
  }
}

/* Location:           D:\oracle\product\10.2.0\client_1\jdbc\lib\ojdbc14.jar
 * Qualified Name:     oracle.sql.OracleSQLOutput
 * JD-Core Version:    0.6.0
 */