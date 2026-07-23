class Solution {
    public int helper(int[] nums, int start, int end){
        int n = nums.length;
        int[] dp = new int[n-1];

        dp[0] = nums[start];
        dp[1] = Math.max(nums[start],nums[start+1]);

        int j = 2;
        for(int i=start+2;i<end;i++){
            dp[j] = Math.max(dp[j-1],dp[j-2]+nums[i]);
            j++;
        }
        return dp[n-2];
    }
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0],nums[1]);
        }
        int n = nums.length;
        return Math.max(helper(nums,0,n-1),helper(nums,1,n));
    }
}