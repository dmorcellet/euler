package problems.tools;

/**
 * @author DAM
 */
public class Digits
{
  /**
   * Get the number fof digits of a natural number.
   * @param n Number to test.
   * @return Number of digits.
   */
  public static int nbDigitsBase10(int n)
  {
    int max=10;
    int nb=1;
    while (nb<12)
    {
      if (n<max) return nb;
      max=max*10;
      nb++;
    }
    return 12;
  }

  /**
   * Get the number fof digits of a natural number.
   * @param n Number to test.
   * @return Number of digits.
   */
  public static int nbDigitsBase10(long n)
  {
    if (n==0) return 1;
    int nb=0;
    while (n>0)
    {
      n/=10;
      nb++;
    }
    return nb;
  }

  /**
   * Indicates if the given number is pandigital.
   * @param n Number to test.
   * @return <code>true</code> if it is, <code>false</code> otherwise.
   */
  public static boolean isPandigital(int n)
  {
    int nbDigits=nbDigitsBase10(n);
    boolean[] digits=new boolean[nbDigits];
    for(int i=0;i<nbDigits;i++) digits[i]=false;
    while (n>0)
    {
      int digit=n%10;
      if (digit==0) return false;
      if (digit>nbDigits) return false;
      if (digits[digit-1]) return false;
      digits[digit-1]=true;
      n/=10;
    }
    return true;
  }
}
