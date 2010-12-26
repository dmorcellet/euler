package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Solved 13.12.2010.
 * @author DAM
 */
public class MainP24
{
  private MainP24()
  {
    // Nothing to do !
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    int n=10;
    int[] fact=new int[n+1];
    fact[0]=1;
    for(int i=1;i<=n;i++) fact[i]=i*fact[i-1];
    List<Integer> numbers=new ArrayList<Integer>(10);
    for(int i=0;i<10;i++) numbers.add(Integer.valueOf(i));
    int index=999999;
    for(int i=0;i<10;i++)
    {
      int f=fact[9-i];
      int number=index/f;
      int digit=numbers.get(number).intValue();
      numbers.remove(number);
      System.out.print(digit);
      index-=(number*f);
    }
    System.out.println("");
      
    long now2=System.currentTimeMillis();
    System.out.println("result="+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP24 m=new MainP24();
    m.doIt();
  }
}
