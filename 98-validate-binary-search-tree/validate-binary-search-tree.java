/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
       return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean helper(TreeNode node, long lowerLimit, long upperLimit) {
        if (node == null) return true; // Empty tree is valid
        
        if (node.val <= lowerLimit || node.val >= upperLimit) {
            return false; // Current node violates the BST rule
        }
        
        // Left subtree: max allowed value is current node's value
        // Right subtree: min allowed value is current node's value
        return helper(node.left, lowerLimit, node.val) &&
               helper(node.right, node.val, upperLimit); 
    }
}