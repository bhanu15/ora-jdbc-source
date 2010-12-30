package oracle.jdbc.driver;

import java.sql.SQLException;

class RawAccessor extends RawCommonAccessor
{
  static final int MAXLENGTH_NEW = 2000;
  static final int MAXLENGTH_OLD = 255;

  RawAccessor(OracleStatement paramOracleStatement, int paramInt1, short paramShort, int paramInt2, boolean paramBoolean)
    throws SQLException
  {
    init(paramOracleStatement, 23, 15, paramShort, paramBoolean);
    initForDataAccess(paramInt2, paramInt1, null);
  }

  RawAccessor(OracleStatement paramOracleStatement, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, short paramShort)
    throws SQLException
  {
    init(paramOracleStatement, 23, 15, paramShort, false);
    initForDescribe(23, paramInt1, paramBoolean, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramShort, null);

    int i = paramOracleStatement.maxFieldSize;

    if ((i > 0) && ((paramInt1 == 0) || (i < paramInt1))) {
      paramInt1 = i;
    }
    initForDataAccess(0, paramInt1, null);
  }

  void initForDataAccess(int paramInt1, int paramInt2, String paramString)
    throws SQLException
  {
    if (paramInt1 != 0) {
      this.externalType = paramInt1;
    }
    if (this.statement.connection.getVersionNumber() >= 8000)
      this.internalTypeMaxLength = 2000;
    else {
      this.internalTypeMaxLength = 255;
    }
    if ((paramInt2 > 0) && (paramInt2 < this.internalTypeMaxLength)) {
      this.internalTypeMaxLength = paramInt2;
    }
    this.byteLength = (this.internalTypeMaxLength + 2);
  }

  byte[] getBytes(int paramInt) throws SQLException
  {
    byte[] arrayOfByte = null;

    if (this.rowSpaceIndicator == null)
    {
      DatabaseError.throwSqlException(21);
    }

    if (this.rowSpaceIndicator[(this.indicatorIndex + paramInt)] != -1)
    {
      int i = this.rowSpaceIndicator[(this.lengthIndex + paramInt)];
      int j = this.columnIndex + this.byteLength * paramInt;

      arrayOfByte = new byte[i];

      System.arraycopy(this.rowSpaceByte, j + 2, arrayOfByte, 0, i);
    }

    return arrayOfByte;
  }
}

/* Location:           D:\oracle\product\10.2.0\client_1\jdbc\lib\ojdbc14.jar
 * Qualified Name:     oracle.jdbc.driver.RawAccessor
 * JD-Core Version:    0.6.0
 */