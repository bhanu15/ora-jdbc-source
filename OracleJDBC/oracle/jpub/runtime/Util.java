package oracle.jpub.runtime;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import oracle.sql.ARRAY;
import oracle.sql.BFILE;
import oracle.sql.BLOB;
import oracle.sql.CHAR;
import oracle.sql.CLOB;
import oracle.sql.CharacterSet;
import oracle.sql.CustomDatum;
import oracle.sql.CustomDatumFactory;
import oracle.sql.DATE;
import oracle.sql.Datum;
import oracle.sql.NUMBER;
import oracle.sql.OPAQUE;
import oracle.sql.ORAData;
import oracle.sql.ORADataFactory;
import oracle.sql.RAW;
import oracle.sql.REF;
import oracle.sql.STRUCT;
import oracle.sql.TIMESTAMP;

public class Util
{
  static short lastCsId = 870;
  static CharacterSet lastCS = CharacterSet.make(870);

  private static final String _Copyright_2004_Oracle_All_Rights_Reserved_ = null;
  public static final boolean TRACE = false;
  public static final boolean PRIVATE_TRACE = false;
  public static final String BUILD_DATE = "Wed_Jun_22_11:18:56_PDT_2005";

  public static Object convertToObject(Datum paramDatum, int paramInt, Object paramObject)
    throws SQLException
  {
    Object localObject = _convertToObject(paramDatum, paramInt, paramObject);

    return localObject;
  }

  public static Object _convertToObject(Datum paramDatum, int paramInt, Object paramObject)
    throws SQLException
  {
    if (paramDatum == null) {
      return null;
    }
    if ((paramDatum instanceof STRUCT))
    {
      if ((paramObject instanceof ORADataFactory))
      {
        return ((ORADataFactory)paramObject).create(paramDatum, 2002);
      }

      return ((CustomDatumFactory)paramObject).create(paramDatum, 2002);
    }

    if ((paramDatum instanceof REF))
    {
      if ((paramObject instanceof ORADataFactory))
      {
        return ((ORADataFactory)paramObject).create(paramDatum, 2006);
      }

      return ((CustomDatumFactory)paramObject).create(paramDatum, 2006);
    }

    if ((paramDatum instanceof ARRAY))
    {
      if ((paramObject instanceof ORADataFactory))
      {
        return ((ORADataFactory)paramObject).create(paramDatum, 2003);
      }

      return ((CustomDatumFactory)paramObject).create(paramDatum, 2003);
    }

    if ((paramDatum instanceof OPAQUE))
    {
      if ((paramObject instanceof ORADataFactory))
      {
        return ((ORADataFactory)paramObject).create(paramDatum, 2007);
      }

      return ((CustomDatumFactory)paramObject).create(paramDatum, 2007);
    }

    if (paramObject != null)
    {
      if ((paramObject instanceof ORADataFactory))
      {
        return ((ORADataFactory)paramObject).create(paramDatum, paramInt);
      }

      return ((CustomDatumFactory)paramObject).create(paramDatum, paramInt);
    }

    if ((paramDatum instanceof NUMBER))
    {
      if ((paramInt == 2) || (paramInt == 3)) {
        return ((NUMBER)paramDatum).bigDecimalValue();
      }
      if ((paramInt == 8) || (paramInt == 6)) {
        return new Double(((NUMBER)paramDatum).doubleValue());
      }
      if ((paramInt == 4) || (paramInt == 5)) {
        return new Integer(((NUMBER)paramDatum).intValue());
      }
      if (paramInt == 7) {
        return new Float(((NUMBER)paramDatum).floatValue());
      }
      if (paramInt == 16) {
        return new Boolean(((NUMBER)paramDatum).booleanValue());
      }
      throw new SQLException("Unexpected java.sql.OracleTypes type: " + paramInt);
    }

    return paramDatum.toJdbc();
  }

  public static Datum convertToOracle(Object paramObject, Connection paramConnection)
    throws SQLException
  {
    Datum localDatum = _convertToOracle(paramObject, paramConnection);

    return localDatum;
  }

