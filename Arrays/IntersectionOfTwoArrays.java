import java.util.*;
public class IntersectionOfTwoArrays {

    public static int optimizedSolution(int[] a, int[] b){
        HashSet<Integer> hs = new HashSet<>();

        int count=0;
        for(int i=0;i<a.length;i++){
            hs.add(a[i]);
        }

        for(int i=0;i<b.length;i++){
            if(hs.contains(b[i])){
                count++;
                hs.remove(b[i]);
            }
        }
        return count;
    }

    // For Sorted Arrays - Brute Force Approach
    public static int intersectionOftwoArrays(int a[], int b[]){
        int n = a.length;
        int m = b.length;
        ArrayList<Integer> res = new ArrayList<>();

        int left=0, right=0;

        while(left<n || right<m){

            while(left>0 && left<n && a[left]==a[left-1]){
                left++;
            }
            while(right>0 && right<n && b[right]==b[right-1]){
                right++;
            }

            if(left>=n || right>=m){
                break;
            }

            if(a[left]<b[right]){
                left++;
            }
            else if(a[left]>b[right]){
                right++;
            }
            else if(a[left]==b[right]){
                res.add(a[left]);
                left++;
                right++;
            }
        }
        return res.size();
    }
    public static void main(String[] args){
        int[] a = { 1, 1, 2, 5, 6, 8, 9, 10,12};
        int[] b = {2, 4, 3, 5, 6, 8, 10, 11, 12,};

        // System.out.println(intersectionOftwoArrays(a, b));
        System.out.println(optimizedSolution(a, b));
    }
}
