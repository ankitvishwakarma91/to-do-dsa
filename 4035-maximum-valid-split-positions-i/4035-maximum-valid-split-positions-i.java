class Solution {
    public int maxValidSplits(int[] nums) {
        int n = nums.length;

        int score = 0;

        for (int r = -1; r < n; r++) {
            int m = (r == -1) ? n : n - 1;
            int[] ar = new int[m];
            int idx = 0;
            for (int i = 0; i < n; i++) {
                if (i == r)
                    continue;
                ar[idx++] = nums[i];
            }

            int[] prefix = new int[m];
            prefix[0] = ar[0];
            for(int i = 1 ; i < m ; i++){
                prefix[i] = gcd(prefix[i-1] , ar[i]);
            }

            int[] suffix = new int[m];
            suffix[m-1] = ar[m-1];
            for(int i = m - 2 ; i>=0; i--){
                suffix[i] = gcd(suffix[i+1], ar[i]);
            }

            int cs = 0;
            for(int i = 0; i < m - 1 ; i++){
                if(prefix[i]==suffix[i+1]){
                    cs++;
                }
            }


            score = Math.max(score, cs);

        }

        return score;
    }

    public int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}