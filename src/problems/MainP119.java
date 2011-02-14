package problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Solved 14.02.2011.
 * @author DAM
 */
public class MainP119
{
  private MainP119()
  {
    // Nothing to do !
  }

  private boolean test(int base, long n)
  {
    int sum=0;
    long tmpn=n;
    int nbDigits=0;
    while (tmpn>0)
    {
      sum+=(tmpn%10);
      tmpn/=10;
      nbDigits++;
    }
    if ((nbDigits>1) && (base==sum))
    {
      //System.out.println("OK for base="+base+", n="+n);
      return true;
    }
    return false;
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    int nb=0;
    List<Long> goods=new ArrayList<Long>();
    for(int i=2;i<=100;i++)
    {
      long n=i;
      for(int j=1;j<=20;j++)
      {
        if (test(i,n))
        {
          goods.add(Long.valueOf(n));
          nb++;
        }
        n*=i;
      }
    }
    Collections.sort(goods);
    long r=goods.get(30-1).longValue();
    long now2=System.currentTimeMillis();
    System.out.println("result="+r+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP119 m=new MainP119();
    m.doIt();
  }
}
