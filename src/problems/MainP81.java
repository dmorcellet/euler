package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Solved 30.01.2011.
 * @author DAM
 */
public class MainP81
{
  private static final int MATRIX_SIZE=80;
  private int[][] _matrix;

  private MainP81()
  {
    // Nothing to do !
  }

  private void loadMatrix()
  {
    _matrix=new int[MATRIX_SIZE][MATRIX_SIZE];
    try
    {
      InputStream is=getClass().getResourceAsStream("/data/P81-matrix.txt");
      BufferedReader r=new BufferedReader(new InputStreamReader(is));
      String line=null;
      for(int lineIndex=0;lineIndex<MATRIX_SIZE;lineIndex++)
      {
        line=r.readLine();
        if (line==null) break;
        String[] items=line.split(",");
        for(int i=0;i<MATRIX_SIZE;i++)
        {
          _matrix[i][lineIndex]=Integer.parseInt(items[i]);
        }
      }
    }
    catch(IOException ioe)
    {
      ioe.printStackTrace();
    }
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    loadMatrix();
    for(int y=MATRIX_SIZE-1;y>=0;y--)
    {
      for(int x=MATRIX_SIZE-1;x>=0;x--)
      {
        if (x==MATRIX_SIZE-1)
        {
          if (y<MATRIX_SIZE-1)
          {
            _matrix[x][y]+=_matrix[x][y+1];
          }
        }
        else
        {
          if (y==MATRIX_SIZE-1)
          {
            _matrix[x][y]+=_matrix[x+1][y];
          }
          else
          {
            _matrix[x][y]+=Math.min(_matrix[x+1][y],_matrix[x][y+1]);
          }
        }
      }
    }
    int result=_matrix[0][0];
    long now2=System.currentTimeMillis();
    System.out.println("result="+result+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP81 m=new MainP81();
    m.doIt();
  }
}
