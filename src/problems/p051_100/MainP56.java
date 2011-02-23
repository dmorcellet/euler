package problems.p051_100;

import java.math.BigInteger;

/**
 * Solved 08.01.2011.
 * @author DAM
 */
public class MainP56
{
  private MainP56()
  {
    // Nothing to do !
  }

  private int sumOfDigits(BigInteger n)
  {
    final String s=n.toString();
    int sum=0;
    for(int i=0;i<s.length();i++)
    {
      sum+=(s.charAt(i)-'0');
    }
    return sum;
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    int maxSum=0;
    for(int a=1;a<=100;a++)
    {
      BigInteger ba=BigInteger.valueOf(a);
      BigInteger p=BigInteger.valueOf(a);
      int sum=sumOfDigits(p);
      if (sum>maxSum) maxSum=sum;
      for(int b=1;b<=100;b++)
      {
        p=p.multiply(ba);
        sum=sumOfDigits(p);
        if (sum>maxSum)
        {
          //System.out.println("a="+a+", b="+b+", a^b="+p+", sum="+sum);
          maxSum=sum;
        }
      }
    }
    long now2=System.currentTimeMillis();
    System.out.println("result="+maxSum+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP56 m=new MainP56();
    m.doIt();
  }
}
