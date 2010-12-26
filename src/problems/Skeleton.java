package problems;

/**
 * @author DAM
 */
public class Skeleton
{
  private Skeleton()
  {
    // Nothing to do !
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    long now2=System.currentTimeMillis();
    System.out.println("result="+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    Skeleton m=new Skeleton();
    m.doIt();
  }
}
