import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileUtils {

    public static File openInputFile(final String filename)throws FileNotFoundException {
        if (filename == null || filename.isEmpty())
            throw new IllegalArgumentException("Bad Param openInputFile");

        File inf = new File(filename);
        if (!(inf.exists())) throw new FileNotFoundException(filename + " does not exist");

        return inf;
    }

    // aquires File size
    public static int fileSize(final Scanner count) {
        int  c = 0;
        while(count.hasNextLine()){
            count.nextLine();
            c++;
        }
        return c;
    }

    public static void output(String txt, String xtx) throws IOException {
        FileWriter write = new FileWriter("richest.output");
        write.write(xtx);
        write.write(txt);
        write.close();

    }
}
