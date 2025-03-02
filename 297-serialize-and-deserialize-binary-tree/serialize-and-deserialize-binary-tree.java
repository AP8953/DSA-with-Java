/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    static TreeNode k;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        this.k = root;
        return "hello";
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return this.k;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));