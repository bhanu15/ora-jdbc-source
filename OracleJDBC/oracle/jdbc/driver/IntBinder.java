package oracle.jdbc.driver;

class IntBinder extends VarnumBinder
{
  void bind(OraclePreparedStatement paramOraclePreparedStatement, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte, char[] paramArrayOfChar, short[] paramArrayOfShort, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, boolean paramBoolean)
  {
    byte[] arrayOfByte = paramArrayOfByte;
    int i = paramInt6 + 1;
    int j = paramOraclePreparedStatement.parameterInt[paramInt3][paramInt1];
    int k = 0;

    if (j == 0)
    {
      arrayOfByte[i] = -128;
      k = 1;
    }
    else
    {
      int m;
      if (j < 0)
      {
        if (j == -2147483648)
        {
          arrayOfByte[i] = 58;
          arrayOfByte[(i + 1)] = 80;
          arrayOfByte[(i + 2)] = 54;

          arrayOfByte[(i + 3)] = 53;
          arrayOfByte[(i + 4)] = 65;
          arrayOfByte[(i + 5)] = 53;
          arrayOfByte[(i + 6)] = 102;
          k = 7;
        }
        else if (-j < 100)
        {
          arrayOfByte[i] = 62;
          arrayOfByte[(i + 1)] = (byte)(101 + j);
          arrayOfByte[(i + 2)] = 102;
          k = 3;
        }
        else if (-j < 10000)
        {
          arrayOfByte[i] = 61;
          arrayOfByte[(i + 1)] = (byte)(101 - -j / 100);
          m = -j % 100;

          if (m != 0)
          {
            arrayOfByte[(i + 2)] = (byte)(101 - m);
            arrayOfByte[(i + 3)] = 102;
            k = 4;
          }
          else
          {
            arrayOfByte[(i + 2)] = 102;
            k = 3;
          }
        }
        else if (-j < 1000000)
        {
          arrayOfByte[i] = 60;
          arrayOfByte[(i + 1)] = (byte)(101 - -j / 10000);
          m = -j % 100;

          if (m != 0)
          {
            arrayOfByte[(i + 2)] = (byte)(101 - -j % 10000 / 100);
            arrayOfByte[(i + 3)] = (byte)(101 - m);
            arrayOfByte[(i + 4)] = 102;
            k = 5;
          }
          else
          {
            m = -j % 10000 / 100;

            if (m != 0)
            {
              arrayOfByte[(i + 2)] = (byte)(101 - m);
              arrayOfByte[(i + 3)] = 102;
              k = 4;
            }
            else
            {
              arrayOfByte[(i + 2)] = 102;
              k = 3;
            }
          }
        }
        else if (-j < 100000000)
        {
          arrayOfByte[i] = 59;
          arrayOfByte[(i + 1)] = (byte)(101 - -j / 1000000);
          m = -j % 100;

          if (m != 0)
          {
            arrayOfByte[(i + 2)] = (byte)(101 - -j % 1000000 / 10000);
            arrayOfByte[(i + 3)] = (byte)(101 - -j % 10000 / 100);
            arrayOfByte[(i + 4)] = (byte)(101 - m);
            arrayOfByte[(i + 5)] = 102;
            k = 6;
          }
          else
          {
            m = -j % 10000 / 100;

            if (m != 0)
            {
              arrayOfByte[(i + 2)] = (byte)(101 - -j % 1000000 / 10000);
              arrayOfByte[(i + 3)] = (byte)(101 - m);
              arrayOfByte[(i + 4)] = 102;
              k = 5;
            }
            else
            {
              m = -j % 1000000 / 10000;

              if (m != 0)
              {
                arrayOfByte[(i + 2)] = (byte)(101 - m);
                arrayOfByte[(i + 3)] = 102;
                k = 4;
              }
              else
              {
                arrayOfByte[(i + 2)] = 102;
                k = 3;
              }
            }
          }
        }
        else
        {
          arrayOfByte[i] = 58;
          arrayOfByte[(i + 1)] = (byte)(101 - -j / 100000000);
          m = -j % 100;

          if (m != 0)
          {
            arrayOfByte[(i + 2)] = (byte)(101 - -j % 100000000 / 1000000);
            arrayOfByte[(i + 3)] = (byte)(101 - -j % 1000000 / 10000);
            arrayOfByte[(i + 4)] = (byte)(101 - -j % 10000 / 100);
            arrayOfByte[(i + 5)] = (byte)(101 - m);
            arrayOfByte[(i + 6)] = 102;
            k = 7;
          }
          else
          {
            m = -j % 10000 / 100;

            if (m != 0)
            {
              arrayOfByte[(i + 2)] = (byte)(101 - -j % 100000000 / 1000000);
              arrayOfByte[(i + 3)] = (byte)(101 - -j % 1000000 / 10000);
              arrayOfByte[(i + 4)] = (byte)(101 - m);
              arrayOfByte[(i + 5)] = 102;
              k = 6;
            }
            else
            {
              m = -j % 1000000 / 10000;

              if (m != 0)
              {
                arrayOfByte[(i + 2)] = (byte)(101 - -j % 100000000 / 1000000);
                arrayOfByte[(i + 3)] = (byte)(101 - m);
                arrayOfByte[(i + 4)] = 102;
                k = 5;
              }
              else
              {
                m = -j % 100000000 / 1000000;

                if (m != 0)
                {
                  arrayOfByte[(i + 2)] = (byte)(101 - m);
                  arrayOfByte[(i + 3)] = 102;
                  k = 4;
                }
                else
                {
                  arrayOfByte[(i + 2)] = 102;
                  k = 3;
                }
              }
            }
          }

        }

      }
      else if (j < 100)
      {
        arrayOfByte[i] = -63;
        arrayOfByte[(i + 1)] = (byte)(j + 1);
        k = 2;
      }
      else if (j < 10000)
      {
        arrayOfByte[i] = -62;
        arrayOfByte[(i + 1)] = (byte)(j / 100 + 1);
        m = j % 100;

        if (m != 0)
        {
          arrayOfByte[(i + 2)] = (byte)(m + 1);
          k = 3;
        }
        else
        {
          k = 2;
        }
      }
      else if (j < 1000000)
      {
        arrayOfByte[i] = -61;
        arrayOfByte[(i + 1)] = (byte)(j / 10000 + 1);
        m = j % 100;

        if (m != 0)
        {
          arrayOfByte[(i + 2)] = (byte)(j % 10000 / 100 + 1);
          arrayOfByte[(i + 3)] = (byte)(m + 1);
          k = 4;
        }
        else
        {
          m = j % 10000 / 100;

          if (m != 0)
          {
            arrayOfByte[(i + 2)] = (byte)(m + 1);
            k = 3;
          }
          else
          {
            k = 2;
          }
        }
      }
      else if (j < 100000000)
      {
        arrayOfByte[i] = -60;
        arrayOfByte[(i + 1)] = (byte)(j / 1000000 + 1);
        m = j % 100;

        if (m != 0)
        {
          arrayOfByte[(i + 2)] = (byte)(j % 1000000 / 10000 + 1);
          arrayOfByte[(i + 3)] = (byte)(j % 10000 / 100 + 1);
          arrayOfByte[(i + 4)] = (byte)(m + 1);
          k = 5;
        }
        else
        {
          m = j % 10000 / 100;

          if (m != 0)
          {
            arrayOfByte[(i + 2)] = (byte)(j % 1000000 / 10000 + 1);
            arrayOfByte[(i + 3)] = (byte)(m + 1);
            k = 4;
          }
          else
          {
            m = j % 1000000 / 10000;

            if (m != 0)
            {
              arrayOfByte[(i + 2)] = (byte)(m + 1);
              k = 3;
            }
            else
            {
              k = 2;
            }
          }
        }
      }
      else
      {
        arrayOfByte[i] = -59;
        arrayOfByte[(i + 1)] = (byte)(j / 100000000 + 1);
        m = j % 100;

        if (m != 0)
        {
          arrayOfByte[(i + 2)] = (byte)(j % 100000000 / 1000000 + 1);
          arrayOfByte[(i + 3)] = (byte)(j % 1000000 / 10000 + 1);
          arrayOfByte[(i + 4)] = (byte)(j % 10000 / 100 + 1);
          arrayOfByte[(i + 5)] = (byte)(m + 1);
          k = 6;
        }
        else
        {
          m = j % 10000 / 100;

          if (m != 0)
          {
            arrayOfByte[(i + 2)] = (byte)(j % 100000000 / 1000000 + 1);
            arrayOfByte[(i + 3)] = (byte)(j % 1000000 / 10000 + 1);
            arrayOfByte[(i + 4)] = (byte)(m + 1);
            k = 5;
          }
          else
          {
            m = j % 1000000 / 10000;

            if (m != 0)
            {
              arrayOfByte[(i + 2)] = (byte)(j % 100000000 / 1000000 + 1);
              arrayOfByte[(i + 3)] = (byte)(m + 1);
              k = 4;
            }
            else
            {
              m = j % 100000000 / 1000000;

              if (m != 0)
              {
                arrayOfByte[(i + 2)] = (byte)(m + 1);
                k = 3;
              }
              else
              {
                k = 2;
              }
            }
          }
        }
      }
    }

    arrayOfByte[paramInt6] = (byte)k;
    paramArrayOfShort[paramInt9] = 0;
    paramArrayOfShort[paramInt8] = (short)(k + 1);
  }
}

/* Location:           D:\oracle\product\10.2.0\client_1\jdbc\lib\ojdbc14.jar
 * Qualified Name:     oracle.jdbc.driver.IntBinder
 * JD-Core Version:    0.6.0
 */