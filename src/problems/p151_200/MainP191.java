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

  // days, nb late, nb absent
  private long[][][] _memo;

  private MainP191()
  {
    // Nothing to do !
  }

  private long evalNextDay(/*char[] data,*/ int daysLeft, int nbLate, int nbConsecutiveAbsent)
  {
    long ret=0;
    if (daysLeft>0)
    {
      ret=_memo[daysLeft][nbLate][nbConsecutiveAbsent];
      if (ret==-1)
      {
        // late
        ret=0;
        if (nbLate<MAX_NB_LATE)
        {
          //data[index]='L';
          ret+=evalNextDay(/*data,*/daysLeft-1,nbLate+1,0);
          //data[index]=' ';
        }
        // absent
        if (nbConsecutiveAbsent<MAX_NB_CONSECUTIVE_ABSENT)
        {
          //data[index]='A';
          ret+=evalNextDay(/*data,*/daysLeft-1,nbLate,nbConsecutiveAbsent+1);
          //data[index]=' ';
        }
        // present
        //data[index]='0';
        ret+=evalNextDay(/*data,*/daysLeft-1,nbLate,0);
        //data[index]=' ';
        _memo[daysLeft][nbLate][nbConsecutiveAbsent]=ret;
      }
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
    // init memo
    _memo=new long[MAX_DAYS+1][][];
    for(int i=0;i<MAX_DAYS+1;i++)
    {
      _memo[i]=new long[MAX_NB_LATE+1][];
      for(int j=0;j<MAX_NB_LATE+1;j++)
      {
        _memo[i][j]=new long[MAX_NB_CONSECUTIVE_ABSENT+1];
        for(int k=0;k<MAX_NB_CONSECUTIVE_ABSENT+1;k++) _memo[i][j][k]=-1;
      }
    }
    long nb=evalNextDay(/*data,*/MAX_DAYS,0,0);
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
