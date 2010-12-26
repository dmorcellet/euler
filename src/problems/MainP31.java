package problems;

/**
 * Solved 19.12.2010.
 * @author DAM
 */
public class MainP31
{
  private static int[] values={200,100,50,20,10,5,2,1};
  //private static String[] str={"2L","1L","50p","20p","10p","5p","2p","1p"};
  private static int NB=values.length;
  private long[][] _nbSolucesCache;
  private static final int TARGET=200;
 
  private MainP31()
  {
    // Nothing to do !
  }

  /*
  private void printSoluce(int[] nbCoins)
  {
    for(int i=0;i<NB;i++)
    {
      if (nbCoins[i]>0)
      {
        System.out.print(nbCoins[i]);
        System.out.print('x');
        System.out.print(str[i]);
        System.out.print(", ");
      }
    }
    System.out.println("");
  }
  */

  private long evaluate(int value,int firstItem)
  {
    if (_nbSolucesCache[value][firstItem]!=-1) return _nbSolucesCache[value][firstItem];
    long s=evaluateNoCache(value,firstItem);
    _nbSolucesCache[value][firstItem]=s;
    //System.out.println("Soluces(value="+value+",firstItem="+firstItem+")="+s);
    return s;
  }


  private long evaluateNoCache(int value,int firstItem)
  {
    long s=0;
    if (firstItem==NB-1) return ((value%values[firstItem])==0)?1:0;
    for(int i=firstItem;i<NB;i++)
    {
      int tmp=value;
      while (tmp>=values[i])
      {
        tmp-=values[i];
        if (tmp==0)
        {
          s++;
        }
        else
        {
          if (i<NB-1)
          {
            s+=evaluate(tmp,i+1);
          }
        }
      }
    }
    return s;
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    _nbSolucesCache=new long[TARGET+1][NB];
    for(int i=0;i<TARGET+1;i++)
    {
      _nbSolucesCache[i]=new long[NB];
      for(int j=0;j<NB;j++) _nbSolucesCache[i][j]=-1; 
    }
    long nb=evaluate(TARGET,0);
    long now2=System.currentTimeMillis();
    System.out.println("result="+nb+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP31 m=new MainP31();
    m.doIt();
  }
}
