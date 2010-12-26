package problems.primes;

/**
 * @author dm
 */
public class PrimeTester
{
  public static boolean isPrime(long n)
  {
    // 1 is not a prime.
    // All primes except 2 are odd.
    // All primes greater than 3 can be written in the form 6k+/-1.
    // Any number n can have only one primefactor greater than sqrt(n).
    // The consequence for primality testing of a number n is: if we cannot find a number f less than
    //or equal sqrt(n) that divides n then n is prime: the only primefactor of n is n itself
    
    if (n==1) return false;
    if (n<4) return true; //2 and 3 are prime
    if (n%2==0) return false;
    if (n<9) return true;
    if (n%3==0) return false;

    long r=(long)Math.floor(Math.sqrt(n));
    long f=5;
    while (f<=r)
    {
      if (n%f==0) return false;
      if (n%(f+2)==0) return false;
      f+=6;
    }
    return true;
  }
}
 