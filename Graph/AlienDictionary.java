import java.util.*;

class AlienDictionary {
    public static String findOrder(String[] dict, int k) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<k; i++){
            adj.add(new ArrayList<>());
        }
        
        int[] indegree = new int[k];
        
        for(int i=0; i<dict.length-1; i++){
            String s1 = dict[i];
            String s2 = dict[i+1];
            
            for(int j=0; j<Math.min(s1.length(), s2.length()); j++){
                if(s1.charAt(j) != s2.charAt(j)){
                    adj.get(s1.charAt(j)-'a').add(s2.charAt(j)-'a');
                    indegree[s2.charAt(j)-'a']++;
                    break;
                }
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        List<Integer> topoSort = new ArrayList<>();

        for(int i=0; i<k; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int node = q.poll();
            topoSort.add(node);

            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.offer(it);
                }
            }
        }
        
        String ans="";
        
        for(int i=0; i<topoSort.size(); i++){
            ans+=(char)(97+topoSort.get(i));
        }
        
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] dict = sc.nextLine().split(" ");
        int k = sc.nextInt();

        System.out.println(findOrder(dict, k));
    }
}