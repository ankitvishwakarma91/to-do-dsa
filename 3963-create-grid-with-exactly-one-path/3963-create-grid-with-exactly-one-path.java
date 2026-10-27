class Solution {
    public String[] createGrid(int m, int n) {

        String[] ans = new String[m];

        for (int i = 0; i < m; i++) {
            if (i == 0) {
                String s = "";
                for (int j = 0; j < n; j++) {

                    s += '.';
                }
                ans[i] = s;
            } else {

                String s = "";
                for (int j = 0; j < n - 1; j++) {
                    s += '#';
                }
                s += '.';
                ans[i] = s;
            }
        }

        return ans;
    }
}