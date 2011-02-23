package problems.p001_050;

import java.util.HashSet;

/**
 * Solved 19.12.2010.
 * @author DAM
 */
public class MainP32
{
  private MainP32()
  {
    // Nothing to do !
  }

  private int nbDigits(int n)
  {
    if (n<10) return 1;
    if (n<100) return 2;
    if (n<1000) return 3;
    if (n<10000) return 4;
    if (n<100000) return 5;
    if (n<1000000) return 6;
    if (n<10000000) return 7;
    if (n<100000000) return 8;
    return 9;
  }

  private boolean[] digits;
  private boolean isPandigital(int a, int b)
  {
    int product=a*b;
    int nbDigits=nbDigits(a)+nbDigits(b)+nbDigits(product);
    if (nbDigits!=9) return false;
    for(int i=0;i<10;i++) digits[i]=false;
    if (!fitDigits(a)) return false;
    if (!fitDigits(b)) return false;
    if (!fitDigits(product)) return false;
    return true;
  }

  private boolean fitDigits(int value)
  {
    while (value>0)
    {
      int digit=value%10;
      if (digit==0) return false;
      if (digits[digit-1]) return false;
      digits[digit-1]=true;
      value/=10;
    }
    return true;
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    digits=new boolean[10];
    HashSet<Integer> products=new HashSet<Integer>();
    for(int a=1;a<=10000;a++)
    {
      int nbDigitsA=nbDigits(a);
      int bmax=(int)Math.pow(10,6-nbDigitsA);
      //System.out.println(bmax);
      for(int b=1;b<=bmax;b++)
      {
        if (isPandigital(a,b))
        {
          //System.out.println("a="+a+", b="+b);
          products.add(Integer.valueOf(a*b));
        }
      }
    }
    //System.out.println(products);
    //int nb=products.size();
    int sum=0;
    for(Integer product : products)
    {
      sum+=product.intValue();
    }
    long now2=System.currentTimeMillis();
    System.out.println("result="+sum+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP32 m=new MainP32();
    m.doIt();
  }
}
