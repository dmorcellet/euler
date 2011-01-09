package problems.primes;

import java.util.ArrayList;
import java.util.List;

/**
 * Erathostenes sieve.
 * @author DAM
 */
public class ErathostenesSieve
{
  private static final int SIZE=10000;
  private static final int PACKET_SIZE=10000;

  /**
   * Compute an array of all prime numbers below the specified maximum.
   * @param maxInt Maximum integer to test.
   * @return An array of sorted primes.
   */
  public long[] fill(long maxInt)
  {
    return fill(maxInt,SIZE);
  }

  /**
   * Compute an array of all prime numbers below the specified maximum.
   * @param maxInt Maximum integer to test.
   * @param rowSize Size of rows used for temporary primes storage.
   * @return An array of sorted primes.
   */
  public long[] fill(long maxInt, int rowSize)
  {
    List<long[]> primesList=new ArrayList<long[]>();
    int nbPrimes=0;
    long[] primes=new long[PACKET_SIZE];
    int primeIndex=0;
    boolean[][] flags;
    int nbRows=(int)((maxInt/rowSize)+(((maxInt%rowSize)>0)?1:0));
    flags=new boolean[nbRows][];
    for(int i=0;i<nbRows;i++)
    {
      flags[i]=new boolean[rowSize];
    }

    flags[0][0]=true;
    flags[0][1]=true;
    int index=2;
    int rowIndex=0;
    int indexInRow=2;
    while (index<maxInt)
    {
      if (!flags[rowIndex][indexInRow])
      {
        primes[primeIndex]=index;
        primeIndex++;
        if (primeIndex==PACKET_SIZE)
        {
          primesList.add(primes);
          primes=new long[PACKET_SIZE];
          primeIndex=0;
          nbPrimes+=PACKET_SIZE;
        }
        //System.out.println(index);
        int i=index*2;
        while (i<maxInt)
        {
          int row=i/rowSize;
          int column=i%rowSize;
          flags[row][column]=true;
          i+=index;
        }
      }
      index++;
      indexInRow++;
      if (indexInRow==rowSize)
      {
        indexInRow=0;
        rowIndex++;
      }
    }
    nbPrimes+=primeIndex;
    long[] allPrimes=new long[nbPrimes];
    int i=0;
    for(long[] p : primesList)
    {
      System.arraycopy(p,0,allPrimes,i,p.length);
      i+=p.length;
    }
    System.arraycopy(primes,0,allPrimes,i,primeIndex);
    return allPrimes;
  }
}
