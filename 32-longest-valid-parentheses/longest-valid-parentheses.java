class Solution {
    public int longestValidParentheses(String s) {
        int maxLen = 0;
        Stack<Integer> stack = new Stack<>();
        
        // Push -1 onto the stack as a base for the first valid substring
        stack.push(-1);
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                // Store the index of the opening bracket
                stack.push(i);
            } else {
                // It's a closing bracket: pop the last opening bracket
                stack.pop();
                
                if (stack.isEmpty()) {
                    // If empty, this ')' is unmatched. 
                    // Push its index as the new base for future valid strings.
                    stack.push(i);
                } else {
                    // Calculate the length: current index minus the index 
                    // of the character before the current valid substring started.
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        
        return maxLen;
    }
}
