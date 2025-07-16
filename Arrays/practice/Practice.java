public class Practice {
    public static void main(String[] args){
        int x=5, y=8;
        System.out.println(x+" "+y);
        swap(x,y);
        System.out.println(x+" "+y);
    }

    public static void swap(int a, int b){
        int temp;
        temp = a;
        a = b;
        b = temp;
        System.out.println(a+" "+b);
    }
}
