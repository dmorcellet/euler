package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * Solved 28.12.2010.
 * @author DAM
 */
public class MainP42
{
  private MainP42()
  {
    // Nothing to do !
  }

  private String loadData()
  {
    String line=null;
    try
    {
      InputStream is=getClass().getResourceAsStream("/data/P42-words.txt");
      BufferedReader r=new BufferedReader(new InputStreamReader(is));
      line=r.readLine();
    }
    catch(IOException ioe)
    {
      ioe.printStackTrace();
    }
    return line;
  }

  private List<String> loadWords()
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

  private HashSet<Integer> computeTriangleNumbers(int n)
  {
    HashSet<Integer> values=new HashSet<Integer>(); 
    for(int i=1;i<=n;i++)
    {
      int value=(i*(i+1))/2;
      values.add(Integer.valueOf(value));
    }
    return values;
  }

  private int computeWordValue(String word)
  {
    int ret=0;
    int length=word.length();
    for(int i=0;i<length;i++)
    {
      ret+=((word.charAt(i))-'A'+1);
    }
    return ret;
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    List<String> words=loadWords();
    computeWordValue("SKY");
    HashSet<Integer> triangles=computeTriangleNumbers(100);
    int nb=0;
    for(String word : words)
    {
      int wordValue=computeWordValue(word);
      if (triangles.contains(Integer.valueOf(wordValue)))
      {
        nb++;
      }
    }
    long now2=System.currentTimeMillis();
    System.out.println("result="+nb+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP42 m=new MainP42();
    m.doIt();
  }
}
