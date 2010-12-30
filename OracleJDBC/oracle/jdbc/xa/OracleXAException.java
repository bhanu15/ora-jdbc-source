package oracle.jdbc.xa;

import javax.transaction.xa.XAException;

public class OracleXAException extends XAException
{
  private int xaError = 0;
  private int primary = 0;
  private int secondary = 0;

  private static final String _Copyright_2004_Oracle_All_Rights_Reserved_ = null;
  public static final boolean TRACE = false;
  public static final boolean PRIVATE_TRACE = false;
  public static final String BUILD_DATE = "Wed_Jun_22_11:18:55_PDT_2005";

  public OracleXAException()
  {
  }

  public OracleXAException(int paramInt)
  {
    super(errorConvert(paramInt));

    this.xaError = errorConvert(paramInt);
    this.primary = (paramInt & 0xFFFF);
    this.secondary = (paramInt >> 16);
  }

  public static int errorConvert(int paramInt)
  {
    switch (paramInt & 0xFFFF)
    {
    case 24756:
      return -4;
    case 25351:
      return 4;
    case 24764:
      return 7;
    case 24765:
      return 6;
    case 24766:
      return 5;
    case 24767:
      return 3;
    case 1033:
    case 1034:
    case 1041:
    case 1089:
    case 1090:
    case 3113:
    case 3114:
    case 12571:
    case 17002:
    case 17410:
    case 24768:
      return -7;
    case 24763:
    case 24769:
    case 24770:
    case 24776:
      return -6;
    case 2091:
    case 2092:
    case 24761:
      return 100;
    }

    return -3;
  }

  public int getXAError()
  {
    return this.xaError;
  }

  public int getOracleError()
  {
    return this.primary;
  }

  public int getOracleSQLError()
  {
    return this.secondary;
  }

  public static String getXAErrorMessage(int paramInt)
  {
    switch (paramInt)
    {
    case 7:
      return "The transaction branch has been heuristically committed.";
    case 8:
      return "The transaction branch may have been heuristically completed.";
    case 5:
      return "The transaction branch has been heuristically committed and rolled back.";
    case 6:
      return "The transaction branch has been heuristically rolled back.";
    case 9:
      return "Resumption must occur where suspension occured.";
    case 100:
      return "The inclusive lower bound oof the rollback codes.";
    case 101:
      return "Rollback was caused by communication failure.";
    case 102:
      return "A deadlock was detected.";
    case 107:
      return "The inclusive upper bound of the rollback error code.";
    case 103:
      return "A condition that violates the integrity of the resource was detected.";
    case 104:
      return "The resource manager rolled back the transaction branch for a reason not on this list.";
    case 105:
      return "A protocol error occured in the resource manager.";
    case 106:
      return "A transaction branch took too long.";
    case 3:
      return "The transaction branch has been read-only and has been committed.";
    case 4:
      return "Routine returned with no effect and may be reissued.";
    case -2:
      return "Asynchronous operation already outstanding.";
    case -8:
      return "The XID already exists.";
    case -5:
      return "Invalid arguments were given.";
    case -4:
      return "The XID is not valid.";
    case -9:
      return "The resource manager is doing work outside global transaction.";
    case -6:
      return "Routine was invoked in an inproper context.";
    case -3:
      return "A resource manager error has occured in the transaction branch.";
    case -7:
      return "Resource manager is unavailable.";
    }

    return "Internal XA Error";
  }
}

/* Location:           D:\oracle\product\10.2.0\client_1\jdbc\lib\ojdbc14.jar
 * Qualified Name:     oracle.jdbc.xa.OracleXAException
 * JD-Core Version:    0.6.0
 */