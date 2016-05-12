import java.util.Arrays;

class Heap {
  private final int CAPACITY = 2;

  protected int size;
  protected int[] heap;

  public Heap() {
    size = 0;
    heap = new int[CAPACITY];
  }

  public Heap(int[] array) {
    size = array.length;
    heap = new int[array.length + 1];
    System.arraycopy(array, 0, heap, 1, array.length);
  }

  public int size() {
    return size;
  }

  public int[] resize() {
    return Arrays.copyOf(heap, heap.length + 1);
  }

  public boolean hasParent(int i) {
    return i > 1;
  }

  public int leftIndex(int i) {
    return i * 2;
  }

  public int rightIndex(int i) {
    return i * 2 + 1;
  }

  public boolean hasLeftChild(int i) {
    return leftIndex(i) <= size;
  }

  public boolean hasRightChild(int i) {
    return rightIndex(i) <= size;
  }

  public int parentIndex(int i) {
    return i / 2;
  }

  public int parent(int i) {
    return heap[parentIndex(i)];
  }



  public int swap(int index1, int index2) {
    int temp = heap[index1];
    heap[index1] = heap[index2];
    heap[index2] = temp;
    return 1;
  }

  public int insert(int[] data) {
    int count = 0;
    for(int i = 0; i < data.length; i++) {
      if (size >= heap.length - 1) {
        heap = this.resize();
      }

      size++;
      heap[size] = data[i];
      count += percolateUp(size);
    }

    return count;
  }

  public int percolateUp(int index) {
    int compare = index;
    int swapCount = 0;

    while (hasParent(compare) && parent(compare) < heap[compare]) {
      //System.out.println("perc");
      swapCount += swap(compare, parentIndex(compare));
      compare = parentIndex(compare);
    }
    return swapCount;
  }

  public int heapify() {
    int count = 0;
    for (int i = size() / 2; i >= 1; i--) {
      count += percolateDown(i);
    }

    return count;
  }

  public int percolateDown(int index) {
    int compare = index;
    int swapCount = 0;
    while (compare < size) {
      if (hasRightChild(compare)) {
        if (heap[leftIndex(compare)] > heap[rightIndex(compare)]) {
          if (heap[compare] < heap[leftIndex(compare)]) {
            swapCount += swap(compare, leftIndex(compare));
            compare = leftIndex(compare);
          } else {
            break;
          }
        } else {
          if (heap[compare] < heap[rightIndex(compare)]) {
            swapCount += swap(compare, rightIndex(compare));
            compare = rightIndex(compare);
          } else {
            break;
          }
        }
      } else if (hasLeftChild(compare)) {
        if (heap[compare] < heap[leftIndex(compare)]) {
          swapCount += swap(compare, leftIndex(compare));
          compare = leftIndex(compare);
        } else {
          break;
        }
      } else {
        break;
      }
    }

    return swapCount;
  }

  public void removal() {
    if (size == 0) return;
    if (size >= 1) {
      int pointer = heap.length - 1;
      heap[1] = heap[pointer];
      int[] newHeap = new int[heap.length - 1];
      System.arraycopy(heap, 1, newHeap, 1, newHeap.length - 1);
      heap = newHeap;
      size--;
      heapify();
    }
  }

}
