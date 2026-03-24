class Solution {
    public int lengthOfLastWord(String s) {
        // Trim trailing and leading spaces
        s = s.trim();
        
        // Find the index of the last space in the trimmed string
        int lastSpaceIndex = s.lastIndexOf(' ');
        
        // The length is the total length minus the index of the last space
        // If no space is found, lastIndex is -1, so length - (-1) gives full string length
        return s.length() - lastSpaceIndex - 1;
    }
}
