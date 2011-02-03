package problems;

/**
 * @author DAM
 */
public class MainP2
{
  private static final int MAX=4000000;

  private int nextFib(int n1, int n2)
  {
    return n1+n2;
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    int sum=0;
    int n1=1;
    int n2=2;
    int tmp;
    int iter=0;
    while (n1<MAX)
    {
      if (n2%2==0)
      {
        //System.out.println("Added "+n2);
        sum+=n2;
      }
      tmp=n2;
      n2=nextFib(n1,n2);
      //System.out.println("Got: "+n2);
      n1=tmp;
      iter++;
    }
    //System.out.println("Iter="+iter+", n1="+n1);
    long now2=System.currentTimeMillis();
    System.out.println("result="+sum+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP2 m=new MainP2();
    m.doIt();
  }
}
