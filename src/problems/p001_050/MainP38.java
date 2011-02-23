package problems.p001_050;

/**
 * Solved 28.12.2010.
 * @author DAM
 */
public class MainP38
{
  private boolean[] _digits; 

  private MainP38()
  {
    _digits=new boolean[11];
  }

  private int nbDigitsBase10(int n)
  {
    int max=10;
    int nb=1;
    while (nb<12)
    {
      if (n<max) return nb;
      max=max*10;
      nb++;
    }
    return 12;
  }

  private int firstDigit(int n)
  {
    int nb=1;
    int digit=n;
    while (nb<12)
    {
      if (n<10)
      {
        digit=n;
        break;
      }
      n=n/10;
      nb++;
    }
    return digit;
  }

  private int check(int n, int nbProducts)
  {
    int value=0;
    for(int i=1;i<=nbProducts;i++)
    {
      int product=n*i;
      int nbDigits=nbDigitsBase10(product);
      int base=1;
      for(int j=0;j<nbDigits;j++) base*=10;
      value=value*base+product;
    }
    //System.out.println("Value="+value);
    for(int i=1;i<=10;i++) _digits[i]=false;
    boolean ok=true;
    int tmp=value;
    while (tmp>0)
    {
      int digit=tmp%10;
      if (_digits[digit])
      {
        ok=false;
        break;
      }
      _digits[digit]=true;
      tmp/=10;
    }
    if (ok) return value;
    return 0;
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    int max=0;
    for(int i=1;i<=10000000;i++)
    {
      // Check that first digit is a 9
      int firstDigit=firstDigit(i);
      if (firstDigit!=9) continue;    
      // Check number of digits
      int nbDigits=0;
      int index=1;
      while (true)
      {
        int product=i*index;
        nbDigits+=nbDigitsBase10(product);
        if (nbDigits>=9) break;
        index++;
      }
      if (nbDigits!=9) continue;
      // Check all digits
      //System.out.println("Check i="+i+", index="+index);
      int value=check(i,index);
      if (value>max)
      {
        //System.out.println("Found max="+max);
        max=value;
      }
    }
    long now2=System.currentTimeMillis();
    System.out.println("result="+max+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP38 m=new MainP38();
    m.doIt();
  }
}
