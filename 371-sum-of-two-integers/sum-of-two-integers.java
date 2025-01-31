class Solution {
    public int getSum(int a, int b) {
       while (b != 0) {
            int carry = (a & b) << 1; // Compute carry
            a = a ^ b; // Compute sum without carry
            b = carry; // Assign carry for next iteration
        }
        return a; 
    }
}