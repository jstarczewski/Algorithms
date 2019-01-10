import java.util.Random;

public class MergeProof {


    //  ##### DOWÓD #####
    //
    //
    //  0. Alfa i Beta
    //      void sort(int[] a)
    //          Alfa -> a[]
    //          Beta -> a[n] <= a[n+1]
    //      void sort(int[] a, int lo, int hi)
    //          lo < hi
    //          Alfa -> a[lo] ... a[hi] (int)
    //  		Beta -> a[lo] <= a[lo+1] <= a[lo+2] <= .... <= a[hi] (int -> posorotwane)
    //      void merge(int[] a, int lo, int mid, int hi)
    //          lo < mid < hi
    //          Alfa -> a[lo] ... a[mid] ... a[hi] (int)
    // 			Beta -> a[lo] <= a[lo+1] <= a[lo+2] <= ... <= a[mid] <= a[mid+1] <= ... <= a[hi] (int -> posorotwane)
    //
    //  1. Własność stopu
    //      void sort(int[] a)
    //          Metoda ta tworzy nową tablicę i wywołuje sort(int[] a, int lo, int hi), która koczy działanie,
    //          gdy lo < hi
    //
    //      void sort(int[] a, int lo, int hi)
    //          Dla danych wejsciowych lo i hi reprezentujacych odpowiednio indeks poczatku sortowania
    //    		i indeks konca wystepuje instrukcja warunkowa if wychodzaca z rekurencji w
    //    		momencie przeciecia sie wartosci indeksow. Przecięcie następuje gdy nastąpi scalenie ostatnich dwóch
    //          wektorów, po czym program wychodzi z rekurencji. Przy dzieleniu wektora na mniejsze wektory
    //          program sprawdza czy wartości lo oraz hi są równe, tak więc najmniejszy możliwy wektor utworzony
    //          na zasadzie podzielenia może mieć dwa elementy w innym przypadku program wychodzi z rekurencji.
    //
    //      void merge(int[] a, int lo, int mid, int hi)
    //          Zarówno pierwsza pętla for jak i druga kończa swoje działanie gdy k <= hi, a k po każdym wykonaniu
    //          zwiększa się o jeden. W pierwszej pętli gdy k przekroczy wartość hi program przechodzi do drugiej pętli,
    //          w tej analogicznie gdy k przekroczy wartość hi program opuszcza pętle i kończy działanie merge.
    //
    //
    //
    //  2. Własność określoności
    //
    //          Podczas działanie algorytmu nie występuje mazanie po pamięci, w merge
    //          pętle działają dopoki k jest mniejsze od hi, czyli indeksu ostatniego elementu, zatem
    //          uniemożliwia to dostęp do indeksów poza zakresem tablicy. W drugiej pętli, drugi warunek if zapobiega
    //          pobraniu elemntu spoza tablicy, jeśli j przekroczy wartść hi, a k będzie nadal mniejsze od hi.
    //
    //
    //  3. Własność częściowej poprawnośći
    //
    //          Wektor wynikowy jest posortowana, ponieważ rekurencyjne dzielenie wektora zachodzi do momentu
    //          otrzymania dwu elementowego wektora, następnie scalenie ich i posortowanie zapenia otrzymanie
    //          posortowanej tablicy wynkowej.
    //
    //
    //


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

