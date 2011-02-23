package problems.p051_100;

import problems.primes.PrimeTester;
import problems.primes.SmartPrimeTester;

/**
 * Solved 08.01.2011.
 * Optimized 09.01.2011.
 * @author DAM
 */
public class MainP58
{
  private PrimeTester _primeTester;

  private MainP58()
  {
    _primeTester=new SmartPrimeTester(30000);
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    int size=1;
    int n=1;
    int p=2;
    int nbPrimes=0;
    int nbNonPrime=1; // 1
    while(true)
    {
      //System.out.println("p="+p+", n="+n);
      p+=n;
      if (_primeTester.isPrime(p)) nbPrimes++; else nbNonPrime++;
      p+=n;p+=n;
      if (_primeTester.isPrime(p)) nbPrimes++; else nbNonPrime++;
      p+=n;p+=n;
      if (_primeTester.isPrime(p)) nbPrimes++; else nbNonPrime++;
      p+=n;p+=n;
      if (_primeTester.isPrime(p)) nbPrimes++; else nbNonPrime++;
      p++;
      p+=n;
      n++;
      size+=2;
      //double percent=100*((double)nbPrimes)/(nbNonPrime+nbPrimes);
      //System.out.println("size="+size+", %="+percent+", nbPrimes="+nbPrimes+", nbNonPrimes="+nbNonPrime);
      if (nbPrimes*10<(nbPrimes+nbNonPrime))
      {
        break;
      }
    }
    long now2=System.currentTimeMillis();
    System.out.println("result="+size+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP58 m=new MainP58();
    m.doIt();
  }
}
