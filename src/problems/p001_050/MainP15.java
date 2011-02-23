package problems.p001_050;

/**
 * Solved 28.11.2010.
 * @author DAM
 */
public class MainP15
{
  //private boolean[][] _grid;
  private static final int GRID_SIZE=21;
  //private int _x;
  //private int _y;
  //private long _nbRoutes;
  
  private MainP15()
  {
    /*
    _grid=new boolean[GRID_SIZE][GRID_SIZE];
    _x=0;
    _y=0;
    _grid[_x][_y]=true;
    _nbRoutes=0;
    */
  }

  /*
  private void iterateOnMoves()
  {
    if (success())
    {
      _nbRoutes++;
      _grid[_x][_y]=false;
      return;
    }
    if (isLegal(_x,_y+1))
    {
      _y++;
      _grid[_x][_y]=true;
      iterateOnMoves();
      _y--;
      _grid[_x][_y]=false;
    }
    if (isLegal(_x+1,_y))
    {
      _x++;
      _grid[_x][_y]=true;
      iterateOnMoves();
      _x--;
      _grid[_x][_y]=false;
    }
  }

  private boolean isLegal(int x, int y)
  {
    return ((x<GRID_SIZE) && (y<GRID_SIZE) && (_grid[x][y]==false));
  }

  private boolean success()
  {
    return ((_x==(GRID_SIZE-1)) && (_y==(GRID_SIZE-1)));
  }

  private void doIt2()
  {
    long now=System.currentTimeMillis();
    iterateOnMoves();
    long now2=System.currentTimeMillis();
    System.out.println("result="+_nbRoutes+" ("+(now2-now)+"ms).");
  }
  */

  private void doIt()
  {
    long now=System.currentTimeMillis();
    long[][] paths=new long[GRID_SIZE][GRID_SIZE];
    for(int i=0;i<GRID_SIZE;i++)
    {
      paths[i][0]=1;
      paths[0][i]=1;
    }
    for(int j=1;j<GRID_SIZE;j++)
    {
      for(int i=1;i<GRID_SIZE;i++)
      {
        paths[j][i]=paths[j-1][i]+paths[j][i-1];
      }
    }
    long nbRoutes=paths[GRID_SIZE-1][GRID_SIZE-1];
    /*
    for(int i=1;i<GRID_SIZE;i++)
    {
      System.out.println("Size="+i+" => Nb paths="+paths[i][i]);
    }
    */
    long now2=System.currentTimeMillis();
    System.out.println("result="+nbRoutes+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP15 m=new MainP15();
    m.doIt();
  }
}
