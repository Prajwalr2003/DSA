import java.util.*;

class MinimumMultiplicationstoReachEnd {
    public static int minimumMultiplications(int[] arr, int start, int end) {
        if(start == end) return 0;
        
        int n = arr.length;
        int mod = 100000;
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, start});
        
        int dist[] = new int[100000];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int steps = curr[0];
            int node = curr[1];
            
            for(int i=0; i<n; i++){
                int num = (node*arr[i])%mod;
                if(steps+1 < dist[num]){
                    dist[num] = steps+1;
                    if(num == end) return steps+1;
                    
                    q.offer(new int[]{steps+1, num});
                }
            }
        }
        
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int start=sc.nextInt();
        int end=sc.nextInt();

        System.out.println(minimumMultiplications(arr, start, end));

        // 3
        // 2 5 7
        // 3 30
    }
}