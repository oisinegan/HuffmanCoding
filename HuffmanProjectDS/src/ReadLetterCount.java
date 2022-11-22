import java.io.File; 
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadLetterCount {
	public static String data;
	 
    public void readFile(ListReferenceBased list)  {
        try {
            File myObj = new File("src/LetterCountAscending.txt");
            
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
                list.add(1, data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
