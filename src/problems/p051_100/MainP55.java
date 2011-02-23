package problems.p051_100;

import java.math.BigInteger;

/**
 * Solved 08.01.2011.
 * @author DAM
 */
public class MainP55
{
  private static final int MAX_STEPS=50;

  private MainP55()
  {
    // Nothing to do !
  }

  private BigInteger reverse(BigInteger bigInt)
  {
    String nStr=bigInt.toString();
    StringBuilder sb=new StringBuilder(nStr.length());
    for(int i=nStr.length()-1;i>=0;i--) sb.append(nStr.charAt(i));
    BigInteger b=new BigInteger(sb.toString());
    return b;
  }
  
  private boolean isPalindromic(BigInteger bigInt)
  {
    String s=bigInt.toString();
    int size=s.length();
    int nChecks=size/2+(size%2);
    boolean palindromic=true;
    for(int i=0;i<nChecks;i++)
    {
      if (s.charAt(i)!=s.charAt(s.length()-i-1))
      {
        palindromic=false;
        break;
      }
    }
    return palindromic;
  }

  private boolean isLychrel(int n)
  {
    BigInteger bigInt=BigInteger.valueOf(n);
    int step=0;
    while(step<MAX_STEPS)
    {
      step++;
      BigInteger reverse=reverse(bigInt);
      bigInt=reverse.add(bigInt);
      if (isPalindromic(bigInt))
      {
        break;
      }
    }
    return (step==MAX_STEPS);
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    int nbLychrel=0;
    for(int i=1;i<=10000;i++)
    {
      if (isLychrel(i))
      {
        //System.out.println(i);
        nbLychrel++;
      }
    }
    long now2=System.currentTimeMillis();
    System.out.println("result="+nbLychrel+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP55 m=new MainP55();
    m.doIt();
  }
}
