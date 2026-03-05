class Solution {

    //Apply DSU 

    public int find(int u, int[] parent) {
        if (parent[u] == u)
            return u;
        return parent[u] = find(parent[u], parent);
    }

    public void Union(int u, int v, int[] parent, int[] size) {
        int pu = find(u, parent);
        int pv = find(v, parent);

        if (pu == pv)
            return;

        if (size[pu] > size[pv]) {
            parent[pv] = pu;
            size[pu] += size[pv];
        } else {
            parent[pu] = pv;
            size[pv] += size[pu];
        }

        return;
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        int[] size = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        for (int[] curr : edges) {
            int u = curr[0];
            int v = curr[1];

            if (find(u, parent) == find(v, parent)) {
                return new int[] { u, v };
            }

            Union(u, v, parent, size);
        }

        return new int[] { 0 };
    }
}