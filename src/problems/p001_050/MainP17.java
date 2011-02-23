package problems.p001_050;

/**
 * Solved 28.11.2010.
 * @author DAM
 */
public class MainP17
{
  private static final String[] SPELL0_9= {"one","two","three","four","five","six","seven","eight","nine"};
  private static final String[] SPELL10_19= {"ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
  private static final String[] SPELL10s= {"twenty","thirty","forty","fifty","sxity","seventy","eigthy","ninety"};
  private static final String HUNDRED="hundred";
  private static final String THOUSAND="thousand";
  private static final String AND="and";

  private MainP17()
  {
    // Nothing to do !
  }

  private int countBelow100()
  {
    int total=0;
    // <10
    for(int i=0;i<SPELL0_9.length;i++) total+=SPELL0_9[i].length();
    // <20
    for(int i=0;i<SPELL10_19.length;i++) total+=SPELL10_19[i].length();
    // from 20 to 99 
    for(int i=2;i<10;i++)
    {
      int dozens=SPELL10s[i-2].length();
      total+=dozens;
      for(int j=1;j<=9;j++)
      {
        total+=dozens;
        total+=SPELL0_9[j-1].length();
      }
    }
    return total;
  }

  private int countHundred(int n)
  {
    // n hundred
    int seed=SPELL0_9[n-1].length()+HUNDRED.length();
    int total=seed+99*(seed+AND.length())+countBelow100();
    return total;
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    int total=countBelow100();
    for(int i=1;i<=9;i++)
    {
      total+=countHundred(i);
    }
    // one thousand
    total+=(SPELL0_9[0].length()+THOUSAND.length());
    long now2=System.currentTimeMillis();
    System.out.println("result="+total+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP17 m=new MainP17();
    m.doIt();
  }
}
