class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        int n = cardPoints.length;
        int total = 0;
        int l=0;
        int minSum = Integer.MAX_VALUE;

        for(int r=0;r<n;r++){
            total += cardPoints[r];
            sum += cardPoints[r];
            if(r-l+1 == n-k){
                minSum = Math.min(minSum, sum);
                sum -= cardPoints[l];
                l++;
            }
        }
        if(n-k == 0){
            return total;
        }
        return total - minSum;
    }
}