import java.util.*;
public class BasicSortingAlgo {
    
    public static void bubbleSort(int arr[])
    {
        for(int turn=0; turn<arr.length-1;turn++)
        {
            for(int j=0;j<arr.length-1-turn;j++)
            {
                if(arr[j]>arr[j+1])
                {
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }

    public static void printArray(int arr[])
    {
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void selectionSort(int arr[])
    {
        for(int i=0;i<arr.length-1;i++)
        {
            int minPos=i;
            for(int j=i+1;j<arr.length;j++)
            {
                if(arr[minPos]>arr[j])
                {
                    minPos=j;
                }
            }

            //swap
            int temp=arr[minPos];
            arr[minPos]=arr[i];
            arr[i]=temp;
        }
    }

    public static void insertionSort(int arr[])
    {
        for(int i=0;i<arr.length;i++)
        {
            int curr = arr[i];
            int prev=i-1;

            while(prev>=0 && arr[prev]>curr)
            {
                arr[prev+1]=arr[prev];
                prev--;
            }

            arr[prev+1]=curr;
        }
    }

    public static void countingSort(int arr[])
    {
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++)
        {
            if(max<arr[i])
            {
                max=arr[i];
            }
        }

        int temp[] = new int[max+1];
        Arrays.fill(temp, 0);
        for(int i=0;i<arr.length;i++)
        {
            temp[arr[i]]++;
        }

        int j=0;
        for(int i=0;i<arr.length;i++)
        {
            while(temp[i]>0)
            {
                arr[j]=i;
                j++;
                temp[i]--;
            }
        
        }
    }

    public static void main(String[] args)
    {
        // int arr[] = {5, 3, 2, 4, 1};
        // bubbleSort(arr);
        // selectionSort(arr);
        // insertionSort(arr);

        int arr[] = {1, 4, 1, 3, 2, 4, 3, 7};
        countingSort(arr);
        printArray(arr);
    }
}
