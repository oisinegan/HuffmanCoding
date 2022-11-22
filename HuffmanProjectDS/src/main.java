
public class main {
	
	static StackReferenceBased stack = new StackReferenceBased();
	
	public static void main(String[] args) {
		ListReferenceBased list = new ListReferenceBased();
		
		ReadLetterCount rf = new ReadLetterCount();
		rf.readFile(list);
		
		//DELETE
		TreeNode node1 = list.get(list.size());
		TreeNode node2 = list.get(list.size()-1);
		System.out.println(node1.getItem());
		System.out.println(node2.getItem());
		
		list.remove(list.size());
		list.remove(list.size());
		
		System.out.println("\n\n List after Removing two nodes");
		System.out.println(list.displayList());
		
		
		int addingTwoNodes = node1.getFrequency() + node2.getFrequency();
		String createItem = "* " + addingTwoNodes;
		
		TreeNode parentNode = new TreeNode(createItem,node1,node2);
		System.out.println("\n\nCalling using parent node");
		System.out.println(parentNode.getItem());
		System.out.println(parentNode.getLeft().getItem());
		System.out.println(parentNode.getRight().getItem());
		
		System.out.println("\n\n List after Adding part node and sorting");
		list.add(1, parentNode.getItem());
		list.bubbleSortList();
		System.out.println(list.displayList());
		
		//Test
		TreeNode test = list.get(23);
		System.out.println(test.getItem());
		System.out.println(test.getLeft());
		//

		
		/*		int gen =0;
	//Generate tree
while(list.size() != 1) {
	
			
		/*	TreeNode node1 = list.get(list.size());
			TreeNode node2 = list.get(list.size()-1);
			
			System.out.println("LIST:");
			System.out.println(list.displayList()); 
			
			System.out.println("\nITEMS TO REMOVE");
			System.out.println(node1.getItem());
			System.out.println(node2.getItem());
			
			
			list.remove(list.size());
			list.remove(list.size());
			
			
			int addingTwoNodes = node1.getFrequency() + node2.getFrequency();
			String createItem = "* " + addingTwoNodes;
			
			TreeNode parentNode = new TreeNode(createItem,null,null);
			
			parentNode.setLeft(node1);
			parentNode.setRight(node2);
			list.add(1, parentNode.getItem());
			list.bubbleSortList();
	
			System.out.println("list sorted \n\n");
			System.out.println(list.displayList());
			
			gen++;
			System.out.println("Iteration "+ gen);
			System.out.println("ROOT: "+ parentNode.getItem() + ", LEFT CHILD: " + parentNode.getLeft().getItem() + ", RIGHT CHILD: "+ parentNode.getRight().getItem());
		} 
	
	System.out.println("\n\n\n");
	
	
	*/
	} 
	
	//Traverse through list and generate table
	public void preOrderTraversal(TreeNode node) {
		while(stack.isEmpty() == false) {
			
		}
	}

}
