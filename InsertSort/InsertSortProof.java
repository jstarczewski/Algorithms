public class InsertSort {
    public static void insertSort(int[] a) {
        int swap;
        for (int i = 1; i < a.length; i++)
            for (int j = i; j > 0 && a[j] < a[j - 1]; j--) {
                swap = a[j];
                a[j] = a[j - 1];
                a[j - 1] = swap;
            }
        /*
        Dowód:

            0.Alfa i Beta
                Alfa -> a[0],a[1],... , a[a.lenght-1]
                Beta -> a[o]<=a[1]<= ... <=a[a.lenght-1]

            1.Własnośc stopu
                Pierwsza pętla działa tak długo jak i jest mniejsze od rozmiaru tablicy a. Z kazdym przejsciem
                petli i rośnie o 1 tym samym zmniejszając różnice a.length - i. Pętla zakończy swe działanie jak
                różnica a.length - i będzie rowna 0.
                Druga pętla zawsze zaczyna sie od j = i oraz bedzie miała miejsce dopóki j > 0 oraz element
                tablicy pod indeksem j - 1 jest wiekszy od elementu tablicy pod indeksem j. Z każdym przejściem
                petli j zmniejsza się 1. Pętla zakonczy swe dzialanie gdy j == 0 lub wcześnie gdy j-ty element tablicy
                bedzie wiekszy od j - 1-wszego elementu. Jako że pętla kończy swoje działanie gdy j == 0, nie dojdzie
                nigdy do momentu w którym odwołując się do indeksu j - 1-wszego wyjdziemy poza tablicę.
                Wszystkie pętle są obsługiwane w sposób poprawny nie wystepuje mazanie po pamięci i wychodzenie poza
                indeksy, pętle się kończą.

            2.Własność określoności
                Podczas całego działania algorytmu nie nastepuje mazanie po pamięci, ponieważ pętle są zbudowane
                w sposób uniemożliwiający dostęp do indeksów spoza zakresu tablicy. Podczas odwoływania się do j-tego
                elemntu tablicy na początku j przybiera wartość i które jest w zakresie od 1 do wielkośći tablicy - 1.
                Więc w najwyższej wartości odwołujemy się do ostatniego elemntu tablicy a w najmniejszym  do pierwszego,
                poprzez wyrazenie j - 1.

            3.Własność częściowej poprawności
                Tablica wynikowa jest posortowana, ponieważ dla każdego elementu zaczynając od indeksu 1. Wkładamy i-ty
                element do posortowanego podciągu poprzez swap'owanie. 1-elementowy zbior jest zawsze posortowany, a
                każdy następny jest przesuwany na pozycje w której jest wiekszy od indeksu wyzej i mniejszy od indeksu
                nizej.

         */
    }


    public static void main(String[] args) {

        int a[] = new int[100];
        for (int i = 0; i < 100; i++)
            a[i] = 100 - i;
        for (int i = 0; i < 100; i++)
            System.out.printf(a[i] + " ");
        insertSort(a);
        System.out.printf("\n");
        for (int i = 0; i < 100; i++)
            System.out.printf(a[i] + " ");

    }
}
