class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, String word, int i, int j, int start){
        if(start==word.length()) return true;
        if(i<0||j<0||i>=board.length || j>=board[0].length || board[i][j]!=word.charAt(start)){
            return false;
        }
        char temp=board[i][j];
        board[i][j]='#';
        boolean found=dfs(board, word, i+1,j,start+1) ||
                    dfs(board, word, i-1,j,start+1) || 
                    dfs(board, word, i,j+1,start+1) ||
                    dfs(board,word,i,j-1,start+1);
        board[i][j]=temp;
        return found;
    }
}