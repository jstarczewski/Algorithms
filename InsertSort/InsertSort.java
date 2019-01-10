public class InsertSort {

    public static void insertSort(int[] a) {
	//zmienna do zamiany wartosci
	int tmp;
	//petla od pierwszego elementu do konca
        for (int i = 1; i < a.length; i++)     
		// petla od i-tego elementu do poczatku
		for (int j = i; j > 0 && a[j] < a[j - 1]; j--) { 
		//jak jestesmy w i-tym elemencie to wracamy do poczatku petli zamieniajac caly
		//czas i-ty element w strone jego miejsca w tabeli tworzac podciag posortowany
                tmp = a[j];                    
		//i nastepnie zabieramy sie za kolejny element i wstawiamy go na jego miejsce
		//w naszym podciagu posortowanym
		a[j] = a[j - 1];
                a[j - 1] = tmp;
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
