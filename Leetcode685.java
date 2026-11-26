class Solution {
    int[] parent;
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] parentNode = new int[n + 1];
        int[] edge1 = null;
        int[] edge2 = null;
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (parentNode[v] == 0) {
                parentNode[v] = u;
            } 
            else {
                edge1 = new int[]{parentNode[v], v};
                edge2 = new int[]{u, v};
                edge[1] = 0;
            }
        }
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (v == 0) {
                continue;
            }
            int pu = find(u);
            int pv = find(v);
            if (pu == pv) {
                if (edge1 == null) {
                    return edge;
                }
                return edge1;
            }
            parent[pv] = pu;
        }
        return edge2;
    }
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}
