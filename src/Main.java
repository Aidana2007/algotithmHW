import java.util.Arrays;
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
                case 2 -> task2();
                case 3 -> task3();
                case 4 -> task4();
                case 5 -> task5();
                case 6 -> task6();
                case 7 -> task7();
                case 8 -> task8();
                case 9 -> task9();
                default -> System.out.println("Invalid task number.");
            }
            long endTime = System.nanoTime();

            System.out.println("Execution Time: " + (endTime - startTime) / 1_000_000.0 + " ms");
            // it converts nanoseconds to milliseconds
            // it calculates execution time
        }
    }

    private static void task1() {
        //it finds a minimum in the array
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
    private static void task2() {
        //it finds an average in the array
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

        // Calculate sum using loop
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        double average = (double) sum / n;
        System.out.println("The average is " + average);
        System.out.println("Time Complexity: O(n)");
    }

    private static void task3() {
        //find if a number is prime
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        if (n < 2) {
            System.out.println(n + " is Composite");
            return;
        }

        boolean isPrime = true; // Assume prime initially
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                isPrime = false;
                break; // if found a factor, no need to continue
            }
        }

        System.out.println(n + " is " + (isPrime ? "Prime" : "Composite"));
        System.out.println("Time Complexity: O(sqrt(n))");
    }
    private static void task4() {
        //uses recursion to find factorial of a number
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        System.out.println("Factorial: " + factorial(n));
        System.out.println("Time Complexity: O(n)");
    }

    private static int factorial(int n) {
        return (n <= 1) ? 1 : n * factorial(n - 1);
    }
    private static void task5(){
        //finds n-th element in Fibonacci sequence
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        System.out.println("Fibonacci: " + fibonacci(n));
        System.out.println("Time Complexity: O(2^n)");
    }

    private static int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    private static void task6() {
        //find a^n using recursion
        System.out.print("Enter base (a) and exponent (n): ");
        int a = sc.nextInt();
        int n = sc.nextInt();

        System.out.println("Result: " + power(a, n));
        System.out.println("Time Complexity: O(n)");
    }

    private static int power(int a, int n) {
        if (n == 0) return 1;      // a^0 = 1
        return a * power(a, n - 1);
    }
    static void task7() {
        //reverses give array
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        int[] arr = readArray(n);

        reverseArray(arr, 0);

        System.out.println("Reversed array: " + Arrays.toString(arr));
        System.out.println("Time Complexity: O(n)");
    }

    static void reverseArray(int[] arr, int i) {
        if (i >= arr.length / 2) return;
        int temp = arr[i];
        arr[i] = arr[arr.length - 1 - i];
        arr[arr.length - 1 - i] = temp;
        reverseArray(arr, i + 1);  // Recursive call for the next pair
    }

    static int[] readArray(int n) {
        int[] arr = new int[n];
        System.out.println("Enter the elements: ");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        return arr;
    }
    private static void task8() {
        System.out.print("Enter string: ");
        String s = sc.next();

        if (isAllDigits(s, 0)) {
            System.out.println("All digits: Yes");
        } else {
            System.out.println("All digits: No");
        }

        System.out.println("Time Complexity: O(n)");
    }

    private static boolean isAllDigits(String s, int i) {
        if (i == s.length()) return true;
        char c = s.charAt(i);
        if (c < '0' || c > '9') return false;  // Check if character is outside digit range
        return isAllDigits(s, i + 1);  // Recursive call for the next character
    }
    private static void task9() {
        //finds binomial coefficient
        System.out.print("Enter n and k: ");
        int n = sc.nextInt(), k = sc.nextInt();
        System.out.println("C(n, k): " + binomialCoefficient(n, k));
        System.out.println("Time Complexity: O(2^n)");
    }

    private static int binomialCoefficient(int n, int k) {
        if (k == 0 || k == n) return 1;
        return binomialCoefficient(n - 1, k - 1) + binomialCoefficient(n - 1, k);
    }
}

