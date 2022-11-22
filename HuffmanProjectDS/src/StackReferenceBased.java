public class StackReferenceBased implements StackInterface
{
  private TreeNode top;

  public StackReferenceBased()
  {
    top = null;
  }  // end default constructor
  //============================================================================
  //============================================================================
  //============================================================================

  public boolean isEmpty()
  {
    return top ==  null;
  }  // end isEmpty
//============================================================================
//============================================================================
//============================================================================

  public void push(Object newItem)
  {
    top = new TreeNode(newItem, null,top);
  }  // end push
  //============================================================================
  //============================================================================
  //============================================================================

  public Object pop() throws StackException
  {
    if (!isEmpty())
    {
      TreeNode temp = top;
      top = top.getRight();
      return temp.getItem();
    }
    else
    {
      throw new StackException("StackException on " + "pop: stack empty");
    }  // end if
  }  // end pop
  //============================================================================
  //============================================================================
  //============================================================================

  public void popAll()
  {
    top = null;
  }  // end popAll

//============================================================================
//============================================================================
//============================================================================
  public Object peek() throws StackException
  {
    if (!isEmpty())
    {
      return top.getItem();
    }
    else
    {
      throw new StackException("StackException on " + "peek: stack empty");
    }  // end if

  } // end peek
//============================================================================
//============================================================================
//============================================================================
  
//Display stack 
  public String displayStack() {
	  TreeNode curr = top;
	  String display = "";
	  while(curr!= null ) {
		  Object item = curr.getItem();
		  display = display + item.toString() + " \n";
		  curr = curr.getRight();		  
		
		 
	  }
	  return display;
  }

}  // end StackReferenceBased