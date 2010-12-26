package problems;

/**
 * Solved 19.12.2010.
 * @author DAM
 */
public class MainP34
{
  private int[] f;
  private MainP34()
  {
    f=computeFacts();
  }

  private int[] computeFacts()
  {
    int[] ret=new int[11];
    ret[0]=1;
    ret[1]=1;
    for(int i=2;i<=10;i++)
    {
      ret[i]=ret[i-1]*i;
    }
    return ret;
  }

  private boolean check(int i)
  {
    int sum=0;
    int tmp=i;
    while (tmp>0)
    {
      int digit=tmp%10;
      sum+=f[digit];
      if (sum>i)
      {
        return false;
      }
      tmp=tmp/10;
    }
    return (sum==i);
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    int total=0;
    // 8 digits max:
    // n>=10 000 000
    // sum=factorial of digits(n) <= 8*9!=2903040
    // => sum<n
    //System.out.println(8*f[9]);
    for(int i=10;i<10000000;i++)
    {
      if (check(i))
      {
        System.out.println(i);
        total+=i;
      }
    }
    long now2=System.currentTimeMillis();
    System.out.println("result="+total+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP34 m=new MainP34();
    m.doIt();
  }
}
