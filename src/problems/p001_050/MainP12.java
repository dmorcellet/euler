package problems.p001_050;

import problems.primes.PrimeTester;
import problems.primes.SqrtPrimeTester;

/**
 * @author DAM
 */
public class MainP12
{
  private final int[] PRIMES={2,3,5,7,11,13,17,19,23,29,31,37,41,43};
  private final int NB_PRIMES=PRIMES.length;
  private final int NB=100;
  private int[][] _decs=new int[NB][];
  private PrimeTester _primeTester;
  
  private MainP12()
  {
    _primeTester=new SqrtPrimeTester();
  }

  private void computeDecomposition(int n)
  {
    _decs[n]=new int[NB_PRIMES];
    int tmp=n;
    for(int i=0;i<NB_PRIMES;i++)
    {
      while(tmp%PRIMES[i]==0)
      {
        _decs[n][i]++;
        tmp=tmp/PRIMES[i];
      }
    }
    //System.out.println("N="+n+":");
    //for(int i=0;i<NB_PRIMES;i++) System.out.print(" "+_decs[n][i]);
    //System.out.println("");
  }

  private void computeDecompositions()
  {
    for(int i=2;i<NB;i++)
    {
      computeDecomposition(i);
    }
  }

  /*
  private void displayDivisors(long n)
  {
    int nb=0;
    System.out.print(n);
    System.out.print(" : ");
    for(long i=1;i<=n;i++)
    {
      if (n%i==0)
      {
        System.out.print(' ');
        System.out.print(i);
        nb++;
      }
    }
    System.out.println(" ("+nb+")");
  }
  */

  private int findNbDivisors(long n)
  {
    int nb=0;
    long tmp=n;
    int i=2;
    int factors=1;
    int square=(int)Math.floor(Math.sqrt(n));
    while ((tmp>1) && (i<=square))
    {
      if (_primeTester.isPrime(i))
      {
        int nbTimes=0;
        while (tmp%i==0)
        {
          nb++;
          nbTimes++;
          tmp=tmp/i;
        }
        if (nbTimes>0)
        {
          factors=factors*(nbTimes+1);
        }
      }
      i++;
    }
    if (nb==0) return 2;
    return factors; 
  }

  /*
  private int findNbDivisors2(long n)
  {
    int nb=0;
    for(long i=1;i<=n;i++)
    {
      if (n%i==0) nb++;
    }
    return nb;
  }

  private long fact(int n)
  {
    long r=1;
    for(int i=1;i<=n;i++) r=r*i;
    return r;
  }
  */

  private void doIt()
  {
    long now=System.currentTimeMillis();
    //for(int i=0;i<100;i++) System.out.println("fact("+i+")="+fact(i));
    //for(int i=2;i<=31;i++) displayDivisors(i);
    computeDecompositions();
    //long n=223092870;
    //displayDivisors(n);
    //System.out.println("Racine de n: "+Math.floor(Math.sqrt(2*n)));
    
    //displayDivisors(500);
    int nbMax=0;
    long n=1000;
    long tn=(n*(n-1))/2;
    while(true)
    {
      tn=tn+n;
      n++;
      int nb=findNbDivisors(tn);
      if (nb>nbMax)
      {
        //System.out.println("T(n)="+tn+", n="+n+", nb="+nb);
        nbMax=nb;
      }
      if (nb>500)
      {
        //System.out.println("n="+tn+", nb="+nb);
        break;
      }
    }
    long now2=System.currentTimeMillis();
    System.out.println("result="+tn+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP12 m=new MainP12();
    m.doIt();
  }
}
