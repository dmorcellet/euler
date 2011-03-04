package problems.p051_100;

/**
 * Solved 25.02.2011.
 * @author DAM
 */
public class MainP90
{
  private MainP90()
  {
    // Nothing to do !
  }

  /*
  private void displayDices(boolean[] dice1, boolean[] dice2) {
    StringBuilder sb=new StringBuilder();
    {
      int nb=0;
      for(int i=0;i<10;i++) {
        if (dice1[i]) {
          if (nb>0) sb.append(',');
          sb.append(i);
          nb++;
        }
      }
    }
    sb.append("***");
    {
      int nb=0;
      for(int i=0;i<10;i++) {
        if (dice2[i]) {
          if (nb>0) sb.append(',');
          sb.append(i);
          nb++;
        }
      }
    }
    System.out.println(sb);
  }
  */

  private boolean evalDices(boolean[] dice1, boolean[] dice2) {
    // Check 01
    if (((dice1[0]) && (dice2[1])) || ((dice2[0]) && (dice1[1]))) {
      // Check 04
      if (((dice1[0]) && (dice2[4])) || ((dice2[0]) && (dice1[4]))) {
        // Check 25
        if (((dice1[2]) && (dice2[5])) || ((dice2[2]) && (dice1[5]))) {
          // Check 81
          if (((dice1[8]) && (dice2[1])) || ((dice2[8]) && (dice1[1]))) {
            // Check 09
            if (((dice1[0]) && (dice2[9])) || ((dice2[0]) && (dice1[9])) ||
                ((dice1[0]) && (dice2[6])) || ((dice2[0]) && (dice1[6]))) {
              // Check 16
              if (((dice1[1]) && (dice2[6])) || ((dice2[1]) && (dice1[6])) ||
                  ((dice1[1]) && (dice2[9])) || ((dice2[1]) && (dice1[9]))) {
                // Check 36
                if (((dice1[3]) && (dice2[6])) || ((dice2[3]) && (dice1[6])) ||
                    ((dice1[3]) && (dice2[9])) || ((dice2[3]) && (dice1[9]))) {
                  // Check 49
                  if (((dice1[4]) && (dice2[9])) || ((dice2[4]) && (dice1[9])) ||
                      ((dice1[4]) && (dice2[6])) || ((dice2[4]) && (dice1[6]))) {
                    // Check 61
                    if (((dice1[6]) && (dice2[4])) || ((dice2[6]) && (dice1[4])) ||
                        ((dice1[9]) && (dice2[4])) || ((dice2[9]) && (dice1[4]))) {
                      //displayDices(dice1,dice2);
                      return true;
                    }
                  }
                }
              }              
            }
          }
        }
      }
    }
    return false;
  }

  private int evalDice(boolean[] dice1) {
    int nb=0;
    boolean[] digits=new boolean[10];
    for(int i0=0;i0<10;i0++) {
      digits[i0]=true;
      for(int i1=i0+1;i1<10;i1++)
      {
        digits[i1]=true;
        for(int i2=i1+1;i2<10;i2++)
        {
          digits[i2]=true;
          for(int i3=i2+1;i3<10;i3++)
          {
            digits[i3]=true;
            for(int i4=i3+1;i4<10;i4++)
            {
              digits[i4]=true;
              for(int i5=i4+1;i5<10;i5++)
              {
                digits[i5]=true;
                if (evalDices(dice1,digits)) nb++;
                digits[i5]=false;
              }
              digits[i4]=false;
            }
            digits[i3]=false;
          }
          digits[i2]=false;
        }
        digits[i1]=false;
      }
      digits[i0]=false;
    }
    return nb;
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    int n=0;
    boolean[] digits=new boolean[10];
    for(int i0=0;i0<10;i0++) {
      digits[i0]=true;
      for(int i1=i0+1;i1<10;i1++)
      {
        digits[i1]=true;
        for(int i2=i1+1;i2<10;i2++)
        {
          digits[i2]=true;
          for(int i3=i2+1;i3<10;i3++)
          {
            digits[i3]=true;
            for(int i4=i3+1;i4<10;i4++)
            {
              digits[i4]=true;
              for(int i5=i4+1;i5<10;i5++)
              {
                digits[i5]=true;
                n+=evalDice(digits);
                digits[i5]=false;
              }
              digits[i4]=false;
            }
            digits[i3]=false;
          }
          digits[i2]=false;
        }
        digits[i1]=false;
      }
      digits[i0]=false;
    }
    int result=n/2;
    long now2=System.currentTimeMillis();
    System.out.println("result="+result+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP90 m=new MainP90();
    m.doIt();
  }
}
