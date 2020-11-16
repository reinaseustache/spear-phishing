import java.util.*;
import java.io.*;

public class Spearphishing{
    public static void main(String[] argv){
		int count = 0;
		String theTestFile = getTestFileContents(argv[1]).toLowerCase();

        try {
			Scanner scanner = new Scanner(new File(argv[0]));
			while (scanner.hasNextLine()) {
				if (theTestFile.contains(scanner.nextLine().toLowerCase())){
					count++;
				}
			}
			scanner.close();

			System.out.println("The test data contains " + count + " suspicious words...\n");

			if(count >= 3){
				System.out.println("This is a potential phishing attack!! Be careful.");
			} else {
				System.out.println("This is not a potential phishing attack. Stay safe.");
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    }

    public static String getTestFileContents(String argv1){
		String contents = "";

		try {
			Scanner scanner = new Scanner(new File(argv1));
			while (scanner.hasNextLine()) {
				contents += scanner.nextLine() + " ";
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return contents;
    }
}