 //package BinaryTrees;

public class TreeNode
{
  private Object item;
  private TreeNode leftChild;
  private TreeNode rightChild;
  private TreeNode next;
  private char letter;
  private int number;

  public TreeNode(Object newItem)
  {
  // Initializes tree node with item and no children.
    item = newItem;
    leftChild  = null;
    rightChild = null;
    next =null;
    letter = getLetter();
    number = getFreq();
  }  // end constructor
  
  public TreeNode(Object newItem, TreeNode nextTreeNode )
  {
  // Initializes tree node with item and no children.
    item = newItem;
    leftChild  = null;
    rightChild = null;
    letter = getLetter();
    number = getFreq();
    next = nextTreeNode;
  }  // end constructor


  public TreeNode(Object newItem, 
                  TreeNode left, TreeNode right)
                  {
  // Initializes tree node with item and
  // the left and right children references.
    item = newItem;
    leftChild  = left;
    rightChild = right;
    letter = getLetter();
    number = getFreq();
  }  // end constructor

  public Object getItem()
  {
  // Returns the item field.
    return item;
  }  // end getItem

  public void setItem(Object newItem)
  {
  // Sets the item field to the new value newItem.
  item  = newItem;
  }  // end setItem

  public TreeNode getLeft()
  {
  // Returns the reference to the left child.
    return leftChild;
  }  // end getLeft

  public void setLeft(TreeNode left)
  {
  // Sets the left child reference to left.
    leftChild  = left;
  }  // end setLeft

  public TreeNode getRight()
  {
  // Returns the reference to the right child.
    return rightChild;
  }  // end getRight

  public void setRight(TreeNode right)
  {
  // Sets the right child reference to right.
    rightChild  = right;
  }  // end setRight
  
  public char getLetter() {
	  //Return number from letterCount.txt
	  char letter = item.toString().charAt(0);
	  return letter;
  }
  
  public int getFreq() {
	  //Return frequency from letterCount.txt
	  String itemString = item.toString();
	  String freqStr = itemString.substring(2,itemString.length());
	  int freq = Integer.parseInt(freqStr);
	  return freq;
  }
  
  //Get binary number from table
  public String getBinNumber() {
	  //Return frequency from letterCount.txt
	  String itemString = item.toString();
	  String freqStr = itemString.substring(2,itemString.length());
	  return freqStr;
  }

  public void setNext(TreeNode nextNode)
  {
    next = nextNode;
  } // end setNext

  public TreeNode getNext()
  {
    return next;
  } // end getNext
}  // end TreeNode