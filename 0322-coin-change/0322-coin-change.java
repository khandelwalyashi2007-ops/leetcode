class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = amount+1;
        int[] dp = new int[n];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=1;i<n;i++){
            for(int coin: coins){
                if(coin <= i && dp[i-coin] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i],dp[i-coin]+1);
                }
            }
        }
       if(dp[n-1] == Integer.MAX_VALUE){
        return -1;
       }else{
        return dp[n-1];
       }
    // int[] dp = new int[amount + 1];

    //     Arrays.fill(dp, amount + 1);

    //     dp[0] = 0;

    //     for (int i = 1; i <= amount; i++) {

    //         for (int coin : coins) {

    //             if (coin <= i) {
    //                 dp[i] = Math.min(dp[i], dp[i - coin] + 1);
    //             }
    //         }
    //     }

    //     if (dp[amount] == amount + 1) {
    //         return -1;
    //     }

    //     return dp[amount];
    }
}