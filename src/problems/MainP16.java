package problems;

/**
 * Solved 28.11.2010.
 * @author DAM
 */
public class MainP16
{
  private MainP16()
  {
    // Nothing to do !
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    int[] digits=new int[2000];
    digits[0]=1;
    int nbDigits=1;
    for(int i=0;i<1000;i++)
    {
      int remainder=0;
      for(int j=0;j<nbDigits;j++)
      {
        digits[j]=digits[j]*2+remainder;
        if (digits[j]>9)
        {
          digits[j]=digits[j]-10;
          remainder=1;
        }
        else
        {
          remainder=0;
        }
      }
      if (remainder>0)
      {
        digits[nbDigits]=1;
        nbDigits++;
      }
      /*
      System.out.print("2^"+(i+1)+"=");
      for(int j=nbDigits-1;j>=0;j--) 
      {
        System.out.print(digits[j]);
      }
      System.out.println("");
      */
    }
    int sum=0;
    for(int i=0;i<nbDigits;i++)
    {
      sum+=digits[i];
    }
    long now2=System.currentTimeMillis();
    System.out.println("result="+sum+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP16 m=new MainP16();
    m.doIt();
  }
}
