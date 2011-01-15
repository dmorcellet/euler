package problems;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Solved 15.01.2011.
 * @author DAM
 */
public class MainP62
{
  private MainP62()
  {
    // Nothing to do !
  }

  private static class CubeInfo
  {
    private String _sortedDigits;
    private BigInteger _cubeValue;
    private int _cube;

    /**
     * Constructor.
     * @param cube Base value for the cube.
     */
    public CubeInfo(int cube)
    {
      _cube=cube;
      BigInteger b=BigInteger.valueOf(cube);
      BigInteger b2=b.multiply(b);
      _cubeValue=b2.multiply(b);
      String digits=_cubeValue.toString();
      char[] digitChars=digits.toCharArray();
      Arrays.sort(digitChars);
      _sortedDigits=String.valueOf(digitChars);
    }
    
    public String toString()
    {
      return _cubeValue+" "+_sortedDigits+" "+_cube;
    }
  }
  
  private static class DigitsStringCubeComparator implements Comparator<CubeInfo>
  {
    public int compare(CubeInfo o1, CubeInfo o2)
    {
      return o1._sortedDigits.compareTo(o2._sortedDigits);
    }
    
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    final int max=10000;
    final int nbPermutations=5;  
    List<CubeInfo> infos=new ArrayList<CubeInfo>();
    for(int i=0;i<=max;i++) infos.add(new CubeInfo(i));
    Collections.sort(infos,new DigitsStringCubeComparator());
    //System.out.println(infos);
    int nbSame=1;
    String ref=infos.get(0)._sortedDigits;
    String value;
    BigInteger result=null;
    for(int i=1;i<=max;i++)
    {
      value=infos.get(i)._sortedDigits;
      if (value.equals(ref))
      {
        nbSame++;
        if (nbSame==nbPermutations)
        {
          BigInteger minCube=null;
          for(int k=i;k>i-nbPermutations;k--)
          {
            //System.out.println(infos.get(k));
            BigInteger cube=infos.get(k)._cubeValue;
            if ((minCube==null) || (cube.compareTo(minCube)<0)) minCube=cube;
          }
          result=minCube;
          break;
        }
      }
      else
      {
        ref=value;
        nbSame=1;
      }
    }
    long now2=System.currentTimeMillis();
    System.out.println("result="+result+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP62 m=new MainP62();
    m.doIt();
  }
}
