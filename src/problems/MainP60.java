package problems;

import problems.primes.ErathostenesSieve;

/**
 * Solved 09.01.2011.
 * @author DAM
 */
public class MainP60
{
  //private static long nbChecks=0;
  private static int max = 100000000;
  private static int sq = (int)Math.round(Math.sqrt(max));
  private static boolean[] p = new boolean[max+1];

  private static void Primes() {
    //long now=System.currentTimeMillis();
    int i, j;
    p[1] = false;
    for (i=2; i<=max; i++) p[i]=true;
    for (i=2; i<=sq; i++)
       if (p[i])
          for (j=2*i; j<=max; j+=i)
             p[j] = false;
    //long now2=System.currentTimeMillis();
    //System.out.println("result="+" ("+(now2-now)+"ms).");
  }

  private MainP60()
  {
    // Nothing to do !
  }

  private static boolean testPair(long p1, long p2)
  {
    long i;
    for(i=1;i<p1;) i*=10;
    long p21=p2*i+p1;
    //nbChecks++;
    if (!p[(int)p21]) return false;
    for(i=1;i<p2;) i*=10;
    //nbChecks++;
    long p12=p1*i+p2;
    if (!p[(int)p12]) return false;
    return true;
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    long[] primes=new ErathostenesSieve().fill(8500);
    Primes();
    int nbPrimes=primes.length;
    long sum=Long.MAX_VALUE;
    for(int i1=0;i1<nbPrimes;i1++)
    {
      long p1=primes[i1];
      for(int i2=i1+1;i2<nbPrimes;i2++)
      {
        long p2=primes[i2];
        if (!testPair(p1,p2)) continue;
        //System.out.println("Found p1="+p1+", p2="+p2);
        for(int i3=i2+1;i3<nbPrimes;i3++)
        {
          long p3=primes[i3];
          if (!testPair(p1,p3)) continue;
          if (!testPair(p2,p3)) continue;
          //System.out.println("Found p1="+p1+", p2="+p2+", p3="+p3);
          for(int i4=i3+1;i4<nbPrimes;i4++)
          {
            long p4=primes[i4];
            long s=p1+p2+p3+p4;
            if (s>=792)
            {
              if (!testPair(p1,p4)) continue;
              if (!testPair(p2,p4)) continue;
              if (!testPair(p3,p4)) continue;
              //System.out.println("Found p1="+p1+", p2="+p2+", p3="+p3+", p4="+p4+", s="+s);
              for(int i5=i4+1;i5<nbPrimes;i5++)
              {
                long p5=primes[i5];
                s=p1+p2+p3+p4+p5;
                if ((s>792) && (s<sum))
                {
                  if (!testPair(p1,p5)) continue;
                  if (!testPair(p2,p5)) continue;
                  if (!testPair(p3,p5)) continue;
                  if (!testPair(p4,p5)) continue;
                  sum=s;
                  //System.out.println("Found p1="+p1+", p2="+p2+", p3="+p3+", p4="+p4+", p5="+p5+", sum="+sum);
                }
              }
            }
          }
        }
      }
    }
    long now2=System.currentTimeMillis();
    System.out.println("result="+sum+" ("+(now2-now)+"ms).");
    //System.out.println(nbChecks);
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP60 m=new MainP60();
    m.doIt();
  }
}
