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
    int capacity;
    public int heapSize;
    private int[] heap;


    // Constructors
    /**
     * creates a new Heap object
     */
    Heap(int size) {
        heapSize = 0;
        heap = new int[size];
        capacity = size;
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
        if (index != 0) { // If the given index is not the top index
            int parentIndex = parent(index); // Get the parent index
            if (breaks(heap[index], heap[parentIndex])) { // If the child breaks the Heap Property
                swap(index, parentIndex); // Swap between child and parent.
                heapifyUp(parentIndex); // Run heapifyUp on parent index.
            }
        }
    }

    private int parent(int index) {
        return index / 2;
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
            // If heapType is Max, the child breaks the Heap if it is greater than it's parent.
            return child > parent;
        } else {
            // If heapType is Min, the child breaks the Heap if it is lower than it's parent.
            return child < parent;
        }
    }

    /**
     * Insert an element to the heap
     */
    public void insert(int z) {
        if (heapSize >= capacity){
            throw new ArrayIndexOutOfBoundsException("The heap has reached its capacity.");
        }
        heap[heapSize] = z;
        heapifyUp(heapSize);
        heapSize++;
    }

    /**
     * Extract the top element of the Heap.
     * @return the top element of the Heap.
     */
    public int extractTop() {
        int temp = heap[0]; // put the top element on temp
        heap[0] = heap[heapSize - 1]; // put the last element of the Heap as the top element.
        heapSize--; // Reduce the size of the Heap.
        heapifyDown(0); // Fix the Heap by running heapifyDown algorithm, with 0 as the index.
        return temp;
    }

    /**
     * Given a tree that is a heap except for node i,
     * This method arranges node i and it’s subtrees to satisfy the heap property.
     * The algorithm matches the algorithm that has been taught in the book.
     * @param i
     */
    private void heapifyDown(int i) {
        int top;
        int l = left(i);
        int r = right(i);
        // If the left node exists and it breaks the heap that the node i is its parent, left node should be top
        if (exists(l) && breaks(heap[l], heap[i])) {
            top = l;
        } else {
            top = i;
        }
        // If the right node exists and it breaks the heap that the node i is its parent, right node should be top
        if (exists(r) && breaks(heap[r], heap[top])) {
            top = r;
        }
        // If the top is not the i, swap
        if (top != i) {
            swap(i, top);
            heapifyDown(top);
        }
    }

    private boolean exists(int index) {
        return index <= heapSize - 1;
    }

    /**
     * Calculate the left child index of the given index
     * @param index The index of parent node.
     * @return The left child index of the parent node.
     */
    private int left(int index) {
        return index * 2 + 1;
    }

    /**
     * Calculate the right child index of the given index
     * @param index The index of parent node.
     * @return The right child index of the parent node.
     */
    private int right(int index) {
        return index * 2 + 2;
    }

    /**
     * Converts the Heap to string, by extracting the array by HeapSize.
     * @return
     */
    public String toString() {
        return Arrays.toString(Arrays.copyOfRange(heap, 0, heapSize));
    }


}// end of class Heap


