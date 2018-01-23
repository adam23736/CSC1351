import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.File;

public class FW {
	public static void main(String []args) throws IOException {
		File f = new File("foo.txt");
		if(f.exists()){
			FileWriter fw = new FileWriter(f, true);
			PrintWriter pw = new PrintWriter(fw);
			pw.println("Hello");
			pw.close();
		}
	}
}
