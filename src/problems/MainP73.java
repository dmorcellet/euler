package problems;

import java.util.List;

import problems.primes.PrimeDecomposition;

/**
 * Solved 23.01.2011.
 * @author DAM
 */
public class MainP73
{
  private static final int DMAX=12000;

  private MainP73()
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
    int nb=0;
    for(int d=1;d<=DMAX;d++)
    {
      int nmin=(d/3)+1;
      int nmax=(d%2==0)?((d/2)-1):(d/2);
      for(int n=nmin;n<=nmax;n++)
      {
        if (relativelyPrime(dec,d,n))
        {
          nb++;
        }
      }
    }
    long now2=System.currentTimeMillis();
    System.out.println("result="+nb+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP73 m=new MainP73();
    m.doIt();
  }
}
