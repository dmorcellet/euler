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
}
