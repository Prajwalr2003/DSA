public class PowerOf2OrNot {
    
    public static boolean isPowerOf2(int n)
    {
        return (n&(n-1))==0;
    }

    public static void main(String[] args)
    {
        System.out.println(isPowerOf2(30));
    }
    
}
