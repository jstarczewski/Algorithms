import java.util.Random;

public class HeapSortByWelter {

    public static void Sort(int[] v)
    {
        BuildHeap(v, v.length);

        for (int i = v.length - 1; i > 0; i--)
        {
            Swap(v, 0, i);
            ShiftDown(v, i, 0);
        }
    }

    private static void BuildHeap(int[] v, int n)
    {
        for (int i = n / 2; i >= 0; i--)
            ShiftDown(v, n, i);

    }

    private static void ShiftDown(int[] v, int n, int i){
        int j;
        do{
            j = i;
            if (2 * j < n && v[2 * j] > v[i])
                i = 2 * j;
            if (2 * j + 1 < n && v[2 * j + 1] > v[i])
                i = 2 * j + 1;
            Swap(v, j, i);
        }while (j != i);
    }

    private static void Swap(int[] v, int i, int j) {
        int temp = v[i];
        v[i] = v[j];
        v[j] = temp;
    }

    public static void main(String [] args) throws InterruptedException {
        Random r = new Random();
        int n = 50;
        int max = 100;
        int [] v = new int [n];
        for(int i = 0; i < n; i++){
            v[i] = r.nextInt() % max;
            Thread.sleep(r.nextInt() % 10);
        }
        Sort(v);
        for(int x : v)
            System.out.print(x + ", ");
    }
}
