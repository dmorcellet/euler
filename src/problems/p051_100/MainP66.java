package problems.p051_100;

import java.math.BigInteger;
import java.util.List;

/**
 * Solved 17.01.2011.
 * @author DAM
 */
public class MainP66
{
  private MainP66()
  {
    // Nothing to do !
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    long bestD=-1;
    BigInteger bigOne=BigInteger.valueOf(1);
    BigInteger maxx=bigOne;
    for(int d=1;d<=1000;d++)
    {
      // ignore square values
      long root=(long)Math.sqrt(d);
      if (root*root==d) continue;
      BigInteger bigD=BigInteger.valueOf(d);

      List<Integer> terms=MainP64.computeContinuedFraction(d);
      BigInteger bigX=null,bigY=null;
      int size=terms.size();
      //System.out.println(terms);
      for(int i=0;i<1;i++) for(int j=1;j<size;j++) terms.add(terms.get(j));
      //System.out.println(terms);
      size=terms.size();
      for(int i=1;i<=size;i++)
      {
        BigInteger[] fraction=MainP65.computeContinuedFraction(terms);
        //System.out.println(fraction[0]+" / "+fraction[1]);
        BigInteger x2=fraction[0].multiply(fraction[0]);
        BigInteger y2=fraction[1].multiply(fraction[1]);
        BigInteger tmp=y2.multiply(bigD).add(bigOne);
        if (x2.equals(tmp))
        {
          bigX=fraction[0];
          bigY=fraction[1];
        }
        terms.remove(terms.size()-1);
      }

      if ((bigX==null) || (bigY==null))
      {
        System.out.println("No solution for d="+d);
        /*
        long x=-1;
        long y;
        for(y=1;y<=1000;y++)
        {
          long toTest=1+d*y*y;
          long rootToTest=(long)Math.sqrt(toTest);
          if (rootToTest*rootToTest==toTest)
          {
            x=rootToTest;
            System.out.println("Found x="+x+" and y="+y+" for d="+d);
            break;
          }
        }
        */
      }
      else
      {
        //System.out.println("Found x="+bigX+" and y="+bigY+" for d="+d);
        if (bigX.compareTo(maxx)>0)
        {
          bestD=d;
          maxx=bigX;
        }
      }
    }
    
    long now2=System.currentTimeMillis();
    System.out.println("result="+bestD+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP66 m=new MainP66();
    m.doIt();
  }
}
