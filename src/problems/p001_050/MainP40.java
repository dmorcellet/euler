package problems.p001_050;

import problems.tools.Digits;

/**
 * Solved 28.12.2010.
 * @author DAM
 */
public class MainP40
{
  private static final int NB_GENERATIONS=7;
  private int[] _min;
  private int[] _max;
  private int[] _size;
  private int[] _sizeNbDigits;

  private MainP40()
  {
    // Nothing to do !
  }

  private void populateGeneration(int n)
  {
    int min=1;
    int max=10;
    for(int i=1;i<n;i++)
    {
      min*=10;
      max*=10;
    }
    _min[n]=min;
    _max[n]=max-1;
    int nbNumbers=max-min;
    _size[n]=nbNumbers;
    int size=nbNumbers*n;
    _sizeNbDigits[n]=size;
  }

  private int getDigitInNumber(int n, int digitIndex)
  {
    int nbDigits=Digits.nbDigitsBase10(n);
    int nbDiv=nbDigits-digitIndex-1;
    for(int i=0;i<nbDiv;i++) n/=10;
    return n%10;
  }

  private int d(int n)
  {
    // Find generation
    int sizeLeft=n;
    int generation=1;
    while (true)
    {
      if (sizeLeft>_sizeNbDigits[generation])
      {
        sizeLeft-=_sizeNbDigits[generation];
      }
      else
      {
        break;
      }
      generation++;
    }
    int nbNumbersInGeneration=(sizeLeft-1)/generation;
    int number=_min[generation]+nbNumbersInGeneration;
    int digitInNumber=(sizeLeft-1)%generation;
    //System.out.println("d(n="+n+"): generation="+generation+", number="+number+", digit="+digitInNumber);
    int d=getDigitInNumber(number,digitInNumber);
    return d;
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    _min=new int[NB_GENERATIONS+1];
    _max=new int[NB_GENERATIONS+1];
    _size=new int[NB_GENERATIONS+1];
    _sizeNbDigits=new int[NB_GENERATIONS+1];
    for(int i=1;i<=NB_GENERATIONS;i++)
    {
      populateGeneration(i);
    }
    int index=1;
    int value=1;
    for(int i=0;i<7;i++)
    {
      int d=d(index);
      index*=10;
      //System.out.println(d);
      value*=d;
    }
    long now2=System.currentTimeMillis();
    System.out.println("result="+value+" ("+(now2-now)+"ms).");
  }

  /*
  private void doIt2()
  {
    long now=System.currentTimeMillis();
    StringBuilder sb=new StringBuilder();
    int max=1000000;
    for(int i=1;i<=max;i++)
    {
      sb.append(String.valueOf(i));
    }
    String s=sb.toString();
    sb=null;
    int index=1;
    int value=1;
    for(int i=0;i<7;i++)
    {
      int d=(s.charAt(index-1)-'0');
      index*=10;
      //System.out.println(d);
      value*=d;
    }
    long now2=System.currentTimeMillis();
    System.out.println("result="+value+" ("+(now2-now)+"ms).");
  }
  */

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP40 m=new MainP40();
    m.doIt();
    //m.doIt2();
  }
}
