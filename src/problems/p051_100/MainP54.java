package problems.p051_100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Solved 08.01.2011.
 * @author DAM
 */
public class MainP54
{
  private List<String> _values;
  private List<String> _suits;
  private CardsComparator _cc;
  private CardValueComparator _cvc;
  private int _win1;
  private int _win2;
  private int _tie;
  
  private MainP54()
  {
    _values=new ArrayList<String>();
    for(int i=2;i<=9;i++) _values.add(String.valueOf(i));
    _values.add("T");
    _values.add("J");
    _values.add("Q");
    _values.add("K");
    _values.add("A");
    _suits=new ArrayList<String>();
    _suits.add(("H"));
    _suits.add(("S"));
    _suits.add(("C"));
    _suits.add(("D"));
    _cc=new CardsComparator();
    _cvc=new CardValueComparator();
  }

  private int rankHand(List<String> hand)
  {
    int[] nbS=new int[4];
    int[] nbV=new int[13];
    for(int i=0;i<5;i++)
    {
      String card=hand.get(i);
      int s=_suits.indexOf(card.substring(1));
      nbS[s]++;
      int v=_values.indexOf(card.substring(0,1));
      nbV[v]++;
    }
    boolean sameSuit=false;
    for(int i=0;i<4;i++)
    {
      if (nbS[i]==5)
      {
        sameSuit=true;
        break;
      }
    }
    if (sameSuit)
    {
      int v=_values.indexOf(hand.get(0).substring(0,1));
      int v2=_values.indexOf(hand.get(4).substring(0,1));
      if (v2-v==4)
      {
        if (v==9) return 9*1000; // Royal flush
        return 8*1000; // Straight flush
      }
      return 5*1000; // flush
    }
    int nb4=0;
    int nb3=0;
    int nb2=0;
    int nb1=0;
    for(int i=0;i<13;i++)
    {
      if (nbV[i]==4) nb4++;
      else if (nbV[i]==3) nb3++;
      else if (nbV[i]==2) nb2++;
      else nb1++;
    }
    if (nb4==1) return 7*1000; // Four a of Kind
    if ((nb3==1) && (nb2==1)) return 6*1000; // Full House
    if (nb3==1) return 3*1000; // Three of a kind
    if (nb2==2) return 2*1000; // Two pairs
    if (nb2==1)
    {
      int pairValue=0;
      int highCard=0;
      for(int i=0;i<13;i++)
      {
        if ((pairValue==0) && (nbV[i]==2))
        {
          pairValue=i;
        }
        else if (nbV[i]==1)
        {
          highCard=i;
        }
      }
      return 1*1000+(pairValue*15)+highCard; // One pair
    }
    Collections.sort(hand,_cvc);
    int v=_values.indexOf(hand.get(0).substring(0,1));
    int v2=_values.indexOf(hand.get(4).substring(0,1));
    if (v2-v==4) return 4*1000; // Straight
    int maxV=0;
    for(int i=12;i>=0;i--)
    {
      if (nbV[i]!=0)
      {
        maxV=i;
        break;
      }
    }
    return 0*1000+maxV; // High card
  }

  private class CardsComparator implements Comparator<String>
  {
    /**
     * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
     */
    public int compare(String o1, String o2)
    {
      char s1=o1.charAt(1);
      char s2=o2.charAt(1);
      if (s1!=s2)
      {
        return s1-s2;
      }
      int v1=_values.indexOf(o1.substring(0,1));
      int v2=_values.indexOf(o2.substring(0,1));
      return v1-v2;
    }
  }

  private class CardValueComparator implements Comparator<String>
  {
    /**
     * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
     */
    public int compare(String o1, String o2)
    {
      int v1=_values.indexOf(o1.substring(0,1));
      int v2=_values.indexOf(o2.substring(0,1));
      return v1-v2;
    }
  }

  private List<String> hand(String handStr, boolean firstHand)
  {
    String[] numberStrs=handStr.split(" ");
    int startIndex=(firstHand?0:5);
    List<String> hand=new ArrayList<String>(5);
    for(int i=startIndex;i<startIndex+5;i++) hand.add(numberStrs[i]);
    Collections.sort(hand,_cc);
    return hand;
  }

  private void compareHands(String handStr)
  {
    List<String> hand1=hand(handStr,true);
    List<String> hand2=hand(handStr,false);
    int r1=rankHand(hand1);
    int r2=rankHand(hand2);
    if (r1>r2) _win1++;
    else if (r1<r2) _win2++;
    else
    {
      _tie++;
      System.out.println(r1+" - "+hand1+" / "+hand2);
    }
  }

  private List<String> loadCards()
  {
    List<String> lines=new ArrayList<String>();
    try
    {
      InputStream is=getClass().getResourceAsStream("/data/P54-poker.txt");
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
    List<String> hands=loadCards();
    for(String handStr : hands)
    {
      compareHands(handStr);
    }
    //System.out.println("Win1: "+_win1);
    //System.out.println("Win2: "+_win2);
    //System.out.println("Tie: "+_tie);
    long now2=System.currentTimeMillis();
    System.out.println("result="+_win1+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP54 m=new MainP54();
    m.doIt();
  }
}

/**
 * 0 High Card: Highest value card.
 * 1 One Pair: Two cards of the same value.
 * 2 Two Pairs: Two different pairs.
 * 3 Three of a Kind: Three cards of the same value.
 * 4 Straight: All cards are consecutive values.
 * 5 Flush: All cards of the same suit.
 * 6 Full House: Three of a kind and a pair.
 * 7 Four of a Kind: Four cards of the same value.
 * 8 Straight Flush: All cards are consecutive values of same suit.
 * 9 Royal Flush: Ten, Jack, Queen, King, Ace, in same suit.
 * 
 * The cards are valued in the order:
 * 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King, Ace.
 */
