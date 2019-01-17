import java.util.Random;

public class Heap {
	private int[] heap;
	private int size;
	private int end = 0;

	Heap(int size) {
		this.heap = new int[size+1];
		this.size = size;
	}

	public void add(int value) {
        if(this.end  > this.size - 1) return;
		this.heap[++this.end] = value;
		heapUp(this.heap, this.end);
	}

    public static void heapUp(int[] v, int index) {
	while( (index / 2) > 0 && v[index / 2] < v[index] ){
	    swap(v, index, index / 2);
        index /= 2;
		}
	}

    public void delete() {
        if(this.end == 1) {
            end--;
            return;
        }
        this.heap[1] = this.heap[this.end];
        this.end--;
        heapDown(this.heap, this.end, 1);
        return;
    }

    public static void heapDown(int[] v, int size, int index) {
        int child = 2 * index;
        while(child < size){
            if(child + 1 < size && v[child + 1] > v[child])
                child++;
            if(v[child] <= v[index]) return;
            swap(v, index, child);
            index = child;
            child = index * 2;
        }
    }

    public static void sort(int[] v) {
        buildHeap(v, v.length);
        for (int i = v.length - 1; i > 0; i--)
        {
            swap(v, 0, i);
            heapDown(v, i, 0);
        }
    }

    private static void buildHeap(int[] v, int n) {
        for (int i = n / 2; i >= 0; i--)
            heapDown(v, n, i);

    }

    private static void swap(int[] v, int i, int j) {
        int temp = v[i];
        v[i] = v[j];
        v[j] = temp;
    }

    public void showHeap(){
        for(int i = 1; i <= this.end; i++) {
            System.out.print(this.heap[i] + ", ");
        }
        System.out.println("");
    }

    public static void main(String [] args) throws InterruptedException {
        Heap heap = new Heap(10);
        heap.add(1);
        heap.add(2);
        heap.add(3);
        heap.showHeap();
        heap.add(5);
        heap.add(4);
        heap.showHeap();
        heap.delete();
        heap.showHeap();
        heap.delete();
        heap.showHeap();
        Random r = new Random();
        int n = 50;
        int max = 100;
        int [] v = new int [n];
        for(int i = 0; i < n; i++){
            v[i] = r.nextInt() % max;
        }
        sort(v);
        for(int x : v)
            System.out.print(x + ", ");
    }
}


