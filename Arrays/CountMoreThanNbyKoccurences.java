import java.util.*;
public class CountMoreThanNbyKoccurences {

    public static int countOccurences(int arr[], int n, int k){
        HashMap<Integer, Integer> map = new HashMap<>();

        int count = 0;

        for(int i=0;i<n;i++){
            int value=map.getOrDefault(arr[i],0);
            map.put(arr[i], value+1);
        }

        for(Map.Entry<Integer, Integer> it: map.entrySet()){
            if(it.getValue() > n/k){
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args){
        int arr[] = { 3, 1, 2, 2, 1, 2, 3, 3};
        int n = arr.length;
        int k=4;

        System.out.println(countOccurences(arr, n, k));
    }
}
