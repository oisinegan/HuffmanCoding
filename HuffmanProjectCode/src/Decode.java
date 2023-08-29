
public class Decode {
	public String decodeMessage(TreeNode root, String test) {
			//DECODE
			test = test + " ";
			TreeNode curr = root;
			String message = "";
			for(int i=0;i<test.length();i++) {
				if(test.charAt(i)=='0') {
					curr = curr.getLeft();
				}
				else if(test.charAt(i)=='1') {
					curr = curr.getRight();
				}
				//New Word Space
				else if(test.charAt(i)== ',' && test.charAt(i+1) == ' ' ) {
					message = message + " ";
					curr = root;
				}
				//Write new letter to message
				else if(test.charAt(i)== ' ' && test.charAt(i-1) != ',') {
					message = message + curr.getLetter();
					curr = root;
				}
				
			}
			return message;
	}
}
