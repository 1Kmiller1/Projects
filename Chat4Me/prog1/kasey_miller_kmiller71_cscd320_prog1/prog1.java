
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;



/**
 * Main for Prog1Main.prog1 for implimenting algrithm for
 * finding ith order statistic
 */
public class prog1 {
    public static void main(String [] args) throws FileNotFoundException {


        // file set up
        String file = args[0];
        File input =  openInputFile(file);
        Scanner fin = new Scanner(input);
        Scanner count = new Scanner(input);
        // array set up
        int size = fileSize(count);
        int[] num = new int[size];
        fillArray(fin, num);
        int i = Integer.parseInt(args[1]);
        //printArray(num);
        //System.out.println("looking for " + i + "th item");
        if (i > num.length || i < 0){
            System.out.println("null");
        }
        else {
            System.out.println(randomizedSelect(num, 0, num.length - 1, i));
        }

    }

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

    // Fills array with numbers from file
    public static void fillArray (final Scanner fin, int[] num){
        if (fin == null || num == null)
            throw new IllegalArgumentException("Bad param in fillArray");
        // put first element in
        String line = fin.nextLine();
        num[0] = Integer.parseInt(line);
        int i = 0;
        // fill remaining elements
        while (fin.hasNextLine()){
            line = fin.nextLine();
            i++;
            num[i] = Integer.parseInt(line);
        }
    }

    public static void sortArray(final int arr[], int i){

        randomizedSelect(arr, 0, arr.length-1, i);
    }

    public static int partiton(int[] arr, int right, int left){

        int pivot = arr[right];
        int index = left;
        int i = left;

        for (i = left; i <= right-1; i++){
            if (arr[i] <= pivot){
                swap(arr, index, i);
                index++;
            }
        }
        swap(arr, index, right);
        return index;

    }
    // swap 2 values in array position
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // get randomized pivits
    public static int randomized_partition(final int[] arr, final int right, final int left) {
        int i = getRand(right, left);
        swap(arr, i, right);
        return partiton(arr, right, left);
    }

    //genereat and return int withing left to right bounds
    public static int getRand(final int right, final int left){

        Random rand = new Random();
        return rand.nextInt(left, right);

    }


    public static int randomizedSelect(int[] arr ,int left, int right,int i){

        //printArray(arr);
        if (right==left)
            return arr[left];
        int q = randomized_partition(arr, right, left);
        int k = q - left + 1;
        if (i == k)
            return arr[q];
        else if (i < k)
            return randomizedSelect(arr, left, q-1, i);
        else
            return randomizedSelect(arr, q+1, right, i-k);

    }

    // made to test array methods
    public static void printArray(final int[] arr){
        System.out.print("{");
        for (int i = 0; i < arr.length-1; i++){
            System.out.print( (arr[i]) + ", " );
        }
        System.out.print( arr[arr.length - 1] +"}");
        System.out.println();
    }
    }
