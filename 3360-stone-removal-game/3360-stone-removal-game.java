class Solution {
    public boolean canAliceWin(int n) {
        if(n < 10) return false;
        int re = 10;
        while (n > 0) {
            n = n - re;
            re--;
            if (n < re) {
                break;
            }
        }
        return re % 2 == 0 ? false : true;
    }
}