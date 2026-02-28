class Solution {
    static int MOD = (int) 1e9 + 7;
    public  String convertANumberIntoBinary(int n) {
        if (n == 0)
            return "0";
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            sb.append(n & 1);
            n = n >> 1;
        }

        return sb.reverse().toString();
    }

    public  int convertBinaryToNumber(String binary) {
        int ans = 0;
        for (int i = 0; i < binary.length(); i++) {
            ans = (ans * 2 + (binary.charAt(i) - '0')) % MOD;
        }
        return (int)ans;
    }

    public  int concatenatedBinary(int n) {

        // String binary = "";
        // for (int i = 1; i <= n; i++) {
        //     binary += convertANumberIntoBinary(i);
        // }

        // return convertBinaryToNumber(binary);

        // System.out.println(binary);
        // return 0;

        long result = 0;
        int MOD = 1_000_000_007;
        int digits = 0;
        
        for (int i = 1; i <= n; i++) {
            //digit count tabhi barhta hai jab power of 2 ata hai
            if ((i & (i - 1)) == 0) {
                digits++;
            }
            
            result = ((result << digits) % MOD + i) % MOD;
        }
        
        return (int) result;
    }
}