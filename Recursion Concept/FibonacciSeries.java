public class FibonacciSeries {

    public static int fib(int n)
    {
        if(n == 0 || n == 1)
        {
            return n;
        }
        int fibnm1 = fib(n-1);
        int fibnm2 = fib(n-2); 
        int fib = fibnm1 + fibnm2;

        return fib;
    }
    
    public static void main(String[] args)
    {
        System.out.println(fib(20));
        System.out.println(fib(21));
        System.out.println(fib(22));
        System.out.println(fib(23));
        System.out.println(fib(24));
        System.out.println(fib(25));
        System.out.println(fib(26));
        System.out.println(fib(27));
        System.out.println(fib(28));
    }
}
