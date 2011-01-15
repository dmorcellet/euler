package problems;

import java.lang.reflect.Method;

/**
 * Launch all the problems.
 * @author DAM
 */
public class All
{
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
        String className="problems.MainP"+i;
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
