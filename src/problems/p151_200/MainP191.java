package problems.p151_200;

/**
 * Solved 03.04.2011.
 * @author DAM
 */
public class MainP191
{
  private static final int MAX_DAYS=30; 
  private static final int MAX_NB_LATE=1; 
  private static final int MAX_NB_CONSECUTIVE_ABSENT=2; 

  private MainP191()
  {
    // Nothing to do !
  }

  private int evalNextDay(/*char[] data,*/ int index, int nbLate, int nbConsecutiveAbsent)
  {
    int ret=0;
    if (index<MAX_DAYS)
    {
      // late
      if (nbLate<MAX_NB_LATE)
      {
        //data[index]='L';
        ret+=evalNextDay(/*data,*/index+1,nbLate+1,0);
        //data[index]=' ';
      }
      // absent
      if (nbConsecutiveAbsent<MAX_NB_CONSECUTIVE_ABSENT)
      {
        //data[index]='A';
        ret+=evalNextDay(/*data,*/index+1,nbLate,nbConsecutiveAbsent+1);
        //data[index]=' ';
      }
      // present
      //data[index]='0';
      ret+=evalNextDay(/*data,*/index+1,nbLate,0);
      //data[index]=' ';
    }
    else
    {
      //System.out.println(String.valueOf(data));
      ret=1;
    }
    return ret;
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    //char[] data=new char[MAX_DAYS];
    int nb=evalNextDay(/*data,*/0,0,0);
    long now2=System.currentTimeMillis();
    System.out.println("result="+nb+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP191 m=new MainP191();
    m.doIt();
  }
}
