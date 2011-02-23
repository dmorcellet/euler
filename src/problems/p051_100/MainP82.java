package problems.p051_100;

/**
 * Solved 30.01.2011.
 * @author DAM
 */
public class MainP82
{
  private static final int MATRIX_SIZE=MainP81.MATRIX_SIZE;

  private MainP82()
  {
    // Nothing to do !
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    int[][] matrix=MainP81.loadMatrix();
    int[] tmpMin=new int[MATRIX_SIZE];
    for(int x=1;x<MATRIX_SIZE;x++)
    {
      for(int y=0;y<MATRIX_SIZE;y++)
      {
        int min=matrix[x-1][y];
        int sumY=0;
        for(int y2=y+1;y2<MATRIX_SIZE;y2++)
        {
          sumY+=matrix[x][y2];
          if (sumY>min) break;
          int sum=matrix[x-1][y2]+sumY;
          if (sum<min) min=sum;
        }
        sumY=0;
        for(int y2=y-1;y2>=0;y2--)
        {
          sumY+=matrix[x][y2];
          if (sumY>min) break;
          int sum=matrix[x-1][y2]+sumY;
          if (sum<min) min=sum;
        }
        tmpMin[y]=matrix[x][y]+min;
      }
      for(int y=0;y<MATRIX_SIZE;y++) matrix[x][y]=tmpMin[y];
    }
    // find min in last column
    int min=Integer.MAX_VALUE;
    for(int y=0;y<MATRIX_SIZE;y++)
    {
      if (matrix[MATRIX_SIZE-1][y]<min)
      {
        min=matrix[MATRIX_SIZE-1][y];
      }
    }
    long now2=System.currentTimeMillis();
    System.out.println("result="+min+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP82 m=new MainP82();
    m.doIt();
  }
}
