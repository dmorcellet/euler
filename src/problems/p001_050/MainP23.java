package problems.p001_050;

import java.util.ArrayList;

/**
 * Solved 19.12.2010.
 * @author DAM
 */
public class MainP23
{
  private MainP23()
  {
    // Nothing to do !
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    int max=30000; //28123;
    boolean[] reachable=new boolean[max+1];
    ArrayList<Integer> abundantNumbers=new ArrayList<Integer>(); 
    for(int i=1;i<=max;i++)
    {
      int sumOfDivisors=0;
      int maxDivisor=i/2;
      for(int j=1;j<=maxDivisor;j++)
      {
        if (i%j==0) sumOfDivisors+=j;
        if (sumOfDivisors>i)
        {
          abundantNumbers.add(Integer.valueOf(i));
          int nb=abundantNumbers.size();
          for(int k=0;k<nb;k++)
          {
            int index=i+abundantNumbers.get(k).intValue();
            if (index<=max) reachable[index]=true;
          }
          break;
        }
      }
    }
    long sum=0;
    for(int i=1;i<=max;i++)
    {
      if (!reachable[i])
      {
        //System.out.print(' ');System.out.print(i);
        sum+=i;
      }
    }
    //System.out.println(abundantNumbers);
    //System.out.println(abundantNumbers.size());
    long now2=System.currentTimeMillis();
    System.out.println("result="+sum+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP23 m=new MainP23();
    m.doIt();
  }
}
