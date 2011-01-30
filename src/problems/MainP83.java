package problems;

/**
 * Solved 30.01.2011.
 * @author DAM
 */
public class MainP83
{
  private static final int MATRIX_SIZE=80;
  private static final int BORDER=1000000;

  private MainP83()
  {
    // Nothing to do !
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    int[][] matrix=MainP81.loadMatrix();
    // Init best matrix
    int[][] best=new int[MATRIX_SIZE+2][MATRIX_SIZE+2];
    // - make a border
    for(int x=0;x<MATRIX_SIZE+2;x++)
    {
      best[x][0]=BORDER;best[x][MATRIX_SIZE+1]=BORDER;
      best[0][x]=BORDER;best[MATRIX_SIZE+1][x]=BORDER;
    }
    // - init each cell with a default path value (straight increasing y, then increase x).
    best[1][1]=matrix[0][0];
    // -- first column
    for(int y=2;y<=MATRIX_SIZE;y++) best[1][y]=best[1][y-1]+matrix[0][y-1];
    // - other columns
    for(int x=2;x<=MATRIX_SIZE;x++)
      for(int y=1;y<=MATRIX_SIZE;y++)
        best[x][y]=best[x-1][y]+matrix[x-1][y-1];
    //dumpMatrix(matrix,MATRIX_SIZE);
    
    int iterationNumber=0;
    while(iterationNumber<1000)
    {
      //dumpMatrix(best,MATRIX_SIZE+2);
      iterationNumber++;
      int nbChanges=0;
      int bestBefore=best[MATRIX_SIZE][MATRIX_SIZE];
      for(int x=1;x<=MATRIX_SIZE;x++)
      {
        for(int y=1;y<=MATRIX_SIZE;y++)
        {
          if ((x!=1) || (y!=1))
          {
            int min1=Math.min(best[x-1][y],best[x+1][y]);
            int min2=Math.min(best[x][y-1],best[x][y+1]);
            int min=Math.min(min1,min2);
            int newValue=matrix[x-1][y-1]+min;
            if (newValue<best[x][y])
            {
              //System.out.println("Dropped from "+best[x][y]+" to "+newValue+" at ("+x+","+y+")");
              best[x][y]=newValue;
              nbChanges++;
            }
          }
        }
      }
      //dumpMatrix(best,MATRIX_SIZE+2);
      int bestAfter=best[MATRIX_SIZE][MATRIX_SIZE];
      if (bestAfter==bestBefore) break;
      if (nbChanges==0) break;
      //if (bestAfter==bestBefore) break;
    }
    int result=best[MATRIX_SIZE][MATRIX_SIZE];
    long now2=System.currentTimeMillis();
    System.out.println("result="+result+" ("+(now2-now)+"ms).");
  }

  /*
  private void dumpMatrix(int[][] m, int size)
  {
    String s;
    for(int y=0;y<size;y++)
    {
      for(int x=0;x<size;x++)
      {
        s=String.valueOf(m[x][y]);
        System.out.print(s);
        for(int i=0;i<10-s.length();i++) System.out.print(' ');
      }
      System.out.println("");
    }
  }
  */

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP83 m=new MainP83();
    m.doIt();
  }
}
