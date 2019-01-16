public class Heap {
	private int[] heap;
	private int size;
	private int end = 0;

	Heap(int size) {
		this.heap = new int[size];
		this.size = size;
	}

	public void add(int value) {
		this.heap[++end] = value;
		heapUp(end);
	}

    public void heapUp(int index) {
	int position = index;
	while( (position / 2) > 0 && heap[position / 2] < heap[position] ){
            int temp = heap[position/2];
	    heap[position/2] = heap[position];
	    heap[position] = temp;
	    position /= 2;
		}
	}

    public boolean delete(int index) {
        if(index > this.end || index < 1) return false;
        if(index == this.end) {
            end--;
            return true;
        }
        this.heap[index] = this.heap[this.end]; 
        size--;
        heapUp(index);
        return true;

    private void heapDown(int index) {
        int child = 2 * index;
        while(child < this.end){
            if(child + 1 > this.end && this.heap[child + 1] > this.heap[child])
                child++;
            if(this.heap[child] <= this.heap[index]) return;
            int tmp = heap[child];
            heap[child] = heap[index];
            heap[index] = tmp
            index = child;
            child = index * 2;
        }
    }

    public static void Sort(int[] v) {
        BuildHeap(v, v.length
        for (int i = v.length - 1; i > 0; i--)
        {
            Swap(v, 0, i);
            ShiftDown(v, i, 0);
        }
    }

    private static void BuildHeap(int[] v, int n) {
        for (int i = n / 2; i >= 0; i--)
            ShiftDown(v, n, i);

    }

    private static void Swap(int[] v, int i, int j) {
        int temp = v[i];
        v[i] = v[j];
        v[j] = temp;
    }

    public static void main(String [] args) throws InterruptedException {
        Random r = new Random();
        int n = 50;
        int max = 100;
        int [] v = new int [n];
        for(int i = 0; i < n; i++){
            v[i] = r.nextInt() % max;
        }
        Sort(v);
        for(int x : v)
            System.out.print(x + ", ");
    }
}


