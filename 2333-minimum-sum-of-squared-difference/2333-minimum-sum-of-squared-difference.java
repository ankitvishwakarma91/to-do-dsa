class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;

        // Brute force : Not work 
        // int[] diff = new int[n];
        // PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        // for (int i = 0; i < n; i++) {
        //     pq.add(Math.abs(nums1[i] - nums2[i]));

        // }

        // int k = k1 + k2;

        // // for (int i : diff) {
        // //     pq.add(i);
        // // }

        // while (k > 0 && pq.peek() > 0) {
        //     int val = pq.poll();
        //     pq.add(val - 1);
        //     k--;
        // }
        // long sum = 0;
        // while (!pq.isEmpty()) {
        //     long val = pq.poll();
        //     sum += (val * val);
        // }
        // return sum;

        // Optimse Solution
        long k = k1 + k2;
        int[] diff = new int[n];
        int maxD = 0;
        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            maxD = Math.max(maxD, diff[i]);

        }
        int[] freq = new int[maxD + 1];
        for (int i : diff) {
            freq[i]++;
        }

        for (int i = maxD; i >= 0 && k > 0; i--) {
            int count = (int) Math.min(k, freq[i]);
            freq[i] -= count;
            if (i - 1 >= 0) {

                freq[i - 1] += count;
            }
            k -= count;
        }

        long sum = 0;
        for (long i = 1; i <= maxD; i++) {
            sum += freq[(int) i] * i * i;
        }

        return sum;
    }
}