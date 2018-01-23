import java.util.ArrayList;
import java.io.File; // blank
import java.io.IOException;
import java.util.Scanner;
public class Ex {
  public static void main(String[] args) throws IOException {
    String fileName = "/etc/group";
    File file = new File("/etc/group");// blank
    if(file.exists()) {
      Scanner s = new Scanner(file);
      while(s.hasNextLine())
        System.out.println(s.nextLine());
    } } }
