import java.util.Stack;

class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (!stack.isEmpty() && stack.peek() == '(') {
                stack.pop(); // Valid pair found, remove the opening parenthesis
            } else {
                stack.push(c); // Push the unmatched closing parenthesis
            }
        }
        return stack.size(); // Remaining elements in the stack are unmatched parentheses
    }
}
