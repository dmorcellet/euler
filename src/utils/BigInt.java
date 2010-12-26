package utils;

/**
 * @author DAM
 */
public class BigInt
{
  private int _maxDigits;
  private int _nbDigits;
  private int[] _digits;
  
  public BigInt(BigInt toClone)
  {
    _maxDigits=toClone._maxDigits;
    _nbDigits=toClone._nbDigits;
    _digits=new int[_maxDigits];
    System.arraycopy(toClone._digits,0,_digits,0,_maxDigits);
  }

  public BigInt(int maxDigits)
  {
    _maxDigits=maxDigits;
    _digits=new int[maxDigits];
    _nbDigits=0;
  }

  public BigInt(int maxDigits, int value)
  {
    this(maxDigits);
    setValue(value);
  }

  public void setValue(int value)
  {
    for(int i=0;i<_maxDigits;i++)
    {
      _digits[i]=0;
    }
    int index=0;
    while (value>0)
    {
      _digits[index]=value%10;
      value/=10;
      index++;
    }
    _nbDigits=index;
  }
  
  public int getNbDigits()
  {
    return _nbDigits;
  }

  public int getDigit(int index)
  {
    if (index>=_maxDigits) return 0;
    return _digits[index];
  }

  public void setDigit(int index, int value)
  {
    if (index>=_maxDigits) throw new IllegalArgumentException("Invalid index: "+index);
    _digits[index]=value;
    if (value>0)
    {
      if (index>=_nbDigits) _nbDigits=index+1;
    }
    else
    {
      if (index==_nbDigits-1)
      {
        do
        {
          _nbDigits--;
        }
        while ((_nbDigits>0) && (_digits[_nbDigits-1]==0));
      }
    }
  }

  public void add(BigInt value)
  {
    int nbDigitsOfValue=value.getNbDigits();
    int maxDigits=Math.max(nbDigitsOfValue,_nbDigits);
    int remainder=0;
    for(int i=0;i<maxDigits;i++)
    {
      int s=getDigit(i)+value.getDigit(i)+remainder;
      if (s>=10)
      {
        remainder=s/10;
        s%=10;
      }
      else
      {
        remainder=0;
      }
      setDigit(i,s);
    }
    if (remainder>0)
    {
      setDigit(maxDigits,remainder);
    }
  }

  public void shift(int n)
  {
    for(int i=_nbDigits-1;i>=0;i--)
    {
      int toIndex=i+n;
      if (toIndex<_maxDigits)
      {
        setDigit(toIndex,getDigit(i));
      }
    }
    for(int i=0;i<n;i++) setDigit(i,0);
  }

  /**
   * Multiply by value (0<=value<=9).
   * @param n Source number.
   * @param value Digit.
   */
  private void simpleMultiply(BigInt n, int value)
  {
    int remainder=0;
    int nbDigits=n.getNbDigits();
    for(int j=0;j<nbDigits;j++)
    {
      int d=n.getDigit(j)*value+remainder;
      if (d>=10)
      {
        remainder=d/10;
        d%=10;
      }
      else
      {
        remainder=0;
      }
      n.setDigit(j,d);
    }
    while (remainder>0)
    {
      n.setDigit(nbDigits,remainder%10);
      remainder=remainder/10;
      nbDigits++;
    }
  }

  public BigInt multiply(BigInt value)
  {
    int nbDigitsOfValue=value.getNbDigits();
    BigInt result=new BigInt(_maxDigits,0);
    for(int i=0;i<nbDigitsOfValue;i++)
    {
      BigInt n=new BigInt(this);
      int digit=value.getDigit(i);
      simpleMultiply(n,digit);
      n.shift(i);
      result.add(n);
    }
    return result;
  }

  @Override
  public String toString()
  {
    if (_nbDigits==0) return "0";
    StringBuilder sb=new StringBuilder(_nbDigits);
    for(int j=_nbDigits-1;j>=0;j--)
    {
      sb.append(_digits[j]);
    }
    return sb.toString();
  }
  
  public static void main(String[] args)
  {
    BigInt n1=new BigInt(100,12);
    BigInt n2=new BigInt(100,345);
    System.out.println("n1="+n1);
    n1.add(n2);
    System.out.println("n1="+n1);
    System.out.println("n2="+n2);
    n2.shift(3);
    System.out.println("n2="+n2);

    BigInt n3=n1.multiply(n2);
    System.out.println("n3="+n3);
    /*
    BigInt n=new BigInt(1000,0);
    for(int i=1;i<100000;i++)
    {
      n.add(new BigInt(10,i));
      System.out.println(n);
    }
    */
  }
}
