package problems.p051_100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Solved 26.03.2011.
 * @author DAM
 */
public class MainP98
{
  private int _best;

  private MainP98()
  {
    // Nothing to do !
  }

  /**
   * Iterator on digits combinaisons.
   * @author DAM
   */
  public static class DigitsCombinator
  {
    private int _size;
    private Evaluator _e;
    private boolean[] _usedDigits;
    private int[] _digits;
    
    /**
     * Callback method used to evaluate a combinaison.
     * @author DAM
     */
    public interface Evaluator
    {
      /**
       * Evaluate a digits combinaison.
       * @param _digits Digits combinaison.
       */
      public void evaluate(int[] _digits);
    }

    /**
     * Constructor.
     * @param size Number of digits;
     * @param e Evaluator.
     */
    public DigitsCombinator(int size, Evaluator e)
    {
      _usedDigits=new boolean[10];
      _digits=new int[size];
      _size=size;
      _e=e;
    }

    /**
     * Iteration.
     */
    public void iterate()
    {
      for(int i=0;i<_size;i++) _digits[i]=-1;
      iterate(0);
    }

    private void iterate(int index)
    {
      for(int i=0;i<10;i++)
      {
        if (!_usedDigits[i])
        {
          _usedDigits[i]=true;
          _digits[index]=i;
          index++;
          if (index==_size)
          {
            _e.evaluate(_digits);
          }
          else
          {
            iterate(index);
          }
          index--;
          _digits[index]=-1;
          _usedDigits[i]=false;
        }
      }
    }
  }

  /**
   * Load words.
   * @return a list of words.
   */
  public List<String> loadWords()
  {
    List<String> ret=new ArrayList<String>();
    try
    {
      InputStream is=MainP81.class.getResourceAsStream("/data/P98-words.txt");
      BufferedReader r=new BufferedReader(new InputStreamReader(is));
      String line=null;
      while(true)
      {
        line=r.readLine();
        if (line==null) break;
        String[] items=line.split(",");
        for(int i=0;i<items.length;i++)
        {
          ret.add(items[i].substring(1,items[i].length()-1));
        }
      }
    }
    catch(IOException ioe)
    {
      ioe.printStackTrace();
    }
    return ret;
  }

  private HashMap<Integer,List<String>> sortByLength(List<String> words)
  {
    HashMap<Integer,List<String>> ret=new HashMap<Integer,List<String>>();
    Integer key;
    List<String> list;
    for(String word : words)
    {
      int length=word.length();
      key=Integer.valueOf(length);
      list=ret.get(key);
      if (list==null)
      {
        list=new ArrayList<String>();
        ret.put(key,list);
      }
      list.add(word);
    }
    return ret;
  }

  private HashMap<String,List<String>> getAnagrams(List<String> words)
  {
    HashMap<String,List<String>> ret=new HashMap<String,List<String>>();
    String sortedLetters;
    char[] letters;
    List<String> list;
    for(String word : words)
    {
      letters=word.toCharArray();
      Arrays.sort(letters);
      sortedLetters=String.valueOf(letters);
      list=ret.get(sortedLetters);
      if (list==null)
      {
        list=new ArrayList<String>();
        ret.put(sortedLetters,list);
      }
      list.add(word);
    }
    for(Iterator<Map.Entry<String,List<String>>> it=ret.entrySet().iterator();it.hasNext();)
    {
      if (it.next().getValue().size()==1)
      {
        it.remove();
      }
    }
    return ret;
  }

  private String getDifferentLetters(String sortedLetters)
  {
    StringBuilder sb=new StringBuilder();
    char previous=' ',c;
    int length=sortedLetters.length();
    for(int i=0;i<length;i++)
    {
      c=sortedLetters.charAt(i);
      if (c!=previous)
      {
        sb.append(c);
        previous=c;
      }
    }
    return sb.toString();
  }

  private class DigitsCombinaisonsEvaluator implements DigitsCombinator.Evaluator
  {
    private char[] _letters;
    private String _word1;
    private String _word2;

    private DigitsCombinaisonsEvaluator(String letters, String word1, String word2)
    {
      _letters=letters.toCharArray();
      _word1=word1;
      _word2=word2;
    }

    public void iterateOnCombinaisons()
    {
      DigitsCombinator d=new DigitsCombinator(_letters.length,this);
      d.iterate();
    }

    public void evaluate(int[] digits)
    {
      if (digits[0]==0) return;
      int value1=getWordValue(digits,_word1);
      if (!isSquare(value1)) return;
      int value2=getWordValue(digits,_word2);
      if (!isSquare(value2)) return;
      if (value1>_best)
      {
        _best=value1;
        //System.out.println("Best="+_best+", word=["+_word1+"] ("+value1+"), other=["+_word2+"] ("+value2+")");
      }
      if (value2>_best)
      {
        _best=value2;
        //System.out.println("Best="+_best+", word=["+_word2+"] ("+value2+"), other=["+_word1+"] ("+value1+")");
      }
    }

    private int getWordValue(int digits[], String word)
    {
      int ret=0;
      int length=word.length();
      int nbLetters=_letters.length;
      char c;
      for(int i=0;i<length;i++)
      {
        c=word.charAt(i);
        ret*=10;
        for(int j=0;j<nbLetters;j++)
        {
          if (_letters[j]==c)
          {
            ret+=digits[j];
            break;
          }
        }
        // leading 0 is not allowed
        if ((i==0) && (ret==0)) return 10; // not a square
      }
      return ret;
    }

    private boolean isSquare(int value)
    {
      int sq=(int)Math.sqrt(value);
      return (value==sq*sq);
    }
  }

  private void examineAnagramPair(String word1, String word2)
  {
    String letters=getDifferentLetters(word1);
    DigitsCombinaisonsEvaluator m=new DigitsCombinaisonsEvaluator(letters,word1,word2);
    m.iterateOnCombinaisons();
  }

  private void examineAnagramGroup(String sortedLetters, List<String> group)
  {
    //System.out.println(sortedLetters+" : "+group);
    if (group.size()==2)
    {
      examineAnagramPair(group.get(0),group.get(1));
    }
    else if (group.size()==3)
    {
      examineAnagramPair(group.get(0),group.get(1));
      examineAnagramPair(group.get(0),group.get(2));
      examineAnagramPair(group.get(1),group.get(2));
    }
  }

  private void examineList(int length, List<String> words)
  {
    HashMap<String,List<String>> anagrams=getAnagrams(words);
    //System.out.println("Length="+length+": nb groups="+anagrams.size());
    for(Map.Entry<String,List<String>> groupEntry : anagrams.entrySet())
    {
      examineAnagramGroup(groupEntry.getKey(),groupEntry.getValue());
    }
  }

  private void doIt()
  {
    long now=System.currentTimeMillis();
    _best=0;
    List<String> words=loadWords();
    HashMap<Integer,List<String>> sorted=sortByLength(words);
    List<Integer> lengths=new ArrayList<Integer>(sorted.keySet());
    Collections.sort(lengths);
    Collections.reverse(lengths);
    for(Integer key : lengths)
    {
      int length=key.intValue();
      //System.out.println("Length="+length);
      if (length>=4)
      {
        examineList(length,sorted.get(key));
      }
    }
    long now2=System.currentTimeMillis();
    System.out.println("result="+_best+" ("+(now2-now)+"ms).");
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MainP98 m=new MainP98();
    m.doIt();
  }
}
