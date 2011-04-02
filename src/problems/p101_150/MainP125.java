package problems.p101_150;

import java.util.HashSet;

/**
 * Solved 02.04.2011.
 * @author DAM
 */
public class MainP125
{
  private MainP125()
  {
    // Nothing to do !
  }

  private int[] _palindromicBuffer=new int[10];

  private boolean isPalindromic(int v)
  {
    int nbDigits=0;
    while (v>0)
    {
      _palindromicBuffer[nbDigits]=v%10;
      v/=10;
      nbDigits++;
    }
    for(int i=0;i<nbDigits/2;i++)
    {
      if (_palindromicBuffer[i]!=_palindromicBuffer[nbDigits-i-1])
        return false;
    }
    return true;
  }

  private int[] computeSquares(int maxn)
  {
    int[] ret=new int[maxn+1];
    for(int i=1;i<=maxn;i++)
    {
      ret[i]=i*i;
    }
    return ret;
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    HashSet<Integer> goods=new HashSet<Integer>();
    final int MAX_SUM=10000*10000;
    final int MAX_N=10000;
    int[] squares=computeSquares(MAX_N);
    //System.out.println(Arrays.toString(squares));
    int nbSoluces=0;
    for(int start=1;start<=MAX_N;start++)
    {
      int sum=squares[start];
      int index=start+1;
      while (true)
      {
        if (index>MAX_N) break;
        sum+=squares[index];
        if (sum>MAX_SUM) break;
        if (isPalindromic(sum))
        {
          //System.out.println("OK : "+sum+ ", start="+start+", index="+index);
          goods.add(Integer.valueOf(sum));
          nbSoluces++;
        }
        index++;
      }
    }
    long total=0;
    for(Integer palindrom : goods) {
    	total+=palindrom.longValue();
    }
    long now2=System.currentTimeMillis();
    System.out.println("result="+total+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP125 m=new MainP125();
    m.doIt();
  }
}
