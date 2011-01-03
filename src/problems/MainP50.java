package problems;

import java.util.ArrayList;
import java.util.List;

import problems.primes.Erathostenes;

/**
 * Solved 03.01.2011.
 * @author DAM
 */
public class MainP50
{
  private static final int MAX=1000000;

  private MainP50()
  {
    // Nothing to do !
  }

  private void dumpPrimes(int expectedSum, int length, int indexOfFirtPrime, List<Integer> primes)
  {
    System.out.println("Length="+length);
    int sum=0;
    for(int index=indexOfFirtPrime;index<indexOfFirtPrime+length;index++)
    {
      System.out.print(' ');
      System.out.print(primes.get(index));
      sum+=primes.get(index).intValue();
    }
    System.out.println(" ("+sum+"/"+expectedSum+")");
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    Erathostenes e=new Erathostenes(MAX);
    List<Integer> primes=new ArrayList<Integer>();
    for(int i=0;i<MAX;i++)
    {
      if (e.isPrime(i))
      {
        primes.add(Integer.valueOf(i));
      }
    }
    int nbPrimes=primes.size();
    int indexOfFirstPrime=0;
    int maxIndexOfFirstPrime=0;
    int maxSum=0;
    int maxLength=1;
    while (indexOfFirstPrime<nbPrimes)
    {
      int length=0;
      int sum=0;
      int index=indexOfFirstPrime;
      while (index<nbPrimes)
      {
        int primeValue=primes.get(index).intValue();
        sum+=primeValue;
        length++;
        if (sum>=MAX) break;
        if (e.isPrime(sum))
        {
          if (length>maxLength)
          {
            maxIndexOfFirstPrime=indexOfFirstPrime;
            maxSum=sum;
            maxLength=length;
            //dumpPrimes(sum,maxLength,maxIndexOfFirstPrime,primes);
          }
        }
        index++;
      }
      indexOfFirstPrime++;
    }
    long now2=System.currentTimeMillis();
    dumpPrimes(maxSum,maxLength,maxIndexOfFirstPrime,primes);
    System.out.println("result="+maxSum+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP50 m=new MainP50();
    m.doIt();
  }
}
