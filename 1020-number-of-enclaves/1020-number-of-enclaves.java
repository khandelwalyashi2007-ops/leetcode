class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if((i==0||j==0||i==n-1||j==m-1) && grid[i][j] == 1){
                    q.add(new int[]{i,j});
                    vis[i][j] = true;
                }
            }
        }
        int[] dr = {0,0,1,-1};
        int[] dc = {1,-1,0,0};

        while(!q.isEmpty()){
            int[] curr = q.remove();
            int r = curr[0];
            int c = curr[1];

                for(int i=0;i<4;i++){
                    int nr = r+dr[i];
                    int nc = c+dc[i];
                    if(nr >=0 && nc >= 0 && nr < n && nc < m){
                        if(vis[nr][nc] == false && grid[nr][nc] == 1){
                        q.add(new int[]{nr,nc});
                        vis[nr][nc] = true;
                    }
                }
            }
        }
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1 && vis[i][j] == false){
                    count++;
                }
            }
        }
        return count;
    }
}