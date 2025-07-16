import java.util.*;
public class MajorityElement
{
    // Optimal Solution - Moore's Voting Algorithm
    public static int majorityElement3(int arr[], int n){

        int count=0;
        int el = 0;

        for(int i=0;i<n;i++){

            if(count==0){
                count=1;
                el = arr[i];
            }
            else if(el == arr[i]){
                count++;
            }
            else{
                count--;
            }
        }

        count=0;

        for(int i=0;i<n;i++){
            if(el == arr[i]){
                count++;
            }
        }

        if(count>n/2){
            return el;
        }
        return -1;
    }

    // Better Solution using HashMap
    public static int majorityElement2(int arr[], int n){
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<n;i++){
            int value = map.getOrDefault(arr[i], 0);
            map.put(arr[i], value+1);
        }

        for(Map.Entry<Integer, Integer> it: map.entrySet()){
            if(it.getValue()>n/2){
                return it.getKey();
            }
        }

        return -1;
    }


    // Brute Force
    public static int majorityElement(int arr[], int n){
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i]==arr[j]){
                    count++;
                }
            }
            if(count>n/2){
                return count;
            }
        }

        return -1;
    }

    public static void main(String[] args){

        int arr[] = {3,1,3,3,2};
        int n = arr.length;

        System.out.println(majorityElement(arr, n));
        System.out.println(majorityElement2(arr, n));
        System.out.println(majorityElement3(arr, n));
    }
}