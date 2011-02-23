package problems.p051_100;

/**
 * Solved 20.01.2011.
 * @author DAM
 */
public class MainP68
{
  private static final int N=5;
  private static final int NB_ITEMS=N*2;
  private static final int NB_GROUPS=N;
  private static final int SOLUTION_SIZE=16;
  private static final int GROUP_SIZE=3;  

  private String _bestSolution;

  private MainP68()
  {
    // Nothing to do !
  }

  private boolean isUsed(int positions[], int n) {
    for(int i=1;i<=NB_ITEMS;i++)
    {
      if (positions[i]==n) return true;
    }
    return false;
  }

  private void evaluate(int sum, int[] positions, int groupIndex)
  {
    int minStart=1;
    if (groupIndex>0) minStart=positions[1]+1;
    // Loop on first number
    for(int i=minStart;i<=NB_ITEMS;i++)
    {
      if (isUsed(positions,i)) continue;
      //System.out.println("i="+i);
      // use i for first position
      positions[groupIndex*GROUP_SIZE+1]=i;positions[0]++;
      for(int j=1;j<=NB_ITEMS;j++)
      {
        // - Cannot use already used number
        // - Fixed value if groupIndex>0... 
        if ((groupIndex==0) && (isUsed(positions,j))) continue;
        if ((groupIndex>0) && (j!=positions[(groupIndex-1)*GROUP_SIZE+3])) continue;
        if ((groupIndex>0) && (i+j>=sum)) continue;
        //System.out.println("j="+j);
        // use j for next position
        positions[(groupIndex*GROUP_SIZE)+2]=j;positions[0]++;
        for(int k=1;k<=NB_ITEMS;k++)
        {
          if (groupIndex==0)
          {
            if (isUsed(positions,k)) continue;
          }
          else
          {
            if (k!=sum-j-i) continue;
            if (groupIndex==N-1)
            {
              if (k!=positions[2]) continue;
            }
            else
            {
              if (isUsed(positions,k)) continue;
            }
          }
          //System.out.println("k="+k);
          positions[(groupIndex*GROUP_SIZE)+3]=k;positions[0]++;
          sum=i+j+k;
          if (groupIndex==N-1)
          {
            StringBuilder sb=new StringBuilder();
            for(int p=1;p<=GROUP_SIZE*NB_GROUPS;p++) sb.append(positions[p]);
            String s=sb.toString();
            if (SOLUTION_SIZE==s.length())
            {
              //System.out.println("Got a solution ["+s+"] sum="+sum+" !");
              if ((_bestSolution==null) || (_bestSolution.compareTo(s)<0))
              {
                _bestSolution=s;
              }
            }
                
          }
          else
          {
            evaluate(sum,positions,groupIndex+1);
          }
          positions[(groupIndex*GROUP_SIZE)+3]=0;positions[0]--;
        }
        positions[(groupIndex*GROUP_SIZE)+2]=0;positions[0]--;
      }
      positions[(groupIndex*GROUP_SIZE)+1]=0;positions[0]--;
    }
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    // positions[0]=number of set positions
    // positions[i>=1]=value for position (starting at 1).
    int[] positions=new int[NB_GROUPS*GROUP_SIZE+1];
    evaluate(0,positions,0);
    long now2=System.currentTimeMillis();
    System.out.println("result="+_bestSolution+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP68 m=new MainP68();
    m.doIt();
  }
}
