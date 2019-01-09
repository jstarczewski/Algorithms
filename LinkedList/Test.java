import java.util.*;

public class Test {
	
	public static void main(String[] args) {
	
		Random r = new Random();
		LinkedList<Integer> l = new LinkedList<Integer>();
		for (int i = 0; i<20; i++) {
			l.addFirst(i);
		}
		// Wstawianie w liscie liniowej dwukierunkowej moze wystepowac w wersji 
		// 1. Za elementem -> insertAfter(T after, T item)
		// 2. Przed elementem -> insertBefore(T before, T item)
		// 3. Pomiedzy -> insertBetween(T before, T item, T next) 

		System.out.println("Wstawianie");

		// wstawianie pomiedzy tak naprawde jest zbedne
		l.insertAfter(5, 144);
		l.insertBefore(3, 155);
		l.insertBetween(8, 166, 7);

		// wypisujemy
		l.traverse();

		System.out.println("Usuwanie");
		
		// usuwanie
		l.remove(5);
		l.remove(3);
		l.remove(8);
		l.remove(7);

		l.traverse();

		// Wyszukiwanie (sprawdzanie czy jest element w liscie)
		System.out.println(l.contains(12) + " ; " + l.contains(148));
		


		

	}

}
