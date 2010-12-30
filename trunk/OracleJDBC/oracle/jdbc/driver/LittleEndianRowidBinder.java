package oracle.jdbc.driver;

class LittleEndianRowidBinder extends RowidBinder
{
  void bind(OraclePreparedStatement paramOraclePreparedStatement, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte, char[] paramArrayOfChar, short[] paramArrayOfShort, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, boolean paramBoolean)
  {
    byte[][] arrayOfByte = paramOraclePreparedStatement.parameterDatum[paramInt3];
    byte[] arrayOfByte1 = arrayOfByte[paramInt1];

    if (paramBoolean) {
      arrayOfByte[paramInt1] = null;
    }
    if (arrayOfByte1 == null) {
      paramArrayOfShort[paramInt9] = -1;
    }
    else {
      paramArrayOfShort[paramInt9] = 0;

      int i = arrayOfByte1.length;

      System.arraycopy(arrayOfByte1, 0, paramArrayOfByte, paramInt6 + 2, i);

      paramArrayOfByte[(paramInt6 + 1)] = (byte)(i >> 8);
      paramArrayOfByte[paramInt6] = (byte)(i & 0xFF);
      paramArrayOfShort[paramInt8] = (short)(i + 2);
    }
  }
}

/* Location:           D:\oracle\product\10.2.0\client_1\jdbc\lib\ojdbc14.jar
 * Qualified Name:     oracle.jdbc.driver.LittleEndianRowidBinder
 * JD-Core Version:    0.6.0
 */