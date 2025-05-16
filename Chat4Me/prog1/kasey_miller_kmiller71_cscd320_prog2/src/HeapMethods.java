import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class HeapMethods {

    static int[] heap = new int[10000] ;//[10000];
    static int heapSize ;//10000;

    public static void bildArr(Scanner fin){
        int i = 0;
        heapSize = 10000 ;//10000
        //Bild first set of 10000
        for (i=0; i < heap.length; i++){
            int item = Integer.parseInt(String.valueOf(fin.nextLine()));
            heap[i] = item;
            //System.out.print(item);

        }
        //System.out.println();
    }

    public static void heapify(int i) {
        int smallest = i;
        int left = 2*i+1;
        int right = 2*i+2;

        //check left child
        if (left < heapSize && heap[left] < heap[smallest]){
                smallest = left;
        }

        // check right child
        if (right < heapSize && heap[right] < heap[smallest]){
            smallest = right;
        }

        //swap
        if (smallest != i){
            int swap = heap[i];
            heap[i] = heap[smallest];
            heap[smallest] = swap;

            //do until compleated all sub Arrays
            heapify(smallest);
        }
    }


    public static void bildHeap(){
        //start from last non leaf
        int start = (heapSize/2)-1;

        // work backwords
        for (int i =start; i >= 0; i--){
            heapify(i);


        }
        //printHeap();
    }

    public static void heapSort() throws IOException {
        int item = 0;
        String txt = "", xtx = "";
        for(int i = 0; i < heap.length; i++){
            item = heap[0];
            extractRoot();
            if (i<5000)
                txt = (item + " " + "\n" + txt);
            else
                xtx = (item + " " + "\n" + xtx);
            FileUtils.output(txt, xtx);

        }
    }
    // remove 'root node' and re heapify
    public static void extractRoot() {
        heap[0] = heap[heapSize - 1];
        heapSize--;
        heapify(0);
    }

    public static void getRichest(Scanner fin){
        int i = 0;
        while(fin.hasNextLine()){
            int next = Integer.parseInt(String.valueOf(fin.nextLine()));
            if (heap[0] < next){
                heap[0] = next;
                heapify(0);
            }
        }
    }
}
