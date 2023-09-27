//Extend the Sieve of Eratosthenes to find the two consecutive primes
// that have highest difference.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Adjust the value of 'n' as needed, this is the upper limit for prime searching
        Scanner scr = new Scanner(System.in);
        int n = scr.nextInt();
        int[] primes = sieveOfEratosthenes(n);

        int maxDifference = 0;
        int prime1 = 0;
        int prime2 = 0;

        for (int i = 2; i < primes.length - 1; i++) {
            if (primes[i] == 1) {
                int currentPrime = i;
                int nextPrime = i + 1;

                if (nextPrime < primes.length && primes[nextPrime] == 1) {
                    int difference = nextPrime - currentPrime;
                    if (difference > maxDifference) {
                        maxDifference = difference;
                        prime1 = currentPrime;
                        prime2 = nextPrime;
                    }
                }
            }
        }

        System.out.println("Consecutive Primes with Highest Difference: " + prime1 + " and " + prime2);
        System.out.println("Difference: " + maxDifference);
    }

    // Sieve of Eratosthenes implementation
    public static int[] sieveOfEratosthenes(int n) {
        int[] primes = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            primes[i] = 1; // Mark all numbers as potential primes
        }

        for (int p = 2; p * p <= n; p++) {
            if (primes[p] == 1) {
                for (int i = p * p; i <= n; i += p) {
                    primes[i] = 0; // Mark multiples as non-prime
                }
            }
        }

        return primes;
    }
}