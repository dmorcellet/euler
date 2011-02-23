package problems.p051_100;

import java.util.List;

import problems.primes.PrimeDecomposition;

/**
 * Solved 24.01.2011.
 * @author DAM
 */
public class MainP75
{
  private static final int LMAX=1500000;
  //private static int nbTests=0;
  //private static int nbPrimarySquares=0;

  private MainP75()
  {
    // Nothing to do !
  }

  private boolean relativelyPrime(PrimeDecomposition dec, int m, int n)
  {
    boolean ret=true;
    List<Integer> decM=dec.decompose(m);
    List<Integer> decN=dec.decompose(n);
    int nb=decN.size();
    for(int i=0;i<nb;i++)
    {
      if (decM.contains(decN.get(i)))
      {
        ret=false;
        break;
      }
    }
    //nbTests++;
    return ret;
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    int[] nbL=new int[LMAX+1];
    int mMax=(int)Math.sqrt(LMAX);
    PrimeDecomposition dec=new PrimeDecomposition(mMax+1);
    // m odd, n even
    // Euclid's formula: a=abs(m2-n2), b=2mn, c=m2+n2
    for(int m=1;m<=mMax;m+=2)
    {
      int nMax=mMax-m;
      int m2=m*m;
      for(int n=2;n<=nMax;n+=2)
      {
        if (relativelyPrime(dec,m,n))
        {
          int n2=n*n;
          int diffSquares=m2-n2;
          int l=((diffSquares>0)?(diffSquares):-diffSquares)+2*m*n+m2+n2;
          //nbPrimarySquares++;
          int lk=l;
          while (lk<=LMAX)
          {
            nbL[lk]++;
            lk+=l;
          }
        }
      }
    }
    int nb=0;
    for(int i=1;i<=LMAX;i++) if (nbL[i]==1) nb++;
    long now2=System.currentTimeMillis();
    //System.out.println("Nb tests="+nbTests);
    //System.out.println("Nb primary squares="+nbPrimarySquares);
    System.out.println("result="+nb+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP75 m=new MainP75();
    m.doIt();
  }
}
