public class InsertSort {
    public static void insertSort(int[] a) {
        int swap;   //zmienna do swap'owania
        for (int i = 1; i < a.length; i++)  //petla od pierwszego elementu do konca
            for (int j = i; j > 0 && a[j] < a[j - 1]; j--) { // petla od i-tego elementu do poczatku
                swap = a[j];    //jak jestesmy w i-tym elemencie to wracamy do poczatku petli zamieniajac caly czas i-ty element w strone jego miejsca w tabeli tworzac podciag posortowany
                a[j] = a[j - 1]; //i nastepnie zabieramy sie za kolejny element i wstawiamy go na jego miejsce w naszym podciagu posortowanym
                a[j - 1] = swap;
            }


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
