
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DisplayProgram extends JFrame implements ActionListener {
	
	//JFrame set up
	JButton decodeButton = new JButton("Decode message");
	JButton encodeButton = new JButton("Encode message");
	JTextArea textFieldTop = new JTextArea(7,20);
	JTextArea textFieldBottom = new JTextArea(7,20);
	JTextArea textFieldBottomCompRes = new JTextArea(7,20);
	JLabel compressionRatioLabel = new JLabel("Compression ratio: ");
	//Compression ratio variables
	static double compression = 0.0;
	static double asciiTotal = 0.0;
	static double compressionRatio = 0.0;
	
	DisplayProgram(){
		super("Text Compression: Huffman Coding");
		setSize(600,500);
		Container contentPane = getContentPane();
		JPanel topPanel = new JPanel();
		JPanel middlePanel = new JPanel();
		JPanel bottomPanel = new JPanel();
		JPanel bottomPanel2 = new JPanel();
		//Colours
		topPanel.setBackground(new Color(232,220,202));
		middlePanel.setBackground(new Color(245,245,220));
		bottomPanel.setBackground(new Color(232,220,202));
		bottomPanel2.setBackground(new Color(245,245,220));
		//Action listeners for buttons
		decodeButton.addActionListener(this);
		encodeButton.addActionListener(this);
		//Labels
		JLabel label1 = new JLabel("Message");
		JLabel label2 = new JLabel(" Result");
		//Add components to panels
		topPanel.add(label1);
		middlePanel.setLayout(new GridBagLayout());
		middlePanel.add(decodeButton);
		middlePanel.add(encodeButton);
		bottomPanel.add(label2);
		bottomPanel2.add(compressionRatioLabel);
		bottomPanel.add(textFieldBottom);
		bottomPanel2.add(textFieldBottomCompRes);
		//Text area customisation
		textFieldTop.setLineWrap(true);
		textFieldBottom.setLineWrap(true);		
		textFieldBottom.setEditable(false);
		textFieldBottomCompRes.setEditable(false);
		//Scroll bars for text areas
		JScrollPane scrollBar = new JScrollPane(textFieldTop,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		JScrollPane scrollBarResult = new JScrollPane(textFieldBottom,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		//Add components
		topPanel.add(scrollBar);
		bottomPanel.add(scrollBarResult);
		contentPane.add(topPanel);
		contentPane.add(middlePanel);
		contentPane.add(bottomPanel);
		contentPane.setLayout(new GridLayout(3,1));
		//Make JFrame visible
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==decodeButton) {
			String messageToDecode = textFieldTop.getText();
			System.out.println(messageToDecode);
			Decode decoder = new Decode();
			String msgDecoded = decoder.decodeMessage(main.root, messageToDecode);
			textFieldBottom.setText(msgDecoded);
		}
		else if(e.getSource()==encodeButton) {
			String messageToEncode = textFieldTop.getText();
			System.out.println(messageToEncode);
			Encode encode = new Encode();
			//set Compression variables back to zero for next encode
			compression = 0;
			asciiTotal = 0;
			compressionRatio = 0;
					
			String encodedMesg = encode.encodeMessage(main.table, messageToEncode);
			encodedMesg = encodedMesg + "\n \n Ascii: " +asciiTotal + "\n Compressed: " + compression + "\n Compression Ratio: "+ compressionRatio ;
			textFieldBottom.setText(encodedMesg);
		}
	}
}
