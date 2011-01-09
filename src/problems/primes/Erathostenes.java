package problems.primes;

/**
 * Prime tester based on a Erathostenes sieve.
 * @author DAM
 */
public class Erathostenes implements PrimeTester
{
  private boolean[][] _flags;
  
  private static final int SIZE=10000;
  private int _rowSize;
  private int _maxInt;

  /**
   * Constructor.
   * @param maxInt Sieve's limit.
   */
  public Erathostenes(int maxInt)
  {
    this(maxInt,SIZE);
  }

  /**
   * Constructor.
   * @param maxInt Sieve's limit.
   * @param rowSize Size of rows used for storage.
   */
  public Erathostenes(int maxInt, int rowSize)
  {
    int nbRows=(maxInt/rowSize)+(((maxInt%rowSize)>0)?1:0);
    _rowSize=rowSize;
    _flags=new boolean[nbRows][];
    for(int i=0;i<nbRows;i++)
    {
      _flags[i]=new boolean[rowSize];
    }
    _maxInt=maxInt;
    fill();
  }

  private void set(int index, boolean value)
  {
    int row=index/_rowSize;
    int column=index%_rowSize;
    _flags[row][column]=value;
  }

  /**
   * Test if n is prime or not.
   * @param n Number to test.
   * @return <code>true</code> if it is prime, <code>false</code> if it is not.
   * @throws IllegalArgumentException if n is not supported.
   */
  public boolean isPrime(long n)
  {
    return !get((int)n);
  }

  private boolean get(int index)
  {
    try
    {
      int row=index/_rowSize;
      int column=index%_rowSize;
      return _flags[row][column];
    }
    catch(Exception e)
    {
      throw new IllegalArgumentException("n="+index);
    }
  }

  private void setMultiples(int value)
  {
    int index=value*2;
    while (index<_maxInt)
    {
      set(index,true);
      index+=value;
    }
  }

  private void fill()
  {
    set(0,true);
    set(1,true);
    int index=2;
    while (index<_maxInt)
    {
      if (!get(index))
      {
        setMultiples(index);
      }
      index++;
    }
  }
}
