package problems.p001_050;

/**
 * @author DAM
 */
public class MainP5
{
  private void doIt()
  {
    long now=System.currentTimeMillis();
    int n=2;
    n*=3;
    n*=2;
    n*=5;
    n*=7;
    n*=2;
    n*=3;
    n*=11;
    n*=13;
    n*=2;
    n*=17;
    n*=19;
    long now2=System.currentTimeMillis();
    System.out.println("result="+n+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP5 m=new MainP5();
    m.doIt();
  }
}
