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

    // declaring class variables
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

    /**
     * Checks if the heap is empty.
     * @return true/false
     */
    public boolean isEmpty() {
        return heapSize == 0;
    }

    /**
     * Get the top element of the heap.
     * @return top element of the heap.
     */
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

    /**
     * Swaps 2 elements in the array.
     * @param indexA index of the first element.
     * @param indexB index of the second element.
     */
    private void swap(int indexA, int indexB) {
        int temp = heap[indexA];
        heap[indexA] = heap[indexB];
        heap[indexB] = temp;
    }

    /**
     * Checks if a child element breaks the heap.
     * If this is a max heap, it checks if the child is greater than the parent.
     * If this is a min heap, it checks if ths child is lower than the parent.
     * @param child child element
     * @param parent parent element
     * @return true if child breaks the heap
     */
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
        heapifyDown(0);
        return temp;
    }

    /**
     * Given a tree that is a heap except for node i,
     * This method arranges node i and it’s subtrees to satisfy the heap property.
     * @param i
     */
    private void heapifyDown(int i) {
        int top;
        int l = left(i);
        int r = right(i);
        // If the left node exists and it breaks the heap that the node i is its parent, left node should be top
        if (l <= heapSize - 1 && breaks(heap[l], heap[i])) {
            top = l;
        } else {
            top = i;
        }
        // If the right node exists and it breaks the heap that the node i is its parent, right node should be top
        if (r <= heapSize - 1 && breaks(heap[r], heap[top])) {
            top = r;
        }
        // If the top is not the i, swap
        if (top != i) {
            swap(i, top);
            heapifyDown(top);
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


