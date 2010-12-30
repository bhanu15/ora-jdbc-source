package oracle.net.ns;

public abstract interface SQLnetDef
{
  public static final boolean DEBUG = false;
  public static final boolean ASSERT = false;
  public static final int NSPTCN = 1;
  public static final int NSPTAC = 2;
  public static final int NSPTAK = 3;
  public static final int NSPTRF = 4;
  public static final int NSPTRD = 5;
  public static final int NSPTDA = 6;
  public static final int NSPTNL = 7;
  public static final int NSPTAB = 9;
  public static final int NSPTRS = 11;
  public static final int NSPTMK = 12;
  public static final int NSPTAT = 13;
  public static final int NSPTCNL = 14;
  public static final int NSPTHI = 19;
  public static final byte NSPHDLEN = 0;
  public static final byte NSPHDPSM = 2;
  public static final byte NSPHDTYP = 4;
  public static final byte NSPHDFLGS = 5;
  public static final byte NSPHDHSM = 6;
  public static final byte NSPSIZHD = 8;
  public static final byte NO_HEADER_FLAGS = 0;
  public static final byte NSPFSRN = 8;
  public static final byte NSPCNVSN = 8;
  public static final byte NSPCNLOV = 10;
  public static final byte NSPCNOPT = 12;
  public static final byte NSPCNSDU = 14;
  public static final byte NSPCNTDU = 16;
  public static final byte NSPCNNTC = 18;
  public static final byte NSPCNTNA = 20;
  public static final byte NSPCNONE = 22;
  public static final byte NSPCNLEN = 24;
  public static final byte NSPCNOFF = 26;
  public static final byte NSPCNMXC = 28;
  public static final byte NSPCNFL0 = 32;
  public static final byte NSPCNFL1 = 33;
  public static final byte NSPCNDAT = 34;
  public static final int NSPMXCDATA = 230;
  public static final int NSINAWANTED = 1;
  public static final int NSINAINTCHG = 2;
  public static final int NSINADISABLEFORCONNECTION = 4;
  public static final int NSINANOSERVICES = 8;
  public static final int NSINAREQUIRED = 16;
  public static final int NSINAAUTHWANTED = 32;
  public static final byte NSPACVSN = 8;
  public static final byte NSPACOPT = 10;
  public static final byte NSPACSDU = 12;
  public static final byte NSPACTDU = 14;
  public static final byte NSPACONE = 16;
  public static final byte NSPACLEN = 18;
  public static final byte NSPACOFF = 20;
  public static final byte NSPACFL0 = 22;
  public static final byte NSPACFL1 = 23;
  public static final byte NSPRFURS = 8;
  public static final byte NSPRFSRS = 9;
  public static final byte NSPRFLEN = 10;
  public static final byte NSPRFDAT = 12;
  public static final byte NSPRDLEN = 8;
  public static final byte NSPRDDAT = 10;
  public static final int NSPDAFLG = 8;
  public static final int NSPDADAT = 10;
  public static final int NSPDAFZER = 0;
  public static final int NSPDAFTKN = 1;
  public static final int NSPDAFRCF = 2;
  public static final int NSPDAFCFM = 4;
  public static final int NSPDAFRSV = 8;
  public static final int NSPDAFMOR = 32;
  public static final int NSPDAFEOF = 64;
  public static final int NSPDAFIMM = 128;
  public static final int NSPDAFRTS = 256;
  public static final int NSPDAFRNT = 512;
  public static final int NSPMKTYP = 8;
  public static final int NSPMKODT = 9;
  public static final int NSPMKDAT = 10;
  public static final int NSPMKTD0 = 0;
  public static final int NSPMKTD1 = 1;
  public static final byte NSPMKATT = 0;
  public static final byte NSPMKBRK = 1;
  public static final byte NSPMKRES = 2;
  public static final int NSPDFSDULN = 2048;
  public static final int NSPMXSDULN = 32767;
  public static final int NSPMNSDULN = 512;
  public static final int NSPDFTDULN = 32767;
  public static final int NSPMXTDULN = 32767;
  public static final int NSPMNTDULN = 255;
  public static final int NSPINSDULN = 255;
  public static final String TCP_NODELAY_STR = "TCP.NODELAY";
  public static final String TCP_CONNTIMEOUT_STR = "oracle.net.CONNECT_TIMEOUT";
  public static final String TCP_READTIMEOUT_STR = "oracle.net.READ_TIMEOUT";
  public static final String SSL_SERVER_DN_MATCH = "oracle.net.ssl_server_dn_match";
  public static final String ORACLE_NET_WALLET_LOCATION = "oracle.net.wallet_location";
  public static final String SSL_VERSION = "oracle.net.ssl_version";
  public static final String SSL_CIPHER_SUITES = "oracle.net.ssl_cipher_suites";
  public static final String JAVAX_NET_SSL_KEYSTORE = "javax.net.ssl.keyStore";
  public static final String JAVAX_NET_SSL_KEYSTORETYPE = "javax.net.ssl.keyStoreType";
  public static final String JAVAX_NET_SSL_KEYSTOREPASSWORD = "javax.net.ssl.keyStorePassword";
  public static final String JAVAX_NET_SSL_TRUSTSTORE = "javax.net.ssl.trustStore";
  public static final String JAVAX_NET_SSL_TRUSTSTORETYPE = "javax.net.ssl.trustStoreType";
  public static final String JAVAX_NET_SSL_TRUSTSTOREPASSWORD = "javax.net.ssl.trustStorePassword";
  public static final String SSL_KEYMANAGERFACTORY_ALGORITHM = "ssl.keyManagerFactory.algorithm";
  public static final String SSL_TRUSTMANAGERFACTORY_ALGORITHM = "ssl.trustManagerFactory.algorithm";
  public static final int TCP_NODELAY_OFF = 0;
  public static final int TCP_KEEPALIVE_OFF = 1;
  public static final int TCP_CONNTIMEOUT_OFF = 2;
  public static final int TCP_READTIMEOUT_OFF = 3;
  public static final int SSL_SERVER_DN_MATCH_OFF = 4;
  public static final int ORACLE_NET_WALLET_LOCATION_OFF = 5;
  public static final int SSL_VERSION_OFF = 6;
  public static final int SSL_CIPHER_SUITES_OFF = 7;
  public static final int JAVAX_NET_SSL_KEYSTORE_OFF = 8;
  public static final int JAVAX_NET_SSL_KEYSTORETYPE_OFF = 9;
  public static final int JAVAX_NET_SSL_KEYSTOREPASSWORD_OFF = 10;
  public static final int JAVAX_NET_SSL_TRUSTSTORE_OFF = 11;
  public static final int JAVAX_NET_SSL_TRUSTSTORETYPE_OFF = 12;
  public static final int JAVAX_NET_SSL_TRUSTSTOREPASSWORD_OFF = 13;
  public static final int SSL_KEYMANAGERFACTORY_ALGORITHM_OFF = 14;
  public static final int SSL_TRUSTMANAGERFACTORY_ALGORITHM_OFF = 15;
  public static final int ORACLE_NET_NTMINOPT = 0;
  public static final int ORACLE_NET_READ_TIMEOUT = 1;
  public static final int ORACLE_NET_SSL_ENCRYPTION_ENABLED = 2;
  public static final int ORACLE_NET_SSL_PEER_CERT_DN = 3;
  public static final int ORACLE_NET_SSL_PEER_CERT_CHAIN = 4;
  public static final int ORACLE_NET_SSL_CIPHER_SUITE = 5;
  public static final int ORACLE_NET_SSL_MATCH_SERVER_DN = 6;
  public static final int ORACLE_NET_SSL_FULL_DN_MATCH = 7;
  public static final int ORACLE_NET_SSL_MATCH_SERVER_DN_WITH = 8;
  public static final int ORACLE_NET_NTMAXOPT = 10;
}

/* Location:           D:\oracle\product\10.2.0\client_1\jdbc\lib\ojdbc14.jar
 * Qualified Name:     oracle.net.ns.SQLnetDef
 * JD-Core Version:    0.6.0
 */