package problems.primes;

/**
 * @author dm
 */
public class Erathostenes
{
  private boolean[][] _flags;
  
  private static final int SIZE=10000;
  private int _rowSize;
  private int _maxInt;

  public Erathostenes(int maxInt)
  {
    this(maxInt,SIZE);
  }

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

  public boolean isPrime(int n)
  {
    return !get(n);
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
      System.out.println("Got error for index="+index);
      e.printStackTrace();
      return false;
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
    //long sum=0;
    //long product=1;
    int index=2;
    //int nbPrimes=0;
    while (index<_maxInt)
    {
      if (!get(index))
      {
        //sum+=index;
        //product*=index;
        //nbPrimes++;
        //System.out.println("Found prime #"+nbPrimes+" = "+index+", sum="+sum+", product="+product);
        setMultiples(index);
      }
      index++;
    }
    //System.out.println("Sum = "+sum);
    /*
    for(int i=1;i<_maxInt;i++)
    {
      if (!get(i)) { System.out.print(' '+String.valueOf(i)); }
    }
    System.out.println("");
    */
  }
}
