import java.util.*;
import java.lang.System;

public class Quicksort {

	//  
	//   Algorytm sortujacy Quicksort
	//  	- bardzo popularny 
	//  	- dziala w miejscu ( wymaga tylko malego stosu do do wywolan rekurencyjnych)
	//  	- sortuje srednio w czasie N log N wektor dlugosci N
	//  	- krotka petla wewnetrza (szybki w teori i praktyce)
	//  	- algorytm bardzo wrazliwy (drobne bledy w implementacji rujnuja zlozonosc
	// 		N log N i sprowadzaja sortowanie do zlozonosci KWADRATOWEJ
	 
	// quicksort to rekrurencyjna metoda sortowania
	// zakladajac, ze chcemy sortowac caly wektor to przyjmuje ona jako parametry:
	// wektor a,
	// int lo reprezentujacy pierwszy element w wektorze (0)
	// int hi reprezentujacy ostatni element w wektorze
	public static void quicksort(int[] a, int lo, int hi) {
		// instrukcja warunkowa, która opuszcza rekurencje!
		// klucz lo przechodzi od lewej strony (poczatku) wektora
		// klucz hi przechodzi od prawej strony (konca) wektora
		// kiedy sie przetna wtedy wychodzimy z rekurencji
		// przeciecie oznacza, ze przeszlismy po calej czesci wektora, ktora nas interesowala
		if (hi <= lo) 
			return;
		// metoda dzielaca, jest kluczowa do poprawnego dzialania quicksorta
		// metoda ta wyznacza taki klucz (indeks) j, ze
		// -> element a[j] znajduje sie na ostatnim miejscu tablicy (dla pewnego j)
		// -> zaden element w przedziale od a[lo] do a[j-1] nie jest wiekszy niz a[j]
		// -> zaden element w przedziale a[j+1] do a[hi] nie jest mniejszy niz a[j]
		int j = split(a, lo, hi);
		// wywolanie quicksorta dla pierwszej polowy po lewej stronie od obranego metoda split j
		quicksort(a, lo, j-1);
		// wywolanie metody quicksort dla drugiej polowy
		quicksort(a, j+1, hi);
	

	}
	// metoda dzielaca
	private static int split(int[] a, int lo, int hi) {
		int i = lo;
		int j = hi;
		
		// 
		//   [    ----array-----  ]		 
		//  
		// 
		//   Przed 
		//   [m][ ----array---- ][]
		//   (lo) 	     (hi)
		//  
		//  
		//  
		//   W trakcie
		//   [m][ <=m ][||][ >=m][]
		//   (lo)    (i)  (j)  (hi)
		//  
		//  
		//  
 		//   Po
		//   [  <=m  ][m][  >=m   ]
		//   (lo)     (j)      (hi)
		    

		// arbitralnie wybieramy a[lo] jako element osiowy ktory na koniec sortowania
		// znajdzie sie na swojej ostatecznej pozycji
		int m = a[lo];
		// petla dziala do momentu kiedy klucze i,j sie nie przetna
		// i startuje od lewej strony rosnac, j od prawej malejeac
		while(true) {

			// pierwsza petla szuka elementu wiekszego od osiowego (dlatego tez jest ++i, a nie i++)
			// druga petla szuka elementu mniejszego od osiowego (analogicznie --j a nie j--)

			// dopki wartosci sa mniejsze od arbitralnie wybranego przez nas elementu osiowego to petla leci dalej
			 while(a[++i] < m) 
				 if (i == hi) // gdy dojdzie do konca wychodzi z petli, indeks nie idzie dalej
					 // przez to nie ma mazania po pamieci ( w kolejnych wywolaniach rekurencyjnych nie ma mazania 
					 // po innych wartosiach wektora)
					 break;
			 // ta sama sytuacja dla idacego od konca j
			 while(m < a[--j])
				 if (j == lo)
					 break;
			 // jezeli elementy sie przeciely wychodzimy z petli glownej
			 if (i >= j)
				 break;
			 // zamiana wartosci kryjacych sie pod kluczami i,j poniewaz wartosci a[i] i a[j] znajduja sie w nieodpowiednich
			 // pozycjach wzgledem wybranego wczesniej elementu osiowego
			 int tmp = a[j];
			 a[j]  = a[i];
			 a[j] = tmp;
		}
		// w miejsce pod klucz j wstawiamy wartosc osiowa za pomoca prostej zamiany
		int tmp = a[j];
		a[j] = tmp;
		a[lo] = tmp;
		// po wykonaniu zmian zamieniamy wartosc pod kluczem j z arbitralnie wybranym przez nas m
		// po wykonaniu operacji w metodzie split otrzymujemy wektor w ktorym
		// obrana na poczatku wartosc osiowa m = a[lo] znajduje sie pod odpowiednim kluczem (indeksem), a pozostale
		// elementy przed m sa mniejsze lub rowne m, a po m sa wieksze lub rowne
		// zwracamy wartosc osiowa wedlug ktorej beda sortowane coraz to mniejsze czescie wejsciowego wektora
		return j;
	}

	public static void main(String[] args) {

		// przykladowy wektor o milionie elementów, który bedziemy sortowac naszym
		// wlasnym quicksortem
		int[] testArray = new int[1000000];
		// drugi przykladowy wektor, który bedzie sortowany za pomoca standardowej metody sort
		// z biblioteki Javy
		int[] testArrayJavaSort = new int[1000000];

		Random r = new Random();
		// petla wypelniajaca wektory
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
