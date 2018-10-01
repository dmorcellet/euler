package problems.p001_050;

import java.util.ArrayList;
import java.util.List;

import problems.primes.Erathostenes;

/**
 * Solved 03.01.2011.
 * @author DAM
 */
public class MainP49
{
  private static final int MAX=10000;

  private MainP49()
  {
    // Nothing to do !
  }

  private boolean checkTriplet(int i, int j, int k)
  {
    int[] digits=new int[10];
    for(int d=0;d<4;d++)
    {
      int digit=i%10;
      digits[digit]++;
      i/=10;
    }
    int[] dj=new int[10];
    for(int d=0;d<10;d++) dj[d]=digits[d];
    for(int d=0;d<4;d++)
    {
      int digit=j%10;
      if (dj[digit]==0) return false;
      dj[digit]--;
      j/=10;
    }
    int[] dk=new int[10];
    for(int d=0;d<10;d++) dk[d]=digits[d];
    for(int d=0;d<4;d++)
    {
      int digit=k%10;
      if (dk[digit]==0) return false;
      dk[digit]--;
      k/=10;
    }
    return true;
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    Erathostenes e=new Erathostenes(MAX);
    List<Integer> primes=new ArrayList<Integer>();
    for(int i=1000;i<=9999;i++)
    {
      if (e.isPrime(i))
      {
        primes.add(Integer.valueOf(i));
      }
    }
    int size=primes.size();
    //int nb=0;
    long result=0;
    for(int i=0;i<size-2;i++)
    {
      int pi=primes.get(i).intValue();
      for(int j=i+1;j<size-1;j++)
      {
        int pj=primes.get(j).intValue();
        int pk=pj+pj-pi;
        if ((pk<MAX) && (e.isPrime(pk)))
        {
          if (checkTriplet(pi,pj,pk))
          {
            //System.out.println("pi="+pi+", pj="+pj+", pk="+pk);
            result=(long)pi*100000000+(long)pj*10000+pk;
            if (result!=148748178147L)
            {
              break;
            }
          }
          //nb++;
        }
      }
    }
    long now2=System.currentTimeMillis();
    System.out.println("result="+result+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP49 m=new MainP49();
    m.doIt();
  }
}
