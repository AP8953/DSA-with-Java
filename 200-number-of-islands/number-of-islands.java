class Solution {
    int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        Queue<int[]> queue = new LinkedList<>();
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]=='1'){
                    count++;
                    grid[i][j]='0';
                    queue.add(new int[]{i,j});

                    while(!queue.isEmpty()){
                        int[] cell=queue.poll();
                        for(int[] d:dir){
                            int r=cell[0]+d[0];
                            int c=cell[1]+d[1];
                            if(r>=0&&r<grid.length&&c>=0&&c<grid[0].length&&grid[r][c]=='1'){
                                grid[r][c]='0';
                                queue.add(new int[]{r,c});
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}