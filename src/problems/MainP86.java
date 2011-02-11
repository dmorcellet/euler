package problems;

/**
 * Solved 11.02.2011.
 * @author DAM
 */
public class MainP86
{
  private static final int MAX=1000000;

  private MainP86()
  {
    // Nothing to do !
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    int nb=0;
    int m=2;
    while (nb<MAX)
    {
      m++;
      // n=i+j
      for(int n=2;n<=2*m;n++)
      {
        double min=Math.sqrt(m*m+n*n);
        if (min==(int)min)
        {
          int minj=(n/2)+n%2;
          int maxj=n-1;
          if (maxj>m) maxj=m;
          int diff=maxj-minj+1;
          if (diff>0) nb+=diff;
          //System.out.println("m="+m+", n="+n+", diff="+diff);
        }
      }
      //System.out.println("m="+m+", nb="+nb);
    }
    long now2=System.currentTimeMillis();
    System.out.println("result="+m+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP86 m=new MainP86();
    m.doIt();
  }
}
