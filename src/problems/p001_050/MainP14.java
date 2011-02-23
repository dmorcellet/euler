package problems.p001_050;

/**
 * Solved 22.11.2010.
 * @author DAM
 */
public class MainP14
{
  private static final int CACHE_LENGTH=10000; 
  private int[] _lengths;

  private MainP14()
  {
    _lengths=new int[CACHE_LENGTH];
    _lengths[1]=1;
    //for(int i=0;i<CACHE_LENGTH;i++) _lengths=0;
  }

  private long computeNext(long n)
  {
    if (n%2==0) return n/2;
    return 3*n+1;
  }

  /*
  private void showSequence(int startNumber)
  {
    long n=startNumber;
    int length=1;
    while (true)
    {
      if (length>0) System.out.print(' ');
      System.out.print(n);
      if (n==1)
      {
        break;
      }
      n=computeNext(n);
      length++;
    }
    System.out.println(" ("+length+")");
  }
  */

  private int computeSequenceLength(long startNumber)
  {
    long n=startNumber;
    int currentLength=0;
    int length=0;
    while (true)
    {
      if ((n<CACHE_LENGTH) && (_lengths[(int)n]!=0))
      {
        length=currentLength+_lengths[(int)n];
        break;
      }
      n=computeNext(n);
      currentLength++;
    }
    if (startNumber<CACHE_LENGTH)
    {
      _lengths[(int)startNumber]=length;
    }
    return length;
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    int maxLength=0;
    long n=0;
    for(long i=1;i<1000000;i++)
    {
      int length=computeSequenceLength(i);
      if (length>maxLength)
      {
        maxLength=length;
        n=i;
      }
    }
    long now2=System.currentTimeMillis();
    //System.out.println("start="+n+" => length="+maxLength+" ("+(now2-now)+"ms).");
    System.out.println("result="+n+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP14 m=new MainP14();
    m.doIt();
  }
}
