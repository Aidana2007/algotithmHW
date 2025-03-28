import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.print("Enter task number (1-10) or 0 to exit: ");
            int task = sc.nextInt();
            if (task == 0) break;

            long startTime = System.nanoTime();
            switch (task) {
                case 1 -> task1();
                default -> System.out.println("Invalid task number.");
            }
            long endTime = System.nanoTime();

            System.out.println("Execution Time: " + (endTime - startTime) / 1_000_000.0 + " ms");
        }
    }

    private static void task1() {
        System.out.print("Enter the number of elements in the array: ");
        int n = sc.nextInt();

        if (n == 0) {
            System.out.println("The array is empty");
            return;
        }

        int[] arr = new int[n];
        System.out.println("Enter the elements in the array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int min = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        System.out.println("The minimum element is " + min);
        System.out.println("Time Complexity: O(n)");
    }
}
