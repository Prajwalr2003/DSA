public class RemoveDuplicateFromSortedArray {

    public static int removeDuplicate(int arr[]){

        int n = arr.length;
        int j=0;

        for(int i=0;i<n;i++){

            if(arr[j]!=arr[i]){
                j++;
                arr[j]=arr[i];
            }
        }
        return j+1;
    }

    public static void main(String[] args){
        int arr[]={1,1,2,3,3,4,5};

        System.out.println(removeDuplicate(arr));
    }
}
