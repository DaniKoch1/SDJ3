import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class WriteToFile {

	public static void saveObject(File file, String content) {
		try {
			PrintWriter write = new PrintWriter(file);
			write.println(content);
			write.flush();
			write.close();
		} catch (FileNotFoundException fnf) {
			System.out.println("File not found!!!");
		}
	}
}
