class Solution {
     public int gcd(int a,int b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }
    public boolean canMeasureWater(int m, int n, int d) {
        if(d==0){
            return true;
        }
         if(d>m+n){
            return false;
         }
        return d%gcd(m,n)==0;
    }
}