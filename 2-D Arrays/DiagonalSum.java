public class DiagonalSum {

    //Optimized Solution
    public static int diagonalSum2(int matrix[][]){
        int sum=0;

        for(int i=0;i<matrix.length;i++){
            sum += matrix[i][i];

            if(i != matrix.length-1-i){
                sum += matrix[i][matrix.length-1-i];
            }
        }

        return sum;
    }

    //Brute force
    public static int diagonalSum(int matrix[][]){

        int sum = 0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(i==j){
                    sum+=matrix[i][j];
                }
                else if(i+j == matrix.length-1){
                    sum+=matrix[i][j];
                }
            }
        }
        return sum;
    }
    public static void main(String[] args){
        int matrix[][] = {{1,1,1},{1,1,1},{1,1,1}};
        // System.out.println(diagonalSum(matrix));
        System.out.println(diagonalSum2(matrix));
    }
}
