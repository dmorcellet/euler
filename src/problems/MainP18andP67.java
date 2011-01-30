package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Solved 13.12.2010.
 * @author DAM
 */
public class MainP18andP67
{
  private int[][] _values;
  private int _height;
  private int _maxWidth;

  private void loadTriangle(String name)
  {
    List<String> lines=new ArrayList<String>();
    try
    {
      InputStream is=getClass().getResourceAsStream("/data/"+name+".txt");
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
    _height=lines.size();
    _values=new int[_height][];
    int width=0;
    for(int i=_height-1;i>=0;i--)
    {
      String line=lines.get(i);
      String[] numberStrs=line.split(" ");
      if (numberStrs.length>width) width=numberStrs.length;
      _values[i]=new int[numberStrs.length];
      for(int j=0;j<numberStrs.length;j++)
      {
        _values[i][j]=Integer.parseInt(numberStrs[j]);
      }
    }
    _maxWidth=width;
  }

  /**
   * Resolution of problems 18 and 67.
   * @param name Data file to use.
   */
  public void doIt(String name)
  {
    long now=System.currentTimeMillis();
    loadTriangle(name);
    int[] max=new int[_maxWidth];
    int[] tmp=new int[_maxWidth];
    for(int i=0;i<_maxWidth;i++)
    {
      max[i]=_values[_height-1][i];
    }
    for(int i=_height-1;i>=0;i--)
    {
      //System.out.print(i+1+":");
      //for(int k=1;k<=(i+1);k++) System.out.print(" "+max[k-1]);
      //System.out.println("");
      for(int j=1;j<_maxWidth;j++)
      {
        if (j<=i)
        {
          int v=_values[i-1][j-1];
          int oneLeft=0;//((j>1)?(max[j-2]):0);
          int below=max[j-1];
          int oneRight=max[j];
          int best=Math.max(oneLeft,below);
          best=Math.max(best,oneRight);
          tmp[j-1]=v+best;
        }
      }
      System.arraycopy(tmp,0,max,0,_maxWidth);
    }

    long now2=System.currentTimeMillis();
    System.out.println("result="+max[0]+" ("+(now2-now)+"ms).");
  }
}