  private static Datum _convertToOracle(Object paramObject, Connection paramConnection)
    throws SQLException
  {
    if (paramObject == null) {
      return null;
    }
    if ((paramObject instanceof ORAData)) {
      return ((ORAData)paramObject).toDatum(paramConnection);
    }
    if ((paramObject instanceof CustomDatum))
      return ((CustomDatum)paramObject).toDatum((oracle.jdbc.driver.OracleConnection)paramConnection);
    short s;
    if ((paramObject instanceof String))
    {
      s = (paramConnection == null) || (!(paramConnection instanceof oracle.jdbc.driver.OracleConnection)) ? 870 : ((oracle.jdbc.driver.OracleConnection)paramConnection).getDbCsId();

      if (s != lastCsId)
      {
        lastCsId = s;
        lastCS = CharacterSet.make(lastCsId);
      }

      return new CHAR((String)paramObject, lastCS);
    }

    if ((paramObject instanceof Character))
    {
      s = (paramConnection == null) || (!(paramConnection instanceof oracle.jdbc.driver.OracleConnection)) ? 870 : ((oracle.jdbc.driver.OracleConnection)paramConnection).getDbCsId();

      if (s != lastCsId)
      {
        lastCsId = s;
        lastCS = CharacterSet.make(lastCsId);
      }

      return new CHAR(((Character)paramObject).toString(), lastCS);
    }

    if ((paramObject instanceof BigDecimal)) {
      return new NUMBER((BigDecimal)paramObject);
    }
    if ((paramObject instanceof BigInteger)) {
      return new NUMBER((BigInteger)paramObject);
    }
    if ((paramObject instanceof Double)) {
      return new NUMBER(((Double)paramObject).doubleValue());
    }
    if ((paramObject instanceof Float)) {
      return new NUMBER(((Float)paramObject).floatValue());
    }
    if ((paramObject instanceof Integer)) {
      return new NUMBER(((Integer)paramObject).intValue());
    }
    if ((paramObject instanceof Boolean)) {
      return new NUMBER(((Boolean)paramObject).booleanValue());
    }
    if ((paramObject instanceof Short)) {
      return new NUMBER(((Short)paramObject).shortValue());
    }
    if ((paramObject instanceof Byte)) {
      return new NUMBER(((Byte)paramObject).byteValue());
    }
    if ((paramObject instanceof Long)) {
      return new NUMBER(((Long)paramObject).longValue());
    }
    if ((paramObject instanceof Timestamp))
    {
      if (((oracle.jdbc.OracleConnection)paramConnection).physicalConnectionWithin().isV8Compatible()) {
        return new DATE((Timestamp)paramObject);
      }
      return new TIMESTAMP((Timestamp)paramObject);
    }

    if ((paramObject instanceof java.sql.Date)) {
      return new DATE((java.sql.Date)paramObject);
    }
    if ((paramObject instanceof java.util.Date)) {
      return new DATE(new java.sql.Date(((java.util.Date)paramObject).getTime()));
    }
    if ((paramObject instanceof byte[])) {
      return new RAW((byte[])paramObject);
    }
    if ((paramObject instanceof Datum)) {
      return (Datum)paramObject;
    }
    throw new SQLException("Unable to convert object to oracle.sql.Datum: " + paramObject);
  }

  static boolean isMutable(Datum paramDatum, ORADataFactory paramORADataFactory)
  {
    if (paramDatum == null) {
      return false;
    }

    return ((paramDatum instanceof BFILE)) || ((paramDatum instanceof BLOB)) || ((paramDatum instanceof CLOB)) || ((paramORADataFactory != null) && (((paramDatum instanceof STRUCT)) || ((paramDatum instanceof OPAQUE)) || ((paramDatum instanceof ARRAY))));
  }

  static boolean isMutable(Datum paramDatum, CustomDatumFactory paramCustomDatumFactory)
  {
    if (paramDatum == null) {
      return false;
    }

    return ((paramDatum instanceof BFILE)) || ((paramDatum instanceof BLOB)) || ((paramDatum instanceof CLOB)) || ((paramCustomDatumFactory != null) && (((paramDatum instanceof STRUCT)) || ((paramDatum instanceof OPAQUE)) || ((paramDatum instanceof ARRAY))));
  }
}

/* Location:           D:\oracle\product\10.2.0\client_1\jdbc\lib\ojdbc14.jar
 * Qualified Name:     oracle.jpub.runtime.Util
 * JD-Core Version:    0.6.0
 */