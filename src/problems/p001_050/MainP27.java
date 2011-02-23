package problems.p001_050;

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
    int result=-1;
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
          result=a*b;
          //System.out.println("A="+a+", B="+b+", nmax="+n+", product="+result);
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
    MainP27 m=new MainP27();
    m.doIt();
  }
}
