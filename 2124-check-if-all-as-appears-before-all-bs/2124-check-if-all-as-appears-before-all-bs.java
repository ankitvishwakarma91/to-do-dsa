class Solution {
    public boolean checkString(String s) {
        boolean f = false;

        for (char ch : s.toCharArray()) {
            if (ch == 'b') {
                f = true;
            } else if (f && ch == 'a') {
                return false;
            }
        }
        return true;
    }
}