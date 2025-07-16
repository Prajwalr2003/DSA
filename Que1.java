import java.util.Scanner;
class Que1
{
  public static int bubbleSort(int arr[], int n)
  {
    int swap1=0, swap2=0;

    for (int i=0; i<n-1; i++) 
    {
      for (int j = 0; j<n-i-1; j++) 
      {
        if (arr[j]>arr[j+1]) 
        {
          int temp = arr[j];
          arr[j] = arr[j+1];
          arr[j+1] = temp;
          swap1++;
        }
        else if (arr[j]<arr[j+1]) 
        {
          int temp = arr[j];
          arr[j] = arr[j+1];
          arr[j+1] = temp;
          swap2++;
        }
      }
    }

    if(swap1>swap2)
    {
      return swap2;
    }
    else{
      return swap1;
    }
  }
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int arr[] = new int[n];
    for(int i=0;i<n;i++)
    {
      arr[i] = sc.nextInt();
    }
    
    System.out.println(bubbleSort(arr, n));
    sc.close();
  }
}