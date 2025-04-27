class Solution {
    public static void PrintStack(Stack<Integer> s) 
{ 
     
    // If stack is empty 
    if (s.empty()) 
        return; 
   
    // Extract top of the stack 
    int x = s.peek(); 
   
    // Pop the top element 
    s.pop(); 
   
    // Print the current top 
    // of the stack i.e., x 
    System.out.print(x + " ");
   
    // Proceed to print 
    // remaining stack 
    PrintStack(s); 
   
    // Push the element back 
    s.push(x); 
} 
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;

        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int height = heights[stack.pop()];
                //int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, height * (stack.isEmpty() ? i : i - stack.peek() - 1));
            }

            stack.push(i);
        }
        System.out.println(max);
        PrintStack(stack); 
        while (!stack.isEmpty()) {
            int height = heights[stack.pop()];
            //int width = stack.isEmpty() ? heights.length : heights.length - stack.peek() - 1;
            max = Math.max(max, height * (stack.isEmpty() ? heights.length : heights.length - stack.peek() - 1));
            //System.out.println(max);
        }

        return max;
    }
}
