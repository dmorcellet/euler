package problems.p101_150;

/**
 * Solved 11.03.2011.
 * @author DAM
 */
public class MainP112
{
  private MainP112()
  {
    // Nothing to do !
  }

  private boolean isBouncy(int n) {
    if (n<100) return false;
    Boolean trend=null;
    
    int digit=n%10;
    n/=10;
    while (n>0)
    {
      int nextDigit=n%10;
      if (trend==null)
      {
        if (nextDigit<digit) trend=Boolean.FALSE;
        else if (nextDigit>digit) trend=Boolean.TRUE;
      }
      else
      {
        if (trend!=null)
        {
          if ((nextDigit<digit) && (trend.booleanValue())) return true;
          if ((nextDigit>digit) && (!trend.booleanValue())) return true;
        }
      }
      n/=10;
      digit=nextDigit;
    }
    return false;
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    int nbBouncy=0;
    int nbNotBouncy=0;
    int i=1;
    while(true)
    {
      if (isBouncy(i))
      {
        nbBouncy++;
        //System.out.println("Bouncy: "+i);
      }
      else
      {
        nbNotBouncy++;
        //System.out.println("Not bouncy: "+i);
      }
      if (nbBouncy==nbNotBouncy*99)
      {
        //System.out.println(i);
        break;
      }
      i++;
    }
    //System.out.println("Nb bouncy="+nbBouncy+", nb not bouncy="+nbNotBouncy);
    long now2=System.currentTimeMillis();
    System.out.println("result="+i+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
	MainP112 m=new MainP112();
    m.doIt();
  }
}
