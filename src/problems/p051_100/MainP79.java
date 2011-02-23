package problems.p051_100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Solved 25.01.2011.
 * (manual answer based on computed helpers)
 * @author DAM
 */
public class MainP79
{
  private MainP79()
  {
    // Nothing to do !
  }

  private List<String> loadKeys()
  {
    List<String> lines=new ArrayList<String>();
    try
    {
      InputStream is=getClass().getResourceAsStream("/data/P79-keylog.txt");
      BufferedReader r=new BufferedReader(new InputStreamReader(is));
      String line=null;
      while(true)
      {
        line=r.readLine();
        if (line==null) break;
        lines.add(line);
      }
    }
    catch(IOException ioe)
    {
      ioe.printStackTrace();
    }
    return lines;
  }

  private void put(HashMap<Integer,List<Integer>> map, Integer key, Integer item)
  {
    List<Integer> list=map.get(key);
    if (list==null)
    {
      list=new ArrayList<Integer>();
      map.put(key,list);
    }
    if (!list.contains(item)) list.add(item);
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    List<String> keys=loadKeys();
    Collections.sort(keys);
    String lastKey="";
    List<String> uniqueKeys=new ArrayList<String>();
    for(String key : keys)
    {
      if (!lastKey.equals(key))
      {
        uniqueKeys.add(key);
        lastKey=key;
        //System.out.println(key);
      }
    }
    //System.out.println("Keys : "+keys.size()+" "+keys);
    //System.out.println("Unique keys : "+uniqueKeys.size()+" "+uniqueKeys);
    HashSet<Integer> exists=new HashSet<Integer>();
    HashMap<Integer,List<Integer>> befores=new HashMap<Integer,List<Integer>>();
    HashMap<Integer,List<Integer>> afters=new HashMap<Integer,List<Integer>>();
    for(String key : keys)
    {
      Integer n1=Integer.valueOf(key.charAt(0)-'0');
      exists.add(n1);
      Integer n2=Integer.valueOf(key.charAt(1)-'0');
      exists.add(n2);
      Integer n3=Integer.valueOf(key.charAt(2)-'0');
      exists.add(n3);
      // Befores
      put(befores,n2,n1);
      put(befores,n3,n2);
      put(befores,n3,n1);
      // Afters
      put(afters,n2,n3);
      put(afters,n1,n2);
      put(afters,n1,n3);
    }
    List<Integer> keyItems=new ArrayList<Integer>(exists);
    Collections.sort(keyItems);
    for(Integer key : keyItems)
    {
      List<Integer> beforesList=befores.get(key);
      List<Integer> aftersList=afters.get(key);
      System.out.println(beforesList+" < "+key+" < "+aftersList);
    }
    long now2=System.currentTimeMillis();
    System.out.println("result="+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP79 m=new MainP79();
    m.doIt();
  }
}
