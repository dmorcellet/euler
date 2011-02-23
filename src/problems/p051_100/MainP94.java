package problems.p051_100;

/**
 * Solved 19.02.2011.
 * To be optimized (11s on desktop PC!).
 * @author DAM
 */
public class MainP94
{
  private MainP94()
  {
    // Nothing to do !
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    long r=0;
    for(long n=2;n<=335000000;n++)
    {
      long h2=n*n*3-2*n-1;
      if (h2%4==0)
      {
        h2=h2/4;
        long root=(long)Math.sqrt(h2);
        if (root*root==h2)
        {
          //System.out.println("1) n="+n+", root="+root+", a="+(n+1)*root/2);
          r+=3*n+1;
        }
      }
      h2=n*n*3+2*n-1;
      if (h2%4==0)
      {
        h2=h2/4;
        long root=(long)Math.sqrt(h2);
        if (root*root==h2)
        {
          //System.out.println("2) n="+n+", root="+root+", a="+(n+1)*root/2);
          r+=3*n-1;
        }
      }
    }
    long now2=System.currentTimeMillis();
    System.out.println("result="+r+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP94 m=new MainP94();
    m.doIt();
  }
}
