public class LongestSubarrayWithSum {
    public static int[] longestSubarray(int arr[], int k){
        int l=0, r=0, maxLen=0, sum=0;
        int ind1=0, ind2=-1;
        while(r<arr.length){
            sum = sum + arr[r];
            while(sum > k){
                sum = sum - arr[l];
                l++;
            }
            if(sum <= k && (r-l+1)>maxLen){
                maxLen = r-l+1;
                ind1=l;
                ind2=r;
            }
            r++;
        }

        int ans[] = new int[ind2-ind1+1];
        for(int i=0, j=ind1; j<=ind2; i++, j++){
            ans[i] = arr[j];
        }

        return ans;
    }
    public static void main(String[] args){
        int arr[] = {1, 4, 7, 2, 10};
        int k = 14;
        int ans[] = longestSubarray(arr, k);

        for(int i=0; i<ans.length; i++){
            System.out.print(ans[i]+" ");
        }
    }
}
