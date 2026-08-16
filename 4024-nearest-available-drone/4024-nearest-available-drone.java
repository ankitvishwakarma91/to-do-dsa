class Solution {
    public int nearestDrone(int[][] drones, int[] target) {
        int n = drones.length;

        int min = 102;
        int ans = -1;
        for (int i = 0; i < n; i++) {
            int x = drones[i][0];
            int y = drones[i][1];
            int range = drones[i][2];

            int dis = Math.abs(x - target[0]) + Math.abs(y - target[1]);

            if (dis <= range) {
                if (min > dis) {
                    min = dis;
                    ans = i;
                }
            }
        }

        return ans;
    }
}