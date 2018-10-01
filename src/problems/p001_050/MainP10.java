package problems.p001_050;

/**
 * @author DAM
 */
public class MainP10
{
  private boolean[][] _flags;
  
  private final int SIZE=10000;
  private final int MAX=SIZE*SIZE;
  private final int MAX_PRIME=2000000;

  private MainP10()
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

  private void erathostenes()
  {
    long now=System.currentTimeMillis();
    long sum=0;
    //long product=1;
    int index=2;
    //int nbPrimes=0;
    while (index<MAX_PRIME)
    {
      if (!get(index))
      {
        sum+=index;
        //product*=index;
        //nbPrimes++;
        //System.out.println("Found prime #"+nbPrimes+" = "+index+", sum="+sum+", product="+product);
        setMultiples(index);
      }
      index++;
    }
    long now2=System.currentTimeMillis();
    System.out.println("result="+sum+" ("+(now2-now)+"ms).");
  }

  private void doIt()
  {
    erathostenes();
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP10 m=new MainP10();
    m.doIt();
  }
}
