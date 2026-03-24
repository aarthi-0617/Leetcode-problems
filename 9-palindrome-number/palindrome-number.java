class Solution {
    public boolean isPalindrome(int x) {
        // Base cases: 
        // 1. Negative numbers are not palindromes.
        // 2. If the last digit is 0, the first digit must be 0 (only happens with 0).
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        // Reverse only half of the number
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // For even-length numbers: x == revertedNumber (e.g., 1221 -> x: 12, reverted: 12)
        // For odd-length numbers: x == revertedNumber / 10 (e.g., 121 -> x: 1, reverted: 12)
        return x == revertedNumber || x == revertedNumber / 10;
    }
}
