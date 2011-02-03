package problems;

/**
 * Solved 19.12.2010.
 * @author DAM
 */
public class MainP30
{
  private MainP30()
  {
    // Nothing to do !
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    int power=5;
    int base=(int)Math.pow(9,power);
    int nbDigitsMax=1;
    int n=10;
    while (true)
    {
      if ((base*nbDigitsMax)<n) break;
      n*=10;
      nbDigitsMax++;
    }
    int max=nbDigitsMax*base;
    int totalSum=0;
    for(int i=10;i<=max;i++)
    {
      int tmp=i;
      int sum=0;
      while (tmp>0)
      {
        sum+=Math.pow(tmp%10,power);
        tmp/=10;
      }
      if (i==sum)
      {
        //System.out.println("i="+i+", sum="+sum);
        totalSum+=sum;
      }
    }
    
    long now2=System.currentTimeMillis();
    System.out.println("result="+totalSum+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP30 m=new MainP30();
    m.doIt();
  }
}
