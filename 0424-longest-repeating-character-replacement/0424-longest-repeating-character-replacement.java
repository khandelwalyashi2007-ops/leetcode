class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;
        int[] freq = new int[26];
        int maxFreq = 0;
        int ans = 0;
         while(right < s.length()){
            int idx = s.charAt(right) - 'A';
            freq[idx]++;
            right++;
            maxFreq = Math.max(maxFreq,freq[idx]);

            int size = right - left;
            if(size - maxFreq > k){
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            ans = Math.max(ans, right - left);
         }
         return ans;
    }
}