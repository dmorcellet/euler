package problems;

/**
 * @author DAM
 */
public class MainP3
{
  private static final long N=600851475143l;

  private void doIt()
  {
    long now=System.currentTimeMillis();
    //System.out.println("N="+N);
    long n=N;
    long factor=2;
    long lastFactor=-1;
    while (n>1)
    {
      while (n%factor==0)
      {
        lastFactor=factor;
        n=n/factor;
        //System.out.println("Factor : "+factor);
      }
      factor++;
    }
    //System.out.println("Last factor="+lastFactor);
    long now2=System.currentTimeMillis();
    System.out.println("result="+lastFactor+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP3 m=new MainP3();
    m.doIt();
  }
}
