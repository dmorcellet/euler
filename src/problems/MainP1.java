package problems;

/**
 * @author DAM
 */
public class MainP1
{
  private static final int MAX=999;
  private void doIt1()
  {
    int sum=0;
    for(int i=1;i<=MAX;i++)
    {
      if ((i%3==0) || (i%5==0))
      {
        sum+=i;
      }
    }
    System.out.println("Result="+sum);
  }

  private void doIt2()
  {
    int sum=sumDivisibleBy(MAX,3)+sumDivisibleBy(MAX,5)-sumDivisibleBy(MAX,15);
    System.out.println("Result="+sum);
  }

  private int sumDivisibleBy(int max, int n)
  {
    int d=max/n;
    return n*(d*(d+1))/2;
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP1 m=new MainP1();
    m.doIt1();
    m.doIt2();
  }
}
