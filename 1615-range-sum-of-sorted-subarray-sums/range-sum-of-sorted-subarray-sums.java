class Solution {
    static int MOD = 1_000_000_007;
    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i<n; i++){
            int curr = 0;
            for(int j= i; j<n; j++){
                curr += nums[j];
                list.add(curr);
            }
        }
        Collections.sort(list);
        // System.out.println(Arrays.toString(arr));
        int sum = 0;
        for(int i = left-1; i<right; i++){
            sum= (sum + list.get(i)) % MOD;
        }
        return sum;
    
    }
}