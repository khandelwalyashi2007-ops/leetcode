class Solution {
    public boolean isValid(int i, int j, int n, int m){
        if(i<0 || j<0 || i>=n || j>=m){
            return false;
        }
        return true;
    }
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        Queue<int[]> q = new LinkedList<>();


        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i,j,0});
                }
            }
        }

        int ans = 0;
        boolean vis[][] = new boolean[n][m];
        int[] dr = {0,0,1,-1};
        int[] dc = {1,-1,0,0};

        while(!q.isEmpty()){
            int curr[] = q.poll();
            int i = curr[0];
            int j = curr[1];
            int time = curr[2];

            ans = Math.max(ans,time);
            for(int k=0;k<4;k++){
                int new_i = i + dr[k];
                int new_j = j + dc[k];

                if(isValid(new_i,new_j,n,m) && grid[new_i][new_j] == 1){
                    q.add(new int[]{new_i,new_j,time+1});
                    grid[new_i][new_j] = 2;
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }
        return ans;
    }
}