package problems.p101_150;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Solved 11.03.2011.
 * @author DAM
 */
public class MainP102
{
  private MainP102()
  {
    // Nothing to do !
  }

  private List<Triangle> loadTriangles()
  {
    List<Triangle> triangles=new ArrayList<Triangle>();
    try
    {
      InputStream is=getClass().getResourceAsStream("/data/P102-triangles.txt");
      BufferedReader r=new BufferedReader(new InputStreamReader(is));
      String line=null;
      while(true)
      {
        line=r.readLine();
        if (line==null) break;
        String[] items=line.split(",");
        int x1=Integer.parseInt(items[0]);
        int y1=Integer.parseInt(items[1]);
        int x2=Integer.parseInt(items[2]);
        int y2=Integer.parseInt(items[3]);
        int x3=Integer.parseInt(items[4]);
        int y3=Integer.parseInt(items[5]);
        triangles.add(new Triangle(x1,y1,x2,y2,x3,y3));
      }
    }
    catch(IOException ioe)
    {
      ioe.printStackTrace();
    }
    return triangles;
  }

  private class Triangle
  {
    private int _x1,_x2,_x3;
    private int _y1,_y2,_y3;

    public Triangle(int x1, int y1, int x2, int y2, int x3, int y3)
    {
      _x1=x1; _y1=y1;
      _x2=x2; _y2=y2;
      _x3=x3; _y3=y3;
    }
    
    public boolean isInside(int x, int y)
    {
      long cp12_1=(_x2-_x1)*(y-_y1)-(x-_x1)*(_y2-_y1); 
      long cp12_2=(_x2-_x1)*(_y3-_y1)-(_x3-_x1)*(_y2-_y1);
      boolean side12=((cp12_1*cp12_2)>0);
      if (!side12) return false;
      long cp23_1=(_x3-_x2)*(y-_y2)-(x-_x2)*(_y3-_y2); 
      long cp23_2=(_x3-_x2)*(_y1-_y2)-(_x1-_x2)*(_y3-_y2);
      boolean side23=((cp23_1*cp23_2)>0);
      if (!side23) return false;
      long cp31_1=(_x1-_x3)*(y-_y3)-(x-_x3)*(_y1-_y3); 
      long cp31_2=(_x1-_x3)*(_y2-_y3)-(_x2-_x3)*(_y1-_y3);
      boolean side31=((cp31_1*cp31_2)>0);
      if (!side31) return false;
      return true;
    }
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    List<Triangle> triangles=loadTriangles();
    int nbIn=0;
    for(Triangle t : triangles)
    {
      if (t.isInside(0,0)) nbIn++;
    }
    long now2=System.currentTimeMillis();
    System.out.println("result="+nbIn+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP102 m=new MainP102();
    m.doIt();
  }
}
