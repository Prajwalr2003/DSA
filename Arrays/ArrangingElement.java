public class ArrangingElement
{
    public static void ArrangePosNegEle(int arr[]){

        int ans[] = new int[arr.length];
        int posIndex=0, negIndex=0;

        for(int i=0;i<arr.length;i++){
            if(arr[i]<0){
                ans[negIndex]=arr[i];
                negIndex++;
            }
        }

        posIndex = negIndex;

        for(int i=0;i<arr.length;i++){
            if(arr[i]>0){
                ans[posIndex]=arr[i];
                posIndex++;
            }
        }

        for(int i=0;i<arr.length;i++){
            System.out.print(ans[i]+" ");
        }


    }

    public static void main(String[] args){

        int arr[] = {-3, 1, -2, 4};

        ArrangePosNegEle(arr);
    }
}