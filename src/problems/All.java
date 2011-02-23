package problems;

import java.lang.reflect.Method;

/**
 * Launch all the problems.
 * @author DAM
 */
public class All
{
  private static String intToString(int value)
  {
    String s=String.valueOf(value);
    if (value<10) s="00"+s;
    else if (value<100) s="0"+s;
    return s;
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    for(int i=1;i<=1000;i++)
    {
      Method m=null;
      try
      {
        int min=1+50*((i-1)/50);
        int max=min+49;
        String className="problems.p"+intToString(min)+"_"+intToString(max)+".MainP"+i;
        Class<?> c=Class.forName(className);
        m=c.getMethod("main",String[].class);
      }
      catch(Exception e)
      {
        //e.printStackTrace();
      }
      if (m!=null)
      {
        System.out.println("Problem #"+i);
        try
        {
          m.invoke(null,(Object)args);
        }
        catch(Exception e)
        {
          e.printStackTrace();
        }
      }
    }
  }

}
