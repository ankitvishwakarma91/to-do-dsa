class Solution {

    int mod = (int) 1e9 + 7;

    public int numOfSubarrays(int[] arr) {

        int n = arr.length;
        int count = 0;
        // for (int i = 0; i < n; i++) {
        //     int sum = 0;

        //     for (int j = i; j < n; j++) {
        //         sum += arr[j];

        //         if (sum % 2 != 0)
        //             count++;
        //     }
        // }

        // Optimal Solution 

        int[] pre = new int[n];
        pre[0] = arr[0];
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] + arr[i];
        }

        int even = 1;
        int odd = 0;

        for (int i = 0; i < n; i++) {

            if (pre[i] % 2 == 0) {
                count = (count + odd) % mod;
                even++;
            } else {
                count = (count + even) % mod;
                odd++;
            }
        }

        return count % mod;

    }
}