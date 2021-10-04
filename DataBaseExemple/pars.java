import java.util.*;
import java.io.*;

public class tests {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("data.txt"));
        scanner.useDelimiter(";|\\r\\n");
        while(scanner.hasNext()) {
            String q = "INSERT INTO City VALUES (" + scanner.next() + ", '" + scanner.next() + "', '" +
                    scanner.next() + "', '" + scanner.next() + "', " + scanner.next() + ", " + scanner.next() + ");";
            System.out.println(q);
        }
    }
}
