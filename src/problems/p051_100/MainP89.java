package problems.p051_100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Solved 03.02.2011.
 * @author DAM
 */
public class MainP89
{
  private MainP89()
  {
    // Nothing to do !
  }

  private static final char[][] symbols={{'I','V','X'},{'X','L','C'},{'C','D','M'}};

  /**
   * Convert a number into a latine number.
   * @param number Number of convert.
   * @param sb Output.
   */
  public static void convert(int number, StringBuilder sb)
  {
    char[] tmp=new char[4];
    for(int i=0;i<3;i++)
    {
      int n=0;
      int v=number%10;
      if (v<=3)
      {
        for(int j=0;j<v;j++) { tmp[n]=symbols[i][0]; n++; }
      }
      else if (v<=5)
      {
        for(int j=0;j<5-v;j++) { tmp[n]=symbols[i][0]; n++; }
        tmp[n]=symbols[i][1]; n++;
      }
      else if (v<=8)
      {
        tmp[n]=symbols[i][1]; n++;
        for(int j=0;j<v-5;j++) { tmp[n]=symbols[i][0]; n++; }
      }
      else
      {
        tmp[n]=symbols[i][0]; n++;
        tmp[n]=symbols[i][2]; n++;
      }
      number=number/10;
      sb.insert(0,tmp,0,n);
    }
    if (number>0)
    {
      char[] toAdd=new char[number];
      for(int i=0;i<number;i++)
      {
        toAdd[i]=symbols[2][2];
      }
      sb.insert(0,toAdd);
    }
  }

  /**
   * Convert a number into a latine number.
   * @param number Number of convert.
   * @return A latine number string.
   */
  public static String convert(int number)
  {
    StringBuilder sb=new StringBuilder();
    convert(number,sb);
    return sb.toString();
  }

  /**
   * The value of a latine character.
   * @param c Character to evaluate.
   * @return A value.
   */
  private static int valueOf(char c)
  {
    if (c=='M') return 1000;
    if (c=='D') return 500;
    if (c=='C') return 100;
    if (c=='L') return 50;
    if (c=='X') return 10;
    if (c=='V') return 5;
    if (c=='I') return 1;
    return 0;
  }

  /**
   * Convert a latine number string into a number.
   * @param latineNumberStr Latine number string.
   * @return A number.
   */
  public static int convert(String latineNumberStr)
  {
    int ret=0;
    int nb=latineNumberStr.length();
    int value=0;
    for(int i=nb-1;i>=0;i--)
    {
      int newValue=valueOf(latineNumberStr.charAt(i));
      if (newValue>=value)
      {
        ret+=newValue;
      }
      else
      {
        ret-=newValue;
      }
      value=newValue;
    }
    return ret;
  }

  private List<String> loadRomans()
  {
    List<String> lines=new ArrayList<String>();
    try
    {
      InputStream is=getClass().getResourceAsStream("/data/P89-roman.txt");
      BufferedReader r=new BufferedReader(new InputStreamReader(is));
      String line=null;
      while(true)
      {
        line=r.readLine();
        if (line==null) break;
        lines.add(line);
      }
    }
    catch(IOException ioe)
    {
      ioe.printStackTrace();
    }
    return lines;
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    List<String> romans=loadRomans();
    int sum=0;
    for(String roman : romans) {
      int value=convert(roman);
      String newRoman=convert(value);
      int diff=roman.length()-newRoman.length();
      sum+=diff;
    }
    long now2=System.currentTimeMillis();
    System.out.println("result="+sum+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP89 m=new MainP89();
    m.doIt();
  }
}
