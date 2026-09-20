class Solution {
    public long countIntersectingIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        long cnt = 0;

        for (int i = 0; i < n; i++) {
            int end = intervals[i][1];

            int low = i + 1;
            int high = n;

            while (low < high) {
                int mid = low + (high - low) / 2;

                if (intervals[mid][0] <= end) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            cnt += low - i - 1;
        }
        return cnt;
    }
}