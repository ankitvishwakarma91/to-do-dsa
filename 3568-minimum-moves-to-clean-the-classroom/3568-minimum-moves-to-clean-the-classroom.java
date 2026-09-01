class State{
    int sr;
    int sc;
    int e;
    int s;
    int m;

    public State(int sr , int sc , int e , int s , int m){
        this.sr = sr;
        this.sc = sc;
        this.e = e;
        this.s = s;
        this.m = m;
    }
}

class Solution {


    public int solve(String[] c, int i, int j, int l, int e , int[][] litter) {
        int n = c.length;
        int m = c[0].length();

        Queue<State> q = new LinkedList<>();
        q.add(new State(i,j,e,0,0));

        int alloc = (1<<l)-1;
        boolean[][][][] visited =new boolean[n][m][e + 1][1 << l];
        visited[i][j][e][0] = true;

        int[] dx = { 1, -1, 0, 0 };
        int[] dy = { 0, 0, 1, -1 };

        while (!q.isEmpty()) {
            State cu = q.poll();

            if(cu.m == alloc) return cu.s;

            if(cu.e == 0) continue;

            for (int di = 0; di < 4; di++) {
                int ni = cu.sr + dx[di];
                int nj = cu.sc + dy[di];

                if (ni < 0 || nj < 0 || ni >= n || nj >= m) {
                    continue;
                }

                if (c[ni].charAt(nj) == 'X') {
                    continue;
                }

                int ne = cu.e - 1;
                int nm = cu.m;

                if(litter[ni][nj] != -1){
                    nm |= (1 << litter[ni][nj]);
                }

                if (c[ni].charAt(nj) == 'R') {
                    ne = e;
                }

                if(visited[ni][nj][ne][nm]){
                    continue;
                }

                visited[ni][nj][ne][nm]= true;

                q.add(new State(ni,nj,ne,cu.s+1,nm));
            }
        }

        return -1;
    }

    public int minMoves(String[] classroom, int energy) {
        int n = classroom.length;
        int m = classroom[0].length();

        int si = 0;
        int sj = 0;
        int totalL = 0;

        int[][] litter = new int[n][m];

        for(int[] cu : litter){
            Arrays.fill(cu, -1);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char ch = classroom[i].charAt(j);
                if (ch == 'S') {
                    si = i;
                    sj = j;
                } 
                if (classroom[i].charAt(j) == 'L') {
                    litter[i][j] = totalL++;
                }
            }
        }

        if(totalL == 0) return 0;

        return solve(classroom, si, sj, totalL, energy , litter);
    }
}