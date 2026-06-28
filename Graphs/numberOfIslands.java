class Solution {
    public int numIslands(char[][] grid) {
        int islands=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    islands++;
                    grid=dfs(i,j,grid);
                }
            }
        }
        return islands;
    }
    private char[][] dfs(int i,int j,char[][] grid){
        grid[i][j]='0';
        if(i-1>-1){
            if(grid[i-1][j]=='1'){
                grid=dfs(i-1,j,grid);
            }
        }
        if(i+1<grid.length){
            if(grid[i+1][j]=='1'){
                grid=dfs(i+1,j,grid);
            }
        }
        if(j-1>-1){
            if(grid[i][j-1]=='1'){
                grid=dfs(i,j-1,grid);
            }
        }
        if(j+1<grid[0].length){
            if(grid[i][j+1]=='1'){
                grid=dfs(i,j+1,grid);
            }
        }
        return grid;
    }
}
