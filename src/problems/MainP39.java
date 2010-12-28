package problems;

/**
 * Solved 28.12.2010.
 * @author DAM
 */
public class MainP39
{
  private static final int PMAX=1000;
  private MainP39()
  {
    // Nothing to do !
  }

  private int isSquare(int value)
  {
    int squareRoot=(int)Math.sqrt(value);
    if (squareRoot*squareRoot==value)
    {
      return squareRoot;
    }
    return -1;
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    
    // Compute solutions
    int[] nbSolutions=new int[PMAX+1];
    for(int a=1;a<=1000;a++)
    {
      int a2=a*a;
      for(int b=a;b<=1000;b++)
      {
        int b2=b*b;
        int squareRoot=isSquare(a2+b2);
        if (squareRoot!=-1)
        {
          int p=a+b+squareRoot;
          if (p<=PMAX) nbSolutions[p]++;
        }
      }
    }
    // Compute max
    int max=0;
    int pmax=0;
    for(int i=1;i<=PMAX;i++)
    {
      if (max<nbSolutions[i])
      {
        max=nbSolutions[i];
        pmax=i;
      }
    }
    long now2=System.currentTimeMillis();
    System.out.println("result="+pmax+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP39 m=new MainP39();
    m.doIt();
  }
}
