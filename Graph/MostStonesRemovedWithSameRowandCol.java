import java.util.*;

class DisjointSet{
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DisjointSet(int n){
        for(int i=0; i<=n; i++){
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public int findUPar(int node){
        if(node == parent.get(node)){
            return node;
        }
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    public void unionByRank(int u, int v){
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        if(ulp_u == ulp_v) return;

        if(rank.get(ulp_u) < rank.get(ulp_v)){
            parent.set(ulp_u, ulp_v);
        }
        else if(rank.get(ulp_v) < rank.get(ulp_u)){
            parent.set(ulp_v, ulp_u);
        }
        else{
            parent.set(ulp_v, ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u, rankU+1);
        }
    }

    public void unionBySize(int u, int v){
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        if(ulp_u == ulp_v) return;

        if(size.get(ulp_u) < size.get(ulp_v)){
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_u)+size.get(ulp_v));
        }
        else{
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u)+size.get(ulp_v));
        }
    }
}


class MostStonesRemovedWithSameRowandCol {
    public static int maxRemove(int[][] stones, int n) {
        int maxRow=0, maxCol=0;
        for(int i=0; i<n; i++){
            maxRow = Math.max(maxRow, stones[i][0]);
            maxCol = Math.max(maxCol, stones[i][1]);
        }
        
        DisjointSet ds = new DisjointSet(maxRow+maxCol+1);
        Map<Integer, Integer> stonesMap = new HashMap<>();
        for(int i=0; i<n; i++){
            int row=stones[i][0];
            int col=stones[i][1]+maxRow+1;
            ds.unionByRank(row, col);
            stonesMap.put(row, 1);
            stonesMap.put(col, 1);
        }
        
        Set<Integer> stonesSet = stonesMap.keySet();
        
        int cnt=0;
        for(int it : stonesSet){
            if(ds.findUPar(it) == it){
                cnt++;
            }
        }
        
        return n-cnt;   
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] stones = new int[n][2];
        for(int i=0; i<n; i++){
            stones[i][0] = sc.nextInt();
            stones[i][1] = sc.nextInt();
        }
        System.out.println(maxRemove(stones, n));
        // 6
        // 0 0
        // 0 1
        // 1 0
        // 1 2
        // 2 1
        // 2 2
    }
}