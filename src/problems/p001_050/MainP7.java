package problems.p001_050;

/**
 * @author DAM
 */
public class MainP7
{
  private boolean[][] _flags;
  
  private final int SIZE=10000;
  private final int MAX=SIZE*SIZE;
  private final int NB_PRIMES=10001;

  private MainP7()
  {
    _flags=new boolean[SIZE][];
    for(int i=0;i<SIZE;i++)
    {
      _flags[i]=new boolean[SIZE];
    }
  }

  private void set(int index, boolean value)
  {
    int row=index/SIZE;
    int column=index%SIZE;
    _flags[row][column]=value;
  }

  private boolean get(int index)
  {
    int row=index/SIZE;
    int column=index%SIZE;
    return _flags[row][column];
  }

  private void setMultiples(int value)
  {
    int index=value;
    while (index<MAX)
    {
      set(index,true);
      index+=value;
    }
  }

  private int erathostenes()
  {
    int nbPrimes=0;
    int index=2;
    while (nbPrimes<NB_PRIMES)
    {
      if (!get(index))
      {
        nbPrimes++;
        //System.out.println("Found prime #"+nbPrimes+" = "+index);
        setMultiples(index);
      }
      index++;
    }
    return index;
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    int result=erathostenes();
    long now2=System.currentTimeMillis();
    System.out.println("result="+result+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP7 m=new MainP7();
    m.doIt();
  }
}
