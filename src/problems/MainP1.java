package problems;

/**
 * @author DAM
 */
public class MainP1
{
  private static final int MAX=999;

  private void doIt1()
  {
    long now=System.currentTimeMillis();
    int sum=0;
    for(int i=1;i<=MAX;i++)
    {
      if ((i%3==0) || (i%5==0))
      {
        sum+=i;
      }
    }
    long now2=System.currentTimeMillis();
    System.out.println("result="+sum+" ("+(now2-now)+"ms).");
  }

  /*
  private void doIt2()
  {
    long now=System.currentTimeMillis();
    int sum=sumDivisibleBy(MAX,3)+sumDivisibleBy(MAX,5)-sumDivisibleBy(MAX,15);
    long now2=System.currentTimeMillis();
    System.out.println("result="+sum+" ("+(now2-now)+"ms).");
  }

  private int sumDivisibleBy(int max, int n)
  {
    int d=max/n;
    return n*(d*(d+1))/2;
  }
  */

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP1 m=new MainP1();
    m.doIt1();
    //m.doIt2();
  }
}
