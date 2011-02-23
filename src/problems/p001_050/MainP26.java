package problems.p001_050;

import java.util.ArrayList;
import java.util.List;

/**
 * Solved 28.11.2010.
 * @author DAM
 */
public class MainP26
{
  private static final boolean DEBUG=false;
  private static final boolean MAXDEBUG=false;

  private MainP26()
  {
    // Nothing to do !
  }

  private int findReccuringCycleLength(int n)
  {
    int cycleSize=0;
    // perform division
    if (DEBUG) System.out.print("1/"+n+": ");
    int toDivide=1;
    List<Integer> toDivideSet=new ArrayList<Integer>();
    while (true)
    {
      toDivideSet.add(Integer.valueOf(toDivide));
      while(toDivide<n)
      {
        toDivide*=10;
        if (DEBUG) System.out.print('0');
        toDivideSet.add(Integer.valueOf(toDivide));
      }
      if (DEBUG) System.out.print(toDivide/n);
      toDivide%=n;
      if (toDivide>0)
      {
        toDivide*=10;
        int index=toDivideSet.indexOf(Integer.valueOf(toDivide));
        if (index!=-1)
        {
          cycleSize=(toDivideSet.size()-index);
          if (DEBUG) System.out.print(" - break for cycle of size "+cycleSize);
          break;
        }
      }
      else 
      {
        break;
      }
    }
    if (DEBUG) System.out.println("");
    return cycleSize;
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    int maxCycleSize=0;
    int n=0;
    for(int i=17;i<=1000;i++)
    {
      int cycleSize=findReccuringCycleLength(i);
      if (cycleSize>maxCycleSize)
      {
        maxCycleSize=cycleSize;
        n=i;
        if (MAXDEBUG)
        {
          System.out.println("Got a cycle of size "+maxCycleSize+" for "+n);
        }
      }
    }
    long now2=System.currentTimeMillis();
    System.out.println("result="+maxCycleSize+" ("+n+") ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP26 m=new MainP26();
    m.doIt();
  }
}
