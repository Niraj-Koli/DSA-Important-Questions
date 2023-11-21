/*
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the
 * Fibonacci sequence, such that each number is the sum of the two preceding
 * ones, starting from 0 and 1. That is,
 * 
 * F(0) = 0, F(1) = 1
 * F(n) = F(n - 1) + F(n - 2), for n > 1.
 * Given n, calculate F(n).
 */

import java.util.HashMap;

public class FibonacciNumber {

    // 2D Array -> Iterative //

    public static int fibIterative(int n) {
        if (n <= 1) {
            return n;
        }

        int[] t = new int[n + 1];

        t[0] = 0;
        t[1] = 1;

        for (int i = 2; i <= n; i++) {
            t[i] = t[i - 1] + t[i - 2];
        }

        return t[n];
    }

    // 2D Array -> Recursive //

    private static int[] t;

    public static int fibRecursive(int n) {
        t = new int[n + 1];

        return calculateFibonacci(n);
    }

    private static int calculateFibonacci(int n) {
        if (n <= 1) {
            t[n] = n;

            return t[n];
        }

        if (t[n] != 0) {
            return t[n];
        }

        t[n] = calculateFibonacci(n - 1) + calculateFibonacci(n - 2);

        return t[n];
    }

    // Map -> Recursive //

    public static HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();

    public static int fib(int n) {
        if (n <= 1) {
            return n;
        }

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        int fibValue = fib(n - 1) + fib(n - 2);
        memo.put(n, fibValue);

        return fibValue;
    }

    public static void main(String[] args) {
        int n = 5;

        int answer = fibRecursive(n);

        System.out.println(answer);
    }
}

// class Solution {
// public int fib(int n) {
// int a = 0, b = 1, c = 0;
// if (n == 0)
// return 0;
// else if (n == 1)
// return 1;
// else {
// for (int i = 2; i <= n; i++) {
// c = a + b;
// a = b;
// b = c;
// }
// return c;
// }
// }
// }