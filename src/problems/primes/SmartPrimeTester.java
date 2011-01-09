package problems.primes;

import java.util.Arrays;

/**
 * Smart prime tester.
 * It is based on the smart usage of an Erathostenes sieve.
 * @author DAM
 */
public class SmartPrimeTester implements PrimeTester
{
  private long[] _primesBelowThreshold;
  private long _threshold;
  private long _max;

  /**
   * Constructor.
   * @param erathostenesThreshold Size of Erathostenes sieve.
   */
  public SmartPrimeTester(long erathostenesThreshold)
  {
    _primesBelowThreshold=new ErathostenesSieve().fill(erathostenesThreshold);
    _threshold=erathostenesThreshold;
    _max=_threshold*_threshold;
  }

  public boolean isPrime(long n)
  {
    if (n<_threshold)
    {
     int ret=Arrays.binarySearch(_primesBelowThreshold,(int)n);
     return (ret>=0);
    }
    if (n<_max)
    {
      int nbPrimes=_primesBelowThreshold.length;
      for(int i=0;i<nbPrimes;i++)
      {
        if (n%_primesBelowThreshold[i]==0) return false;
      }
      return true;
    }
    throw new IllegalArgumentException("n="+n);
  }
}
