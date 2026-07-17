class Solution {
    public int count(int[] nums, int k){
        if(k<0){
            return 0;
        }
        int left = 0;
        int right = 0;
        int count = 0;
        int freq = 0;

        while(right < nums.length){
            if(nums[right]==1){
                freq++;
            }
            right++;
            while(freq > k){
                if(nums[left] == 1){
                    freq--;
                }
                left++;
            }
            count += right - left + 1;
        }
        return count;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==0){
                nums[i]=0;
            }else{
                nums[i]=1;
            }
        }
        return count(nums,k) - count(nums,k-1);
    }
}