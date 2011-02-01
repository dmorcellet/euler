package problems;

/**
 * Solved 01.02.2011.
 * @author DAM
 */
public class MainP85
{
  private static final int TARGET=2000000;
  private static final int NMAX=100;

  private MainP85()
  {
    // Nothing to do !
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    int bestN=-1,bestP=-1;
    long bestDiff=TARGET;
    // n=77,p=36=>diff=2
    // how can we be sure that this is the best diff ?
    // problems says that diff=0 is not possible, but what about diff=1 ?
    for(int n=1;n<=NMAX;n++)
    {
      long nb1=n*(n+1);
      for(int p=1;p<=n;p++)
      {
        long nb2=(p*(p+1)*nb1)/4;
        long diff=nb2-TARGET;
        if (diff<0) diff=-diff;
        if (diff<bestDiff)
        {
          bestN=n;
          bestP=p;
          bestDiff=diff;
          System.out.println("n="+n+", p="+p+", diff="+diff);
        }
      }
    }
    int result=bestN*bestP;
    long now2=System.currentTimeMillis();
    System.out.println("result="+result+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP85 m=new MainP85();
    m.doIt();
  }
}
