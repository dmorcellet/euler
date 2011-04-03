package problems.p151_200;

import problems.primes.ErathostenesSieve;

/**
 * Solved 03.04.2011.
 * @author DAM
 */
public class MainP187
{
  private static final int MAX=100000000;
  private static final int SQRT_MAX=(int)Math.sqrt(MAX)+1;

  private MainP187()
  {
    // Nothing to do !
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    ErathostenesSieve s=new ErathostenesSieve();
    long[] primes=s.fill(MAX/2);
    int nbPrimes=primes.length;
    int nb=0;
    int index=0;
    while(true)
    {
      if (index>=nbPrimes) break;
      long p=primes[index];
      if (p<SQRT_MAX)
      {
        for(int i=index;i<nbPrimes;i++)
        {
          if (p*primes[i]>=MAX) break;
          nb++;
        }
      }
      else break;
      index++;
    }
    long now2=System.currentTimeMillis();
    System.out.println("result="+nb+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP187 m=new MainP187();
    m.doIt();
  }
}
