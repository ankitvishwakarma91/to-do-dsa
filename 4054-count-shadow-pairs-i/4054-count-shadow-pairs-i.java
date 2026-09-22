class Solution {
    public long shadowPairs(int[] nums) {
        // 1,1,3,4,5

        int n = nums.length;

        ArrayList<Integer> st = new ArrayList<>();

        long ans = 0;

        for (int j = 0; j < n; j++) {

            int current = nums[j];

            int low = 0;
            int high = st.size();

            while (low < high) {

                int mid = low + (high - low) / 2;

                if (st.get(mid) < current) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }

            ans += low;

            while (!st.isEmpty() &&
                    st.get(st.size() - 1) > current) {

                st.remove(st.size() - 1);
            }

            st.add(current);
        }

        return ans;
    }
}