public class Heap {
    int[] table;
    int size;

    public Heap(int heapSize) {
        this.table = new int[heapSize+1];
        this.size = 0;
    }

    public void add(int in) {
	if(this.size >= this.table.length) return;
	this.table[++size] = in;
	int position = this.size;
	while( (position / 2) > 0 && this.table[position / 2] < in){
		int temp = this.table[position/2];
		this.table[position/2] = in;
		this.table[position] = temp;
		position /= 2;

	}
    }

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

    public int[] getTable() { return this.table; }

    public static void main(String[] args) {
	    Heap h = new Heap(6);
	    h.add(2);
	    h.add(1);
	    h.add(4);
	    h.add(3);
	    h.add(5);
	    h.add(2);
	    h.delete(1);

	    int [] tab = h.getTable();

	    System.out.println(String.format("Root: %d, Child1: %d, Child2: %d, Child11: %d, Child12: %d, Child21: %d",
				    tab[1], tab[2], tab[3], tab[4], tab[5], tab[6]));


    }
}
