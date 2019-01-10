import java.util.Random;

public class MergeComments {

    // Sortowanie przez scalanie
    //  -działa w miejscu,
    //  -potrzebuje drugiej takiego samego wektora, wymaga dodatkowej pamięci w ilości proporcjonalnej no N
    //  -sortuje w czasie N log N
    //  -algorytm typu dziel i zwyciężaj xD
    //  -dla małych tablic lepiej zastanowić się nad innym agorytmem


    //      M E R G E S O R
    //      M E|R G|E S|O R         sortujemy po dwa elementy
    //      E M|G R|E S|O R         scalamy pierwsza parę z drugą i trzecią z czwartą
    //      E G M R|E O R S         scalamy kolejne dwa utworzone wektory
    //      E E G M O R R S


    //tworzymy nową pomocniczy wektor do którego będziemy kopiowac wektor 'główny' a potem posortowane części wkładamy do głownego wektora
    private static int[] aux;

    public static void sort(int[] a){      //metoda sort inicjuje wektor i wywołuje metodą sort
        aux = new int[a.length];
        sort(a, 0, a.length-1);
    }

    //metoda sort przyjmuje argumenty:
    //tablice []a do posortowania
    //int lo oznaczający pierwszy element tablicy
    //int hi oznaczający ostatni element tablicy
    private static void sort(int[] a, int lo, int hi){
        // instrukcja warunkowa, która opuszcza rekurencje!
        // klucz lo przechodzi od lewej strony (poczatku) wektora
        // klucz hi przechodzi od prawej strony (konca) wektora
        // kiedy sie przetna wtedy wychodzimy z rekurencji
        // przeciecie oznacza, ze przeszlismy po calej czesci tablicy, ktora nas interesowala
        if(hi <= lo) return;
        //dzielimy wektor do posortowania na dwie czesci
        //mid i mid+1 są srodkowymi elementami i dzilą wektor na dwa mniejsze wektory
        int mid = lo + (hi - lo)/2;
        //sortujemy wektor a od lo elementu do mid elementu czyli pierwszą połowe wektora
        sort(a, lo, mid);
        //sortujemy wektor a od mid+1 elementu do hi elementu czyli pierwszą połowe wektora
        sort(a, mid + 1, hi);
        //łączymy oba wektory odrazu je sortując w jeden wektor
        merge(a, lo, mid, hi);
    }

    public static void merge(int[] a, int lo, int mid, int hi){ //Scalanie a[lo..mid] z a[mid+1..hi]
        //int i oraz int j są pierwszymi elementami wektorów
        int i = lo;
        int j = mid +1;

        for(int k = lo; k <= hi; k++){  //kopiowanie a[lo..hi] do aux[lo..hi]
            aux[k] = a[k];
        }
        //
        for(int k = lo; k <= hi; k++){  //scalanie z powrotem do a[lo..hi]
            //wyczerpano lewą połowę, należy pobrać element z prawej połowy
            if(i > mid)
                a[k] = aux[j++];
            //wyczerpano prawą połowę, należy pobrać element z lewej połowy
            else if (j > hi)
                a[k] = aux[i++];
            //aktualny klucz po prawej ma wartość mniejszą niż aktualny klucz po lewej stronie, należy pobrać dane z prawej
            else if (aux[j] < aux[i])
                a[k] = aux[j++];
            //aktualny klucz po lewej ma wartość mniejszą niż aktualny klucz po prawej stronie, należy pobrać dane z lewej
            else
                a[k] = aux[i++];
        }
    }

    public static void main(String[] args) {
        //twirzymy jakas tablice 1000 elementów i wypełniamy ją losowymi liczbami
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

