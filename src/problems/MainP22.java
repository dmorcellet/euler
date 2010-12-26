package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Solved 28.11.2010.
 * @author DAM
 */
public class MainP22
{
  private MainP22()
  {
    // Nothing to do !
  }

  private String loadData()
  {
    String line=null;
    try
    {
      InputStream is=getClass().getResourceAsStream("/data/P22-names.txt");
      BufferedReader r=new BufferedReader(new InputStreamReader(is));
      line=r.readLine();
    }
    catch(IOException ioe)
    {
      ioe.printStackTrace();
    }
    return line;
  }

  private List<String> loadNames()
  {
    String line=loadData();
    List<String> names=new ArrayList<String>();
    String[] namesArray=line.split(",");
    for(String name : namesArray)
    {
      if (name.startsWith("\"")) name=name.substring(1);
      if (name.endsWith("\"")) name=name.substring(0,name.length()-1);
      names.add(name);
    }
    Collections.sort(names);
    return names;
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    List<String> names=loadNames();
    long total=0;
    long rank=1;
    for(String name : names)
    {
      long alphaValue=0;
      for(int i=0;i<name.length();i++)
      {
        alphaValue+=(name.charAt(i)-'A'+1);
      }
      total=total+(alphaValue*rank);
      rank++;
    }
    long now2=System.currentTimeMillis();
    System.out.println("result="+total+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP22 m=new MainP22();
    m.doIt();
  }
}
