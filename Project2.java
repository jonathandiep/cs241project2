import java.util.Arrays;

class Project2 {
  public static void main(String args[]) {
    Integer[] arr = {11, 24, 3, 47, 57, 86, 37, 15, 90, 10};
    Integer[] inc = new Integer[100];
    for (Integer i = 1; i <= 100; i++) {
      inc[i - 1] = i;
    }
    Heap heapInc = new Heap(inc);
    heapInc.heapify();
    System.out.println(Arrays.toString(heapInc.heap));
    Heap test = new Heap(arr);
    System.out.println(Arrays.toString(test.heap));
    test.heapify();
    System.out.println(Arrays.toString(test.heap));
    Heap empty = new Heap();
    empty.insert(1);
    System.out.println(empty.hasParent(1));
    empty.insert(2);
    empty.insert(3);
    empty.insert(4);
    empty.insert(5);
    System.out.println(Arrays.toString(empty.heap));
  }
}
