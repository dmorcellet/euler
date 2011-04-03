package problems.p201_250;

import java.util.HashSet;

import problems.primes.ErathostenesSieve;

/**
 * Solved 03.04.2011.
 * @author DAM
 */
public class MainP203
{
  private static final int NB_ROWS=51;
  private static final boolean DO_MAX_SIEVE_OPTIMIZE=true;

  private MainP203()
  {
    // Nothing to do !
  }

  private boolean isSquareFree(long n, long[] squarePrimes)
  {
    int nbPrimes=squarePrimes.length;
    for(int i=0;i<nbPrimes;i++)
    {
      if (n%squarePrimes[i]==0) return false;
    }
    return true;
  }

  private HashSet<Long> computePascalTriangle()
  {
    HashSet<Long> ret=new HashSet<Long>(); 
    long[][] values=new long[NB_ROWS+1][];
    values[1]=new long[1];
    values[1][0]=1;
    ret.add(Long.valueOf(1));
    for(int i=2;i<=NB_ROWS;i++)
    {
      values[i]=new long[i];
      values[i][0]=1;
      values[i][i-1]=1;
      for(int j=1;j<i-1;j++)
      {
        values[i][j]=values[i-1][j-1]+values[i-1][j];
        ret.add(Long.valueOf(values[i][j]));
      }
      //System.out.println(Arrays.toString(values[i]));
    }
    return ret;
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    HashSet<Long> values=computePascalTriangle();
    long maxSieve=0;
    if (DO_MAX_SIEVE_OPTIMIZE)
    {
      maxSieve=NB_ROWS-1;
    }
    else
    {
      long max=0;
      for(Long value : values)
      {
        if (value.longValue()>max) max=value.longValue();
      }
      //System.out.println(max);
      //System.out.println(values.size());
      maxSieve=(long)Math.sqrt(Math.sqrt(max))+1;
      //System.out.println(maxSieve);
    }
    long[] primes=new ErathostenesSieve().fill(maxSieve);
    //System.out.println(Arrays.toString(primes));
    //System.out.println(primes.length);
    long[] squares=new long[primes.length];
    for(int i=0;i<primes.length;i++) squares[i]=primes[i]*primes[i];
    int nbSquareFree=0;
    long sum=0;
    for(Long value : values)
    {
      if (isSquareFree(value.longValue(),squares))
      {
        sum+=value.longValue();
        nbSquareFree++;
      }
    }
    long now2=System.currentTimeMillis();
    System.out.println("result="+sum+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP203 m=new MainP203();
    m.doIt();
  }
}
