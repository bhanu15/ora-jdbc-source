package oracle.net.aso;

public class C05
  implements C00
{
  private static final byte[] k;
  private int[] l;
  private byte[] m = new byte[8];
  private static final int[] n;
  private static final byte[] o;
  private static final short[] p = { 128, 64, 32, 16, 8, 4, 2, 1 };
  private static final byte[] q;
  private static final int[] r;
  protected static final int s = 1;
  private int[] t;
  private int[] u;
  protected boolean v = false;
  private static final int[] w;
  protected static final byte x = 1;
  protected static final int y = 8;
  private static final int[] z;
  protected byte[] A = new byte[8];
  private static final int[] B;
  protected byte[] C = new byte[8];
  protected static final byte D = 0;
  private static final int[] E;
  protected byte[] F = new byte[8];
  private int[] G;
  private static final int[] H;
  private int[] I;
  private static final int[] J;
  private static final byte[] K;
  private static final int[] L = { 8388608, 4194304, 2097152, 1048576, 524288, 262144, 131072, 65536, 32768, 16384, 8192, 4096, 2048, 1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1 };
  private int[] M;
  protected static final int N = 2;

  protected void a(byte[] paramArrayOfByte, int[] paramArrayOfInt)
  {
    int i = 0;
    paramArrayOfInt[0] = ((paramArrayOfByte[i] & 0xFF) << 24);
    i++;
    paramArrayOfInt[0] |= (paramArrayOfByte[i] & 0xFF) << 16;
    i++;
    paramArrayOfInt[0] |= (paramArrayOfByte[i] & 0xFF) << 8;
    i++;
    paramArrayOfInt[0] |= paramArrayOfByte[i] & 0xFF;
    i++;
    paramArrayOfInt[1] = ((paramArrayOfByte[i] & 0xFF) << 24);
    i++;
    paramArrayOfInt[1] |= (paramArrayOfByte[i] & 0xFF) << 16;
    i++;
    paramArrayOfInt[1] |= (paramArrayOfByte[i] & 0xFF) << 8;
    i++;
    paramArrayOfInt[1] |= paramArrayOfByte[i] & 0xFF;
  }

  static
  {
    k = new byte[] { 56, 48, 40, 32, 24, 16, 8, 0, 57, 49, 41, 33, 25, 17, 9, 1, 58, 50, 42, 34, 26, 18, 10, 2, 59, 51, 43, 35, 62, 54, 46, 38, 30, 22, 14, 6, 61, 53, 45, 37, 29, 21, 13, 5, 60, 52, 44, 36, 28, 20, 12, 4, 27, 19, 11, 3 };
    q = new byte[] { 1, 2, 4, 6, 8, 10, 12, 14, 15, 17, 19, 21, 23, 25, 27, 28 };
    o = new byte[] { 13, 16, 10, 23, 0, 4, 2, 27, 14, 5, 20, 9, 22, 18, 11, 3, 25, 7, 15, 6, 26, 19, 12, 1, 40, 51, 30, 36, 46, 54, 29, 39, 50, 44, 32, 47, 43, 48, 38, 55, 33, 52, 45, 41, 49, 35, 28, 31 };
    K = new byte[] { 1, 35, 69, 103, -119, -85, -51, -17 };
    w = new int[] { 16843776, 0, 65536, 16843780, 16842756, 66564, 4, 65536, 1024, 16843776, 16843780, 1024, 16778244, 16842756, 16777216, 4, 1028, 16778240, 16778240, 66560, 66560, 16842752, 16842752, 16778244, 65540, 16777220, 16777220, 65540, 0, 1028, 66564, 16777216, 65536, 16843780, 4, 16842752, 16843776, 16777216, 16777216, 1024, 16842756, 65536, 66560, 16777220, 1024, 4, 16778244, 66564, 16843780, 65540, 16842752, 16778244, 16777220, 1028, 66564, 16843776, 1028, 16778240, 16778240, 0, 65540, 66560, 0, 16842756 };
    z = new int[] { -2146402272, -2147450880, 32768, 1081376, 1048576, 32, -2146435040, -2147450848, -2147483616, -2146402272, -2146402304, -2147483648, -2147450880, 1048576, 32, -2146435040, 1081344, 1048608, -2147450848, 0, -2147483648, 32768, 1081376, -2146435072, 1048608, -2147483616, 0, 1081344, 32800, -2146402304, -2146435072, 32800, 0, 1081376, -2146435040, 1048576, -2147450848, -2146435072, -2146402304, 32768, -2146435072, -2147450880, 32, -2146402272, 1081376, 32, 32768, -2147483648, 32800, -2146402304, 1048576, -2147483616, 1048608, -2147450848, -2147483616, 1048608, 1081344, 0, -2147450880, 32800, -2147483648, -2146435040, -2146402272, 1081344 };
    B = new int[] { 520, 134349312, 0, 134348808, 134218240, 0, 131592, 134218240, 131080, 134217736, 134217736, 131072, 134349320, 131080, 134348800, 520, 134217728, 8, 134349312, 512, 131584, 134348800, 134348808, 131592, 134218248, 131584, 131072, 134218248, 8, 134349320, 512, 134217728, 134349312, 134217728, 131080, 520, 131072, 134349312, 134218240, 0, 512, 131080, 134349320, 134218240, 134217736, 512, 0, 134348808, 134218248, 131072, 134217728, 134349320, 8, 131592, 131584, 134217736, 134348800, 134218248, 520, 134348800, 131592, 8, 134348808, 131584 };
    E = new int[] { 8396801, 8321, 8321, 128, 8396928, 8388737, 8388609, 8193, 0, 8396800, 8396800, 8396929, 129, 0, 8388736, 8388609, 1, 8192, 8388608, 8396801, 128, 8388608, 8193, 8320, 8388737, 1, 8320, 8388736, 8192, 8396928, 8396929, 129, 8388736, 8388609, 8396800, 8396929, 129, 0, 0, 8396800, 8320, 8388736, 8388737, 1, 8396801, 8321, 8321, 128, 8396929, 129, 1, 8192, 8388609, 8193, 8396928, 8388737, 8193, 8320, 8388608, 8396801, 128, 8388608, 8192, 8396928 };
    H = new int[] { 256, 34078976, 34078720, 1107296512, 524288, 256, 1073741824, 34078720, 1074266368, 524288, 33554688, 1074266368, 1107296512, 1107820544, 524544, 1073741824, 33554432, 1074266112, 1074266112, 0, 1073742080, 1107820800, 1107820800, 33554688, 1107820544, 1073742080, 0, 1107296256, 34078976, 33554432, 1107296256, 524544, 524288, 1107296512, 256, 33554432, 1073741824, 34078720, 1107296512, 1074266368, 33554688, 1073741824, 1107820544, 34078976, 1074266368, 256, 33554432, 1107820544, 1107820800, 524544, 1107296256, 1107820800, 34078720, 0, 1074266112, 1107296256, 524544, 33554688, 1073742080, 524288, 0, 1074266112, 34078976, 1073742080 };
    J = new int[] { 536870928, 541065216, 16384, 541081616, 541065216, 16, 541081616, 4194304, 536887296, 4210704, 4194304, 536870928, 4194320, 536887296, 536870912, 16400, 0, 4194320, 536887312, 16384, 4210688, 536887312, 16, 541065232, 541065232, 0, 4210704, 541081600, 16400, 4210688, 541081600, 536870912, 536887296, 16, 541065232, 4210688, 541081616, 4194304, 16400, 536870928, 4194304, 536887296, 536870912, 16400, 536870928, 541081616, 4210688, 541065216, 4210704, 541081600, 0, 541065232, 16, 16384, 541065216, 4210704, 16384, 4194320, 536887312, 0, 541081600, 536870912, 4194320, 536887312 };
    n = new int[] { 2097152, 69206018, 67110914, 0, 2048, 67110914, 2099202, 69208064, 69208066, 2097152, 0, 67108866, 2, 67108864, 69206018, 2050, 67110912, 2099202, 2097154, 67110912, 67108866, 69206016, 69208064, 2097154, 69206016, 2048, 2050, 69208066, 2099200, 2, 67108864, 2099200, 67108864, 2099200, 2097152, 67110914, 67110914, 69206018, 69206018, 2, 2097154, 67108864, 67110912, 2097152, 69208064, 2050, 2099202, 69208064, 2050, 67108866, 69208066, 69206016, 2099200, 0, 2, 69208066, 0, 2099202, 69206016, 2048, 67108866, 67110912, 2048, 2097154 };
    r = new int[] { 268439616, 4096, 262144, 268701760, 268435456, 268439616, 64, 268435456, 262208, 268697600, 268701760, 266240, 268701696, 266304, 4096, 64, 268697600, 268435520, 268439552, 4160, 266240, 262208, 268697664, 268701696, 4160, 0, 0, 268697664, 268435520, 268439552, 266304, 262144, 266304, 262144, 268701696, 4096, 64, 268697664, 4096, 266304, 268439552, 64, 268435520, 268697600, 268697664, 268435456, 262144, 268439616, 0, 268701760, 262208, 268435520, 268697600, 268439552, 268439616, 0, 268701760, 266240, 266240, 4160, 4160, 262208, 268435456, 268701696 };
  }

  private int[] b(int[] paramArrayOfInt)
  {
    int[] arrayOfInt3 = new int[32];
    int[] arrayOfInt1 = arrayOfInt3;
    int[] arrayOfInt2 = paramArrayOfInt;
    int i = 0;
    int j = 0;
    int i1 = 0;
    int i2 = 0;
    while (i < 16)
    {
      j = i1++;
      arrayOfInt1[i2] = ((arrayOfInt2[j] & 0xFC0000) << 6);
      arrayOfInt1[i2] |= (arrayOfInt2[j] & 0xFC0) << 10;
      arrayOfInt1[i2] |= (paramArrayOfInt[i1] & 0xFC0000) >> 10;
      arrayOfInt1[i2] |= (paramArrayOfInt[i1] & 0xFC0) >> 6;
      i2++;
      arrayOfInt1[i2] = ((arrayOfInt2[j] & 0x3F000) << 12);
      arrayOfInt1[i2] |= (arrayOfInt2[j] & 0x3F) << 16;
      arrayOfInt1[i2] |= (paramArrayOfInt[i1] & 0x3F000) >> 4;
      arrayOfInt1[i2] |= paramArrayOfInt[i1] & 0x3F;
      i2++;
      i++;
      i1++;
    }
    return arrayOfInt1;
  }

  public void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws C03
  {
    this.v = true;
    if ((paramArrayOfByte1 == null) && (paramArrayOfByte2 == null))
    {
      if (this.A == null)
        throw new C03(102);
      return;
    }
    if (paramArrayOfByte1.length < 24)
      throw new C03(102);
    System.arraycopy(paramArrayOfByte1, 0, this.A, 0, 8);
    System.arraycopy(paramArrayOfByte1, 8, this.C, 0, 8);
    System.arraycopy(paramArrayOfByte1, 16, this.F, 0, 8);
  }

  public void c()
  {
  }

  protected void d(int[] paramArrayOfInt, byte[] paramArrayOfByte)
  {
    int i = 0;
    paramArrayOfByte[i] = (byte)(paramArrayOfInt[0] >> 24 & 0xFF);
    i++;
    paramArrayOfByte[i] = (byte)(paramArrayOfInt[0] >> 16 & 0xFF);
    i++;
    paramArrayOfByte[i] = (byte)(paramArrayOfInt[0] >> 8 & 0xFF);
    i++;
    paramArrayOfByte[i] = (byte)(paramArrayOfInt[0] & 0xFF);
    i++;
    paramArrayOfByte[i] = (byte)(paramArrayOfInt[1] >> 24 & 0xFF);
    i++;
    paramArrayOfByte[i] = (byte)(paramArrayOfInt[1] >> 16 & 0xFF);
    i++;
    paramArrayOfByte[i] = (byte)(paramArrayOfInt[1] >> 8 & 0xFF);
    i++;
    paramArrayOfByte[i] = (byte)(paramArrayOfInt[1] & 0xFF);
  }

  protected void e(byte[] paramArrayOfByte, int[] paramArrayOfInt)
  {
    int[] arrayOfInt = new int[2];
    a(paramArrayOfByte, arrayOfInt);
    i(arrayOfInt, paramArrayOfInt);
    d(arrayOfInt, paramArrayOfByte);
  }

  public void c(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws C03
  {
    if ((paramArrayOfByte1 == null) && (paramArrayOfByte2 == null))
      throw new C03(102);
    if (paramArrayOfByte1.length < 24)
      throw new C03(102);
    System.arraycopy(paramArrayOfByte1, 0, this.A, 0, 8);
    System.arraycopy(paramArrayOfByte1, 8, this.C, 0, 8);
    System.arraycopy(paramArrayOfByte1, 16, this.F, 0, 8);
    this.v = true;
  }

  protected void f(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt)
  {
    int i;
    if (paramInt == 1)
      for (i = 0; i < 8; i++)
        paramArrayOfByte1[i] = (byte)(paramArrayOfByte2[i] & paramArrayOfByte3[i]);
    if (paramInt == 2)
      for (i = 0; i < 8; i++)
        paramArrayOfByte1[i] = (byte)(paramArrayOfByte2[i] ^ paramArrayOfByte3[i]);
  }

  protected int[] g(byte[] paramArrayOfByte, byte paramByte)
  {
    byte[] arrayOfByte1 = new byte[56];
    byte[] arrayOfByte2 = new byte[56];
    int[] arrayOfInt = new int[32];
    int i1;
    int i2;
    for (int j = 0; j < 56; j++)
    {
      i1 = k[j];
      i2 = i1 & 0x7;
      arrayOfByte1[j] = (byte)((paramArrayOfByte[(i1 >> 3)] & p[i2]) != 0 ? 1 : 0);
    }
    for (int i = 0; i < 16; i++)
    {
      if (paramByte == 1)
        i2 = 15 - i << 1;
      else
        i2 = i << 1;
      int i3 = i2 + 1;
      int tmp120_119 = 0;
      arrayOfInt[i3] = tmp120_119;
      arrayOfInt[i2] = tmp120_119;
      for (j = 0; j < 28; j++)
      {
        i1 = j + q[i];
        if (i1 < 28)
          arrayOfByte2[j] = arrayOfByte1[i1];
        else
          arrayOfByte2[j] = arrayOfByte1[(i1 - 28)];
      }
      for (j = 28; j < 56; j++)
      {
        i1 = j + q[i];
        if (i1 < 56)
          arrayOfByte2[j] = arrayOfByte1[i1];
        else
          arrayOfByte2[j] = arrayOfByte1[(i1 - 28)];
      }
      for (j = 0; j < 24; j++)
      {
        if (arrayOfByte2[o[j]] != 0)
          arrayOfInt[i2] |= L[j];
        if (arrayOfByte2[o[(j + 24)]] == 0)
          continue;
        arrayOfInt[i3] |= L[j];
      }
    }
    return b(arrayOfInt);
  }

  public byte[] e(byte[] paramArrayOfByte)
    throws C03
  {
    int i = paramArrayOfByte.length;
    int j = paramArrayOfByte[(i - 1)];
    if ((j < 0) || (j > 8))
      return null;
    int i1 = i - j;
    byte[] arrayOfByte1 = new byte[i - 1];
    i--;
    if (this.v == true)
      j(this.A, this.C, this.F, 1);
    for (int i2 = 0; i2 < i; i2 += 8)
    {
      byte[] arrayOfByte3 = new byte[8];
      System.arraycopy(paramArrayOfByte, i2, arrayOfByte3, 0, 8);
      byte[] arrayOfByte4 = h(arrayOfByte3, 1);
      System.arraycopy(arrayOfByte4, 0, arrayOfByte1, i2, 8);
    }
    byte[] arrayOfByte2 = new byte[i1];
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, i1);
    return arrayOfByte2;
  }

  public int b()
  {
    return 8;
  }

  private byte[] h(byte[] paramArrayOfByte, byte paramByte)
  {
    byte[] arrayOfByte1 = new byte[8];
    if (paramByte == 0)
    {
      f(arrayOfByte1, this.m, paramArrayOfByte, 2);
      e(arrayOfByte1, this.u);
      e(arrayOfByte1, this.I);
      e(arrayOfByte1, this.l);
      System.arraycopy(arrayOfByte1, 0, this.m, 0, 8);
    }
    else
    {
      byte[] arrayOfByte2 = new byte[8];
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte2, 0, 8);
      e(paramArrayOfByte, this.t);
      e(paramArrayOfByte, this.G);
      e(paramArrayOfByte, this.M);
      f(arrayOfByte1, this.m, paramArrayOfByte, 2);
      System.arraycopy(arrayOfByte2, 0, this.m, 0, 8);
    }
    return arrayOfByte1;
  }

  protected void i(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int i4 = 0;
    int i5 = 0;
    int i2 = paramArrayOfInt1[0];
    int i1 = paramArrayOfInt1[1];
    int j = (i2 >>> 4 ^ i1) & 0xF0F0F0F;
    i1 ^= j;
    i2 ^= j << 4;
    j = (i2 >>> 16 ^ i1) & 0xFFFF;
    i1 ^= j;
    i2 ^= j << 16;
    j = (i1 >>> 2 ^ i2) & 0x33333333;
    i2 ^= j;
    i1 ^= j << 2;
    j = (i1 >>> 8 ^ i2) & 0xFF00FF;
    i2 ^= j;
    i1 ^= j << 8;
    i1 = (i1 << 1 | i1 >>> 31 & 0x1) & 0xFFFFFFFF;
    j = (i2 ^ i1) & 0xAAAAAAAA;
    i2 ^= j;
    i1 ^= j;
    i2 = (i2 << 1 | i2 >>> 31 & 0x1) & 0xFFFFFFFF;
    for (int i3 = 0; i3 < 8; i3++)
    {
      j = i1 << 28 | i1 >>> 4;
      long l1 = 0L;
      l1 = paramArrayOfInt2[i5] | 0x0;
      j ^= paramArrayOfInt2[i5];
      i5++;
      int i = n[(j & 0x3F)];
      i |= H[(j >>> 8 & 0x3F)];
      i |= B[(j >>> 16 & 0x3F)];
      i |= w[(j >>> 24 & 0x3F)];
      j = i1 ^ paramArrayOfInt2[i5];
      i5++;
      i |= r[(j & 0x3F)];
      i |= J[(j >>> 8 & 0x3F)];
      i |= E[(j >>> 16 & 0x3F)];
      i |= z[(j >>> 24 & 0x3F)];
      i2 ^= i;
      j = i2 << 28 | i2 >>> 4;
      j ^= paramArrayOfInt2[i5];
      i5++;
      i = n[(j & 0x3F)];
      i |= H[(j >>> 8 & 0x3F)];
      i |= B[(j >>> 16 & 0x3F)];
      i |= w[(j >>> 24 & 0x3F)];
      j = i2 ^ paramArrayOfInt2[i5];
      i5++;
      i |= r[(j & 0x3F)];
      i |= J[(j >>> 8 & 0x3F)];
      i |= E[(j >>> 16 & 0x3F)];
      i |= z[(j >>> 24 & 0x3F)];
      i1 ^= i;
    }
    i1 = i1 << 31 | i1 >>> 1;
    j = (i2 ^ i1) & 0xAAAAAAAA;
    i2 ^= j;
    i1 ^= j;
    i2 = i2 << 31 | i2 >>> 1;
    j = (i2 >>> 8 ^ i1) & 0xFF00FF;
    i1 ^= j;
    i2 ^= j << 8;
    j = (i2 >>> 2 ^ i1) & 0x33333333;
    i1 ^= j;
    i2 ^= j << 2;
    j = (i1 >>> 16 ^ i2) & 0xFFFF;
    i2 ^= j;
    i1 ^= j << 16;
    j = (i1 >>> 4 ^ i2) & 0xF0F0F0F;
    i2 ^= j;
    i1 ^= j << 4;
    paramArrayOfInt1[0] = i1;
    paramArrayOfInt1[1] = i2;
  }

  public byte[] d(byte[] paramArrayOfByte)
    throws C03
  {
    int i = paramArrayOfByte.length;
    int j = (byte)(i % 8 == 0 ? 0 : 8 - i % 8);
    int i1 = i + j;
    byte[] arrayOfByte1 = new byte[i1 + 1];
    if (this.v == true)
      j(this.A, this.C, this.F, 0);
    for (int i2 = 0; i2 < i; i2 += 8)
    {
      byte[] arrayOfByte2 = new byte[8];
      if (i2 <= i - 8)
        System.arraycopy(paramArrayOfByte, i2, arrayOfByte2, 0, 8);
      else
        System.arraycopy(paramArrayOfByte, i2, arrayOfByte2, 0, i & 0x7);
      byte[] arrayOfByte3 = h(arrayOfByte2, 0);
      System.arraycopy(arrayOfByte3, 0, arrayOfByte1, i2, 8);
    }
    arrayOfByte1[i1] = (byte)(j + 1);
    return arrayOfByte1;
  }

  protected void j(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte paramByte)
  {
    System.arraycopy(paramArrayOfByte1, 0, this.A, 0, 8);
    System.arraycopy(paramArrayOfByte2, 0, this.C, 0, 8);
    System.arraycopy(paramArrayOfByte3, 0, this.F, 0, 8);
    this.u = g(this.A, paramByte);
    this.I = g(this.C, paramByte == 0 ? 1 : 0);
    this.l = g(this.F, paramByte);
    this.t = g(this.A, paramByte);
    this.G = g(this.C, paramByte == 0 ? 1 : 0);
    this.M = g(this.F, paramByte);
    System.arraycopy(K, 0, this.m, 0, 8);
    this.v = false;
  }
}

/* Location:           D:\oracle\product\10.2.0\client_1\jdbc\lib\ojdbc14.jar
 * Qualified Name:     oracle.net.aso.C05
 * JD-Core Version:    0.6.0
 */