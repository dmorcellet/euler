package problems;

import java.math.BigInteger;

/**
 * Solved 05.01.2011.
 * @author DAM
 */
public class MainP53
{
  private MainP53()
  {
    // Nothing to do !
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    int nb=0;
    BigInteger treshold=BigInteger.valueOf(1000000);
    //long max=0;
    for(int n=1;n<=100;n++)
    {
    	// c(r=1;n)=n
    	//BigInteger cn1=BigInteger.valueOf(n);
    	BigInteger cnr=BigInteger.valueOf(n);
    	for(int r=2;r<=n;r++)
    	{
    		// divide by r and multiply by n-r
    		cnr=cnr.multiply(BigInteger.valueOf(n-r+1));
    		cnr=cnr.divide(BigInteger.valueOf(r));
    		if (cnr.compareTo(treshold)>0)
    		{
    			//System.out.println("C(n="+n+",r="+r+")="+cnr);
    			nb++;
    		}
    		//if (cnr>max) max=cnr;
    	}
    }
    long now2=System.currentTimeMillis();
    System.out.println("result="+nb+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP53 m=new MainP53();
    m.doIt();
  }
}
