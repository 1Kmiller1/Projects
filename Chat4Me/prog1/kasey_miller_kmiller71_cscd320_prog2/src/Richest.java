import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Richest {
    public static void main(String [] args) throws IOException {

        String file = args[0];
        File input =  FileUtils.openInputFile(file);
        Scanner fin = new Scanner(input);
        //Scanner count = new Scanner(input);

        //System.out.println(fin.nextLine());
        HeapMethods.bildArr(fin);
        HeapMethods.bildHeap();
        HeapMethods.getRichest(fin);


        System.out.println("fix Size to 10000");
        HeapMethods.heapSort();


    }
}
