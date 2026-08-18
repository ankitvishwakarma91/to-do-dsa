class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <= n - k; i++) {

            HashSet<Integer> set = new HashSet<>();
            for (int j = i; j <= i + k - 1; j++) {
                set.add(nums[j]);
            }

            for (int va : set) {
                map.put(va, map.getOrDefault(va, 0) + 1);
            }
        }

        // for(int i = 0; i<k ; i++){
        //     map.put(nums[i] , map.getOrDefault(nums[i], 0) + 1);
        // }

        int ans = Integer.MIN_VALUE;

        for (int i : nums) {

            if (map.containsKey(i)) {
                int val = map.get(i);
                if (val == 1) {
                    ans = Math.max(i, ans);
                }
            }

        }

        return ans == Integer.MIN_VALUE ? -1 : ans;
    }
}