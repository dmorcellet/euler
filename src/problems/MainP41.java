package problems;

import problems.primes.Erathostenes;
import problems.tools.Digits;

/**
 * Solved 28.12.2010.
 * @author DAM
 */
public class MainP41
{
  private static final int MAX=10000000;
  private MainP41()
  {
    // Nothing to do !
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    // 9 digits won't do it (1+2+3+...9=45 divisible by 3)
    // 8 digits won't do it (1+2+3+...9=36 divisible by 3)
    // biggest 7-digit pandigital is 7654321
    // 2143 does it
    Erathostenes e=new Erathostenes(MAX);
    int value=-1;
    for(int i=7654321;i>=2413;i--)
    {
      if ((e.isPrime(i)) && (Digits.isPandigital(i)))
      {
        value=i;
        break;
      }
    }
    long now2=System.currentTimeMillis();
    System.out.println("result="+value+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP41 m=new MainP41();
    m.doIt();
  }
}
