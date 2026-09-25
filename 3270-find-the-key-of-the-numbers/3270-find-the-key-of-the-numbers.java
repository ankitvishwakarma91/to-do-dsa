class Solution {
    public int generateKey(int num1, int num2, int num3) {
        
        int ans = 0;
        int placeValue = 1;

        for(int i = 0 ; i < 4 ; i++){
            int digit1 = num1 % 10;
            int digit2 = num2 % 10;
            int digit3 = num3 % 10;

            ans += Math.min(digit1, Math.min(digit2, digit3)) * placeValue;
            num1 /= 10;
            num2 /= 10;
            num3 /= 10;
            placeValue *= 10;
        }

        return ans;
    }
}