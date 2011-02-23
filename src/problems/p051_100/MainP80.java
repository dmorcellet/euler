package problems.p051_100;

import java.math.BigInteger;

/**
 * Solved 30.01.2011.
 * @author DAM
 */
public class MainP80
{
  private static final BigInteger TEN=BigInteger.valueOf(10);
  private static final BigInteger TWENTY=BigInteger.valueOf(20);
  private static final BigInteger HUNDRED=BigInteger.valueOf(100);
  private static final int NB_DIGITS=100;
  private MainP80()
  {
    // Nothing to do !
  }

  private int computeSquareRoot(int n)
  {
    int nbDigits=0;
    BigInteger bigP=BigInteger.ZERO;
    BigInteger bigC=BigInteger.valueOf(n);
    int sumOfDigits=0;
    for(int i=0;i<NB_DIGITS;i++)
    {
      int x=0;
      BigInteger bigJ;
      BigInteger bigY=null;
      for(int j=9;j>=0;j--)
      {
        bigJ=BigInteger.valueOf(j);
        bigY=bigP.multiply(TWENTY).add(bigJ).multiply(bigJ);
        if (bigY.compareTo(bigC)<=0)
        {
          x=j;
          break;
        }
      }
      //System.out.print(x);
      sumOfDigits+=x;
      nbDigits++;
      bigP=bigP.multiply(TEN).add(BigInteger.valueOf(x));
      bigC=bigC.subtract(bigY);
      if (bigC.compareTo(BigInteger.ZERO)==0) break;
      bigC=bigC.multiply(HUNDRED);
    }
    //System.out.println("");
    if (nbDigits>10) return sumOfDigits;
    return 0;
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    long sum=0;
    for(int i=1;i<100;i++)
    {
      int sumOfDigits=computeSquareRoot(i);
      sum+=sumOfDigits;
    }
    long now2=System.currentTimeMillis();
    System.out.println("result="+sum+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP80 m=new MainP80();
    m.doIt();
  }
}
