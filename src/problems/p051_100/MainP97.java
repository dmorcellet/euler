package problems.p051_100;

import problems.tools.LimitedLengthComputation;

/**
 * Solved 12.02.2011.
 * @author DAM
 */
public class MainP97
{
  private static final long MAX=10000000000L;
  private static final int POWER=7830457;
  private static final int FACTOR=28433;

  private MainP97()
  {
    // Nothing to do !
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    // FACTOR and POWER are prime
    long pow10=1;
    for(int i=1;i<=10;i++) pow10*=2;
    int times=POWER/10;
    long r=1;
    for(int i=1;i<=times;i++)
    {
      r=LimitedLengthComputation.multiplication(r,pow10,MAX);
    }
    int mod=POWER%10;
    for(int i=1;i<=mod;i++) r=LimitedLengthComputation.multiplication(r,2,MAX);
    r=LimitedLengthComputation.multiplication(r,FACTOR,MAX);
    r=LimitedLengthComputation.sum(r,1,MAX);
    long now2=System.currentTimeMillis();
    System.out.println("result="+r+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP97 m=new MainP97();
    m.doIt();
  }
}
