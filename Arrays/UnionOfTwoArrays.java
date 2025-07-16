
import java.util.*;
public class UnionOfTwoArrays {

    // For Sorted Arrays  
    // Optimized Solution Using HashSet
    public static int optimizedSolution(int a[] , int b[]){
        int n=a.length;
        int m=b.length;

        HashSet<Integer> hs = new HashSet<>();

        for(int i=0;i<n;i++){
            hs.add(a[i]);
        }

        for(int i=0;i<m;i++){
            hs.add(b[i]);
        }

        return hs.size();
    }

    //  Brute Force Solution
    public static int unionOfArrays(int a[], int b[]){
        ArrayList<Integer> res = new ArrayList<>();

        int n=a.length;
        int m=b.length;
        int left=0, right=0;
        while(left<n || right<m){

            while(left>0 && left<n && a[left]==a[left-1])
            {
                left++;
            }
            while(right>0 && right<m && b[right]==b[right-1]){
                right++;
            }

            if(left>=n){
                res.add(b[right]);
                right++;
                continue;
            }

            if(right>=n){
                res.add(a[left]);
                left++;
                continue;
            }

            if(a[left]<b[right]){
                res.add(a[left]);
                left++;
            }
            else if(a[left]>b[right]){
                res.add(b[right]);
                right++;
            }
            else{
                res.add(a[left]);
                left++;
                right++;
            }
        }

        return res.size();

    }
    public static void main(String[] args){
        int[] a = { 1, 2, 5, 6, 8};
        int[] b = {2, 4, 3, 5, 6};

        // System.out.println(unionOfArrays(a, b));
        System.out.println(optimizedSolution(a, b));
    }
}
