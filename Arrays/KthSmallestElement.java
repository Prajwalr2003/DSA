
import java.util.*;
import java.util.PriorityQueue;
public class KthSmallestElement {

    public static int kthSmallElement(int[] arr,int k){

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        // for(int i=0;i<arr.length;i++){
        //     pq.add(arr[i]);
        // }

        // for(int i=1;i<k;i++){
        //     pq.poll();
        // }

        for(int i=0;i<k;i++){
            pq.add(arr[i]);
        }

        for(int i=k;i<arr.length;i++){
            if(arr[i]<pq.peek()){
                pq.poll();
                pq.add(arr[i]);
            }
        }
        return pq.peek();
    }

    public static void main(String[] args){

        int[] arr = {7,10,4,3,20,15};

        System.out.print(kthSmallElement(arr, 3));
    }
}
