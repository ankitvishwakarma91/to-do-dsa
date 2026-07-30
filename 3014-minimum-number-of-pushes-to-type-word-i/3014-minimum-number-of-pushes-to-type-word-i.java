class Solution {
    public int minimumPushes(String word) {
        int n = word.length();

        if (n <= 8)
            return n;
        // int req = 
        if (n > 8 && n <= 16) {
            int rq = n - 8;
            if (rq == 0) {
                return 24;
            } else {
                return 8 + rq * 2;
            }
        } else if (n > 16 && n <= 24) {
            int rq = n - 16;
            if (rq == 0) {
                return 8 + 16 + 24;
            } else {
                return 8 + 16 + rq * 3;
            }
        } else {
            int rq = n - 24 ;
            if (rq == 0) {
                return 8 + 16 + 24 + 4;
            } else {
                return 8 + 16 + 24 + rq * 4;
            }
        }
    }
}