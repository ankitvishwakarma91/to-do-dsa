class Solution {
    public boolean canBeEqual(String s1, String s2) {

        char[] s = s1.toCharArray();
        if (s[0] != s2.charAt(0)) {
            char temp = s[0];
            s[0] = s[2];
            s[2] = temp;
        }
        if (s[1] != s2.charAt(1)) {
            char temp = s[1];
            s[1] = s[3];
            s[3] = temp;
        }

        String t = new String(s);
        return t.equals(s2);
    }
}