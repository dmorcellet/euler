package problems;

import java.util.HashSet;
import java.util.List;

import problems.primes.PrimeDecomposition;

/**
 * Solved 23.02.2011.
 * @author DAM
 */
public class MainP95
{
  private static final int MAX=1000000;
  private PrimeDecomposition _decomposer;
  private int[] _cache;
  
  private MainP95()
  {
    // Nothing to do !
  }

  private int evaluateProperDivisorsSum(int n)
  {
    //n=product(k,divK^aK)
    //=> sum=product(k,somme(i:0->aK,divK^i))
    List<Integer> divisors=_decomposer.decompose(n);
    if (divisors.size()==1) return 1;
    int p=1;
    int previousD=0;
    int localP=1;
    int divPower=1;
    for(Integer div : divisors)
    {
      int d=div.intValue();
      if (d!=previousD)
      {
        divPower=d;
        p*=localP;
        localP=1+d;
      }
      else
      {
        divPower*=d;
        localP+=divPower;
      }
      previousD=d;
    }
    p*=localP;
    return p-n;
  }

  private int evalChainLength(int n)
  {
    int nb=0;
    int divisorsSum=n;
    //int[] items=new int[1000];
    HashSet<Integer> items=new HashSet<Integer>();
    while(true)
    {
      if (divisorsSum==1) return 0;
      if (divisorsSum>MAX) return 0;
      int newDivisorsSum;
      if (_cache[divisorsSum]==0)
      {
        newDivisorsSum=evaluateProperDivisorsSum(divisorsSum);
        _cache[divisorsSum]=newDivisorsSum;
      }
      else
      {
        newDivisorsSum=_cache[divisorsSum];
      }
      /*
      for(int i=0;i<nb;i++)
      {
        if (items[i]==newDivisorsSum) return 0;
      }
      */
      if (items.contains(Integer.valueOf(newDivisorsSum))) return 0;
      //if (newDivisorsSum==divisorsSum) return 0;
      divisorsSum=newDivisorsSum;
      items.add(Integer.valueOf(divisorsSum));
      //items[nb]=divisorsSum;
      nb++;
      if (divisorsSum==n) break;
    }
    return nb;
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    _decomposer=new PrimeDecomposition(MAX+1);
    _cache=new int[MAX+1];
    int goodI=-1;
    int maxLength=0;
    for(int i=2;i<=MAX;i++)
    {
      //System.out.println("i="+i);
      int length=evalChainLength(i);
      if (length>maxLength)
      {
        goodI=i;
        maxLength=length;
        //System.out.println("i="+goodI+", length="+maxLength);
      }
    }
    long now2=System.currentTimeMillis();
    System.out.println("result="+goodI+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP95 m=new MainP95();
    m.doIt();
  }
}
