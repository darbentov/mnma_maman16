/**
 * This class represents a MinHeap object
 *
 * @author Dar Ben-Tov & David Dadon.
 * @version (2018)
 */
class MinHeap extends Heap {
    MinHeap(int size){
        super(size);
        heapType = MIN;
    }
}