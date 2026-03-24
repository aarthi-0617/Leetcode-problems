class Solution {
    public double myPow(double x, int n) {
        // Use a long to avoid overflow when converting Integer.MIN_VALUE to positive
        long N = n;
        
        // Handle negative power
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        
        return binaryPow(x, N);
    }

    private double binaryPow(double x, long n) {
        if (n == 0) return 1.0;
        
        // Recursively compute half the power
        double half = binaryPow(x, n / 2);
        
        if (n % 2 == 0) {
            // If n is even: x^n = (x^(n/2))^2
            return half * half;
        } else {
            // If n is odd: x^n = (x^(n/2))^2 * x
            return half * half * x;
        }
    }
}
