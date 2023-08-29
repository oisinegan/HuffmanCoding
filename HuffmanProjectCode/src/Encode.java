
public class Encode {

	public String encodeMessage(ListReferenceBased table, String messageInput ) {
		//Encoding by searching table
		String encodeResult ="";
		String msg = messageInput.toUpperCase();

		for(int i=0;i<msg.length();i++) {
			TreeNode currNode = table.get(1);
			
				while(currNode!=null) {
				if(currNode.getLetter()==msg.charAt(i)) {
					//Get binary number
					encodeResult += currNode.getBinNumber() + " " ;
					//Update compression ratio numbers
					DisplayProgram.compression += currNode.getBinNumber().length();
					DisplayProgram.asciiTotal += + 7;
				
					if(i<msg.length()-1) {
						//Add ',' for new binary number (word)
						if(msg.charAt(i+1) == ' ') {
							encodeResult = encodeResult + ", ";
						}
					}
				}
				currNode = currNode.getNext();
				}
		}
		System.out.println("TOTAL: " + DisplayProgram.asciiTotal + ", COMP: "+ DisplayProgram.compression);
		//Calculate compression ratio
		double compresionRatio = (DisplayProgram.compression/DisplayProgram.asciiTotal) *100;
		//Round compression ration to 2 decimal places
		DisplayProgram.compressionRatio = Math.round(compresionRatio * 100.0) / 100.0;
		System.out.println("COMPRESSION RATIO: " + DisplayProgram.compressionRatio);
		return encodeResult;
	}
}
