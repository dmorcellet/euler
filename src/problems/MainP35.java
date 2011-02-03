package problems;

import java.util.HashSet;

import problems.primes.Erathostenes;

/**
 * Solved 19.12.2010.
 * @author DAM
 */
public class MainP35
{
  private MainP35()
  {
    // Nothing to do !
  }

  private int nbDigits(int n)
  {
    if (n<10) return 1;
    if (n<100) return 2;
    if (n<1000) return 3;
    if (n<10000) return 4;
    if (n<100000) return 5;
    if (n<1000000) return 6;
    return 7;
  }


  private int computeRotations(int[] rotations, int n)
  {
    int nbDigits=nbDigits(n);
    int factor=1;
    for(int i=0;i<nbDigits-1;i++) factor*=10;
    for(int i=0;i<nbDigits;i++)
    {
      rotations[i]=n;
      int digit=n%10;
      n=n/10+digit*factor;
    }
    return nbDigits;
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    final int MAX=1000000;
    Erathostenes e=new Erathostenes(MAX);
    int[] rotations=new int[10];
    HashSet<Integer> foundCircularPrimes=new HashSet<Integer>();
    for(int i=2;i<MAX;i++)
    {
      if (e.isPrime(i))
      {
        if (foundCircularPrimes.contains(Integer.valueOf(i)))
          continue;
        int nbDigits=computeRotations(rotations,i);
        boolean circular=true;
        for(int j=1;j<nbDigits;j++)
        {
          if (!e.isPrime(rotations[j]))
          {
            circular=false;
            break;
          }
        }
        if (circular)
        {
          for(int j=0;j<nbDigits;j++)
          {
            //System.out.print(rotations[j]);
            //System.out.print(' ');
            foundCircularPrimes.add(Integer.valueOf(rotations[j]));
          }
          //System.out.println("");
        }
      }
    }
    int nb=foundCircularPrimes.size();
    long now2=System.currentTimeMillis();
    System.out.println("result="+nb+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP35 m=new MainP35();
    m.doIt();
  }
}
