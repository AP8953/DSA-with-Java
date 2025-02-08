class Solution {
    int[][] dir={{0,1},{0,-1},{-1,0},{1,0}};
    public int numIslands(char[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        boolean[][] visited=new boolean[row][col];
        int count=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    count++;
                    
                        dfs(grid,i,j,visited);
                    
                }  
            }
        }
        return count;
    }
    public void dfs(char[][] grid, int i, int j, boolean[][] visited){
        if(i<0 ||i>=grid.length || j<0 ||j>=grid[0].length || grid[i][j]=='0' || visited[i][j]) return;
        visited[i][j]=true;
        
        
        for(int[] d:dir){
              dfs(grid,i+d[0],j+d[1],visited);
        }
    }
}