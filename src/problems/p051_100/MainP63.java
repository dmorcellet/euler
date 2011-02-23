package problems.p051_100;

import java.math.BigInteger;
import java.util.HashSet;

/**
 * Solved 16.01.2011.
 * @author DAM
 */
public class MainP63
{
  private MainP63()
  {
    // Nothing to do !
  }

  private boolean testValue(BigInteger value, int power)
  {
    int nbDigits=value.toString().length();
    return (nbDigits==power);
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();

    HashSet<BigInteger> values=new HashSet<BigInteger>();
    for(int baseNumber=1;baseNumber<11;baseNumber++)
    {
      BigInteger baseNumberAsBigInt=BigInteger.valueOf(baseNumber);
      BigInteger value=BigInteger.valueOf(baseNumber);
      for(int power=1;power<23;power++)
      {
        if (testValue(value,power))
        {
          //System.out.println(baseNumber+"^"+power+"="+value);
          values.add(value);
        }
        value=value.multiply(baseNumberAsBigInt);
      }
    }
    int nb=values.size();
    long now2=System.currentTimeMillis();
    System.out.println("result="+nb+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP63 m=new MainP63();
    m.doIt();
  }
}
