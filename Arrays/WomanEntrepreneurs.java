import java.util.*;
public class WomanEntrepreneurs {
    
    public static int solution(List<Integer> arr){

        int sum=0;

        while(arr.size()>0){
            int min=Integer.MAX_VALUE;
            int index=-1;

            for(int i=0;i<arr.size();i++){
                if(min>arr.get(i)){
                    min=arr.get(i);
                    index=i;
                }
            }

            sum += min;

            arr.remove(index);

            if(index<arr.size()-1){
                arr.remove(index);
            }

            if(index>0){
                arr.remove(index-1);
            }
        }

        return sum;
    }
    public static void main(String[] args){
        
        ArrayList<Integer> list = new ArrayList<>();

        list.add(6);
        list.add(4);
        list.add(9);
        list.add(10);
        list.add(34);
        list.add(56);
        list.add(54);

        System.out.println(solution(list));
    }
}
