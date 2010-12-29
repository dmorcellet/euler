package problems;

/**
 * Solved 29.12.2010.
 * @author DAM
 */
public class MainP44
{
  private MainP44()
  {
    // Nothing to do !
  }

  private int penta(int n)
  {
    return (n*(3*n-1))/2;
  }

  private int isSquare(int d)
  {
    int squareRoot=(int)(Math.sqrt(d));
    if (d==squareRoot*squareRoot) return squareRoot;
    return 0;
  }

  private int isPenta(int a)
  {
    int d=1+24*a;
    int square=isSquare(d);
    if (square!=0)
    {
      int n=1+square;
      if (n%6==0)
      {
        return n/6;
      }
    }
    return 0;
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    int distance=10000000; 
    for(int i=1;i<=10000;i++)
    {
      int pentaI=penta(i);
      for(int j=i+1;j<=10000;j++)
      {
        int pentaJ=penta(j);
        int d=pentaJ-pentaI;
        if (d<distance)
        {
          int pentaSomme=isPenta(pentaI+pentaJ);
          if (pentaSomme!=0)
          {
            int pentaDiff=isPenta(pentaJ-pentaI);
            if (pentaDiff!=0)
            {
              System.out.println("Got i="+i+", Pi="+pentaI+", j="+j+", Pj="+pentaJ+", somme="+pentaSomme+", Psomme="+(pentaI+pentaJ)+", diff="+pentaDiff+", Pdiff="+(pentaJ-pentaI));
              if (d<distance)
              {
                distance=d;
                System.out.println("Distance = "+d);
              }
            }
          }
        }
      }
    }

    long now2=System.currentTimeMillis();
    System.out.println("result="+distance+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP44 m=new MainP44();
    m.doIt();
  }
}
