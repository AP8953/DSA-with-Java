class Node{
    Node link[]=new Node[2];
    boolean containsKey(int index){
        return link[index]!=null;
    }
    Node get(int index){
        return link[index];
    }
    void put(int index, Node node){
        link[index]=node;
    }
}
class Trie{
    private static Node root;
    Trie(){
        root=new Node();
    }
    public static void insert(int num){
        Node node =root;
        for(int i=31;i>=0;i--){
            int bit=(num>>i)&1;
            if(!node.containsKey(bit)){
                node.put(bit, new Node());
            }
            node=node.get(bit);
        }
    }
    public int getMax(int num){
        Node node=root;
        int max=0;
        for(int i=31;i>=0;i--){
            int bit=(num>>i)&1;
            if(node.containsKey(1-bit)){
                max=max|(1<<i);
                node=node.get(1-bit);
            }
            else{
                node=node.get(bit);
            }
        }
        return max;
    }
}
class Solution {
    public int findMaximumXOR(int[] nums) {
        Trie trie= new Trie();
        for(int i=0;i<nums.length;i++){
            trie.insert(nums[i]);
        }
        int max=0;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max, trie.getMax(nums[i]));
        }
        return max;
    }
}