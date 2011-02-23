package problems.p051_100;

import problems.primes.ErathostenesSieve;

/**
 * Solved 21.01.2011.
 * @author DAM
 */
public class MainP69
{
  private static final int MAX=1000000;

  private MainP69()
  {
    // Nothing to do !
  }

  // phi(n)=n*product(p prime divisor of n: (p-1)/p)
  // n/phi(n)=product(p prime divisor of n: p/(p-1))
  // maximized for n=p0*p1*p2*p3 < MAX
  // => imax=2*3*5*7*11*13*17

  /*
  private void doIt2()
  {
    long now=System.currentTimeMillis();
    PrimeDecomposition decomposer=new PrimeDecomposition(MAX+1);
    int imax=-1;
    long nmax=1,dmax=0;
    for(int i=2;i<=MAX;i++)
    {
      List<Integer> factors=decomposer.decompose(i);
      long n=1,d=1;
      Integer previousFactor=null;
      for(Integer factor : factors)
      {
        if ((previousFactor==null) || (factor.intValue()!=previousFactor.intValue())) {
          n*=(factor.intValue()-1);
          d*=factor.intValue();
          previousFactor=factor;
        }
      }
      if (d*nmax>n*dmax)
      {
        // imax values to 2, 6, 30, 210,...,510510
        // 2, 2*3, 2*3*5, 2*3*5*7, ... 2*3*5*7*11*13*17
        nmax=n;dmax=d;
        imax=i;
      }
      //System.out.println("n="+i+" n/phi="+nDivPhi);
    }
    long now2=System.currentTimeMillis();
    System.out.println("result="+imax+" ("+(now2-now)+"ms).");
  }
  */

  private void doIt()
  {
    long now=System.currentTimeMillis();
    long[] primes=new ErathostenesSieve().fill(30);
    int n=1;
    int index=0;
    while (n*primes[index]<MAX)
    {
      n*=primes[index];
      index++;
    }
    long now2=System.currentTimeMillis();
    System.out.println("result="+n+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP69 m=new MainP69();
    m.doIt();
  }
}
