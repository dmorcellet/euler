package problems;

import java.util.HashSet;

/**
 * Solved 18.02.2011.
 * @author DAM
 */
public class MainP88
{
  private static final int KMAX=12000;
  private static final int VALUEMAX=13000;

  private MainP88()
  {
    // Nothing to do !
  }

  private void addOneItem(int[] items, int[] min, int nbItems, int minItem, int product, int sum)
  {
    int item=minItem;
    int p=product*minItem;
    int s=sum+minItem;
    nbItems++;
    items[nbItems-1]=item;
    while(true)
    {
      if (p>s) break;
      if (s>VALUEMAX) break;
      if (p>VALUEMAX) break;
      if (p==s)
      {
        if (p<min[nbItems-1])
        {
          min[nbItems-1]=p;
          /*
          for(int i=0;i<nbItems;i++)
          {
            if (i>0) System.out.print(',');
            System.out.print(items[i]);
          }
          System.out.println(" ("+nbItems+") => p="+p+", s="+s);
          */
        }
      }
      if (nbItems<KMAX)
      {
        addOneItem(items,min,nbItems,item,p,s);
      }
      item++;
      items[nbItems-1]=item;
      p=product*item;
      s=sum+item;
    }
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    //PrimeDecomposition p=new PrimeDecomposition(KMAX+1);
    //List<Integer> ints=p.decompose(KMAX);
    //System.out.println(ints);
    int[] min=new int[KMAX];
    int[] items=new int[KMAX];
    for(int i=0;i<KMAX;i++)
    {
      items[i]=1;
      min[i]=Integer.MAX_VALUE;
    }
    addOneItem(items,min,0,1,1,0);
    HashSet<Integer> values=new HashSet<Integer>();
    for(int i=1;i<KMAX;i++)
    {
      //System.out.println("k="+(i+1)+", min="+min[i]);
      values.add(Integer.valueOf(min[i]));
    }
    long sum=0;
    for(Integer value : values)
    {
      sum+=value.intValue();
    }
    long now2=System.currentTimeMillis();
    System.out.println("result="+sum+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP88 m=new MainP88();
    m.doIt();
  }
}
