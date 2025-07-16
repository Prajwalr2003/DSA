public class MaxCountPosNegInteger {

    public static int maxCount(int arr[]){
        int n = arr.length;

        int pos=0, neg=0;

        for(int i=0;i<n;i++){
            if(arr[i]>0){
                pos++;
            }
            if(arr[i]<0){
                neg++;
            }
        }

        if(pos>neg){
            return pos;
        }
        else{
            return neg;
        }
    }
    
    public static void main(String[] args){
        int arr[] = {-2,-1,-1,1,2,3};
        System.out.print(maxCount(arr));
    }
}
