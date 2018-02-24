/**
 * This class represents a Heap object
 *
 * @author Dar Ben-Tov & David Dadon.
 * @version (2018)
 */

import java.util.Arrays;

public class Heap {
    // setting constants;
    final static int MAX = 0;
    final static int MIN = 1;
    final private static int defaultSize = 10;
    int heapType;
    public int heapSize;
    private int[] heap;
    // Constructors

    /**
     * creates a new Heap object
     */
    Heap(int size) {
        heapSize = 0;
        heap = new int[size];
    }

    /**
     * creates a new Heap object with default size
     */
    Heap() {
        this(defaultSize);
    }

    public boolean isEmpty() {
        return heapSize == 0;
    }

    public int getTop() {
        return isEmpty() ? 0 : heap[0];
    }

    /**
     * Propagate up the element of the current index if it breaks the heap
     */
    private void heapifyUp(int index) {
        if (index != 0) {
            int parentIndex = index / 2;
            if (breaks(heap[index], heap[parentIndex])) {
                swap(index, parentIndex);
                heapifyUp(parentIndex);
            }
        }
    }

    private void swap(int index, int parentIndex) {
        int temp = heap[index];
        heap[index] = heap[parentIndex];
        heap[parentIndex] = temp;
    }

    private boolean breaks(int child, int parent) {
        if (heapType == MAX) {
            return child > parent;
        } else {
            return child < parent;
        }
    }

    /**
     * Insert an element to the heap
     */
    public void insert(int z) {
        heap[heapSize] = z;
        heapifyUp(heapSize);
        heapSize++;
    }

    public int extractTop() {
        int temp = heap[0];
        heap[0] = heap[heapSize - 1];
        heap[heapSize - 1] = 0;
        heapSize--;
        topHeapify(0);
        return temp;
    }

    private void topHeapify(int index) {
        int top;
        int l = left(index);
        int r = right(index);
        if (l <= heapSize && breaks(heap[l], heap[index])) {
            top = l;
        } else {
            top = index;
        }
        if (r <= heapSize && breaks(heap[r], heap[top])) {
            top = r;
        }
        if (top != index) {
            swap(index, top);
            topHeapify(top);
        }
    }

    private int left(int index) {
        return index * 2 + 1;
    }

    private int right(int index) {
        return index * 2 + 2;
    }

    public String toString() {
        return Arrays.toString(heap);
    }


}// end of class Heap


