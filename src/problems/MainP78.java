package problems;

/**
 * Solved 29.01.2011.
 * @author DAM
 */
public class MainP78
{
  private static final int DIV=1000000;
  private static final int MAXP=100000;
  private static final int MAX_PENTA=1000;
  //private HashMap<Integer,BigInteger> _cacheP;
  private int[] _cachePMod;

  private int[] _penta;

  private MainP78()
  {
    //_cacheP=new HashMap<Integer,BigInteger>();
    _cachePMod=new int[MAXP+1];
  }

  private int[] penta(int max)
  {
    int[] ret=new int[max*2];
    int index=0;
    for(int i=1;i<=max;i++)
    {
      ret[index]=((3*i-1)*i)/2;
      index++;
      ret[index]=((3*i+1)*i)/2;
      index++;
    }
    return ret;
  }

  /*
  private BigInteger getP(int n)
  {
    Integer intN=Integer.valueOf(n);
    BigInteger ret=_cacheP.get(intN);
    if (ret!=null) return ret;
    if (n==0)
    {
      ret=BigInteger.ONE;
    }
    else
    {
      int term=0;
      int index=0;
      while (true)
      {
        int penta=_penta[index];
        if (penta>n) break;
        BigInteger item=getP(n-penta);
        if (term<2)
        {
          if (ret!=null)
          {
            ret=ret.add(item);
          }
          else
          {
            ret=item;
          }
        }
        else
        {
          ret=ret.subtract(item);
        }
        term++;
        index++;
        if (term==4) term=0;
      }
    }
    _cacheP.put(intN,ret);
    return ret;
  }
  */

  private int getpMod(int n)
  {
    int ret=_cachePMod[n];
    if (ret!=0) return ret;
    if (n==0)
    {
      ret=1;
    }
    else
    {
      int term=0;
      int index=0;
      while (true)
      {
        int penta=_penta[index];
        if (penta>n) break;
        int item=getpMod(n-penta);
        if (term<2)
        {
          ret=(ret+item)%DIV;
        }
        else
        {
          ret=(ret-item)%DIV;
        }
        term++;
        index++;
        if (term==4) term=0;
      }
    }
    _cachePMod[n]=ret;
    return ret;
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    _penta=penta(MAX_PENTA);
    int p;
    //BigInteger p;
    int goodI=0;
    //BigInteger d=BigInteger.valueOf(DIV);
    for(int i=1;i<=100000;i++)
    {
      //p=getP(i);
      p=getpMod(i);
      if (p==0)
      //if (p.mod(d).equals(BigInteger.ZERO))
      {
        //System.out.println("i="+i+", p(i)="+p);
        goodI=i;
        break;
      }
    }
    long now2=System.currentTimeMillis();
    System.out.println("result="+goodI+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP78 m=new MainP78();
    m.doIt();
  }
}
