import java.util.ArrayList;
public class Table {
	public void createTable(TreeNode root,ArrayList<String> paths,ListReferenceBased table) {
		
		for(int i = 0;i<paths.size();i++) {
			String currentPath = paths.get(i);
			//Split each node in the path into array
			String arr[] = currentPath.split(",", 10);
			
			int position = 1;
			String pathBin = currentPath.charAt(0) + " ";
			TreeNode currNode = root;
			
			//If node equals leaf
			while(currNode.getLeft() != null && currNode.getRight() !=null) {
				//Check if its a left child
				if(arr[arr.length-position].equals(currNode.getLeft().getItem())) {
					pathBin = pathBin + "0";
					currNode = currNode.getLeft();
				}
				//Check if its a right child
				else if(arr[arr.length-position].equals(currNode.getRight().getItem())) {
					pathBin = pathBin + "1";
					currNode = currNode.getRight();
				}
				position++;
			} 
				TreeNode tableElement = new TreeNode(pathBin);
				table.add(1, tableElement);
			}
	}
}
