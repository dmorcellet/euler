package problems.p001_050;

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
    long result=0;
    for(int i=0;i<10;i++)
    {
      int f=fact[9-i];
      int number=index/f;
      int digit=numbers.get(number).intValue();
      numbers.remove(number);
      result=result*10+digit;
      index-=(number*f);
    }
      
    long now2=System.currentTimeMillis();
    System.out.println("result="+result+" ("+(now2-now)+"ms).");
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
