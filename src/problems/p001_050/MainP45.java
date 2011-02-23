package problems.p001_050;

/**
 * Solved 02.01.2011.
 * @author DAM
 */
public class MainP45
{
  private MainP45()
  {
    // Nothing to do !
  }

  private long isSquare(long d)
  {
    long squareRoot=(long)(Math.sqrt(d));
    if (d==squareRoot*squareRoot) return squareRoot;
    return 0;
  }

  private long isPenta(long a)
  {
    long d=1+24*a;
    long square=isSquare(d);
    if (square!=0)
    {
      long n=1+square;
      if (n%6==0)
      {
        return n/6;
      }
    }
    return 0;
  }

  private long isTriangle(long a)
  {
    long d=1+8*a;
    long square=isSquare(d);
    if (square!=0)
    {
      long n=square-1;
      if (n%2==0)
      {
        return n/2;
      }
    }
    return 0;
  }

  private long isHexa(long a)
  {
    long d=1+8*a;
    long square=isSquare(d);
    if (square!=0)
    {
      long n=1+square;
      if (n%4==0)
      {
        return n/4;
      }
    }
    return 0;
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    // Non optimal but... works
    long n=0;
    for(long i=40756;i<10000000000L;i++)
    {
      /*
      long t=isTriangle(i);
      long p=isPenta(i);
      long h=isHexa(i);
      */
      if ((isTriangle(i)!=0) && (isPenta(i)!=0) && (isHexa(i)!=0))
      {
        n=i;
        break;
      }
    }
    long now2=System.currentTimeMillis();
    System.out.println("result="+n+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP45 m=new MainP45();
    m.doIt();
  }
}
