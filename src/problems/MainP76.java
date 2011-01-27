package problems;

/**
 * Solved 27.01.2011.
 * @author DAM
 */
public class MainP76
{
  private static final int MAX=100;

  private int[][] _nb;

  private MainP76()
  {
    _nb=new int[MAX+1][];
    _nb[0]=new int[1];
    _nb[0][0]=1;
    for(int i=1;i<=MAX;i++)
    {
      _nb[i]=new int[i+1];
      _nb[i][1]=1;
    }
  }

  private int getNb(int sum, int maxItem)
  {
    if (maxItem>sum) maxItem=sum;
    int value=_nb[sum][maxItem];
    if (value==0)
    {
      for(int i=maxItem;i>=1;i--)
      {
        value+=getNb(sum-i,i);
      }
      _nb[sum][maxItem]=value;
    }
    return value; 
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    int nb=getNb(MAX,MAX)-1;
    long now2=System.currentTimeMillis();
    System.out.println("result="+nb+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP76 m=new MainP76();
    m.doIt();
  }
}
