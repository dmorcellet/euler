package problems.p001_050;

/**
 * Solved 19.12.2010.
 * @author DAM
 */
public class MainP28
{
  private MainP28()
  {
    // Nothing to do !
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    int value=3;
    int size=1001;
    int maxn=(size-1)/2;
    int diag1=1;
    int diag2=1;
    int sum=1;
    for(int n=1;n<=maxn;n++)
    {
      diag1+=value;
      value+=2*n;
      diag2+=value;
      value+=2*n;
      diag1+=value;
      value+=2*n;
      diag2+=value;
      // go to the next corner
      value++; // go to next column
      value+=2*n;
      value++;
      sum=diag1+diag2-1;
      //System.out.println("value="+value+", diag1="+diag1+", diag2="+diag2+", sum="+sum);
    }
    //System.out.println("value="+value+", diag1="+diag1+", diag2="+diag2+", sum="+sum);

    long now2=System.currentTimeMillis();
    System.out.println("result="+sum+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP28 m=new MainP28();
    m.doIt();
  }
}
