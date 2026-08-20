class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;

        int[] ans = new int[n];

        int half = n / 2;

        List<Integer> arr = new ArrayList<>();
        arr.add(nums[0]);
        List<Integer> list = new ArrayList<>();
        list.add(nums[1]);
        int idx = 0;
        int id = 0;
        for (int i = 2; i < n; i++) {
            int curr = nums[i];

            if (arr.get(idx) > list.get(id)) {
                arr.add(curr);
                idx++;
            } else {
                list.add(curr);
                id++;
            }
        }
        int indx = 0;
        for (int va : arr) {
            ans[indx++] = va;
        }
        for (int va : list) {
            ans[indx++] = va;
        }
        return ans;
    }
}