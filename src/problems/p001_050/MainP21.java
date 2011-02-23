package problems.p001_050;

/**
 * Solved 13.12.2010.
 * @author DAM
 */
public class MainP21
{
  private int[] d;
  private static final int MAX=10000;

  private MainP21()
  {
    d=new int[MAX+1];
  }

  private int d(int n)
  {
    int sumOfDivisors=0;
    int max=n/2+1;
    for(int i=1;i<=max;i++)
    {
      if (n%i==0) sumOfDivisors+=i;
    }
    //System.out.println("n="+n+"->"+sumOfDivisors);
    return sumOfDivisors;
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    // Compute all values of d
    for(int i=1;i<=MAX;i++)
    {
      d[i]=d(i);
    }
    int sum=0;
    for(int i=1;i<=MAX;i++)
    {
      for(int j=1;j<=MAX;j++)
      {
        if ((i!=j) && (d[i]==j) && (d[j]==i))
        {
          sum+=i;
          //System.out.println("i="+i+" is amicable with j="+j);
          break;
        }
      }
    }
    long now2=System.currentTimeMillis();
    System.out.println("result="+sum+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP21 m=new MainP21();
    m.doIt();
  }
}
