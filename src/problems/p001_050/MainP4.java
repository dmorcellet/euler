package problems.p001_050;

/**
 * @author DAM
 */
public class MainP4
{
  private int _maxP=0;
  private void doIt()
  {
    long now=System.currentTimeMillis();
    for(int i=999;i>=100;i--)
    {
      for(int j=100;j<=999;j++)
      {
        if (j<=i)
        {
          int p=i*j;
          if ((p>_maxP) && (isPalindromic(p)))
          {
            _maxP=p;
            //System.out.println("MaxP="+_maxP+" : "+i+"*"+j);
          }
        }
      }
    }
    long now2=System.currentTimeMillis();
    System.out.println("result="+_maxP+" ("+(now2-now)+"ms).");
  }

  private int getNbDigits(int n)
  {
    if (n<10) return 1;
    if (n<100) return 2;
    if (n<1000) return 3;
    if (n<10000) return 4;
    if (n<100000) return 5;
    if (n<1000000) return 6;
    if (n<10000000) return 7;
    return 0;
  }

  private int getDigit(int n, int index)
  {
    for(int i=0;i<index;i++) n=n/10;
    return n%10;
  }

  private boolean isPalindromic(int n)
  {
    int nbDigits=getNbDigits(n);
    for(int i=0;i<nbDigits/2;i++)
    {
      int d1=getDigit(n,i);
      int d2=getDigit(n,nbDigits-i-1);
      if (d1!=d2)
      {
        return false;
      }
    }
    return true;
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP4 m=new MainP4();
    m.doIt();
  }
}
