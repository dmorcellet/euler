package problems;

import problems.primes.Erathostenes;

/**
 * Solved 19.12.2010.
 * @author DAM
 */
public class MainP27
{
  private MainP27()
  {
    // Nothing to do !
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    Erathostenes e=new Erathostenes(50000);
    final int maxA=1000;
    final int maxB=1000;
    int maxPrimes=0;
    //int a=1,b=41;
    for(int a=-maxA;a<=maxA;a++)
    {
      for(int b=-maxB;b<=maxB;b++)
      {
        int n=0;
        while (true)
        {
          int value=n*n+a*n+b;
          if ((value<1) || !(e.isPrime(value)))
          {
            n--;
            break;
          }
          n++;
        }
        if (n>maxPrimes)
        {
          maxPrimes=n;
          System.out.println("A="+a+", B="+b+", nmax="+n+", product="+(a*b));
        }
      }
    }
    long now2=System.currentTimeMillis();
    System.out.println("result="+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP27 m=new MainP27();
    m.doIt();
  }
}
