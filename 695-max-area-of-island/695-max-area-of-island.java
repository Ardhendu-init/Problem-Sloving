class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean vis [][] = new boolean[n][m];
        int area = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j]==1 && vis[i][j]==false){
                    
                    int res = helper(grid , i , j , vis);
                    area = Math.max(area , res);
                    
                }
            }
        }
        return area ;
        
    }
    
    public static int helper (int [][] grid , int i , int j , boolean vis[][]){
        if(i < 0 || j < 0 || i >= grid.length|| j >= grid[0].length || vis[i][j]==true || grid[i][j]==0){
            return 0;
        }
        vis[i][j] = true;
        int curArea = 1;
        curArea+=helper(grid , i+1 , j , vis);//top
        curArea+=helper(grid , i , j+1 , vis);//right
        curArea+=helper(grid , i-1 , j , vis);//bottom
        curArea+=helper(grid , i , j-1 , vis);//left
        return curArea;
    }
}