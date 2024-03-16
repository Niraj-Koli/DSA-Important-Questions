public class FibonacciNumber {

    // Time -> O(2^n) //
    // Space -> O(n) //

    private static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        int n = 5;

        System.out.println(fibonacci(n));
    }
}
