public class Node
{
  private Object item;
  private Node next;
  private char letter;
  private int frequency;

  public Node(Object newItem)
  {
    item = newItem;
    next = null;
    letter = getLetter();
    frequency = getFrequency();
  } // end constructor

  public Node(Object newItem, Node nextNode)
  {
    item = newItem;
    next = nextNode;
    letter = getLetter();
    frequency = getFrequency();
  } // end constructor

  public void setItem(Object newItem)
  {
    item = newItem;
  } // end setItem

  public Object getItem()
  {
    return item;
  } // end getItem

  public void setNext(Node nextNode)
  {
    next = nextNode;
  } // end setNext

  public Node getNext()
  {
    return next;
  } // end getNext
  
  public char getLetter() {
	  //Return number from letterCount.txt
	  char letter = item.toString().charAt(0);
	  return letter;
  }
  
  public int getFrequency() {
	  //Return frequency from letterCount.txt
	  String itemString = item.toString();
	  String freqStr = itemString.substring(2,itemString.length());
	  int freq = Integer.parseInt(freqStr);
	  return freq;
  } 
  
  
} // end class Node

