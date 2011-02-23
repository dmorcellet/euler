package problems.p001_050;

/**
 * Solved 26.12.2010.
 * @author DAM
 */
public class MainP36
{
  private static final int MAX=1000000;

  private MainP36()
  {
    // Nothing to do !
  }

  private int nbDigitsBase10(int n)
  {
    if (n<10) return 1;
    if (n<100) return 2;
    if (n<1000) return 3;
    if (n<10000) return 4;
    if (n<100000) return 5;
    if (n<1000000) return 6;
    return 7;
  }

  private int nbDigitsBase2(int n)
  {
    int max=2;
    int nb=1;
    while (nb<32)
    {
      if (n<max) return nb;
      max=max*2;
      nb++;
    }
    return 32;
  }

  private int getDigitBase10(int n, int digit)
  {
    for(int i=0;i<digit;i++) n/=10;
    return n%10;
  }

  private int getDigitBase2(int n, int digit)
  {
    for(int i=0;i<digit;i++) n/=2;
    return n%2;
  }

  private boolean isPalindromicBase10(int n)
  {
    boolean ok=true;
    int nbDigits=nbDigitsBase10(n);
    int nbChecks=nbDigits/2+(nbDigits%2);
    for(int i=0;i<nbChecks;i++)
    {
      int digit1=getDigitBase10(n,i);
      int digit2=getDigitBase10(n,nbDigits-i-1);
      if (digit1!=digit2)
      {
        ok=false;
      }
    }
    return ok;
  }

  private boolean isPalindromicBase2(int n)
  {
    boolean ok=true;
    int nbDigits=nbDigitsBase2(n);
    int nbChecks=nbDigits/2+(nbDigits%2);
    for(int i=0;i<nbChecks;i++)
    {
      int digit1=getDigitBase2(n,i);
      int digit2=getDigitBase2(n,nbDigits-i-1);
      if (digit1!=digit2)
      {
        ok=false;
      }
    }
    return ok;
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    int sum=0;
    for(int i=1;i<=MAX;i++)
    {
      if ((isPalindromicBase10(i)) && (isPalindromicBase2(i)))
      {
        sum+=i;
        //System.out.println("Found i="+i);
      }
    }
    long now2=System.currentTimeMillis();
    System.out.println("result="+sum+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP36 m=new MainP36();
    m.doIt();
  }
}
