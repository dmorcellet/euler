package problems.p051_100;

import java.math.BigInteger;

/**
 * Solved 08.01.2011.
 * @author DAM
 */
public class MainP57
{
  private MainP57()
  {
    // Nothing to do !
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    BigInteger n=BigInteger.valueOf(1);
    BigInteger d=BigInteger.valueOf(2);
    int nb=0;
    for(int i=0;i<1000;i++)
    {
      BigInteger fullN=d.add(n);
      int nbDigitsFullN=fullN.toString().length();
      int nbDigitsD=d.toString().length();
      if (nbDigitsFullN>nbDigitsD)
      {
        //System.out.println("i="+(i+1)+", digits(n)="+nbDigitsFullN+", digits(d)="+nbDigitsD+", "+fullN+"/"+d);
        nb++;
      }
      BigInteger d2=d.add(d);
      BigInteger tmpD=d;
      d=d2.add(n);
      n=tmpD;
    }
    long now2=System.currentTimeMillis();
    System.out.println("result="+nb+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP57 m=new MainP57();
    m.doIt();
  }
}
