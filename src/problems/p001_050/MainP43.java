package problems.p001_050;

import java.util.ArrayList;
import java.util.List;

/**
 * Solved 28.12.2010.
 * @author DAM
 */
public class MainP43
{
  private long _total;

  private MainP43()
  {
    _total=0;
  }

  /*
  private String showDigits(boolean[] digits)
  {
    StringBuilder sb=new StringBuilder();
    for(int i=0;i<10;i++)
    {
      if (digits[i]) sb.append((char)('0'+i)); else sb.append(' ');
    }
    return sb.toString();
  }
  */

  private boolean[] fillDigits(long n,int nbDigits)
  {
    boolean[] digits=new boolean[10];
    while (nbDigits>0)
    {
      int digit=(int)(n%10);
      if (digits[digit]) return null;
      digits[digit]=true;
      n/=10;
      nbDigits--;
    }
    return digits;
  }

  private boolean[] mergeDigits(boolean[] n1, boolean[] n2)
  {
    if ((n1==null) || (n2==null)) return null;
    boolean[] digits=new boolean[10];
    for(int i=0;i<10;i++)
    {
      if (n1[i]&&n2[i]) return null;
      digits[i]=n1[i]|n2[i];
    }
    return digits;
  }

  private int[] divisors={17,13,11,7,5,3,2};
  private long[] base={1,1000,10000,100000,1000000,10000000,100000000,1000000000};

  private int getMissingDigit(boolean[] digits)
  {
    for(int i=0;i<10;i++)
    {
      if (!digits[i]) return i;
    }
    return -1;
  }

  private void test(int level, int last2Digits, boolean[] sourceDigits, long value, List<Integer> digits)
  {
    int divisor=divisors[level];
    for(int k=1;k<1000;k++)
    {
      if ((k%divisor==0) && (last2Digits==k%100))
      {
        boolean[] newDigits=mergeDigits(sourceDigits,fillDigits(k/100,1));
        if (newDigits!=null)
        {
          digits.add(Integer.valueOf(k/100));
          long newValue=((k/100)*base[level])+value;
          if (level==6)
          {
            int missingDigit=getMissingDigit(newDigits);
            newValue+=(missingDigit*base[7]);
            _total+=newValue;
            //System.out.println("Got value: "+newValue+" digits="+digits);
          }
          else
          {
            test(level+1,k/10,newDigits,newValue,digits);
            //System.out.println("digits="+showDigits(newDigits));
          }
          digits.remove(digits.size()-1);
        }
      }
    }
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    ArrayList<Integer> digits=new ArrayList<Integer>();
    for(int i=1;i<1000;i++)
    {
      if (i%17==0)
      {
        //System.out.println("i="+i);
        boolean[] d1=fillDigits(i,3);
        if (d1!=null)
        {
          digits.add(Integer.valueOf(i));
          test(1,i/10,d1,i,digits);
          digits.clear();
        }
      }
    }
    long now2=System.currentTimeMillis();
    System.out.println("result="+_total+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP43 m=new MainP43();
    m.doIt();
  }
}
