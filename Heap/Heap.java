public class Heap {
    public static void heapUp(int[] heap, int n) {
	int position = n;
	while( (position / 2) > 0 && heap[position / 2] < heap[position] ){
            int temp = heap[position/2];
	    heap[position/2] = heap[position];
	    heap[position] = temp;
	    position /= 2;
	}
}
/*
    public int delete(int out) {
        int ret = table[out];   //return value
        int biggerGame = 0;     //zmienna przechowujaca indeks wiekszego dziecka
        int swap;               //zmienna do swap'owania
        table[out] = table[size--];     //w puste miejsce wrzucamy ostatni element kopca
        if (out == 1 || table[out / 2] > table[out]) {      //sprawdzamy czy bedziemy "sortowac" w gore lub w dol
            while ((out * 2 <= size) && table[out] < table[out * 2] || (out * 2 + 1 <= size) && table[out] < table[out * 2 + 1]) {      //sortujemy w dol tak dlugo az nie bedzie dzieci lub dzieci sa mniejsze od wstawionego elementu
                if (out * 2 + 1 <= size)    //jesli istnieje 2 dzieci to sprawdzamy ktory wiekszy
                    biggerGame = table[out * 2 + 1] >= table[out * 2] ? out * 2 + 1 : out * 2;  //instrukcja warunkowa uzyskujaca indeks wiekszego dziecka
                swap = table[biggerGame];   //swapujemy wieksze dziecko z wstawionym elementem
                table[biggerGame]=table[out];
                table[out]=swap;
                out=biggerGame;     //zmieniamy indeks na miejsce dziecka z ktorym sie zamienilismy
            }

        } else {    //sortowanie w gore
            while (out != 1 || table[out] > table[out / 2]) {   //jesli ojciec wiekszy od elementu wstawionego to zamieniamy
                swap = table[out];
                table[out] = table[out / 2];
                table[out / 2] = swap;
                out /= 2;       //przechodzimy pod indeks ojca
            }

        }
        return ret;     //zwrot usunietej wartosci
    }
*/
    public static void main(String[] args) {
	int [] heap = new int[7];
	heap[1] = 1;
	heap[2] = 2;
	heapUp(heap, 2);
	heap[3] = 1;
	heapUp(heap, 3);
	heap[4] = 4;
	heapUp(heap, 4);
	heap[5] = 3;
	heapUp(heap, 5);
	heap[6] = 5;
	heapUp(heap, 6);
        System.out.println(String.format("Root: %d, Child1: %d, Child2: %d, Child11: %d, Child12: %d, Child21: %d",
				    heap[1], heap[2], heap[3], heap[4], heap[5], heap[6]));
    }
}
