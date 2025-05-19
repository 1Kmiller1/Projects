import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String [] args) throws FileNotFoundException {
        ArrayList<Person> familys = new ArrayList<Person>();
        File inf = new File("Family.txt");
        Scanner fin = new Scanner(inf);

        Methods.fillArrayList(fin, familys);
        Collections.shuffle(familys);
        Methods.give(familys);


    }
}
