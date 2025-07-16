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


class AccountsMerge {
    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        
        Map<String, Integer> mapMail = new HashMap<>();
        
        for(int i=0; i<n; i++){
            for(int j=1; j<accounts.get(i).size(); j++){
                String mail = accounts.get(i).get(j);
                if(mapMail.containsKey(mail)){
                    ds.unionBySize(i, mapMail.get(mail));
                }else{
                    mapMail.put(mail, i);
                }
            }
        }
        
        List<List<String>> mergeMail = new ArrayList<>();
        for(int i=0; i<n; i++){
            mergeMail.add(new ArrayList<>());
        }
        
        Set<String> mails = mapMail.keySet();
        for(String mail : mails){
            int node = ds.findUPar(mapMail.get(mail));
            mergeMail.get(node).add(mail);
        }
        
        List<List<String>> ans = new ArrayList<>();
        for(int i=0; i<mergeMail.size(); i++){
            if(mergeMail.get(i).size()==0) continue;
            Collections.sort(mergeMail.get(i));
            
            List<String> list = new ArrayList<>();
            list.add(accounts.get(i).get(0));
            for(int j=0; j<mergeMail.get(i).size(); j++){
                list.add(mergeMail.get(i).get(j));
            }
            ans.add(list);
        }
        
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<List<String>> accounts = new ArrayList<>();
        while(sc.hasNextLine()){
            int size = sc.nextInt();
            sc.nextLine();
            List<String> account = new ArrayList<>();
            String[] arr = sc.nextLine().split(" ");
            for(String mail : arr){
                account.add(mail);
            }

            accounts.add(account);
        }
        
        System.out.println(accountsMerge(accounts));

        // 4
        // 3
        // John johnsmith@mail.com john_newyork@mail.com
        // 3
        // John johnsmith@mail.com john00@mail.com
        // 2
        // Mary mary@mail.com
        // 2
        // John johnnybravo@mail.com
    }
}