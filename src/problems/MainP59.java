package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Solved 09.01.2011.
 * @author DAM
 */
public class MainP59
{
  private MainP59()
  {
    // Nothing to do !
  }

  private String loadData()
  {
    String line=null;
    try
    {
      InputStream is=getClass().getResourceAsStream("/data/P59-cipher1.txt");
      BufferedReader r=new BufferedReader(new InputStreamReader(is));
      line=r.readLine();
    }
    catch(IOException ioe)
    {
      ioe.printStackTrace();
    }
    return line;
  }

  private String computeMessage(int[] cipheredMessage, int[] key)
  {
    StringBuilder sb=new StringBuilder(cipheredMessage.length);
    int messageLength=cipheredMessage.length;
    int keyLength=key.length;
    int keyIndex=0;
    for(int i=0;i<messageLength;i++)
    {
      char c=(char)(cipheredMessage[i]^key[keyIndex]);
      sb.append(c);
      keyIndex++;
      if (keyIndex==keyLength) keyIndex=0;
    }
    return sb.toString();
  }

  private int[] loadCipheredMessage()
  {
    String line=loadData();
    String[] values=line.split(",");
    int nb=values.length;
    int[] ret=new int[nb];
    for(int i=0;i<nb;i++)
    {
      ret[i]=Integer.parseInt(values[i]);
    }
    return ret;
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    int sum=0;
    int[] cipheredMessage=loadCipheredMessage();
    int[] key=new int[3];
    for(int k1='a';k1<='z';k1++)
    {
      key[0]=k1;
      for(int k2='a';k2<='z';k2++)
      {
        key[1]=k2;
        for(int k3='a';k3<='z';k3++)
        {
          key[2]=k3;
          String text=computeMessage(cipheredMessage,key);
          if (text.contains(" the "))
          {
            //System.out.println(text);
            for(int i=0;i<text.length();i++)
            {
              sum+=text.charAt(i);
            }
            k1='z';k2='z';k3='z'; // break;
          }
        }
      }
    }
    long now2=System.currentTimeMillis();
    System.out.println("result="+sum+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP59 m=new MainP59();
    m.doIt();
  }
}
