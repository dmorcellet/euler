package problems;

/**
 * @author DAM
 */
public class MainP9
{
  private final int MAX=1000;

  private void doIt()
  {
    long now=System.currentTimeMillis();
    int product=0;
    for(int i=0;i<MAX;i++)
    {
      for(int j=i+1;j<MAX;j++)
      {
        int k=1000-i-j;
        if (k>j)
        {
          int s1=i*i+j*j;
          int s2=k*k;
          if (s1==s2)
          {
            //System.out.println("i="+i+", j="+j+", k="+k);
            product=(i*j*k);
          }
        }
      }
    }
    long now2=System.currentTimeMillis();
    System.out.println("result="+product+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP9 m=new MainP9();
    m.doIt();
  }
}
