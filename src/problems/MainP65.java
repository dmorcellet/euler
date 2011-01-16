package problems;

import java.math.BigInteger;

/**
 * Solved 16.01.2011.
 * @author DAM
 */
public class MainP65
{
  private MainP65()
  {
    // Nothing to do !
  }

  // n>=1
  private int getTermAt(int n)
  {
    if (n==1) return 2;
    int indexInGroup=(n-2)%3;
    if (indexInGroup==0) return 1;
    if (indexInGroup==2) return 1;
    int group=(n-2)/3;
    return 2*(group+1);
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    // e: 2; 1,2,1, 1,4,1, 1,6,1 , ... , 1,2k,1, ...]
    //for(int i=1;i<=100;i++) System.out.println(getTermAt(i));
    int rank=100;
    BigInteger numerator=BigInteger.valueOf(getTermAt(rank));
    BigInteger denominator=BigInteger.valueOf(1);
    for(int i=rank-1;i>=1;i--)
    {
      BigInteger term=BigInteger.valueOf(getTermAt(i));
      BigInteger newNumerator=numerator.multiply(term).add(denominator);
      denominator=numerator;
      numerator=newNumerator;
    }
    // add first term as an int...
    //System.out.println("n="+numerator+", d="+denominator);
    int sumDigits=0;
    String digitsStr=numerator.toString();
    int nbDigits=digitsStr.length();
    for(int i=0;i<nbDigits;i++)
    {
      sumDigits+=(digitsStr.charAt(i)-'0');
    }
    long now2=System.currentTimeMillis();
    System.out.println("result="+sumDigits+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP65 m=new MainP65();
    m.doIt();
  }
}


