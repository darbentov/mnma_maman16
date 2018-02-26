public class S {
    // Constants
    private final static int sizeOffset = 2;

    // Declaring class variables
    private MaxHeap hMax;
    private MinHeap hMin;

    /**
     * Initializing 2 Heaps, with half of the total size + offset that can be caused during the insert.
     * @param size The size of the heap.
     */
    S(int size) {
        hMax = new MaxHeap(size / 2 + sizeOffset);
        hMin = new MinHeap(size / 2 + sizeOffset);
    }

    /**
     Insert an element to the DS.
     Algorithm is described in the Doc file attached.
     */
    public void insert(int z) {
        if (hMax.isEmpty()) {
            hMax.insert(z);
        } else if (z < hMax.getTop()) {
            hMax.insert(z);
        } else {
            hMin.insert(z);
        }
        if (hMin.heapSize > hMax.heapSize) {
            balance(hMin, hMax);
        } else if (hMax.heapSize - hMin.heapSize > 1) {
            balance(hMax, hMin);
        }
    }

    /**
     * Extracts the top of the source Heap and puts it in the target Heap, to balance between heaps.
     * @param source The Heap to extract the top from.
     * @param target The Heap to insert the extracted top to.
     */
    private void balance(Heap source, Heap target) {
        int temp = source.extractTop();
        target.insert(temp);
    }

    /**
     * Print the median of the DS
     */
    public void printMedian() {
        System.out.println(hMax.getTop());
    }

    public String toString() {
        return "MaxHeap: " + hMax.toString() + ", MinHeap: " + hMin.toString();
    }
}
