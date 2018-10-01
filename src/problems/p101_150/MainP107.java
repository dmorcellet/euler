package problems.p101_150;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Solved 03.04.2011.
 * @author DAM
 */
public class MainP107
{
  private MainP107()
  {
    // Nothing to do !
  }

  private int[][] loadMatrix()
  {
    List<String> lines=new ArrayList<String>();
    try
    {
      InputStream is=getClass().getResourceAsStream("/data/P107-network.txt");
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
    int height=lines.size();
    int[][] ret=new int[height][];
    for(int i=0;i<height;i++)
    {
      String line=lines.get(i);
      String[] items=line.split(",");
      int nbItems=items.length;
      ret[i]=new int[nbItems];
      for(int j=0;j<nbItems;j++)
      {
    	  if ("-".equals(items[j]))
    	  {
    		  ret[i][j]=-1;
    	  }
    	  else
    	  {
    		  ret[i][j]=Integer.parseInt(items[j]);
    	  }
      }
    }
    return ret;
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    int[][] m=loadMatrix();
    int nbVertex=m.length;
    boolean[] chosenVertex=new boolean[nbVertex];
    chosenVertex[0]=true;
    //HashSet<Integer> chosenVertex=new HashSet<Integer>();
    //chosenVertex.add(Integer.valueOf(0));
    int initialWeight=0;
    for(int i=0;i<nbVertex;i++)
    {
      for(int j=0;j<=i;j++)
      {
        if (m[i][j]!=-1) initialWeight+=m[i][j];
      }
    }
    int totalWeight=0;
    //int nbChosenVertex=1;
    for(int i=1;i<nbVertex;i++)
    {
      // Choose next vertex
      // Find a vertex V in chosenVertex and another one U not in chosenVertex
      // so that the edge (V,U) is minimal.
      int minWeight=Integer.MAX_VALUE;
      int /*chosenV=-1,*/chosenU=-1;
      for(int v=0;v<nbVertex;v++)
      {
        if (chosenVertex[v])
        {
          for(int u=0;u<nbVertex;u++)
          {
            if (!chosenVertex[u])
            {
              int w=m[u][v];
              if ((w!=-1) && (w<minWeight))
              {
                //chosenV=v;
                chosenU=u;
                minWeight=w;
              }
            }
          }
        }
      }
      chosenVertex[chosenU]=true;
      //nbChosenVertex++;
      //System.out.println("Chosen U="+chosenU+", chosenV="+chosenV+", minWeight="+minWeight);
      totalWeight+=minWeight;
    }
    int savings=initialWeight-totalWeight;
    //System.out.println("Nb chosen vertex="+nbChosenVertex);
    long now2=System.currentTimeMillis();
    System.out.println("result="+savings+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
	MainP107 m=new MainP107();
    m.doIt();
  }
}
