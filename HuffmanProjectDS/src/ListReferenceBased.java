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
      curr = curr.getRight();
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

  public void add(int index, Object item) throws ListIndexOutOfBoundsException
 
  {
    if (index >= 1 && index <= numItems+1)
    {
      if (index == 1)
      {
        // insert the new node containing item at
        // beginning of list
    	TreeNode newNode = new TreeNode(item, null,head);
        head = newNode;
      }
      else
      {
    	  TreeNode prev = find(index-1);
        // insert the new node containing item after
        // the node that prev references
    	  TreeNode newNode = new TreeNode(item, null ,prev.getRight());
        prev.setRight(newNode);
      } // end if
      numItems++;
    }
    else
    {
      throw new ListIndexOutOfBoundsException(
                    "List index out of bounds exception on add");
    } // end if
  }  // end add 1
  
  
  
  
  public void remove(int index) throws ListIndexOutOfBoundsException
  {
    if (index >= 1 && index <= numItems)
    {
      if (index == 1)
      {
        // delete the first node from the list
        head = head.getRight();
      }
      else
      {
    	  TreeNode prev = find(index-1);
        // delete the node after the node that prev
        // references, save reference to node
    	 TreeNode curr = prev.getRight();
        prev.setRight(curr.getRight());
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
	  for(TreeNode curr = head;curr!= null;curr = curr.getRight()) {
		  Object item = curr.getItem();
		  list = list + item.toString() + " \n";
	  }
	  return list;
  }
  
  public  void bubbleSortList() {
		
	  		TreeNode current = head;
	  		TreeNode index = null;
		    Object temp;
		    if(head == null) {
		    	System.out.println("Q");
		    	
		    }
		    else {
		   
		    	while(current != null) {
		    	 
		    		index = current.getRight();
		    
		    		while(index != null) {
		    			
		    		if(current.getFrequency() < index.getFrequency()) {
		    			
		    			temp = current.getItem();
		    			current.setItem(index.getItem());
		    			index.setItem(temp); 
		    		}
		    		 index = index.getRight();
		    		}
		    		current = current.getRight();
		    	} 
		   } 
  }
  
  public boolean seachTree(TreeNode node) {
	  boolean isNodeInTree =false;
	  for(TreeNode curr = head;curr!= null;curr = curr.getRight()) 
	    {
		  if(curr.getItem().toString().equals(node.getItem().toString())) {
			  isNodeInTree= true;
		  }
		 
	    }
	  return isNodeInTree;
  }
} // end ListReferenceBased