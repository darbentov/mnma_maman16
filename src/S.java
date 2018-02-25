public class S {
    // Constants
    private final static int sizeOffset = 2;

    // Declaring class variables
    private MaxHeap h1;
    private MinHeap h2;

    S(int size) {
        /*
        Initializing 2 Heaps, with half of the total size + offset that can be caused during the insert.
         */
        h1 = new MaxHeap(size / 2 + sizeOffset);
        h2 = new MinHeap(size / 2 + sizeOffset);
    }

    /**
    Insert an element to the DS.
     */
    public void insert(int z) {
        if (h1.isEmpty()) {
            h1.insert(z);
        } else if (z < h1.getTop()) {
            h1.insert(z);
        } else {
            h2.insert(z);
        }
        if (h2.heapSize > h1.heapSize) {
            balance(h2, h1);
        } else if (h1.heapSize - h2.heapSize > 1) {
            balance(h1, h2);
        }
    }

    private void balance(Heap source, Heap target) {
        int temp = source.extractTop();
        target.insert(temp);
    }

    /**
     * Print the median of the DS
     */
    public void printMedian() {
        System.out.println(h1.getTop());
    }

    public String toString() {
        return h1.toString() + ' ' + h2.toString();
    }
}
