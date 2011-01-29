package problems;

import java.util.Arrays;

import problems.primes.ErathostenesSieve;

/**
 * Solved 29.01.2011.
 * @author DAM
 */
public class MainP77
{
  private static final int MAX=1000;
  private static final int THRESHOLD=5000;
  private int[][] _nb;
  private long[] _primes;

  private MainP77()
  {
    _nb=new int[MAX+1][];
    _nb[0]=new int[1];
    _nb[0][0]=1;
    for(int i=1;i<=MAX;i++)
    {
      _nb[i]=new int[i+1];
      _nb[i][1]=0;
    }
  }

  private int getNb(int sum, int maxItem)
  {
    if (maxItem>sum) maxItem=sum;
    int value=_nb[sum][maxItem];
    if (value==0)
    {
      int index=Arrays.binarySearch(_primes,maxItem);
      if (index<0) index=-index-2;
      for(int i=index;i>=0;i--) 
      {
        value+=getNb((int)(sum-_primes[i]),(int)_primes[i]);
      }
      _nb[sum][maxItem]=value;
    }
    return value; 
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    _primes=new ErathostenesSieve().fill(10000);
    int best=0;
    for(int i=5;i<=MAX;i++)
    {
      int nb=getNb(i,i)-1;
      if (nb>THRESHOLD)
      {
        best=i;
        break;
      }
    }
    long now2=System.currentTimeMillis();
    System.out.println("result="+best+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP77 m=new MainP77();
    m.doIt();
  }
}
