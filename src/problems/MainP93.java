package problems;

/**
 * Solved 19.02.2011.
 * @author DAM
 */
public class MainP93
{
  private static final int NB_DIGITS=4;

  private MainP93()
  {
    // Nothing to do !
  }

  private void eval(double value, int nbDigitsUsed, int[] digits, int[] usedDigits, int[] results, String label)
  {
    if (nbDigitsUsed==0)
    {
      for(int i=0;i<NB_DIGITS;i++)
      {
        int v=digits[i];
        usedDigits[i]=1;
        eval(v,1,digits,usedDigits,results,String.valueOf(v));
        usedDigits[i]=0;
      }
    }
    else
    {
      for(int i=0;i<NB_DIGITS;i++)
      {
        if (usedDigits[i]==0)
        {
          int v=digits[i];
          nbDigitsUsed++;
          usedDigits[i]=1;
          // addition
          {
            double next=value+v;
            String newL='('+label+'+'+String.valueOf(v)+')';
            if (nbDigitsUsed==NB_DIGITS)
            {
              int intNext=(int)next;
              if (intNext==next)
              {
                //System.out.println(newL+" = "+next);
                results[intNext]++;
              }
            }
            else
            {
              eval(next,nbDigitsUsed,digits,usedDigits,results,newL);
            }
          }
          // substraction
          {
            double next=-1;
            String newL=null;
            if (value>=v)
            {
              next=value-v;
              newL='('+label+'-'+String.valueOf(v)+')';
            }
            else
            {
              next=v-value;
              newL='('+String.valueOf(v)+'-'+label+')';
            }
            if (next>=0)
            {
              if (nbDigitsUsed==NB_DIGITS)
              {
                int intNext=(int)next;
                if (intNext==next)
                {
                  //System.out.println(newL+" = "+next);
                  results[intNext]++;
                }
              }
              else
              {
                eval(next,nbDigitsUsed,digits,usedDigits,results,newL);
              }
            }
          }
          // multiplication
          {
            double next=value*v;
            String newL='('+label+'*'+String.valueOf(v)+')';
            if (nbDigitsUsed==NB_DIGITS)
            {
              int intNext=(int)next;
              if (intNext==next)
              {
                //System.out.println(newL+" = "+next);
                results[intNext]++;
              }
            }
            else
            {
              eval(next,nbDigitsUsed,digits,usedDigits,results,newL);
            }
          }
          // division
          {
            double next=value/v;
            String newL='('+label+'/'+String.valueOf(v)+')';
            if (nbDigitsUsed==NB_DIGITS)
            {
              int intNext=(int)next;
              if (intNext==next)
              {
                //System.out.println(newL+" = "+next);
                results[intNext]++;
              }
            }
            else
            {
              eval(next,nbDigitsUsed,digits,usedDigits,results,newL);
            }
          }
          // inverse division
          if (value>0)
          {
            double next=v/value;
            String newL='('+String.valueOf(v)+'/'+label+')';
            if (nbDigitsUsed==NB_DIGITS)
            {
              int intNext=(int)next;
              if (intNext==next)
              {
                //System.out.println(newL+" = "+next);
                results[intNext]++;
              }
            }
            else
            {
              eval(next,nbDigitsUsed,digits,usedDigits,results,newL);
            }
          }
          usedDigits[i]=0;
          nbDigitsUsed--;
        }
      }
    }
  }

  private int eval(int[] digits)
  {
    int[] results=new int[9*8*7*6+1];
    int[] digitsUsed=new int[NB_DIGITS];
    eval(0,0,digits,digitsUsed,results,null);
    int n=0;
    while(true)
    {
      if (results[n+1]>0) n++;
      else break;
    }
    return n;
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    int nmax=0;
    int result=0;
    int[] digits=new int[4];
    for(int d=4;d<=9;d++)
    {
      digits[3]=d;
      for(int c=3;c<d;c++)
      {
        digits[2]=c;
        for(int b=2;b<c;b++)
        {
          digits[1]=b;
          for(int a=1;a<b;a++)
          {
            digits[0]=a;
            int r=a*1000+b*100+c*10+d;
            //System.out.println("Eval "+r);
            int n=eval(digits);
            if (n>nmax)
            {
              nmax=n;
              result=r;
              //System.out.println("result="+result+", n="+n);
            }
          }
        }
      }
    }
    long now2=System.currentTimeMillis();
    System.out.println("result="+result+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP93 m=new MainP93();
    m.doIt();
  }
}
