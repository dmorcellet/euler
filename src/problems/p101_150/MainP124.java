package problems.p101_150;

import java.util.Arrays;
import java.util.List;

import problems.primes.PrimeDecomposition;

/**
 * @author DAM
 */
public class MainP124
{
  private static final int MAX=100000;
  private static final int TARGETED_ROW=10000;

  private MainP124()
  {
    // Nothing to do !
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    PrimeDecomposition p=new PrimeDecomposition(MAX+1);
    long[] rad=new long[MAX+1];
    List<Integer> factors;
    for(int i=1;i<=MAX;i++)
    {
      factors=p.factors(i);
      long radn=1;
      for(Integer f : factors) radn*=f.intValue();
      rad[i]=radn;
    }
    long FACTOR=100000; // (>max(rad))
    long[] nAndRad=new long[MAX+1];
    for(int i=1;i<=MAX;i++)
    {
      nAndRad[i]=FACTOR*rad[i]+i;
    }
    Arrays.sort(nAndRad);
    long good=nAndRad[TARGETED_ROW];
    long n=good%FACTOR;
    //System.out.println(Arrays.toString(rad));
    long now2=System.currentTimeMillis();
    System.out.println("result="+n+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP124 m=new MainP124();
    m.doIt();
  }
}
