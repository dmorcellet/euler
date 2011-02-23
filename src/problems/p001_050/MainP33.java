package problems.p001_050;

/**
 * Solved 19.12.2010.
 * @author DAM
 */
public class MainP33
{
  private MainP33()
  {
    // Nothing to do !
  }

  private boolean examine(int a, int b, int n, int p)
  {
    // Examine fraction a/b can be reduced to n/p
    if (a*p==b*n)
    {
      //System.out.println(a+"/"+b+" = "+n+"/"+p);
      return true;
    }
    return false;
  }
  
  private void doIt()
  {
    long now=System.currentTimeMillis();
    int a=1;
    int b=1;
    for(int i=11;i<=99;i++)
    {
      for(int j=10;j<i;j++)
      {
        //System.out.println("Fraction "+j+"/"+i);
        if (i/10==j%10)
        {
          if (examine(j,i,j/10,i%10))
          {
            a*=j;b*=i;
          }
        }
        else if (i%10==j/10)
        {
          if (examine(j,i,j%10,i/10))
          {
            a*=j;b*=i;
          }
        }
      }
    }
    //System.out.println(a+"/"+b);
    int result=b/a;
    long now2=System.currentTimeMillis();
    System.out.println("result="+result+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP33 m=new MainP33();
    m.doIt();
  }
}
