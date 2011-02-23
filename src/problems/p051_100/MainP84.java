package problems.p051_100;

/**
 * Solved 04.02.2011.
 * @author DAM
 */
public class MainP84
{
  private static final int DICE_SIZE=4;
  private static final String[] PLACES= {
    "GO","A1","CC1","A2","T1","R1","B1","CH1","B2","B3","JAIL",
    "C1","U1","C2","C3","R2","D1","CC2","D2","D3","FP",
    "E1","CH2","E2","E3","R3","F1","F2","U2","F3","G2J",
    "G1","G2","C3","G3","R4","CH3","H1","T2","H2"};

  private static int findPlace(String name)
  {
    for(int i=0;i<PLACES.length;i++)
    {
      if (PLACES[i].equals(name))
      {
        return i;
      }
    }
    return -1;
  }

  private static final int GO=findPlace("GO");
  private static final int G2J=findPlace("G2J");
  private static final int JAIL=findPlace("JAIL");
  private static final int E3=findPlace("E3");
  private static final int H2=findPlace("H2");
  private static final int R1=findPlace("R1");
  private static final int R2=findPlace("R2");
  private static final int R3=findPlace("R3");
  private static final int CH1=findPlace("CH1");
  private static final int CH2=findPlace("CH2");
  private static final int CH3=findPlace("CH3");
  private static final int U1=findPlace("U1");
  private static final int U2=findPlace("U2");
  private static final int C1=findPlace("C1");

  private static boolean isCC(int index)
  {
    return PLACES[index].startsWith("CC");
  }

  private static boolean isCH(int index)
  {
    return PLACES[index].startsWith("CH");
  }

  private MainP84()
  {
    // Nothing to do !
  }

  private int computeMoves(int start, int value, int[] results)
  {
    int nbCases=16;
    int next=start+value;
    if (next>=PLACES.length) next-=PLACES.length;
    if (next==G2J)
    {
      results[JAIL]+=16;
    }
    else if (isCC(next))
    {
      results[next]+=14;
      results[GO]++;
      results[JAIL]++;
    }
    else if (isCH(next))
    {
      results[next]+=6;
      results[GO]++;
      results[JAIL]++;
      results[C1]++;
      results[E3]++;
      results[H2]++;
      results[R1]++;
      if (next==CH1)
      {
        results[R2]+=2;
        results[U1]++;
      }
      else if (next==CH2)
      {
        results[R3]+=2;
        results[U2]++;
      }
      else if (next==CH3)
      {
        results[R1]+=2;
        results[U1]++;
      }
      results[next-3]++;
    }
    else
    {
      results[next]+=16;
    }
    return nbCases;
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    //System.out.println(PLACES.length);
    float[][] stats=new float[PLACES.length][];
    for(int i=0;i<PLACES.length;i++){
      int[] places=new int[PLACES.length];
      int moves=0;
      for(int d1=1;d1<=DICE_SIZE;d1++)
      {
        for(int d2=1;d2<=DICE_SIZE;d2++)
        {
          moves+=computeMoves(i,d1+d2,places);
        }
      }
      //System.out.println("Starting from "+PLACES[i]);
      float[] statsForOnePlace=new float[PLACES.length];
      stats[i]=statsForOnePlace;
      for(int place=0;place<PLACES.length;place++) {
        float proba=((float)places[place])/moves;
        statsForOnePlace[place]=proba;
        //System.out.println("\t"+PLACES[place]+"="+proba*100);
      }
    }
    
    // merge probabilities
    float[] probabilities=new float[PLACES.length];
    probabilities[GO]=1;
    for(int i=0;i<100;i++) {
      float[] newProbabilities=new float[PLACES.length];
      for(int place=0;place<PLACES.length;place++) {
        float factor=probabilities[place];
        for(int nextPlace=0;nextPlace<PLACES.length;nextPlace++) {
          newProbabilities[nextPlace]+=factor*stats[place][nextPlace];
        }
      }
      probabilities=newProbabilities;
      //float total=0;
      //for(int j=0;j<PLACES.length;j++) total+=probabilities[j];
      //System.out.println(total);
    }
    // find best probas
    int result=0;
    for(int i=0;i<3;i++) {
      float max=0;
      int bestPlace=-1;
      for(int place=0;place<PLACES.length;place++) {
        if (probabilities[place]>max) {
          max=probabilities[place];
          bestPlace=place;
        }
      }
      //System.out.println("Best="+bestPlace+" "+PLACES[bestPlace]+" ("+max*100+"%)");
      probabilities[bestPlace]=0;
      result=result*100+bestPlace;
    }
    long now2=System.currentTimeMillis();
    System.out.println("result="+result+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP84 m=new MainP84();
    m.doIt();
  }
}
