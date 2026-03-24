class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Map to store the last seen index of each character
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int left = 0; // Left boundary of the sliding window

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // If we've seen this character and it's inside our current window
            if (map.containsKey(currentChar)) {
                // Move the left boundary to the right of the previous occurrence
                left = Math.max(left, map.get(currentChar) + 1);
            }

            // Update the last seen index of the character
            map.put(currentChar, right);

            // Calculate the current window size and update max
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
