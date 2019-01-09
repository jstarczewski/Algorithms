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

/*
	Dowód:
		0.Alfa i Beta
			Alfa -> heap[1] >= heap[2] && heap[1] >= heap[3] , heap[2] >= heap[4] && heap[2] >= heap[5] ... az do liści
			&& size > 0   && out <= size
			Beta -> heap[1] >= heap[2] && heap[1] >= heap[3] , heap[2] >= heap[4] && heap[2] >= heap[5] ...
		1.Warunek stopu
			Pierwsza pętla wykonuje się tylko jeśli dany element posiada przynajmniej 1 dziecko oraz te 1 dziecko jest
			większe od jej aktualnego rodzica. Jeśli jest 2 takich dzieci to sprawdzamy które dziecko jest większe i
			zamieniamy je miejscem z rodzicem, a nastepnie zmieniami indeks out na nową pozycję naszego elementu.
			W tym wypadku pętla zawsze zakończy swe działanie gdy dojdziemy do dołu drzewa lub gdy dzieci bedą mniejsze
			od elementu.
			Druga pętla wykonuje się tak długo jak nie jesteśmy na pozycji root'a oraz rodzic naszego elementu jest
			od niego mniejszy. W takim przypadku zamieniamy pozycje elemntu z jego rodzicem oraz zmieniamy indeks na
			nowa pozycje. W tym wypadku pętla zawsze zakończy swe działanie gdy dojdziemy do pozycji root'a lub gdy
			rodzic elentu bedzie od niego wiekszy.
			Na podstawie powyższych wywodów program zawsze zakonczy swoje działanie.

		2.Własność określoności
            W algorytmie nigdy nie dojdzie do mazania pamieci tak długo jak dane spełniają warunek alfa, ponieważ
            wszelkie indeksowanie odbywa sie po uprzednim sprawdzeniu czy indeks nie wykroczy poza rozmiar kopca.

		3.Właśność częściowej poprawności
            Kopiec wynikowy spełnia założenia kopca, ponieważ po usunięciu dowolnego elementu na jego miejsce zostanie
            wrzucony ostatni element z kopca. Jedynym wyjatkiem jest usuniecie ostatniego elementu. W tym przypadku
            usuniecie go nie zniszczy struktury kopca.
            Po wrzuceniu na miejsce usunietego elementu ostatniego elementu algorytm sprawdza, w która stronę musi
            przesunąć wstawiony element aby kopiec spełniał założenia warunku Beta. W 1 przypadku przesuwa go do góry
            odwołując się do indeksu rodzica. W przeciwnym wypadku sprawdza dzieci i zamienia sie z większym jeśli
            takowy jest także większy od niego. W skutek tych operacji kopiec wynikowy spełnia założenia Beta.


 */

public static int delete(int[] heap,int size, int out) {
		int ret = heap[out];
		int biggerGame = 0;
		int swap;
		if(out == size)
		    return size--;
		heap[out] = heap[size--];
		if (out == 1 || heap[out / 2] > heap[out]) {
		    while ((out * 2 <= size) && heap[out] < heap[out * 2] || (out * 2 + 1 <= size) && heap[out] < heap[out * 2 + 1]) {
		        if (out * 2 + 1 <= size)
		        biggerGame = heap[out * 2 + 1] >= heap[out * 2] ? out * 2 + 1 : out * 2;
		        swap = heap[biggerGame];
		        heap[biggerGame]=heap[out];
		        heap[out]=swap;
		        out=biggerGame;
		}

		} else
		    while (out != 1 && heap[out] > heap[out / 2]) {
		        swap = heap[out];
		        heap[out] = heap[out / 2];
		        heap[out / 2] = swap;
		        out /= 2;
		    }
		return size;
		}