package problems.primes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * Help for prime decomposition of the N first integers.
 * @author DAM
 */
public class PrimeDecomposition
{
  private int[][] _flags;
  
  private static final int SIZE=10000;
  private int _rowSize;
  private int _maxInt;

  /**
   * Constructor.
   * @param maxInt Maximum integer to handle.
   */
  public PrimeDecomposition(int maxInt)
  {
    this(maxInt,SIZE);
  }

  /**
   * Detailed constructor.
   * @param maxInt Maximum integer to handle.
   * @param rowSize Size to use for rows.
   */
  public PrimeDecomposition(int maxInt, int rowSize)
  {
    int nbRows=(maxInt/rowSize)+(((maxInt%rowSize)>0)?1:0);
    _rowSize=rowSize;
    _flags=new int[nbRows][];
    for(int i=0;i<nbRows;i++)
    {
      _flags[i]=new int[rowSize];
    }
    _maxInt=maxInt;
    fill();
  }

  private void set(int index, int value)
  {
    int row=index/_rowSize;
    int column=index%_rowSize;
    _flags[row][column]=value;
  }

  public List<Integer> decompose(int n)
  {
    List<Integer> primeFactors=new ArrayList<Integer>();
    while(true)
    {
      int factor=get(n);
      if (factor==0)
      {
        primeFactors.add(Integer.valueOf(n));
        break;
      }
      primeFactors.add(Integer.valueOf(factor));
      n=n/factor;
    }
    Collections.sort(primeFactors);
    return primeFactors;
  }

  public List<Integer> factors(int n)
  {
    HashSet<Integer> primeFactors=new HashSet<Integer>();
    while(true)
    {
      int factor=get(n);
      if (factor==0)
      {
        primeFactors.add(Integer.valueOf(n));
        break;
      }
      primeFactors.add(Integer.valueOf(factor));
      n=n/factor;
    }
    ArrayList<Integer> factors=new ArrayList<Integer>(primeFactors);
    Collections.sort(factors);
    return factors;
  }

  private int get(int index)
  {
    int row=index/_rowSize;
    int column=index%_rowSize;
    return _flags[row][column];
  }

  private void setMultiples(int value)
  {
    int factor=2;
    int index=value*factor;
    while (index<_maxInt)
    {
      set(index,value);
      index+=value;
      factor++;
    }
  }

  private void fill()
  {
    set(0,0);
    set(1,1);
    int index=2;
    while (index<_maxInt)
    {
      if (get(index)==0)
      {
        setMultiples(index);
      }
      index++;
    }
  }
}
