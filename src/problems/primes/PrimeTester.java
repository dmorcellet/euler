package problems.primes;

/**
 * Interface of a prime tester.
 * @author DAM
 */
public interface PrimeTester
{
  /**
   * Test if n is prime or not.
   * @param n Number to test.
   * @return <code>true</code> if it is prime, <code>false</code> if it is not.
   * @throws IllegalArgumentException if n is not supported.
   */
  boolean isPrime(long n);
}
