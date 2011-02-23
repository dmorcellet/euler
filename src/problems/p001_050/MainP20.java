package problems.p001_050;

import java.math.BigDecimal;


/**
 * @author DAM
 */
public class MainP20
{
  private static final int N=100; 
  private MainP20()
  {
    // Nothing to do !
  }

  /*
  private void doIt2()
  {
    long now=System.currentTimeMillis();
    int nbDigitsMax=(int)Math.round(N*Math.log10(N));
    int[] digits=new int[nbDigitsMax];
    int nbDigits=1;
    digits[0]=1;
    int[] m=new int[3];
    for(int i=2;i<=N;i++)
    {
      // perform digits*i
      m[0]=i%10;
      m[1]=(i/10)%10;
      m[2]=(i/100)%10;
      int remainder=0;
      for(int j=0;j<nbDigits;j++)
      {
        digits[j]=digits[j]*m[j]+remainder;
        if (digits[j]>9)
        {
          remainder=digits[j]/10;
          digits[j]=digits[j]%10;
        }
      }
      while (remainder>0)
      {
        digits[nbDigits]=remainder%10;
        remainder=remainder/10;
        nbDigits++;
      }
      System.out.print(i+"!=");
      for(int j=nbDigits-1;j>=0;j--) System.out.print(digits[j]); System.out.println("");
    }
    long now2=System.currentTimeMillis();
    System.out.println("result="+" ("+(now2-now)+"ms).");
  }
  */

  private void doIt()
  {
    long now=System.currentTimeMillis();
    BigDecimal d=new BigDecimal(1);
    for(int i=2;i<=N;i++)
    {
      BigDecimal m=new BigDecimal(i);
      d=d.multiply(m);
      //System.out.println(i+"!="+d);
    }
    String digitsStr=d.toString();
    int sum=0;
    for(int i=0;i<digitsStr.length();i++)
    {
      sum+=(digitsStr.charAt(i)-'0');
    }
    long now2=System.currentTimeMillis();
    System.out.println("result="+sum+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP20 m=new MainP20();
    m.doIt();
  }
}
