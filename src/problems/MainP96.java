package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Solved 23.02.2011.
 * @author DAM
 */
public class MainP96
{
  private static class Grid
  {
    private static final int SIZE=3;
    private static final int FULLSIZE=SIZE*SIZE;
    private int[][] _values;
    private int _nbSet;
    private Grid(List<String> gridDef)
    {
      _nbSet=0;
      _values=new int[FULLSIZE][];
      for(int i=0;i<FULLSIZE;i++) _values[i]=new int[FULLSIZE];
      int lineIndex=0;
      for(String line : gridDef)
      {
        for(int i=0;i<FULLSIZE;i++)
        {
          int value=(line.charAt(i)-'0');
          _values[i][lineIndex]=value;
          if (value!=0) _nbSet++;
        }
        lineIndex++;
      }
    }

    private int getValue()
    {
      int n1=_values[0][0];
      int n2=_values[1][0];
      int n3=_values[2][0];
      return n1*100+n2*10+n3;
    }

    private boolean isFinished()
    {
      return _nbSet==FULLSIZE*FULLSIZE;
    }

    private void set(int x, int y, int value)
    {
      int X=x/SIZE;x=x%SIZE;
      int Y=y/SIZE;y=y%SIZE;
      _values[X*SIZE+x][Y*SIZE+y]=value;
    }
    
    private int evaluateNextSituation()
    {
      if (isFinished())
      {
        return getValue();
      }
      int ret=0;
      int bestX=-1,bestY=-1;
      int bestNbChoices=100;
      int[] bestChoices=null;
      for(int i=0;i<FULLSIZE;i++)
      {
        for(int j=0;j<FULLSIZE;j++)
        {
          int[] choices=evalChoices(i,j);
          if (choices!=null)
          {
            int nb=0;
            for(int k=0;k<FULLSIZE;k++)
              if (choices[k]==0) nb++;
            if (nb<bestNbChoices)
            {
              bestChoices=choices;
              bestX=i;bestY=j;
              bestNbChoices=nb;
            }
          }
        }
      }
      if (bestChoices!=null)
      {
        for(int i=0;i<FULLSIZE;i++)
        {
          if (bestChoices[i]==0)
          {
            set(bestX,bestY,i+1);
            _nbSet++;
            int subRet=evaluateNextSituation();
            if (subRet!=0)
            {
              ret=subRet;
            }
            set(bestX,bestY,0);
            _nbSet--;
          }
          if (ret!=0) break;
        }
      }
      return ret;
    }

    /**
     * Evaluate possible choices.
     * @param x Horizontal index in grid.
     * @param y Vertical index in grid.
     * @return An array (result[i]=0=> i+1 is a possible choice).
     */
    private int[] evalChoices(int x, int y)
    {
      int X=x/SIZE;x=x%SIZE;
      int Y=y/SIZE;y=y%SIZE;
      int value=_values[X*SIZE+x][Y*SIZE+y];
      if (value!=0) return null;
      int[] choices=new int[10];
      // remove entries of the same subgrid
      for(int i=0;i<SIZE;i++)
      {
        for(int j=0;j<SIZE;j++)
        {
          int v=_values[X*SIZE+i][Y*SIZE+j];
          if (v!=0) choices[v-1]=1;
        }
      }
      // remove entries of the same line
      for(int i=0;i<FULLSIZE;i++)
      {
        int v=_values[i][Y*SIZE+y];
        if (v!=0) choices[v-1]=1;
      }
      // remove entries of the same row
      for(int i=0;i<FULLSIZE;i++)
      {
        int v=_values[X*SIZE+x][i];
        if (v!=0) choices[v-1]=1;
      }
      return choices;
    }
    
    @Override
    public String toString()
    {
      StringBuilder sb=new StringBuilder();
      for(int y=0;y<FULLSIZE;y++)
      {
        for(int x=0;x<FULLSIZE;x++) sb.append(_values[x][y]);
        sb.append("\n");
      }
      return sb.toString();
    }
  }

  private MainP96()
  {
    // Nothing to do !
  }

  private List<String> loadGrids()
  {
    List<String> lines=new ArrayList<String>();
    try
    {
      InputStream is=getClass().getResourceAsStream("/data/P96-sudoku.txt");
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

  private int solveGrid(List<String> grid)
  {
    Grid g=new Grid(grid);
    int ret=g.evaluateNextSituation();
    return ret;
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    int sum=0;
    List<String> grids=loadGrids();
    int n=0;
    for(int i=0;i<50;i++)
    {
      List<String> grid=new ArrayList<String>();
      n++;
      for(int j=0;j<9;j++)
      {
        grid.add(grids.get(n));
        n++;
      }
      int value=solveGrid(grid);
      sum+=value;
    }
    long now2=System.currentTimeMillis();
    System.out.println("result="+sum+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP96 m=new MainP96();
    m.doIt();
  }
}
