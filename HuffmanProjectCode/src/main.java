
import java.util.ArrayList;

import javax.swing.*;

public class main{
	
	static TreeNode root; //Stores the root of the final tree
	static ListReferenceBased list = new ListReferenceBased(); // Used to generate tree 
	static ListReferenceBased table = new ListReferenceBased(); // Used to encode message by storing letter and binary number
	static StackReferenceBased stack = new StackReferenceBased(); //Determine paths from root to each leaf
	static ArrayList<String> paths = new ArrayList<String>(); // Store paths from root to each leaf

	
	public static void main(String[] args) {
		//Read file
		ReadLetterCount readfFile = new ReadLetterCount();
		readfFile.readFile(list);
		
		//Generate tree
		while(list.size() != 1) {
			//Create two child objects
			TreeNode node1 = list.get(list.size());
			TreeNode node2 = list.get(list.size()-1);
			
			//Show initial list and items to remove
			System.out.println("\n\nLIST:");
			System.out.println(list.displayList()); 
			System.out.println("\nITEMS TO REMOVE");
			System.out.println(node1.getItem());
			System.out.println(node2.getItem());
			
			//Remove two smallest frequencies
			list.remove(list.size());
			list.remove(list.size());
			
			//Create parent TreeNode of the two removed TreeNodes
			int addingTwoNodes = node1.getFreq() + node2.getFreq();
			String createItem = "* " + addingTwoNodes;
			TreeNode parentNode = new TreeNode(createItem,node1,node2);
			System.out.println("Parent: "+ parentNode.getItem());
			
			//Find spot to put TreeNode according to the order of the frequencies
			list.add(list.findSpot(parentNode.getFreq()), parentNode);
			System.out.println("SPOT: " +list.findSpot(parentNode.getFreq()));
		} 
		//Get ROOT
		root = list.get(1);
			
		//Create Table
		getPaths(root);
		Table newTable = new Table();
		newTable.createTable(root,paths, table);
		System.out.println(table.displayList());
		
		//Display Frame
		JFrame diplay = new DisplayProgram();
	} 
	
	//Get Paths from root to each leaf
	public static void getPaths(TreeNode root) {
			//Return if no tree
			if(root==null) {
				return;
			}
			else {
				//Push root to stack
				stack.push(root.getItem());
				//Left Subtree
				getPaths(root.getLeft());
				//If add a leaf node add the current stack to the 'paths' Arraylist
				if(root.getLeft()==null&& root.getRight()==null) {
					paths.add(stack.displayStack());
				}
				//Right subtree
				getPaths(root.getRight());
				//Pop visited treenode from stack
				stack.pop();
			}
		}	
	}
	



