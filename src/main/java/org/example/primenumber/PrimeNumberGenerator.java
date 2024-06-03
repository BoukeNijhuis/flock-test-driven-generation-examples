package org.example.primenumber;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumberGenerator {
    public List<Integer> generate(int n) {
        if (n < 2) {
            throw new RuntimeException("Input must be positive");
        }
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            boolean isPrime = true;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes.add(i);
            }
        }
        return primes;
    }
}