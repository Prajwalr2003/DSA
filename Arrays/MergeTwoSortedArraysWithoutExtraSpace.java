import java.util.Arrays;
public class MergeTwoSortedArraysWithoutExtraSpace {

    // Without Using Extra Space with O(1) Space

    public static void swap(long arr1[], long arr2[], int left, int right){
        if(arr1[left]>arr2[right]){
            long temp=arr1[left];
            arr1[left]=arr2[right];
            arr2[right]=temp;
        }
    }
    public static void merge(long arr1[], long arr2[], int n, int m) 
    {
        // code here 
        int len = (n+m);
        int gap = (len/2)+(len%2);
        
        while(gap>0){
            int left=0;
            int right=left+gap;
            while(right<len){
                
                if(left<n && right>=n){
                    swap(arr1, arr2, left, right-n);
                }
                else if(left>=n){
                    swap(arr2, arr2, left-n, right-n);
                }
                else{
                    swap(arr1, arr1, left, right);
                }
                
                left++;
                right++;
            }
            
            if(gap==1) break;
            gap = (gap/2)+(gap%2);
        }
    }

    // Without Using Extra Space but Using Inbuilt Sorting Method

    public static void mergSortedArray2(int arr1[], int arr2[]){
        int n=arr1.length;
        int m=arr2.length;
        int left=n-1, right=0;

        while(left>=0 && right<m){
            if(arr1[left]>=arr2[right]){
                int temp=arr1[left];
                arr1[left]=arr2[right];
                arr2[right]=temp;
                left--;
                right++;
            }
            else{
                break;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }

    // Using Extra Space
    public static void mergeSortedArray(int arr1[], int arr2[]){
        int n=arr1.length;
        int m=arr2.length;
        int arr3[] =new int[n+m];
        int index=0, left=0, right=0;

        while(left<n && right<m){
            if(arr1[left]<=arr2[right]){
                arr3[index++]=arr1[left++];
            }
            else{
                arr3[index++]=arr2[right++];
            }
        }
        while(left<n){
            arr3[index++]=arr1[left++];
        }
        while(right<m){
            arr3[index++]=arr2[right++];
        }

        for (int i = 0; i < n; i++) {
            arr1[i] = arr3[i];
        }
        
        for (int i = 0; i < m; i++) {
            arr2[i] = arr3[n + i];
        }
    }

    public static void main(String[] args){
        
        long arr1[] = { 1, 3, 5, 7};
        int n = arr1.length;
        long arr2[] = { 0, 2, 6, 8, 9, 10};
        int m = arr2.length;

        // mergeSortedArray(arr1, arr2);
        // mergSortedArray2(arr1, arr2);
        merge(arr1, arr2, n, m);

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));


    }
}
