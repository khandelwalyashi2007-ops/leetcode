class Solution {
    int row;
    int col;
    int oldcolor;
    int newcolor;
    public void dfs(int[][] image,int r,int c){
        if(r<0 ||  c<0 || r>=row || c>=col){
            return;
        }
        if(image[r][c]!=oldcolor){
            return;
        }
        image[r][c] = newcolor;

        dfs(image,r+1,c);
        dfs(image,r-1,c);
        dfs(image,r,c+1);
        dfs(image,r,c-1);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
         row = image.length;
         col = image[0].length;
        oldcolor = image[sr][sc];
        newcolor = color;
        if(oldcolor == newcolor){
            return image;
        }

        dfs(image,sr,sc);
        return image;
    }
}