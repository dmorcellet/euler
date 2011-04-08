package problems.p151_200;

import java.util.List;

import problems.primes.PrimeDecomposition;

/**
 * Solved 08.04.2011.
 * @author DAM
 */
public class MainP179
{
  private static final int MAX=10000000;

  private MainP179()
  {
    // Nothing to do !
  }

  private int nbDivisors(PrimeDecomposition p, int i)
  {
    int nbDivisors=1;
    List<Integer> factors=p.decompose(i);
    int nbFactors=factors.size();
    int currentFactor=factors.get(0).intValue();
    int nbCurrentFactor=1;
    for(int f=1;f<nbFactors;f++)
    {
      int factor=factors.get(f).intValue();
      if (factor!=currentFactor)
      {
        nbDivisors*=(1+nbCurrentFactor);
        nbCurrentFactor=1;
        currentFactor=factor;
      }
      else
      {
        nbCurrentFactor++;
      }
    }
    nbDivisors*=(nbCurrentFactor+1);
    return nbDivisors;
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    PrimeDecomposition p=new PrimeDecomposition(MAX+1);
    int lastNbDivisors=1;
    int count=0;
    for(int i=2;i<MAX;i++)
    {
      int nbDivisors=nbDivisors(p,i);
      if (nbDivisors==lastNbDivisors)
      {
        count++;
      }
      else
      {
        lastNbDivisors=nbDivisors;
      }
      //System.out.println("Nb divisors("+i+")="+nbDivisors);
    }
    long now2=System.currentTimeMillis();
    System.out.println("result="+count+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP179 m=new MainP179();
    m.doIt();
  }
}
