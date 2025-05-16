import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FastMatrixMulti {
    public static void main(String [] args) throws FileNotFoundException {


        String file = args[0];
        File input =  openInputFile(file);
        Scanner fin = new Scanner(input);
        Scanner count = new Scanner(input);
        // array set up
        int size = fileSize(count);
        int[] num = new int[size];
        fillArray(fin, num);
        //printArray(num);
        MatrixChainOrder(num, num.length);




    }

    private static void fillArray(Scanner fin, int[] num) {
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

    private static int fileSize(Scanner count) {
        int  c = 0;
        while(count.hasNextLine()){
            count.nextLine();
            c++;
        }
        return c;
    }


    private static File openInputFile(String fileName) throws FileNotFoundException {
        if (fileName == null || fileName.isEmpty())
            throw new IllegalArgumentException("Bad Param openInputFile");

        File inf = new File(fileName);
        if (!(inf.exists())) throw new FileNotFoundException(fileName + " does not exist");

        return inf;
    }

    private static void printArray(int[] A){
        for(int i = 0; i< A.length; i++){
            System.out.println(A[i]);
        }
    }


    static void MatrixChainOrder(int arr[], int n)
    {
        //make 2d array for multiplication
        int m[][] = new int[n][n];
        //make 2s array for visuliation
        int v[][] = new int[n][n];

        //helpful ints
        int i, j, k, ChainLength, cost;

        // make diagionals 0 (0 multi cost for diagonal array)


        //
        for (ChainLength = 2; ChainLength < n; ChainLength++)
        {

            for (i = 1; i < n - ChainLength + 1; i++)
            {
                j = i + ChainLength - 1;
                // skip one Loop if j = arr.length
                if (j == n) {
                    continue;
                }
                for (k = i; k <= j - 1; k++)
                {
                    cost = m[i][k] + m[k + 1][j] + arr[i - 1] * arr[k] * arr[j];
                    if (cost < m[i][j] || m[i][j] == 0) {
                    m[i][j] = cost;
                    v[i][j] = k;///////////////////////////////////////////
                    }
                }
            }
        }
        String para = "";
        if (v[v.length-1][1] == 1)
            System.out.print("((A1A2)A3)");
        else
            System.out.println("(A1(A2A3))");
        for (int l = 0; l < arr.length; l++){

        }
        System.out.print(m[1][n - 1]);
    }



}
