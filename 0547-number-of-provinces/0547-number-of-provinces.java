class Solution {
    public void dfs(int i,int[][] isConnected, boolean vis[]){
        int n = isConnected.length;
        vis[i] = true;

        for(int j=0;j<n;j++){
            if(isConnected[i][j] == 1 && !vis[j]){
                dfs(j,isConnected,vis);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        int n = isConnected.length;
        boolean[] vis = new boolean[n];

        for(int i=0;i<n;i++){
            if(vis[i]==false){
                count++;
                dfs(i,isConnected,vis);
            }
        }
        return count;
    }
}