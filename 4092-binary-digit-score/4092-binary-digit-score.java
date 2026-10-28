class Solution {

    public int countSetBits(int n) {
        int count = 0;

        while (n > 0) {
            int digit = n % 2;
            if (digit == 1)
                count++;
            n /= 2;
        }

        return count;
    }

    public int calculateScore(int a, int b) {

        int cnt1 = countSetBits(a);
        int cnt2 = countSetBits(b);

        if (cnt1 >= cnt2)
            return cnt1 * cnt2;
        return cnt2 / cnt1;

    }
}