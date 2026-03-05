class Solution {
    static int component;
    public int find(int u , int[] parent){
        if(parent[u] ==u) return u;
        return parent[u] = find(parent[u],parent);
    }

    public void Union(int u , int v , int[] parent , int[] size){
        int pu = find(u,parent);
        int pv = find(v, parent);

        if(pu == pv) return;

        if(size[pu] > size[pv]){
            parent[pv] = pu;
            size[pu] += size[pv];
        }else{
            parent[pu] = pv;
            size[pv] += size[pu]; 
        }
        component--;
    }

    public int makeConnected(int n, int[][] connections) {
        
        component = n;

        int[] parent = new int[n];
        int[] size = new int[n];
        for(int i = 0; i<n; i++){
            parent[i] = i;
            size[i] = 1;
        }

        int extraCable = 0; // means wo loop ban rhe hai wo extra cable hai 
        for(int[] con : connections){
            int u = con[0];
            int v = con[1];
            // dono ka parent same hai matlab wo add ho chuke hai to hame ab add kr denge to loop create ho jayega to ki extra 
            // cable hai 
            if(find(u,parent) == find(v,parent)) extraCable++;
            Union(u,v,parent,size);
        }
        // agar 2 component hai matlb 1 cable chahiye aur 3 hai to 2 matlab (component - 1) cable required 
        if( component - 1  <= extraCable) return component - 1;
        else return -1;
    }
}