import java.util.Arrays;

class Project2 {
  public static void main(String args[]) {
    Integer[] inc = new Integer[100];
    for (Integer i = 1; i <= 100; i++) {
      inc[i - 1] = i;
    }
    Heap heapInc = new Heap(inc);
    System.out.println("optimal");
    System.out.println("#: " + heapInc.heapify());
    System.out.println(Arrays.toString(heapInc.heap));
    for (int i = 0; i < 10; i++) {
      heapInc.removal();
    }
    System.out.println(Arrays.toString(heapInc.heap));
    System.out.println();
    System.out.println();

    Integer[] arr = {11, 24, 3, 47, 57, 86, 37, 15, 90, 10};
    Heap test = new Heap();
    System.out.println("series of insertions");
    System.out.println("#: " + test.insert(inc));
    System.out.println(Arrays.toString(test.heap));
    for (int i = 0; i < 10; i++) {
      test.removal();
    }
    System.out.println(Arrays.toString(test.heap));
  }
}

/*

todo:
- create cli
- create 20 sets of 100 randomly generated integers
  - array of arrays?
- get avg swaps for series of insertions
- get avg swaps for optimal method

*/
