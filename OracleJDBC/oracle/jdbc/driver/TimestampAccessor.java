package oracle.jdbc.driver;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Map;
import java.util.TimeZone;
import oracle.sql.Datum;
import oracle.sql.TIMESTAMP;

class TimestampAccessor extends DateTimeCommonAccessor
{
  TimestampAccessor(OracleStatement paramOracleStatement, int paramInt1, short paramShort, int paramInt2, boolean paramBoolean)
    throws SQLException
  {
    init(paramOracleStatement, 180, 180, paramShort, paramBoolean);
    initForDataAccess(paramInt2, paramInt1, null);
  }

  TimestampAccessor(OracleStatement paramOracleStatement, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, short paramShort)
    throws SQLException
  {
    init(paramOracleStatement, 180, 180, paramShort, false);
    initForDescribe(180, paramInt1, paramBoolean, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramShort, null);

    initForDataAccess(0, paramInt1, null);
  }

  void initForDataAccess(int paramInt1, int paramInt2, String paramString)
    throws SQLException
  {
    if (paramInt1 != 0) {
      this.externalType = paramInt1;
    }
    this.internalTypeMaxLength = 11;

    if ((paramInt2 > 0) && (paramInt2 < this.internalTypeMaxLength)) {
      this.internalTypeMaxLength = paramInt2;
    }
    this.byteLength = this.internalTypeMaxLength;
  }

  String getString(int paramInt)
    throws SQLException
  {
    String str = null;

    if (this.rowSpaceIndicator == null)
    {
      DatabaseError.throwSqlException(21);
    }

    if (this.rowSpaceIndicator[(this.indicatorIndex + paramInt)] != -1)
    {
      int i = this.rowSpaceIndicator[(this.lengthIndex + paramInt)];
      int j = this.columnIndex + this.byteLength * paramInt;
      int k = ((this.rowSpaceByte[(0 + j)] & 0xFF) - 100) * 100 + (this.rowSpaceByte[(1 + j)] & 0xFF) - 100;

      int m = 0;

      if (i == 11)
      {
        m = oracleNanos(j);
      }

      str = k + "-" + this.rowSpaceByte[(2 + j)] + "-" + this.rowSpaceByte[(3 + j)] + "." + (this.rowSpaceByte[(4 + j)] - 1) + "." + (this.rowSpaceByte[(5 + j)] - 1) + ". " + (this.rowSpaceByte[(6 + j)] - 1) + ". " + m;
    }

    return str;
  }

  Timestamp getTimestamp(int paramInt)
    throws SQLException
  {
    Timestamp localTimestamp = null;

    if (this.rowSpaceIndicator == null)
    {
      DatabaseError.throwSqlException(21);
    }

    if (this.rowSpaceIndicator[(this.indicatorIndex + paramInt)] != -1)
    {
      int i = this.rowSpaceIndicator[(this.lengthIndex + paramInt)];
      int j = this.columnIndex + this.byteLength * paramInt;

      TimeZone localTimeZone = this.statement.getDefaultTimeZone();

      int k = ((this.rowSpaceByte[(0 + j)] & 0xFF) - 100) * 100 + (this.rowSpaceByte[(1 + j)] & 0xFF) - 100;

      if (k <= 0) {
        k++;
      }
      localTimestamp = new Timestamp(getMillis(k, oracleMonth(j), oracleDay(j), oracleTime(j), localTimeZone));

      if (i == 11)
      {
        localTimestamp.setNanos(oracleNanos(j));
      }

    }

    return localTimestamp;
  }

  Object getObject(int paramInt)
    throws SQLException
  {
    Object localObject = null;

    if (this.rowSpaceIndicator == null)
    {
      DatabaseError.throwSqlException(21);
    }

    if (this.rowSpaceIndicator[(this.indicatorIndex + paramInt)] != -1)
    {
      if (this.externalType == 0)
      {
        if (this.statement.connection.j2ee13Compliant)
        {
          localObject = getTimestamp(paramInt);
        }
        else
        {
          localObject = getTIMESTAMP(paramInt);
        }
      }
      else
      {
        switch (this.externalType)
        {
        case 93:
          return getTimestamp(paramInt);
        }

        DatabaseError.throwSqlException(4);

        return null;
      }

    }

    return localObject;
  }

  Datum getOracleObject(int paramInt)
    throws SQLException
  {
    return getTIMESTAMP(paramInt);
  }

  Object getObject(int paramInt, Map paramMap)
    throws SQLException
  {
    return getObject(paramInt);
  }

  TIMESTAMP getTIMESTAMP(int paramInt)
    throws SQLException
  {
    TIMESTAMP localTIMESTAMP = null;

    if (this.rowSpaceIndicator == null)
    {
      DatabaseError.throwSqlException(21);
    }

    if (this.rowSpaceIndicator[(this.indicatorIndex + paramInt)] != -1)
    {
      int i = this.rowSpaceIndicator[(this.lengthIndex + paramInt)];
      int j = this.columnIndex + this.byteLength * paramInt;
      byte[] arrayOfByte = new byte[i];
      System.arraycopy(this.rowSpaceByte, j, arrayOfByte, 0, i);
      localTIMESTAMP = new TIMESTAMP(arrayOfByte);
    }

    return localTIMESTAMP;
  }
}

/* Location:           D:\oracle\product\10.2.0\client_1\jdbc\lib\ojdbc14.jar
 * Qualified Name:     oracle.jdbc.driver.TimestampAccessor
 * JD-Core Version:    0.6.0
 */