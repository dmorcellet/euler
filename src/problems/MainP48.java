package problems;

/**
 * Solved 03.01.2011.
 * @author DAM
 */
public class MainP48
{
  private static final long MAX=10000000000L; 
  private MainP48()
  {
    // Nothing to do !
  }

  private long limitedLengthMultiplication(long n1, long n2)
  {
    long r=n1*n2;
    r=r%MAX;
    return r;
  }

  private long limitedLengthPower(int n1, int n2)
  {
    long r=n1;
    for(int i=2;i<=n2;i++)
    {
      r=limitedLengthMultiplication(r,n1);
    }
    return r;
  }

  private long limitedLengthSum(long n1, long n2)
  {
    long r=n1+n2;
    r=r%MAX;
    return r;
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    long r=0;
    for(int i=1;i<=1000;i++)
    {
      long item=limitedLengthPower(i,i);
      r=limitedLengthSum(r,item);
    }
    long now2=System.currentTimeMillis();
    System.out.println("result="+r+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP48 m=new MainP48();
    m.doIt();
  }
}
