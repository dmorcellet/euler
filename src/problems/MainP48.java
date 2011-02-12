package problems;

import problems.tools.LimitedLengthComputation;

/**
 * Solved 03.01.2011.
 * @author DAM
 */
public class MainP48
{
  private static final long MAX=10000000000L; 
  private MainP48()
  {
    // Nothing to do !
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    long r=0;
    for(int i=1;i<=1000;i++)
    {
      long item=LimitedLengthComputation.power(i,i,MAX);
      r=LimitedLengthComputation.sum(r,item,MAX);
    }
    long now2=System.currentTimeMillis();
    System.out.println("result="+r+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP48 m=new MainP48();
    m.doIt();
  }
}
