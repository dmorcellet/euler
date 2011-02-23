package problems.p051_100;

import java.util.ArrayList;
import java.util.List;

import problems.primes.Erathostenes;
import problems.tools.Digits;

/**
 * Solved 04.01.2011.
 * @author DAM
 */
public class MainP51
{
  private static final int MAX=1000000;
  private MainP51()
  {
    // Nothing to do !
  }

  private int testPrime(Erathostenes e, int nbDigits, final int base, int toAdd, boolean verbose)
  {
    int nbFails=0;
    int tmpBase=base;
    int good=-1;
    //System.out.println("Test: "+base+", digits="+toAdd);
    for(int i=0;i<10;i++)
    {
      if ((Digits.nbDigitsBase10(tmpBase)!=nbDigits) || (!e.isPrime(tmpBase)))
      {
        nbFails++;
        if (nbFails==3) return -1;
      }
      else
      {
        if (good==-1) good=tmpBase;
        if (verbose)
        {
          System.out.println("OK for : "+tmpBase);
        }
      }
      tmpBase+=toAdd;
    }
    return good;
  }

  private int testCombinaison(Erathostenes e, int nbDigits, final int prime, int combinaison, boolean verbose)
  {
    int base=0;
    int toAdd=0;
    int factor=1;
    int tmpPrime=prime;
    for(int i=0;i<nbDigits;i++)
    {
      if (combinaison%2!=0)
      {
        toAdd+=factor;
      }
      else
      {
        int digit=tmpPrime%10;
        base+=factor*digit;
      }
      combinaison/=2;
      tmpPrime/=10;
      factor*=10;
    }
    return testPrime(e,nbDigits,base,toAdd,verbose);
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    Erathostenes e=new Erathostenes(MAX);
    List<Integer> primes=new ArrayList<Integer>();
    for(int i=0;i<MAX;i++)
    {
      if (e.isPrime(i))
      {
        primes.add(Integer.valueOf(i));
      }
    }
    //int nbPrimes=1000000;//primes.size();
    int nbPrimes=primes.size();
    int result=-1;
    for(int i=0;i<nbPrimes;i++)
    //for(int prime=0;prime<nbPrimes;prime++)
    {
      int prime=primes.get(i).intValue();
      int nbDigits=Digits.nbDigitsBase10(prime);
      // test all combinaisons
      int nbCombinaisons=1;
      for(int n=0;n<nbDigits;n++) nbCombinaisons*=2;
      for(int combinaison=1;combinaison<nbCombinaisons;combinaison++)
      {
        if (testCombinaison(e,nbDigits,prime,combinaison,false)!=-1)
        {
          System.out.println("Got prime : "+prime+", with combinaison: "+combinaison);
          result=testCombinaison(e,nbDigits,prime,combinaison,true);
          i=nbPrimes; // break for parent loop
          break;
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
    MainP51 m=new MainP51();
    m.doIt();
  }
}
