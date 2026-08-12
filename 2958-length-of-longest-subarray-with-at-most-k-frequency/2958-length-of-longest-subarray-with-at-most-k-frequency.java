class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;

        if (n == 1)
            return 1;

        // int max = 1;

        // BRUTE FORCE
        // int i = 0;
        // while (i < n) {
        //     HashMap<Integer, Integer> map = new HashMap<>();

        //     int j = i;
        //     while (j < n) {
        //         map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
        //         if (isGood(map, k)) {
        //             max = Math.max(max, j - i + 1);
        //         }else{
        //             break;
        //         }
        //         j++;
        //     }

        //     i++;
        // }

        // OPTIMIZE 

        int i = 0;
        int j = 0;
        int ans = 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (j < n) {
            int key = nums[j];
            map.put(key, map.getOrDefault(key, 0) + 1);

            while (map.get(key) > k) {
                ans = Math.max(ans, j - i);
                int f = map.get(nums[i]);
                map.put(nums[i], f - 1);
                if (map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }
                i++;
            }

            ans = Math.max(ans, j - i + 1);
            j++;
        }
        return ans;
    }

    // public boolean isGood(HashMap<Integer, Integer> map, int k) {

    //     for (int val : map.values()) {
    //         if (val > k) {
    //             return false;
    //         }
    //     }

    //     return true;
    // }
}