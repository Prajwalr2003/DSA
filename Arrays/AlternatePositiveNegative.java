import java.util.*;
public class AlternatePositiveNegative {

    // public static ArrayList<Long> optimizedSolution(long[] arr){
    //     ArrayList<Long> res = new ArrayList<>();

    // }

    public static ArrayList<Long> alternatePosNeg(long[] arr){
        int n = arr.length;
        long[] ans = new long[n];
        int posIndex=0, negIndex=1;

        for(int i=0;i<arr.length;i++){
            if(arr[i]>0){
                ans[posIndex] = arr[i];
                posIndex = posIndex+2;
            }
            if(arr[i]<0){
                ans[negIndex] = arr[i];
                negIndex = negIndex+2;
            }
        }

        ArrayList<Long> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            res.add(ans[i]);
        }
        return res;

    }
    public static void main(String[] args){
        long[] arr = {-1,2,-3,4,-5,6};
        System.out.println(alternatePosNeg(arr));
    }
}
