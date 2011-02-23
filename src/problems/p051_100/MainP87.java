package problems.p051_100;

import java.util.HashSet;

import problems.primes.ErathostenesSieve;

/**
 * Solved 03.02.2011.
 * @author DAM
 */
public class MainP87
{
  private static final long THRESHOLD=50000000;

  private MainP87()
  {
    // Nothing to do !
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    HashSet<Long> ints=new HashSet<Long>();
    int max=(int)Math.sqrt(THRESHOLD);
    long[] primes=new ErathostenesSieve().fill(max+1);
    int nbPrimes=primes.length;
    for(int i=0;i<nbPrimes;i++)
    {
      long prime1=primes[i];
      long i2=prime1*prime1;
      for(int j=0;j<nbPrimes;j++)
      {
        long prime2=primes[j];
        long j3=prime2*prime2*prime2;
        long smallSum=i2+j3;
        if (smallSum>=THRESHOLD) continue;
        for(int k=0;k<nbPrimes;k++)
        {
          long prime3=primes[k];
          long k2=prime3*prime3;
          long k4=k2*k2;
          long sum=i2+j3+k4;
          if (sum<THRESHOLD)
            ints.add(Long.valueOf(sum));
        }
      }
    }
    //System.out.println(ints);
    int nb=ints.size();
    long now2=System.currentTimeMillis();
    System.out.println("result="+nb+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP87 m=new MainP87();
    m.doIt();
  }
}
