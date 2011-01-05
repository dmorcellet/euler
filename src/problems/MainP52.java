package problems;

/**
 * Solved 05.01.2011.
 * @author DAM
 */
public class MainP52
{
  private MainP52()
  {
    // Nothing to do !
  }

  private int[] findDigits(int n)
  {
    int[] digits=new int[10];
    //for(int i=0;i<nbDigits;i++) digits[i]=0;
    while (n>0)
    {
      int digit=n%10;
      digits[digit]++;
      n/=10;
    }
    return digits;
  }

  private boolean checkDigits(int n, int[] refDigits)
  {
    int[] digits=new int[10];
    for(int i=0;i<10;i++) digits[i]=refDigits[i];
    while (n>0)
    {
      int digit=n%10;
      digits[digit]--;
      if (digits[digit]<0) return false;
      n/=10;
    }
    return true;
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    int result=0;
    for(int i=1;i<150000;i++)
    {
    	int[] digits=findDigits(i*2);
    	boolean ok=true;
    	for(int j=3;j<=6;j++)
    	{
    		if (!checkDigits(i*j, digits))
    		{
    			ok=false;
    			break;
    		}
    	}
    	if (ok)
    	{
    		result=i;
    		break;
    	}
    }
    long now2=System.currentTimeMillis();
    System.out.println("result="+result+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP52 m=new MainP52();
    m.doIt();
  }
}
