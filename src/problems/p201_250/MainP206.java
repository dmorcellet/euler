package problems.p201_250;

/**
 * Solved 03.04.2011.
 * @author DAM
 */
public class MainP206
{
  private static final long MIN=10203040506070809L;
  private static final long MAX=19293949596979899L;

  private MainP206()
  {
    // Nothing to do !
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    long minRoot=(long)Math.sqrt(MIN);
    long maxRoot=(long)Math.sqrt(MAX)+1;
    // let N be the result, n be the square root of N
    // if N ends with 0, then n ends with 0
    // so N ends with 00
    //System.out.println(minRoot);
    //System.out.println(maxRoot);
    //System.out.println(maxRoot-minRoot);
    long min=minRoot,max=maxRoot;
    long n=-1;
    for(long test=min;test<=max;test++)
    {
      long square=test*test;
      if (square%10==9)
      {
        if (((square%1000)/100)==8)
        {
          if (((square%100000)/10000)==7)
          {
            if (((square%10000000)/1000000)==6)
            {
              if (((square%1000000000)/100000000)==5)
              {
                if (((square%100000000000L)/10000000000L)==4)
                {
                  if (((square%10000000000000L)/1000000000000L)==3)
                  {
                    if (((square%1000000000000000L)/100000000000000L)==2)
                    {
                      if (((square%100000000000000000L)/10000000000000000L)==1)
                      {
                        //System.out.println("Good test="+test+", square="+square);
                        n=test;
                        break;
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    String result="";
    if (n>0)
    {
      // add 0 to the result
      result=String.valueOf(n)+"0";
    }
    long now2=System.currentTimeMillis();
    System.out.println("result="+result+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP206 m=new MainP206();
    m.doIt();
  }
}
