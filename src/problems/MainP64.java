package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Solved 16.01.2011.
 * @author DAM
 */
public class MainP64
{
  private MainP64()
  {
    // Nothing to do !
  }

  private int evalN(int n)
  {
    List<Integer> la=computeContinuedFraction(n);
    return la.size()-1;
  }
  
  /**
   * Compute the items in the continued fraction of the
   * square root of n.
   * @param n Number to use.
   * @return A list of numbers.
   */
  public static List<Integer> computeContinuedFraction(int n)
  {
    List<Integer> la=new ArrayList<Integer>();
    //List<Integer> lalpha=new ArrayList<Integer>();
    //List<Integer> lbeta=new ArrayList<Integer>();
    double root=Math.sqrt(n);
    int a=(int)(root);
    la.add(Integer.valueOf(a));
    // Ignore squares
    if (a*a==n) return la;
    int alpha=a;
    int alpha0=alpha;
    int beta=1;
    int beta0=beta;
    int cycleSize=1;
    while(true)
    {
      // compute next value for a,alpha,beta
      int d=(n-alpha*alpha);
      int nextA=(int)(((root+alpha)*beta)/d);
      int nextBeta=d/beta;
      int nextAlpha=(nextA*d)/beta-alpha;
      a=nextA;
      alpha=nextAlpha;
      beta=nextBeta;
      la.add(Integer.valueOf(a));
      //lalpha.add(Integer.valueOf(alpha));
      //lbeta.add(Integer.valueOf(beta));
      if ((nextAlpha==alpha0) && (nextBeta==beta0))
      {
        break;
      }
      cycleSize++;
    }
    //System.out.println("n="+n+", cycle size="+cycleSize+", nbDigits="+la.size()+", digits="+la);
    return la;
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    int n=1;
    int nbOdd=0;
    for(n=1;n<=10000;n++)
    {
      int cycleSize=evalN(n);
      if (cycleSize%2==1) nbOdd++;
    }
    long now2=System.currentTimeMillis();
    System.out.println("result="+nbOdd+" ("+(now2-now)+"ms).");
  }
  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP64 m=new MainP64();
    m.doIt();
  }
}
