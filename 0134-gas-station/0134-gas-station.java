class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total_gas = 0;
        int total_cost = 0;
        int n = gas.length;

        for(int i=0;i<n;i++){
            total_gas += gas[i];
            total_cost += cost[i];
        }
        if(total_gas < total_cost){
            return -1;
        }
        int currGas = 0;
        int start = 0;

        for(int i=0;i<n;i++){
            currGas += gas[i] - cost[i];
            if(currGas < 0){
                currGas = 0;
                start = i+1;
            }
        }
        return start;
    }
}