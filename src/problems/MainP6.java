package problems;

/**
 * @author DAM
 */
public class MainP6
{
  private void doIt()
  {
    int sumOfSquares=0;
    int sum=0;
    final int N=100;
    for(int i=1;i<=N;i++)
    {
      sumOfSquares+=(i*i);
      sum+=i;
    }
    int diff=sum*sum-sumOfSquares;
    System.out.println("diff="+diff);
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP6 m=new MainP6();
    m.doIt();
  }
}
