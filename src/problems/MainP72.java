package problems;

import java.util.List;

import problems.primes.PrimeDecomposition;

/**
 * Solved 23.01.2011.
 * @author DAM
 */
public class MainP72
{
  private static final int MAX=1000000;

  private MainP72()
  {
    // Nothing to do !
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    PrimeDecomposition decomposer=new PrimeDecomposition(MAX+1);
    long total=0;
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
      total+=phi;
    }
    long now2=System.currentTimeMillis();
    System.out.println("result="+total+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP72 m=new MainP72();
    m.doIt();
  }
}
