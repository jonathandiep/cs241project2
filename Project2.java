import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class Project2 {
  public static void main(String args[]) {
    System.out.println("Please select how to test the program:");
    System.out.println("(1) 20 sets of 100 randomly generated integers");
    System.out.println("(2) Fixed integer values 1-100");
    System.out.print("Enter choice: ");
    Scanner sc = new Scanner(System.in);
    int input = sc.nextInt();
    System.out.println();
    if (input == 1) {
      randomInts();
    } else if (input == 2) {
      fixedInts();
    }
  }

  static void randomInts() {
    int[] insertionCount = new int[20];
    int[] optimalCount = new int[20];

    for (int i = 0; i < 20; i++) {
      int[] rands = new int[100];
      for (int j = 0; j < 100; j++) {
        rands[j] = randInt();
      }
      Heap insert = new Heap();
      insertionCount[i] = insert.insert(rands);
      Heap optimal = new Heap(rands);
      optimalCount[i] = optimal.heapify();
    }

    int insertTotal = 0;
    int optimalTotal = 0;
    for (int n : insertionCount) insertTotal += n;
    for (int n : optimalCount) optimalTotal += n;
    double insertAvg = insertTotal / insertionCount.length;
    double optimalAvg = optimalTotal / optimalCount.length;

    System.out.println("Average swaps for series of insertions: " + insertAvg);
    System.out.println("Average swaps for optimal method: " + optimalAvg);

  }

  static void fixedInts() {
    int[] inc = new int[100];
    for (int i = 1; i <= 100; i++) {
      inc[i - 1] = i;
    }

    Heap insert = new Heap();
    System.out.println("Series of Insertions");
    System.out.println("Number of Swaps: " + insert.insert(inc));
    StringBuilder insertDisplay = new StringBuilder();
    for (int i = 1; i < insert.heap.length; i++) {
      insertDisplay.append(insert.heap[i]);
      if (i + 1 != insert.heap.length) insertDisplay.append(", ");
    }
    System.out.println("Heap result: " + insertDisplay.toString());
    System.out.println();
    for (int i = 0; i < 10; i++) {
      insert.removal();
    }
    StringBuilder insertRemoval = new StringBuilder();
    for (int i = 1; i < insert.heap.length; i++) {
      insertRemoval.append(insert.heap[i]);
      if (i + 1 != insert.heap.length) insertRemoval.append(", ");
    }
    System.out.println("Heap after 10 removals: " + insertRemoval.toString());
    System.out.println();
    System.out.println();


    Heap optimal = new Heap(inc);
    System.out.println("Optimal Method");
    System.out.println("Number of Swaps: " + optimal.heapify());
    StringBuilder optimalDisplay = new StringBuilder();
    for (int i = 1; i < optimal.heap.length; i++) {
      optimalDisplay.append(optimal.heap[i]);
      if (i + 1 != optimal.heap.length) optimalDisplay.append(", ");
    }
    System.out.println("Heap result: " + optimalDisplay.toString());
    System.out.println();
    for (int i = 0; i < 10; i++) {
      optimal.removal();
    }
    StringBuilder optimalRemoval = new StringBuilder();
    for (int i = 1; i < optimal.heap.length; i++) {
      optimalRemoval.append(optimal.heap[i]);
      if (i + 1 != optimal.heap.length) optimalRemoval.append(", ");
    }
    System.out.println("Heap after 10 removals: " + optimalRemoval.toString());


  }

  static int randInt() {
    Random rand = new Random();
    int randNum = rand.nextInt((100 - 1) + 1) + 1;
    return randNum;
  }
}
