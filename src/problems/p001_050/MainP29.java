package problems.p001_050;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

/**
 * Solved 19.12.2010.
 * @author DAM
 */
public class MainP29
{
  private MainP29()
  {
    // Nothing to do !
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    Set<BigInteger> values=new HashSet<BigInteger>();
    int maxa=100,maxb=100;
    for(int a=2;a<=maxa;a++)
    {
      BigInteger value=BigInteger.valueOf(a);
      BigInteger B=BigInteger.valueOf(a);
      //values.add(value);
      for(int b=2;b<=maxb;b++)
      {
        value=value.multiply(B);
        values.add(value);
      }
    }
    int size=values.size();
    
    long now2=System.currentTimeMillis();
    System.out.println("result="+size+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP29 m=new MainP29();
    m.doIt();
  }
}
