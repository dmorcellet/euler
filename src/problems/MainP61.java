package problems;

import java.util.Arrays;

/**
 * Solved 15.01.2011.
 * @author DAM
 */
public class MainP61
{
  private static final int NB_RANKS=6;
  private int[][] _p;
  private int[] _numbers;
  private boolean[] _usedFlags;
  private int _sum;

  private MainP61()
  {
    // Nothing to do !
  }

  private int get4DigitsNumbers(int rank,int[] store)
  {
    int nb=0;
    int n=1;
    int p=1;
    while (true)
    {
      if (p>9999) break;
      if (p>999)
      {
        store[nb]=p;
        nb++;
      }
      if (rank==3) p=(n*(n+1))/2;
      else if (rank==4) p=n*n;
      else if (rank==5) p=(n*(3*n-1))/2;
      else if (rank==6) p=n*(2*n-1);
      else if (rank==7) p=(n*(5*n-3))/2;
      else if (rank==8) p=n*(3*n-2);
      n++;
    }
    return nb;
  }

  private int findNumbersStartWith(int[] series, int[] resultIndex, int start)
  {
    int min=start*100;
    int indexMin=Arrays.binarySearch(series,min);
    if (indexMin>=0) resultIndex[0]=indexMin; else resultIndex[0]=(-indexMin-1);
    int max=min+99;
    int indexMax=Arrays.binarySearch(series,max);
    if (indexMax>=0) resultIndex[1]=indexMax; else resultIndex[1]=(-indexMax-1)-1;
    int nb=resultIndex[1]-resultIndex[0];
    return nb;
  }

  private boolean search(int nbSeriesLeft, int seriesIndex, int[] indexes)
  {
    boolean ret=false;

    //System.out.println("Search series "+seriesIndex+" index="+indexes[0]+"->"+indexes[1]);
    int[] thisSeries=_p[seriesIndex];
    int startIndex=indexes[0];
    int endIndex=indexes[1];
    for(int i=startIndex;i<=endIndex;i++)
    {
      int pn=thisSeries[i];
      //System.out.println("Search series "+seriesIndex+" pn="+pn);

      _numbers[seriesIndex]=pn;
      if (nbSeriesLeft==0)
      {
        if (pn%100==_numbers[0]/100)
        {
          _sum=0;
          for(int n=0;n<NB_RANKS;n++) _sum+=_numbers[n];
          ret=true;
          break;
        }
      }
      else
      {
        int last2Digits=pn%100;

        for(int s=0;s<NB_RANKS;s++)
        {
          if (!_usedFlags[s])
          {
            _usedFlags[s]=true;
            int[] nextSeries=_p[s];
            
            int nbFound=findNumbersStartWith(nextSeries,indexes,last2Digits);
            if (nbFound>=0)
            {
              if (search(nbSeriesLeft-1,s,indexes))
              {
                ret=true;
                break;
              }
            }
            _usedFlags[s]=false;
          }
        }
        if (ret) break;
        _numbers[seriesIndex]=0;
      }
    }
    return ret;
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    _p=new int[NB_RANKS+1][];
    _numbers=new int[NB_RANKS];
    _usedFlags=new boolean[NB_RANKS];
    _usedFlags[0]=true;
    for(int i=3;i<=NB_RANKS+2;i++) {
      int[] tmp=new int[100];
      int nb=get4DigitsNumbers(i,tmp);
      _p[i-3]=new int[nb];
      System.arraycopy(tmp,0,_p[i-3],0,nb);
    }
    _p[NB_RANKS]=_p[0];
    int nb=_p[0].length;
    int[] indexes=new int[]{0,nb-1};
    search(NB_RANKS-1,0,indexes);
    //for(int i=0;i<NB_RANKS;i++) System.out.println(_numbers[i]);
    long now2=System.currentTimeMillis();
    System.out.println("result="+_sum+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP61 m=new MainP61();
    m.doIt();
  }
}
