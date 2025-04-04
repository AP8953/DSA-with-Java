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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if(root==null) return null;
        int leftHeight=calHeight(root.left);
        int rightHeight=calHeight(root.right);
        if(leftHeight==rightHeight) return root;
        else{
            if(leftHeight>rightHeight) return lcaDeepestLeaves(root.left);
            else return lcaDeepestLeaves(root.right);
        }
    }
    private int calHeight(TreeNode root){
        if(root==null) return 0;
        return 1+Math.max(calHeight(root.left), calHeight(root.right));
    }
}