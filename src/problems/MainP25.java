package problems;

import utils.BigInt;

/**
 * @author DAM
 */
public class MainP25
{
  private MainP25()
  {
    // Nothing to do !
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    int indexOfN=1;
    BigInt n=new BigInt(1100,1);
    BigInt n1=new BigInt(1100,1);
    BigInt tmp;
    while(true)
    {
      n.add(n1);
      tmp=n;
      n=n1;
      n1=tmp;
      indexOfN++;
      if (n.toString().length()>=1000)
      {
        break;
      }
    }
    long now2=System.currentTimeMillis();
    System.out.println("result="+indexOfN+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP25 m=new MainP25();
    m.doIt();
  }
}
