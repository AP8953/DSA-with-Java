class Solution {
    int m,n;
    int[][] matrix;
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> result=new ArrayList<>();
        if(matrix.length==0 || matrix[0].length==0) return result;
        m=matrix.length;
        n=matrix[0].length;
        this.matrix=matrix;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
				//If both flags are true, add in result
                if(reachPacific(i,j) && reachAtlantic(i,j)){
                    result.add(Arrays.asList(i,j));
                }
            }
        }
        return result;
    }
    
    boolean reachPacific(int r,int c){
        
        if(r==0 || c==0) return true;
        if(matrix[r][c]==-1) return false;
        int val=matrix[r][c];
        matrix[r][c]=-1;
        boolean flag=false;
		    
        //Call DFS in all 4 Directions 
        if(matrix[r-1][c]<=val){
            flag=reachPacific(r-1,c);
        }
        
        if(!flag && matrix[r][c-1]<=val){
            flag = reachPacific(r,c-1);
        }
        
        if(!flag && c+1<n && matrix[r][c+1]<=val){
            flag = reachPacific(r,c+1);
        }
        
        if(!flag && r+1<m && matrix[r+1][c]<=val){
            flag = reachPacific(r+1,c);
        }
        matrix[r][c]=val;
        return flag;
    }
    
    boolean reachAtlantic(int r,int c){
        if(r==m-1 || c==n-1) return true;
        if(matrix[r][c]==-1) return false;
        int val=matrix[r][c];
        matrix[r][c]=-1;
        boolean flag=false;
		    
        //Call DFS in all 4 Directions
        if(matrix[r+1][c]<=val){
            flag=reachAtlantic(r+1,c);
        }
        if(!flag &&  matrix[r][c+1]<=val){
            flag = reachAtlantic(r,c+1);
        }
        if(!flag && c-1>=0 &&  matrix[r][c-1]<=val){
            flag = reachAtlantic(r,c-1);
        }
        if(!flag &&  r-1>=0 && matrix[r-1][c]<=val){
            flag = reachAtlantic(r-1,c);
        }
        matrix[r][c]=val;
        return flag; 
    }
}