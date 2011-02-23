package problems.p001_050;

import java.util.List;

import problems.primes.PrimeDecomposition;

/**
 * Solved 03.01.2011.
 * @author DAM
 */
public class MainP47
{
  private MainP47()
  {
    // Nothing to do !
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    PrimeDecomposition decomposer=new PrimeDecomposition(1000000);
    //System.out.println(decomposer.decompose(14));
    //System.out.println(decomposer.decompose(15));
    //System.out.println(decomposer.decompose(644));
    //System.out.println(decomposer.decompose(645));
    //System.out.println(decomposer.decompose(646));
    int n=647;
    List<Integer> factors;
    int startN=0;
    int nb=0;
    while(true)
    {
      factors=decomposer.factors(n);
      if (factors.size()!=4)
      {
        startN=0;
        nb=0;
      }
      else
      {
        if (startN==0) startN=n;
        nb++;
        if (nb==4)
        {
          break;
        }
      }
      n++;
    }
    /*
    if ((startN!=0) && (nb==4))
    {
      for(int i=startN;i<startN+4;i++) System.out.println(decomposer.decompose(i));
    }
    */
    long now2=System.currentTimeMillis();
    System.out.println("result="+startN+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP47 m=new MainP47();
    m.doIt();
  }
}
