import java.io.FileWriter;
import java.io.IOException;

public class Numbers {
    public static void main(String[] args) throws IOException {
        FileWriter numbers = new FileWriter("data.txt");
        int i = 0;
        for (i = 0; i < 1500; i++) {
            numbers.write(String.valueOf(i) + '\n');
            System.out.println("what?");
        }
        numbers.close();
    }
}
