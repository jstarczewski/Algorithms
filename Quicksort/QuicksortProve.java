import java.util.;
import java.lang.System;

public class Quicksort {

	//  
	//   Algorytm sortujacy Quicksort
	//  	- bardzo popularny 
	//  	- dziala w miejscu ( wymaga tylko malego stosu do do wywolan rekurencyjnych)
	//  	- sortuje srednio w czasie N log N wektor o dlugosci N
	//  	- krotka petla wewnetrza (szybkie w teori i praktyce)
	//  	- algorytm bardzo wrazliwy (drobne bledy w implementacji rujnuja zlozonosc
	// 		N log N i sprowadzaja sortowanie do zlozonosci KWADRATOWEJ
	 


	//
	// DOWÓD
	//  	0. Alfa i beta 
	//  		void quicksort(int[] a, int lo, int hi)		
	//  			lo < hi 
	//  			Alfa -> a[lo] ... a[hi] (int)
	//  			Beta -> a[lo] <= a[lo+1] <= a[lo+2] <= .... <= a[hi] (int -> posorotwane)  
	//  		void split(int[] a, int p, int hi)
	//  			lo < hi
	//  			Alfa -> a[lo] ... a[hi] (int)
	//  			Beta -> a[lo] <= a[lo+1] <= a[m-1] <= ... <= a[m] <= a[m+1] <= ... <= a[hi] 
	//	1. Wlasnosc stopu 
	//		void quicksort()
	//    		Dla danych wejsciowych lo i hi reprezentujacych odpowiednio indeks poczatku sortowania
	//    		i indeks konca wystepuje instrukcja warunkowa if wychodzaca z rekurencji w
	//    		momencie przeciecia sie wartosci indeksow.
	//    		Przeciecie nastapi gdy w procesie obierania indeksu j bedacego arbitralnym indeksem 
	//    		osiowym zostana ostatnie dwa nieposortowane elementy i po ich przesunieciu lo == hi.
	//		Opuszczenie rekurencji jest zapewnione dla wszystkich elementow osiowych niezaleznie czy
	//		jest to element najmiejszy czy najwiekszy.
	//
	//    		void split()
	//    		W metodzie split glowna petla while(true) zostanie opuszczona w momencie gdy
	//    		gdy schodzace sie do siebie indeksy i,j sie przetna (przed ostateczna zamiana)
	//    		
	//    		Pierwasza mniejsza petla while dziala dopoki nie znajdziemy (szukajac od lewej) wartosci
	//    		mniejszej niz wartosc osiowa m, gdy jej nie znajdziemy i indeks dojdzie do wartosci
	//    		maksymalnej (hi) to instrukcja warunkowa if opuszcza petle.
	//	
	//		Druga mniejsza petla while dziala analogicznie do pierwszej, petla zostanie opuszczona
	//		gdy zostanie znaleizona wartosc wieksza niz wartosc osiowa m,
	//		lub w momencie osiagniecia przez zmienna j minimalnej wartosci (lo),
	//		wtedy instrukcja warunkowa opuszcza petle.
	//		
	//		Wszystkie petle dla poprawnych danych wejsciowych sa obslugiwane w sposób
	//		poprwany, nie wystepuje mazanie po pamieci i wychodzenie poza indeksy, petle sie koncza.
	//		Wzieto pod uwage, ze tablica moze zawierac inne elementy o wartosci klucza takiej samej
	//		jak w elemencie osiowym.
	//
	//	2. Wlasnosci okreslonosci
	//
	//  		Operacje niebezpieczne jakie moga wystapic podczas dzialania qsorta to indeksowanie
	//  		tablic w sposob prowadzacy do wystapienia mazania po pamieci (wyjscia poza granice)
	//
	//		Obranie elementu osiowego jako najmniejszego (lub w przypadku innej
	//		implenemtacji jako najwiekszego) jest zabezpieczone przez to, ze element osiowy
	//		znajduje sie w miejscu a[lo] i nie jest mniejszy niz on sam.
	//		Dzieki temu zabezpieczeniu mamy pewnosc ze dla poprawnych danych nie wystapi
	//		wyjscie wskaznikow poza lewy i prawy koniec tablicy (podtablicy).
	//
	//	3. Wlasnosc czesciowej poprawnosci
	//		
	//		Tablica wynikowa jest posortowana bo rekurencyjne dzielenie zachodzi do momentu
	//		otrzymania dwuelementowej podtablicy (niepodzielnej), a proces podzialu
	//		zawsze umieszcza jeden element na jego ostatecznej pozycji,
	//		zakladajac poprawna implementacje, jesli lewa i prawa
	//		podtablica sa poprawnie posortowane to wynikowa tablica
	//		skladajaca sie z lewej podtablicy (uporzadkowanej i bez elementow wiekszych niz osiowy),
	//		elementu osiowego i prawej podtablicy (uporzadkowanej i bez elementow mniejszych niz 
	//		osiowy) równiez jest posortowana (tablica wynikowa). 
	//
	//
	
	public static void quicksort(int[] a, int lo, int hi) {
		if (hi <= lo) 
			return;
		int j = split(a, lo, hi);
		quicksort(a, lo, j-1);
		quicksort(a, j+1, hi);

	}
	private static int split(int[] a, int lo, int hi) {
		int i = lo;
		int j = hi;
		
		int m = a[lo];
		while(true) {
			 while(a[++i] < m) 
				 if (i == hi)
					 break;
			 while(m < a[--j])
				 if (j == lo)
					 break;
			 if (i >= j)
				 break;
			 int tmp = a[j];
			 a[j]  = a[i];
			 a[j] = tmp;
		}
		a[j] = tmp;
		a[lo] = tmp;
	}

	public static void main(String[] args) {

		int[] testArray = new int[1000000];
		int[] testArrayJavaSort = new int[1000000];

		Random r = new Random();
		for (int i = 0; i < 1000000; i++) {
			testArray[i] = r.nextInt(10000000);
			testArrayJavaSort[i] = r.nextInt(10000000);
			//System.out.print(testArray[i]);
		}
		long start = System.currentTimeMillis();
		quicksort(testArray, 0, testArray.length-1);
		long end = System.currentTimeMillis() - start;
		System.out.println("Time of sorting = " + end);

		start = System.currentTimeMillis();
		Arrays.sort(testArrayJavaSort, 0, testArrayJavaSort.length-1);
		end = System.currentTimeMillis() - start;
		System.out.println("Time of sorting = " + end);
		
		//for (int i = 0; i < 10; i++) 
		//	System.out.print(testArray[i] + " ");
	}

}
