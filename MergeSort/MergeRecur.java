import java.util.Random;

public class Merge {
    private static int[] aux;

    public static void sort(int[] a){
        aux = new int[a.length];
        sort(a, 0, a.length-1);
    }

    private static void sort(int[] a, int lo, int hi){
        if(hi <= lo) return;
        int mid = lo + (hi - lo)/2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    public static void merge(int[] a, int lo, int mid, int hi){
        int i = lo;
        int j = mid +1;

        for(int k = lo; k <= hi; k++){
            aux[k] = a[k];
        }

        for(int k = lo; k <= hi; k++){
            if(i > mid)
                a[k] = aux[j++];
            else if (j > hi)
                a[k] = aux[i++];
            else if (aux[j] < aux[i])
                a[k] = aux[j++];
            else
                a[k] = aux[i++];
        }
    }

    public static void main(String[] args) {

        int n = 100000;
        int[] testArray = new int[n];

        Random r = new Random();
        for(int i = 0; i < n; i++){
            testArray[i] = r.nextInt(n);
        }
        long start = System.currentTimeMillis();
        sort(testArray);
        long end = System.currentTimeMillis() - start;

        System.out.println("Time of sorting = " + end);

        for (int i = 0; i < 1000; i++)
            System.out.print(testArray[i] + " ");
    }
}
