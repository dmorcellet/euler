package problems.p051_100;

/**
 * Solved 23.01.2011.
 * @author DAM
 */
public class MainP74
{
  private static final int MAX=1000000;
  private int[] _fact;

  private MainP74()
  {
    // Nothing to do !
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    _fact=new int[10];
    _fact[0]=1;
    _fact[1]=1;
    for(int i=2;i<=9;i++) _fact[i]=_fact[i-1]*i;
    int[] cache=new int[MAX+1];
    int nb=0;
    int[] chain=new int[60];
    for(int i=1;i<=1000000;i++)
    {
      chain[0]=i;
      int chainLength=1,v=i;
      while (true)
      {
        if ((v<=MAX) && (cache[v]!=0))
        {
          chainLength=cache[v]+chainLength-1;
          break;
        }
        int ret=0;
        while (v>0)
        {
          ret+=_fact[v%10];
          v/=10;
        }
        v=ret;
        boolean foundCycle=false;
        for(int j=0;j<chainLength;j++)
        {
          if (v==chain[j])
          {
            foundCycle=true;
            break;
          }
        }
        if (foundCycle)
        {
          cache[i]=chainLength;
          //System.out.println("Computed f("+i+")="+chainLength);
          break;
        }
        chain[chainLength]=v;
        chainLength++;
      }
      if (chainLength==60)
      {
        //System.out.println("Length=60 for n="+i);
        nb++;
      }
    }
    long now2=System.currentTimeMillis();
    System.out.println("result="+nb+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP74 m=new MainP74();
    m.doIt();
  }
}
