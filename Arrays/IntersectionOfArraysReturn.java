
import java.util.*;
public class IntersectionOfArraysReturn {
    
    public static int[] intersectionOfTwoArrays(int a[], int b[]){

        HashSet<Integer> hs = new HashSet<>();
        HashSet<Integer> ans = new HashSet<>();

        for(int i=0;i<a.length;i++){
            hs.add(a[i]);
        }

        for(int i=0;i<b.length;i++){
            if(hs.contains(b[i])){
                ans.add(b[i]);
            }
        }

        int result[] = new int[ans.size()];
        int index=0;
        for(int num : ans){
            result[index++]=num;
        }
        return result;
    }
    
    public static void main(String[] args){
        int[] a = {4, 9, 5, 8};
        int[] b = { 9, 4, 9, 8, 4, 5};
        int[] intersection = intersectionOfTwoArrays(a, b);
        System.out.println(Arrays.toString(intersection));
    }
}
