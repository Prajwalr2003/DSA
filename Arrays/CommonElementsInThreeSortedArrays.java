import java.util.*;
public class CommonElementsInThreeSortedArrays {

    public static ArrayList<Integer> usingHashMap(int arr[], int brr[], int crr[]){
        ArrayList<Integer> res = new ArrayList<>();

        int n1 = arr.length;
        int n2 = brr.length;
        int n3 = crr.length;

        HashMap<Integer, Integer> m1 = new HashMap<>();
        HashMap<Integer, Integer> m2 = new HashMap<>();
        HashMap<Integer, Integer> m3 = new HashMap<>();

        for(int i=0;i<n1;i++){
            m1.put(arr[i],1);
        }
        for(int j=0;j<n2;j++){
            m2.put(brr[j],1);
        }
        for(int k=0;k<n3;k++){
            m3.put(crr[k], 1);
        }

        for(int i=0;i<n1;i++){
            if(m1.containsKey(arr[i]) && m2.containsKey(arr[i]) && m3.containsKey(arr[i])){
                res.add(arr[i]);
                m1.remove(arr[i]);
            }
        }
        if(res.size()==0){
            res.add(-1);
        }
        return res;

    }
    
    public static ArrayList<Integer> commonElements(int arr[], int brr[], int crr[]){
        
        ArrayList<Integer> res = new ArrayList<>();

        int x = arr.length;
        int y = brr.length;
        int z = crr.length;
        int i=0, j=0, k=0;

        while(i<x && j<y && k<z){
            if(arr[i]==brr[j] && brr[j]==crr[k]){
                res.add(arr[i]);
                i++;
                j++;
                k++;

                int a=arr[i-1];
                while(i<x && arr[i]==a){
                    i++;
                }
                int b=brr[j-1];
                while(j<y && brr[j]==b){
                    j++;
                }
                int c=crr[k-1];
                while(k<z && crr[k]==c){
                    k++;
                }
            }
            else if(arr[i]<brr[j]){
                i++;
            }
            else if(brr[j]<crr[k]){
                j++;
            }
            else{
                k++;
            } 
        }

        if(res.size() == 0){
            res.add(-1);
        }

        return res;
    }

    public static void main(String[] args){
        int arr[] = { 1, 5, 10, 20, 40, 80};
        int brr[] = { 5, 6, 20, 80, 100};
        int crr[] = { 3, 5, 15, 20, 30, 70, 80, 120};

        //  System.out.println(commonElements(arr, brr, crr));
        System.out.println(usingHashMap(arr, brr, crr));
        
    }
}
