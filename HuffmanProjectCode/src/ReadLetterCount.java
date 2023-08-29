import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadLetterCount {
    public static String data;

    public void readFile(ListReferenceBased list) {
        try {
            File myObj = new File("LetterCountAscending.txt");

            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
                // Create TreeNode and store it in a list.
                TreeNode node = new TreeNode(data, null, null);
                list.add(1, node);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
