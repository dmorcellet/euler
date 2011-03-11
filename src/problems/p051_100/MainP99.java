package problems.p051_100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Solved 11.03.2011.
 * @author DAM
 */
public class MainP99
{
  private MainP99()
  {
    // Nothing to do !
  }

  private List<Integer> loadValues()
  {
    List<Integer> values=new ArrayList<Integer>();
    try
    {
      InputStream is=getClass().getResourceAsStream("/data/P99-base_exp.txt");
      BufferedReader r=new BufferedReader(new InputStreamReader(is));
      String line=null;
      while(true)
      {
        line=r.readLine();
        if (line==null) break;
        int index=line.indexOf(',');
        values.add(Integer.valueOf(line.substring(0,index)));
        values.add(Integer.valueOf(line.substring(index+1)));
      }
    }
    catch(IOException ioe)
    {
      ioe.printStackTrace();
    }
    return values;
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    List<Integer> values=loadValues();
    int nb=values.size()/2;
    double max=0;
    int lineNumber=-1;
    for(int i=0;i<nb;i++)
    {
    	double tmp=values.get(i*2+1)*Math.log10(values.get(i*2));
    	if (tmp>max)
    	{
    		lineNumber=i+1;
    		max=tmp;
    	}
    }
    long now2=System.currentTimeMillis();
    System.out.println("result="+lineNumber+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
	  MainP99 m=new MainP99();
    m.doIt();
  }
}
