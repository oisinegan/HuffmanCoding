// ****************************************************
// Reference-based implementation of ADT list.
// ****************************************************

public class ListReferenceBased 
{
  // reference to linked list of items
  private TreeNode head;
  private int numItems; // number of items in list

  public ListReferenceBased()
  {
    numItems = 0;
    head = null;
  }  // end default constructor

  public boolean isEmpty()
  {
    return numItems == 0;
  }  // end isEmpty

  public int size()
  {
    return numItems;
  }  // end size

  private TreeNode find(int index)
  {
  // --------------------------------------------------
  // Locates a specified node in a linked list.
  // Precondition: index is the number of the desired
  // node. Assumes that 1 <= index <= numItems+1
  // Postcondition: Returns a reference to the desired
  // node.
  // --------------------------------------------------
	  TreeNode curr = head;
    for (int skip = 1; skip < index; skip++)
    {
      curr = curr.getNext();
    } // end for
    return curr;
  } // end find

  public TreeNode get(int index) throws ListIndexOutOfBoundsException
  {
    if (index >= 1 && index <= numItems)
    {
      // get reference to node, then data in node
    	TreeNode curr = find(index);
      //Object dataItem = curr.getItem();
      return curr;
    }
    else
    {
      throw new ListIndexOutOfBoundsException(
                     "List index out of bounds exception on get");
    } // end if
  } // end get

  public void add(int index, TreeNode node) throws ListIndexOutOfBoundsException
  {
    if (index >= 1 && index <= numItems+1)
    {
      if (index == 1)
      {
        // insert the new node containing item at
        // beginning of list
    	 TreeNode newNode = new TreeNode(node.getItem(), head);
    	 head = newNode;
    	 head.setLeft(node.getLeft());
    	 head.setRight(node.getRight());
      }
      else
      {
    	TreeNode prev = find(index-1);
    	TreeNode newNode = new TreeNode(node.getItem(), prev.getNext());
        prev.setNext(newNode);
        newNode.setLeft(node.getLeft());
        newNode.setRight(node.getRight());
      } // end if 
      numItems++;
    }
    else
    {
      throw new ListIndexOutOfBoundsException(
                    "List index out of bounds exception on add");
    } // end if
  }  // end add

  public void remove(int index) throws ListIndexOutOfBoundsException
  {
    if (index >= 1 && index <= numItems)
    {
      if (index == 1)
      {
        // delete the first node from the list
        head = head.getNext();
      }
      else
      {
    	  TreeNode prev = find(index-1);
        // delete the node after the node that prev
        // references, save reference to node
    	  TreeNode curr = prev.getNext();
        prev.setNext(curr.getNext());
      } // end if
      numItems--;
    } // end if
    else
    {
      throw new ListIndexOutOfBoundsException(
                   "List index out of bounds exception on remove");
    } // end if
  }   // end remove

  public void removeAll()
  {
    // setting head to null causes list to be
    // unreachable and thus marked for garbage
    // collection
    head = null;
    numItems = 0;
  } // end removeAll

  //Display list
  public String displayList() {
	  String list = "";
	  for(TreeNode curr = head;curr!= null;curr = curr.getNext()) {
		  Object item = curr.getItem();
		  list = list + item.toString() + " \n";
	  }
	  return list;
  }
  
  //Find spot in list for new node 
  public  int findSpot(int freq) {
	  TreeNode newNode = head;
	  int spot =1;
	  boolean breakLoop = false;
	  while(newNode!=null) {
		  if(newNode.getFreq()>freq) {
			  spot++;  
		  }
		  newNode = newNode.getNext();
	  }
	  return spot;
  }

} // end ListReferenceBased