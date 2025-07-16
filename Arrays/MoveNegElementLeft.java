public class MoveNegElementLeft {

    public static void moveNegativeLeft(int arr[]){

        int j=1;
        int i=0;
        while(i<arr.length && j<arr.length){

            if(arr[i]<0 && arr[j]<0){
                i++;
                j++;
            }
            else if(arr[i]>0 && arr[j]<0){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;
                j++;
            }
            else if(arr[i]<0 && arr[j]>0){
                i++;
                j++;
            }
            else{
                j++;
            }
        }

        for(int k=0;k<arr.length;k++){
            System.out.print(arr[k]+" ");
        }
    }
    
    public static void main(String[] args){

        int arr[] = { -12, 11, -3, 5, 6, -1, -2};

        moveNegativeLeft(arr);
    }
}
