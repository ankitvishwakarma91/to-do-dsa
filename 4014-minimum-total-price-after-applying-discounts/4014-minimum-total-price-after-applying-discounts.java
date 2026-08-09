class Solution {
    public double minPrice(int[] prices, int[] discounts) {
        int n = prices.length;
        int m = discounts.length;

        double ans = 0;

        Arrays.sort(prices);
        Arrays.sort(discounts);

        int i = n - 1;
        int j = m - 1;

        while (i >= 0 && j >= 0) {

            double dis =(double) (prices[i] * (100 - discounts[j])) / 100;
            System.out.println(dis);
            ans += dis;
            i--;
            j--;
        }

        while (i >= 0) {
            ans += prices[i];
            i--;
        }

        return ans;
    }
}