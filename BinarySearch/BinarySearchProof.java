/*	Dowod
 * ALPHA: arr.size >= 0;
 * 	  arr[0] < arr[1] < arr[2] .... < arr[arr.size - 1];
 * 	  arr: int [], value: int;
 * BETA: |return| nalezy do < 0 ; arr.size-1 >, arr[|return|] == value;
 * 	 |return| == -1 <=> nie istnieje takie k nalezace do < 0 ; arr.size - 1 >, dla ktorego arr[k] == value;
 *
 * 1. WL STOPU:
 * 	Calosc algorytmu zamyka sie w petli while, ktora wykonuje sie dopoki higher >= lower;
 * 	lower = 0, low1, low2, low3;
 * 	higher = arr.size - 1, hi1, hi2, hi3;
 *
 * 	m = (lower + higher) / 2;
 *
 * 	W kazdej sytuacji sterowanie moze pojsc jedna z trzech sciezek:
 * 		a) nowe lower jest wieksze od poprzedniego loweri (dokladnie rowne m + 1)
 * 		b) nowe higher jest mniejsze od poprzedniego higher (dokladnie rowne m-1)
 * 		c) |return| m => koniec dzialania
 * 	Wiec w kazdej iteracji higher - lower maleje, lub funkcja zwraca wartosc, dzieki czemu algorytm spelnia
 * 		wlasnosc stopu.
 *
 * 2. WL OKRESLONOSCI:
 * 	Jedyna niebezpieczna operacja to indeksowanie array wartoscia mid;
 * 	lower jest na poczatku rowne 0 i zawsze mniejsze lub rowne od higher;
 * 	higher jest na poczatku rowne arr.size - 1 i zawsze wieksze lub rowne lower;
 * 	z tego wynika ze mid = (lower + higher) / 2 nalezy do przedzialu < lower ; higher >
 * 	wiec zamyka sie tez w przedziale < 0 ; arr.size - 1 > nie wychodzac poza indeksy tablicy arr
 * 
 * 3. WL CZESCIOWEJ POPRAWNOSCI
 * 	a) Jest poprawne kiedy zwracamy mid po sprawdzeniu ze arr[mid] = value 
 * 	Jesli nie a) to niezmiennik petli stanowi: 
 * 		Jesli value jest w arr, to musi byc pomiedzy arr[lower] i arr[higher]!
 * 	NP jest poprawny przed wejsciem do petli bo lower i higher to skrajne indeksy tablicy arr
 *
 * 	W trakcie istnieja dwie sciezki: 
 * 	1) arr[mid] > x:
 * 		to higher = mid - 1, co oznacza odrzucenie arr[mid], arr[mid+1] .... arr[higher],
 * 		ale z ALPHA mamy ze arr[mid] < arr[mid+1] < ..... < arr[higher] 
 * 		wiec rowniez x < arr[mid] < arr[mid+1] < ...... < arr[higher]
 * 	2) arr[mid] < x 	
 * 		to lower = mid + 1, co oznacza odrzucenie arr[mid], arr[mid-1] .... arr[lower],
 * 		ale z ALPHA mamy ze arr[mid] > arr[mid-11] > ..... > arr[lower] 
 * 		wiec rowniez x > arr[mid] > arr[mid-1] > ...... > arr[lower]
 * 	DZIEKI CZEMU NP POZOSTAJE PRAWDZIWY
 * 	KONIEC DOWODU
 * 	ELO
 *
 * */


import java.lang.System;

public class BinarySearch{
	public static int binarySearch(int [] arr, int value){
		//Inicjalizacja dolnej i gornej granicy przeszukiwania
		int lower = 0;
		int higher = arr.length - 1;
		int mid; 
		//Warunek petli dzieki ktoremu sprawdzone jest tez ostatnie pole, gdzie lower == higher 
		while(higher >= lower){
			//Mid to srednia arytmetyczna dwoch granic
			mid = (lower + higher) / 2;
			//Jesli indeks mid wskazuje na nasza wartosc, to znalezlismy jej indeks	
			if( arr[mid] == value ){
				return mid;
			} else if( arr[mid] < value ) {
				//Jezeli wartosc pod indeksem mid jest mniejsza od wartosci, to wybieramy
				//prawa polowke, omijajac ponowne przeszukiwanie srodka tablicy
				lower = mid + 1;
			} else {
				//Jezeli wartosc pod indeksem mid jest wieksza od wartosci, to wybieramy
				//lewa polowke, omijajac ponowne przeszukiwanie srodka tablicy
				higher = mid - 1;
			}
		}
		//W wypadku kiedy nie znalezlismy w tablicy podanej wartosci, zwracamy -1 jako wartosc
		//nie bedaca mozliwa wartoscia indeksu
		return -1;
	}

	public static void main(String [] args){
		int size = 10000;
		int [] array = new int[size];

		for(int i = 0; i < size; i++){
			array[i] = i;
		}

		int value = 13;

		if( args.length > 0 ) value = Integer.valueOf(args[0]);
		long startTime = System.nanoTime();
		int index = binarySearch(array, value);
		long endTime = System.nanoTime();

		System.out.println(String.format("Value %d found in array at index %d in %d nanoseconds.", 
					value, index, (endTime - startTime)));
	}
}



