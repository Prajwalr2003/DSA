import java.util.*;

public class Matrices
{
    public static void maxminofmatrix(int matrix[][]){
        int n=matrix.length;
        int m=matrix[0].length;

        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(min > matrix[i][j]){
                    min = matrix[i][j];
                }
                if(max < matrix[i][j]){
                    max = matrix[i][j];
                }
            }
        }
        System.out.println("Maximum of matrix: "+max);
        System.out.println("Minimum of matrix: "+min);
    }

    public static boolean search(int matrix[][], int key){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==key){
                    System.out.println("Key found at cell ("+i+","+j+")");
                    return true;
                }
            }
        }
        System.out.println("Key not found");
        return false;
    }
    public static void main(String[] args)
    {
        int matrix[][] = new int[3][3];
        int n=matrix.length, m=matrix[0].length;

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter values of matrix: ");
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                matrix[i][j]=sc.nextInt();
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }

        System.out.print("Enter key: ");
        int key = sc.nextInt();
        System.out.println(search(matrix, key));

        sc.close();

        maxminofmatrix(matrix);
    }
}