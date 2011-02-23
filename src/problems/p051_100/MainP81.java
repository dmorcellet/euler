package problems.p051_100;

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
  /**
   * Matrix size for problems 81, 82 and 83.
   */
  public static final int MATRIX_SIZE=80;

  private MainP81()
  {
    // Nothing to do !
  }

  /**
   * Matric loader for problems 81, 82 and 83.
   * @return a matrix.
   */
  public static int[][] loadMatrix()
  {
    int[][] matrix=new int[MATRIX_SIZE][MATRIX_SIZE];
    try
    {
      InputStream is=MainP81.class.getResourceAsStream("/data/P81-matrix.txt");
      BufferedReader r=new BufferedReader(new InputStreamReader(is));
      String line=null;
      for(int lineIndex=0;lineIndex<MATRIX_SIZE;lineIndex++)
      {
        line=r.readLine();
        if (line==null) break;
        String[] items=line.split(",");
        for(int i=0;i<MATRIX_SIZE;i++)
        {
          matrix[i][lineIndex]=Integer.parseInt(items[i]);
        }
      }
    }
    catch(IOException ioe)
    {
      ioe.printStackTrace();
    }
    return matrix;
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    int[][] matrix=loadMatrix();
    for(int y=MATRIX_SIZE-1;y>=0;y--)
    {
      for(int x=MATRIX_SIZE-1;x>=0;x--)
      {
        if (x==MATRIX_SIZE-1)
        {
          if (y<MATRIX_SIZE-1)
          {
            matrix[x][y]+=matrix[x][y+1];
          }
        }
        else
        {
          if (y==MATRIX_SIZE-1)
          {
            matrix[x][y]+=matrix[x+1][y];
          }
          else
          {
            matrix[x][y]+=Math.min(matrix[x+1][y],matrix[x][y+1]);
          }
        }
      }
    }
    int result=matrix[0][0];
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
