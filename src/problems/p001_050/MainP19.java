package problems.p001_050;

/**
 * Solved 19.12.2010.
 * @author DAM
 */
public class MainP19
{
  private MainP19()
  {
    // Nothing to do !
  }

  private static final int[] DAYS_IN_MONTH={31,28,31,30,31,30,31,31,30,31,30,31};

  private int getDaysOfMonth(int month, int year)
  {
    int days=DAYS_IN_MONTH[month];
    if (month==1)
    {
      // February
      boolean isLeapYear=false;
      if (year%4==0)
      {
        isLeapYear=true;
        if (year%100==0)
        {
          isLeapYear=false;
          if (year%400==0)
          {
            isLeapYear=true;
          }
        }
      }
      if (isLeapYear) days++;
    }
    return days;
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    int index=0;
    int nbSundays=0;
    for(int year=1900;year<=2000;year++)
    {
      for(int month=0;month<12;month++)
      {
        if ((year>=1901) && (index%7==6))
        {
          //System.out.println("Month="+month+", year="+year);
          nbSundays++;
        }
        index+=getDaysOfMonth(month,year);
      }
    }
    long now2=System.currentTimeMillis();
    System.out.println("result="+nbSundays+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP19 m=new MainP19();
    m.doIt();
  }
}
