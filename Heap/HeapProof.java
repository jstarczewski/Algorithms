/*
 *	Dowod
 * Heap add:
 * 	ALPHA: heap[0], heap[1], .. heap[n-1] to kopiec, n >= 0
 * 	BETA: heap[0], heap[1], .. heap[n] to kopiec
 *
 * 	1. WL STOPU:
 * 		Petla wykonuje sie dopoki position > 0, z kazda iteracja position zmniejsza sie dwukrotnie, kolejne
 * 		wartosci ciagu malejacego po log 2 n wiec musi nastapic 0
 * 	2. WL OKRESLONOSCI:
 * 		Potencjalne niebezpieczenstwo to heap[position] i heap[position / 2];
 * 		position nalezy do przedzialu <1 ; n>, wiec jest bezpieczne,
 * 		na mocy dziedziny liczb calkowitych position / 2 nalezy do przedzialu <0 ; n/2>, wiec h[position/2] bezpieczne
 * 	3. WL CZESCIOWEJ POPRAWNOSCI:
 * 		NIEZMIENNIK PETLI: h[0] ... h[n] jest kopcem z wyjatkiem relacji h[position] i h[position/2],
 * 		jezeli h[position/2] >= h[position] to NP zapewnia BETA spelniony
 * 		W przeciwnym wypadku porzadkuje relacje heap[position] i heap[position/2] oraz zmieniam position wedlug NP
 *	KONIEC DOWODU
 *	ELO
 * */

public  void heapUp(int[] heap, int n) {
	int position = n;
	while( (position / 2) > 0 && heap[position / 2] < heap[position] ){
		int temp = heap[position/2];
		heap[position/2] = in;
		heap[position] = temp;
		position /= 2;
	}
}
