class Solution {
    public int smallestNumber(int n, int t) {

        for (int i = n; i <= 100; i++) {
            int prod = 1;
            int temp = i;
            while (temp > 0) {
                int digit = temp % 10;

                // System.out.println("digit : " + digit);
                prod = digit * prod;
                // System.out.println("prod  : " + prod);
                temp /= 10;
            }
            // System.out.println("findal prod : " + prod);

            if (prod % t == 0) {
                return i;
            }
        }

        return -1;
    }
}