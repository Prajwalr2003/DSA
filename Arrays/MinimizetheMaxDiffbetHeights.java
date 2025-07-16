public class MinimizetheMaxDiffbetHeights {
    
    public static int minDiff(int[] arr, int k){
        int n = arr.length;

        int ans = arr[n-1]-arr[0];
        int smallest = arr[0]+k;
        int largest = arr[n-1]-k;
        int min, max;

        for(int i=0;i<n-1;i++){
            
            min = Math.min(smallest, arr[i+1]-k);
            max = Math.max(largest, arr[i]+k);

            if(min<0)continue;

            ans = Math.min(ans, max-min);
        }

        return ans;
    }
    public static void main(String[] args){
        int k = 3;
        int arr[] = {3, 9, 12, 16, 20};

        System.out.println(minDiff(arr, k));
    }
}
