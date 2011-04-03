package problems.p201_250;

import java.util.Locale;

/**
 * Solved 03.04.2011.
 * @author DAM
 */
public class MainP205
{
  private MainP205()
  {
    // Nothing to do !
  }

  private int[] distrib(int diceSize, int nbDices)
  {
    int[] ret;
    if (nbDices==1)
    {
      ret=new int[diceSize+1];
      for(int i=1;i<=diceSize;i++)
      {
        ret[i]=1;
      }
    }
    else
    {
      int[] distribOneLess=distrib(diceSize,nbDices-1);
      int size=distribOneLess.length+diceSize;
      ret=new int[size];
      for(int i=1;i<size;i++)
      {
        // compute F(i)
        for(int d=1;d<=diceSize;d++)
        {
          if ((i-d>=0) && (i-d<distribOneLess.length))
          {
            ret[i]+=1*distribOneLess[i-d];
          }
        }
      }
    }
    //System.out.println("Distrib(diceSize="+diceSize+", nbDices="+nbDices+")=");
    //System.out.println(Arrays.toString(ret));
    return ret;
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    int[] colin=distrib(6,6);
    long colinCases=6*6*6*6*6*6;
    int[] peter=distrib(4,9);
    long peterCases=4*4*4*4*4*4*4*4*4;
    long totalCases=colinCases*peterCases;
    long peteWinsCases=0;
    for(int i=1;i<peter.length;i++)
    {
      for(int j=1;j<i;j++)
      {
        peteWinsCases+=(peter[i]*colin[j]);
      }
    }
    //System.out.println("Peter wins = "+peteWinsCases);
    //System.out.println("Total cases = "+totalCases);
    double probability=((double)peteWinsCases)/((double)totalCases);
    //System.out.println("Probability = "+probability);
    long now2=System.currentTimeMillis();
    String result=String.format(Locale.US,"%10.7f",new Double(probability)).trim();
    System.out.println("result="+result+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP205 m=new MainP205();
    m.doIt();
  }
}
