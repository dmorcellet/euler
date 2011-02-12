package problems.tools;

/**
 * Limited length computations.
 * @author DAM
 */
public class LimitedLengthComputation
{
  /**
   * Multiplication.
   * @param n1 First number.
   * @param n2 First number.
   * @param max Modulo.
   * @return Computed value.
   */
  public static long multiplication(long n1, long n2, long max)
  {
    long r=n1*n2;
    r=r%max;
    return r;
  }

  /**
   * Power.
   * @param n1 First number.
   * @param n2 Power.
   * @param max Modulo.
   * @return Computed value.
   */
  public static long power(int n1, int n2, long max)
  {
    long r=n1;
    for(int i=2;i<=n2;i++)
    {
      r=multiplication(r,n1,max);
    }
    return r;
  }

  /**
   * Sum.
   * @param n1 First number.
   * @param n2 First number.
   * @param max Modulo.
   * @return Computed value.
   */
  public static long sum(long n1, long n2, long max)
  {
    long r=n1+n2;
    r=r%max;
    return r;
  }
}
