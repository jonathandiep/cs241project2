import java.util.Arrays;

class Heap {
  private final Integer CAPACITY = 2;

  protected Integer size;
  protected Integer[] heap;

  public Heap() {
    size = 0;
    heap = new Integer[CAPACITY];
  }

  public Heap(Integer[] array) {
    size = array.length;
    heap = new Integer[array.length + 1];
    System.arraycopy(array, 0, heap, 1, array.length);
  }

  public Integer size() {
    return size;
  }

  public Integer[] resize() {
    return Arrays.copyOf(heap, heap.length + 1);
  }

  public boolean hasParent(Integer i) {
    return i > 1;
  }

  public Integer leftIndex(Integer i) {
    return i * 2;
  }

  public Integer rightIndex(Integer i) {
    return i * 2 + 1;
  }

  public boolean hasLeftChild(Integer i) {
    return leftIndex(i) <= size;
  }

  public boolean hasRightChild(Integer i) {
    return rightIndex(i) <= size;
  }

  public Integer parentIndex(Integer i) {
    return i / 2;
  }

  public Integer parent(Integer i) {
    return heap[parentIndex(i)];
  }



  public int swap(Integer index1, Integer index2) {
    Integer temp = heap[index1];
    heap[index1] = heap[index2];
    heap[index2] = temp;
    return 1;
  }

  public void insert(Integer data) {
    if (size >= heap.length - 1) {
      heap = this.resize();
    }

    size++;
    heap[size] = data;
    percolateUp(size);
  }

  public void percolateUp(int index) {
    int compare = index;

    while (hasParent(compare) && parent(compare) < heap[compare]) {
      System.out.println("perc");
      swap(compare, parentIndex(compare));
      compare = parentIndex(compare);
    }
  }

  public void heapify() {
    for (int i = size() / 2; i >= 1; i--) {
      percolateDown(i);
    }
  }

  public void percolateDown(int index) {
    int compare = index;

    while (compare < size) {
      if (hasRightChild(compare)) {
        if (heap[leftIndex(compare)] > heap[rightIndex(compare)]) {
          if (heap[compare] < heap[leftIndex(compare)]) {
            swap(compare, leftIndex(compare));
            compare = leftIndex(compare);
          } else {
            break;
          }
        } else {
          if (heap[compare] < heap[rightIndex(compare)]) {
            swap(compare, rightIndex(compare));
            compare = rightIndex(compare);
          } else {
            break;
          }
        }
      } else if (hasLeftChild(compare)) {
        if (heap[compare] < heap[leftIndex(compare)]) {
          swap(compare, leftIndex(compare));
          compare = leftIndex(compare);
        } else {
          break;
        }
      } else {
        break;
      }
    }

  }

  /*

  need to count # of swaps

  public boolean removal() {

  }

  */
}
