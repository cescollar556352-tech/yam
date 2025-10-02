package labb;

public class MinHeap {
    private EmergencyCase[] heap;
    private int size;
    private int capacity;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        heap = new EmergencyCase[capacity + 1]; // 1-indexed
    }

    private int parent(int i) { return i / 2; }
    private int left(int i) { return 2 * i; }
    private int right(int i) { return 2 * i + 1; }

    private void swap(int i, int j) {
        EmergencyCase temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private void resize() {
        capacity *= 2;
        EmergencyCase[] newHeap = new EmergencyCase[capacity + 1];
        for (int i = 1; i <= size; i++) {
            newHeap[i] = heap[i];
        }
        heap = newHeap;
        System.out.println("Heap resized to capacity: " + capacity);
    }

    public void insert(EmergencyCase e) {
        if (size >= capacity) {
            resize();
        }
        size++;
        heap[size] = e;
        int current = size;

        while (current > 1 && heap[current].priority < heap[parent(current)].priority) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public EmergencyCase extractMin() {
        if (size == 0) {
            System.out.println("No emergency cases available.");
            return null;
        }
        EmergencyCase root = heap[1];
        heap[1] = heap[size];
        size--;
        heapify(1);
        return root;
    }

    public EmergencyCase peek() {
        if (size == 0) {
            System.out.println("No emergency cases available.");
            return null;
        }
        return heap[1];
    }

    private void heapify(int i) {
        int left = left(i);
        int right = right(i);
        int smallest = i;

        if (left <= size && heap[left].priority < heap[smallest].priority) {
            smallest = left;
        }
        if (right <= size && heap[right].priority < heap[smallest].priority) {
            smallest = right;
        }
        if (smallest != i) {
            swap(i, smallest);
            heapify(smallest);
        }
    }

    public void display() {
        if (size == 0) {
            System.out.println("No cases in queue.");
            return;
        }
        System.out.println("Emergency Cases in Queue:");
        for (int i = 1; i <= size; i++) {
            System.out.println(heap[i]);
        }
    }
}

