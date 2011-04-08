package problems.p101_150;

/**
 * @author DAM
 */
public class MainP120
{
  private MainP120()
  {
    // Nothing to do !
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    long sumRMax=0;
    for(int a=3;a<=1000;a++)
    {
      //System.out.println("a="+a);
      int a2=a*a;
      //boolean[] foundr=new boolean[a2+1]; 
      int p=1, r=2, rmax=2;
      int n=0;//,nmax=0;
      while(n<10000)
      {
        //foundr[r]=true;
        r=((a-1)*r+2*p)%a2;
        p=((a+1)*p)%a2;
        n++;
        if (r>rmax)
        {
          //System.out.println("\trmax="+r+", n="+n);
          rmax=r;
          //nmax=n;
        }
        //if (foundr[r]) break;
      }
      sumRMax+=rmax;
      //System.out.println("a="+a+", rmax="+rmax+", nmax="+nmax);
    }
    long now2=System.currentTimeMillis();
    System.out.println("result="+sumRMax+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP120 m=new MainP120();
    m.doIt();
  }
}
