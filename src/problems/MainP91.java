package problems;

/**
 * Solved 19.02.2011.
 * @author DAM
 */
public class MainP91
{
  private static final int MAX=50;

  private MainP91()
  {
    // Nothing to do !
  }

  private boolean test(int x1, int y1, int x2, int y2)
  {
    int p1=x1*x2+y1*y2;
    if (p1==0) return true;
    int p2=x1*(x2-x1)+(y2-y1)*y1;
    if (p2==0) return true;
    int p3=(x1-x2)*x2+(y1-y2)*y2;
    if (p3==0) return true;
    return false;
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    int count=0;
    for(int x1=0;x1<=MAX;x1++)
    {
      for(int y1=0;y1<=MAX;y1++)
      {
        if ((x1!=0) || (y1!=0))
        {
          for(int x2=0;x2<=MAX;x2++)
          {
            for(int y2=0;y2<=MAX;y2++)
            {
              if (((x2!=0) || (y2!=0)) && ((x1!=x2) || (y1!=y2)))
              {
                if (test(x1,y1,x2,y2))
                {
                  //System.out.println("("+x1+","+y1+") ("+x2+","+y2+")");
                  count++;
                }
              }
            }
          }
        }
      }
    }
    count/=2;
    long now2=System.currentTimeMillis();
    System.out.println("result="+count+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP91 m=new MainP91();
    m.doIt();
  }
}
