package problems.p001_050;

import problems.primes.Erathostenes;

/**
 * Solved 26.12.2010.
 * @author DAM
 */
public class MainP37
{
  private static final int NB_PRIMES=11;
  private static final int MAX_PRIME=1000000;

  private MainP37()
  {
    // Nothing to do !
  }
  
  private boolean testRightToLeft(Erathostenes e, int n)
  {
    boolean ok=false;
    int tmp=n;
    while(true)
    {
      tmp=tmp/10;
      if (tmp==0)
      {
        ok=true;
        break;
      }
      if (!e.isPrime(tmp))
      {
        ok=false;
        break;
      }
    }
    return ok;
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

  private boolean testLeftToRight(Erathostenes e, int n)
  {
    boolean ok=true;
    int nbDigits=nbDigitsBase10(n);
    for(int j=1;j<nbDigits;j++)
    {
      int tmp=n;
      int value=0;
      int base=1;
      for(int i=0;i<j;i++)
      {
        value+=base*(tmp%10);
        base*=10;
        tmp/=10;
      }
      if (!e.isPrime(value))
      {
        ok=false;
        break;
      }
    }
    return ok;
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    int i=12;
    int sum=0;
    Erathostenes e=new Erathostenes(MAX_PRIME);
    int nbFound=0;
    while ((nbFound<NB_PRIMES) && (i<MAX_PRIME))
    {
      if ((e.isPrime(i)) && (testLeftToRight(e,i)) && (testRightToLeft(e,i)))
      {
        //System.out.println("Found i="+i);
        sum+=i;
        nbFound++;
      }
      i++;
    }
    //System.out.println("Nb found="+nbFound);
    long now2=System.currentTimeMillis();
    System.out.println("result="+sum+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP37 m=new MainP37();
    m.doIt();
  }
}
