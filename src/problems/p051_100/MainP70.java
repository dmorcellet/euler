package problems.p051_100;

import java.util.Arrays;
import java.util.List;

import problems.primes.PrimeDecomposition;

/**
 * Solved 21.01.2011.
 * To be optimized (40 seconds on laptop, 12s on desktop PC!).
 * @author DAM
 */
public class MainP70
{
  private static final int MAX=10000000;

  private MainP70()
  {
    // Nothing to do !
  }

  // phi(n)=n*product(p prime divisor of n: (p-1)/p)
  // n/phi(n)=product(p prime divisor of n: p/(p-1))

  private boolean compare(int n, int phin)
  {
    String nstr=String.valueOf(n);
    String phinstr=String.valueOf(phin);
    if (nstr.length()==phinstr.length())
    {
      char[] nchar=nstr.toCharArray();
      Arrays.sort(nchar);
      char[] phichar=phinstr.toCharArray();
      Arrays.sort(phichar);
      return String.valueOf(nchar).equals(String.valueOf(phichar));
    }
    return false;
  }
  
  private void doIt()
  {
    long now=System.currentTimeMillis();
    PrimeDecomposition decomposer=new PrimeDecomposition(MAX+1);
    int goodI=-1;
    double fmin=10000;
    for(int i=2;i<=MAX;i++)
    {
      List<Integer> factors=decomposer.decompose(i);
      long n=i,d=1;
      Integer previousFactor=null;
      for(Integer factor : factors)
      {
        if ((previousFactor==null) || (factor.intValue()!=previousFactor.intValue())) {
          n*=(factor.intValue()-1);
          d*=factor.intValue();
          previousFactor=factor;
        }
      }
      int phi=(int)(n/d);
      if (compare(i,phi))
      {
        double f=i/(double)phi;
        //System.out.println("n="+i+", phi(n)="+phi+", f="+f);
        if (f<fmin)
        {
          fmin=f;
          goodI=i;
        }
      }
    }
    long now2=System.currentTimeMillis();
    System.out.println("result="+goodI+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP70 m=new MainP70();
    m.doIt();
  }
}
