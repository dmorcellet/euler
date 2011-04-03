package problems.p101_150;

/**
 * Solved 03.04.2011.
 * @author DAM
 */
public class MainP145
{
  private static final int MAX=1000000000;

  private MainP145()
  {
    // Nothing to do !
  }

  private int reverse(int n)
  {
    int ret=0;
    while (n>0)
    {
      int d=n%10;
      n/=10;
      ret*=10;
      ret+=d;
    }
    return ret;
  }

  private boolean isEntirelyOdd(int n)
  {
    while (n>0)
    {
      if ((n&1)==0) return false;
      n/=10;
    }
    return true;
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    int nb=0;
    for(int i=1;i<MAX;i++)
    {
      if (i%10>0)
      {
        int sum=i+reverse(i);
        if (isEntirelyOdd(sum))
        {
          //System.out.println("Sum="+sum+", n="+i);
          nb++;
        }
      }
    }
    //System.out.println(reverse(123456));
    long now2=System.currentTimeMillis();
    System.out.println("result="+nb+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP145 m=new MainP145();
    m.doIt();
  }
}
