package problems.p101_150;

/**
 * Solved 12.03.2011.
 * @author DAM
 */
public class MainP101
{
  private static final int MAX=10;
  private long[] _p;
  private MainP101()
  {
    // Nothing to do !
  }

  private long lagrange(int k, int n)
  {
    long v=0;
    for(int i=1;i<=k;i++)
    {
      long ln=1;
      long ld=1;
      for(int j=1;j<=k;j++)
      {
        if (j!=i)
        {
          ln*=(n-j);
          ld*=(i-j);
        }
      }
      //System.out.println("ln="+ln+", ld="+ld);
      long yl=(_p[i]*ln)/ld;
      v+=yl;
    }
    return v;
  }

  private long eval(int n)
  {
    long ret=1;
    long product=n;
    for(int i=1;i<=10;i++)
    {
      if (i%2==1) ret-=product;
      else ret+=product;
      product*=n;
    }
    return ret;
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    _p=new long[MAX+1];
    for(int i=1;i<=MAX;i++)
    {
      _p[i]=eval(i);
      //System.out.println("p("+i+")="+_p[i]);
    }
    long sum=0;
    for(int k=1;k<=10;k++)
    {
      /*
      for(int i=1;i<=k+1;i++)
      {
        long l=lagrange(k,i);
        System.out.println("Lagrange k="+k+", i="+i+", l="+l);
      }
      */
      sum+=lagrange(k,k+1);
    }
    long now2=System.currentTimeMillis();
    System.out.println("result="+sum+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP101 m=new MainP101();
    m.doIt();
  }
}
