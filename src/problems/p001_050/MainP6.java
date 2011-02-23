package problems.p001_050;

/**
 * @author DAM
 */
public class MainP6
{
  private void doIt()
  {
    long now=System.currentTimeMillis();
    int sumOfSquares=0;
    int sum=0;
    final int N=100;
    for(int i=1;i<=N;i++)
    {
      sumOfSquares+=(i*i);
      sum+=i;
    }
    int diff=sum*sum-sumOfSquares;
    long now2=System.currentTimeMillis();
    System.out.println("result="+diff+" ("+(now2-now)+"ms).");
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
