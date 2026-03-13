class Solution {

    public int solve(int[] nums, int i, int prev) {
        int n = nums.length;
        if (i >= n) {
            return 0;
        }
        int take = 0;
        if (prev == -1 || nums[prev] < nums[i]) {
            take = 1 + solve(nums, i + 1, i);
        }
        int notTake = solve(nums, i + 1, prev);

        return Math.max(take, notTake);
    }

    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] t = new int[n];
        Arrays.fill(t, 1);
        int[] count = new int[n];
        Arrays.fill(count, 1);
        for (int i = 1; i < n; i++) {
            int j = 0;
            while (j < i) {
                if (nums[i] > nums[j]) {
                    // t[i] = Math.max(t[i], t[j] + 1);
                    if (t[i] == t[j] + 1)
                        count[i] += count[j];
                    else if (t[i] < t[j] + 1) {
                        t[i] = t[j] + 1;
                        count[i] = count[j];
                    }
                }
                j++;
            }
        }
        System.out.println(Arrays.toString(t));
        int max = 0;
        for (int i : t) {
            max = Math.max(max, i);
        }
        int ans = 0;
        for(int i = 0; i<n; i++){
            if(t[i] == max){
                ans+=count[i];
            }
        }
        
        return ans;
    }
}