package problems.p051_100;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

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

  /**
   * Compute the fraction using the given terms.
   * @param terms Numbers to use.
   * @return A fraction.
   */
  public static BigInteger[] computeContinuedFraction(List<Integer> terms)
  {
    int rank=terms.size()-1;
    BigInteger numerator=BigInteger.valueOf(terms.get(rank).intValue());
    BigInteger denominator=BigInteger.valueOf(1);
    for(int i=rank-1;i>=0;i--)
    {
      BigInteger term=BigInteger.valueOf(terms.get(i).intValue());
      BigInteger newNumerator=numerator.multiply(term).add(denominator);
      denominator=numerator;
      numerator=newNumerator;
    }
    return new BigInteger[]{numerator,denominator};
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    // e: 2; 1,2,1, 1,4,1, 1,6,1 , ... , 1,2k,1, ...]
    //for(int i=1;i<=100;i++) System.out.println(getTermAt(i));
    int rank=100;
    List<Integer> terms=new ArrayList<Integer>();
    for(int i=1;i<=rank;i++) terms.add(Integer.valueOf(getTermAt(i)));
    BigInteger[] fraction=computeContinuedFraction(terms);
    BigInteger numerator=fraction[0];
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


