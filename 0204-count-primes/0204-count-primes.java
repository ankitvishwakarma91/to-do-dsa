class Solution {
    public int countPrimes(int n) {

        if (n < 2)
            return 0;

        boolean[] prime = new boolean[n];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;

        for (int i = 2; i * i < n; i++) {
            if (prime[i]) {
                for (int p = i * i; p < n; p+=i) {
                    prime[p] = false;
                }
            }
        }

        int cnt = 0;
        for(boolean c : prime){
            if(c) cnt++;
        }
        return cnt;
    }

    // public boolean checkPrime(int n) {
    //     for (int j = 2; j * j <= n; j++) {
    //         if (n % j == 0) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }
}