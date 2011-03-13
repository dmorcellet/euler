package problems.p101_150;

/**
 * Solved 12.03.2011.
 * @author DAM
 */
public class MainP104
{
  private static double PHI=(1+Math.sqrt(5))/2;
  private static double LOG_PHI=Math.log10(PHI);
  private static double LOG_SQRT5=Math.log10(Math.sqrt(5));

  private MainP104()
  {
    // Nothing to do !
  }

  private static boolean[] digits=new boolean[10+1];

  private boolean checkPandigital(int n)
  {
    for(int i=1;i<=10;i++) digits[i]=false;
    for(int i=0;i<9;i++)
    {
      int d=n%10;
      if (digits[d]) return false;
      digits[d]=true;
      n/=10;
    }
    return true;
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    int n=1;
    int n2=1;
    int k=3;
    while(true)
    {
      int nextN=(n+n2)%1000000000;
      if (checkPandigital(nextN))
      {
        // Compute last 9 digits
        double logFk=k*LOG_PHI-LOG_SQRT5;
        int topDigits=(int)Math.pow(10,logFk-(int)logFk+8);
        if (checkPandigital(topDigits))
        {
          break;
        }
      }
      n=n2;
      n2=nextN;
      k++;
    }
    long now2=System.currentTimeMillis();
    System.out.println("result="+k+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP104 m=new MainP104();
    m.doIt();
  }
}
