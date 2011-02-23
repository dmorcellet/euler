package problems.p051_100;

import java.util.List;

import problems.primes.PrimeDecomposition;

/**
 * Solved 23.01.2011.
 * @author DAM
 */
public class MainP71
{
  private static final int DMAX=1000000;

  private MainP71()
  {
    // Nothing to do !
  }

  private boolean relativelyPrime(PrimeDecomposition dec, int d, int n)
  {
    boolean ret=true;
    List<Integer> decD=dec.decompose(d);
    List<Integer> decN=dec.decompose(n);
    int nb=decN.size();
    for(int i=0;i<nb;i++)
    {
      if (decD.contains(decN.get(i)))
      {
        ret=false;
        break;
      }
    }
    return ret;
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    PrimeDecomposition dec=new PrimeDecomposition(DMAX+1);
    int N=2,D=5;
    // Let N/D be the best approximation for 3/7 (N/D<3/7)
    // Then any better candidate n/d shall give:
    // N/D < n/d < 3/7
    // Let start with N=2, D=5.
    // For each d (starting at DMAX), find acceptable values for n (nmin<=n<=nmax) and
    // check if d and n ae relatively primes. If they are, let D=d and N=n...
    for(int d=DMAX;d>=3;d--)
    {
      int nmin=(int)(((long)d*N)/D)+1;
      int num=3*d;
      int nmax=(num%7==0)?((num/7)-1):(num/7);
      for(int n=nmax;n>=nmin;n--)
      {
        if (relativelyPrime(dec,d,n))
        {
          N=n;
          D=d;
          //System.out.println("Found N="+N+", D="+D+" for d="+d);
          break;
        }
      }
    }
    long now2=System.currentTimeMillis();
    System.out.println("result="+N+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP71 m=new MainP71();
    m.doIt();
  }
}
