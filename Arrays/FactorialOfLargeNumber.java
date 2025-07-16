import java.util.ArrayList;

public class FactorialOfLargeNumber {

    static ArrayList<Integer> factorial(int N){
        //code here
        
        ArrayList<Integer> res = new ArrayList<>();
        
        int size=1, val=2, carry=0;
        
        res.add(0,1);
        
        while(val<=N){

            for(int i=size-1;i>=0;i--){
                
                int temp = res.get(i)*val+carry;
                
                res.set(i, temp%10);
                
                carry = temp/10;
            }
            
            while(carry != 0){
                res.add(0, carry%10);
                carry = carry/10;
                size++;
            }
            val++;
        }
        
        return res;
    }

    public static void main(String[] args){

        System.out.println(factorial(1000));
    }
}
