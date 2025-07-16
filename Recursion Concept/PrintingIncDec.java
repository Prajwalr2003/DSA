
public class PrintingIncDec {

    public static void printInc(int n)
    {
        if(n == 1){
            System.out.print(n+" ");
            return;
        }

        printInc(n-1);
        System.out.print(n+" ");
    }

    public static void printDec(int n)
    {
        if(n == 1){
            System.out.println(n+" ");
            return;
        }

        System.out.print(n+" ");
        printDec(n-1);
    }

    public static void main(String[] args){
        int n = 10;
        printInc(10);
        System.out.println();
        printDec(n);
        
    }
}
