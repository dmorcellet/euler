package problems.p051_100;

/**
 * Solved 12.02.2011.
 * @author DAM
 */
public class MainP92
{
  private static final int CACHE_SIZE=1000;
  private int[] _cache;

  private MainP92()
  {
    _cache=new int[CACHE_SIZE+1];
    // contains -1 if leads to 1,
    // contains +1 if leads to 89
    // contains 0 if not computed yet
  }

  private int computeNext(int n)
  {
    int ret=0;
    while (n>0)
    {
      int digit=n%10;
      ret+=digit*digit;
      n/=10;
    }
    return ret;
  }

  private boolean evaluate(final int n)
  {
    int tmpn=n;
    while(true)
    {
      if (tmpn<=CACHE_SIZE)
      {
        int cache=_cache[tmpn];
        if (cache>0) return true;
        if (cache<0) return false;
      }
      tmpn=computeNext(tmpn);
      if (tmpn==1)
      {
        return false;
      }
      if (tmpn==89)
      {
        return true;
      }
    }
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    int r=0;
    for(int i=1;i<=CACHE_SIZE;i++)
    {
      boolean ok=evaluate(i);
      _cache[i]=(ok?1:-1);
      if (ok) r++;
    }
    for(int i=CACHE_SIZE+1;i<=10000000;i++)
    {
      int n=computeNext(i);
      int cache=_cache[n];
      if (cache>0) r++;
      //if (cache==0) System.out.println("Error with i="+i);
    }
    long now2=System.currentTimeMillis();
    System.out.println("result="+r+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP92 m=new MainP92();
    m.doIt();
  }
}
