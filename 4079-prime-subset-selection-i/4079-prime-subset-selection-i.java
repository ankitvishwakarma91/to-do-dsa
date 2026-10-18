class Solution {



    public List<Integer> maxPrimes(int n, int s) {
        
        if (n < 2) {
            return new ArrayList<>();
        }
        
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        
        for (int p = 2; (long) p * p <= n; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= n; i += p) {
                    isPrime[i] = false;
                }
            }
        }
        
        List<Integer> result = new ArrayList<>();
        long currentSum = 0;
        
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                if (currentSum + i <= s) {
                    currentSum += i;
                    result.add(i);
                } else {
                    break; 
                }
            }
        }
        
        return result;
    }
}