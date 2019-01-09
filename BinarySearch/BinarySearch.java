import java.lang.System;

public class BinarySearch{
	public static int binarySearch(int [] array, int value){
		//Inicjalizacja dolnej i gornej granicy przeszukiwania
		int lower = 0;
		int higher = array.length - 1;
		int mid; 
		//Warunek petli dzieki ktoremu sprawdzone jest tez ostatnie pole, gdzie lower == higher 
		while(higher >= lower){
			//Mid to srednia arytmetyczna dwoch granic
			mid = (lower + higher) / 2;
			//Jesli indeks mid wskazuje na nasza wartosc, to znalezlismy jej indeks	
			if( array[mid] == value ){
				return mid;
			} else if( array[mid] < value ) {
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



