class Solution {
    public boolean judgeCircle(String moves) {
        int n = moves.length();
        int x = 0;
        int y = 0;

        for (int i = 0; i < n; i++) {
            if (moves.charAt(i) == 'R') {
                x += 1;
            } else if (moves.charAt(i) == 'L') {
                x -= 1;
            } else if (moves.charAt(i) == 'U') {
                y += 1;
            } else {
                y -= 1;
            }
        }

        return x == 0 && y == 0;
    }
}