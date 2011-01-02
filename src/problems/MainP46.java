package problems;

import java.util.ArrayList;
import java.util.List;

import problems.primes.Erathostenes;

/**
 * Solved 02.01.2011.
 * @author DAM
 */
public class MainP46
{
  private MainP46()
  {
    // Nothing to do !
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    int max=10000;
    Erathostenes e=new Erathostenes(max);
    List<Integer> primes=new ArrayList<Integer>();
    for(int i=2;i<max;i++)
    {
      if (e.isPrime(i))
      {
        primes.add(Integer.valueOf(i));
      }
    }
    List<Integer> oddCompositeInts=new ArrayList<Integer>();
    for(int i=3;i<max;i+=2)
    {
      if (!e.isPrime(i))
      {
        oddCompositeInts.add(Integer.valueOf(i));
      }
    }
    //System.out.println(primes);
    //System.out.println(oddCompositeInts);
    for(Integer prime : primes)
    {
      int p=prime.intValue();
      for(int k=1;k<max;k++)
      {
        int n=p+2*(k*k);
        if (n>max) break;
        oddCompositeInts.remove(Integer.valueOf(n));
      }
    }
    //System.out.println(oddCompositeInts);
    int r=0;
    if (oddCompositeInts.size()>0) r=oddCompositeInts.get(0).intValue();
    long now2=System.currentTimeMillis();
    System.out.println("result="+r+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP46 m=new MainP46();
    m.doIt();
  }
}
