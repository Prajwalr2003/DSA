import java.util.*;
public class ChocolateDistributionProblem {
    
    public static int minDiff(ArrayList<Integer> a, int m){

        Collections.sort(a);

        int min = Integer.MAX_VALUE;

        for(int i=0;i+m-1<a.size();i++){

            int minDiff = a.get(i+m-1)-a.get(i);

            min = Math.min(min, minDiff);
        }

        return min;
    }

    public static void main(String[] args){

        ArrayList<Integer> list = new ArrayList<>();

        list.add(0,3);
        list.add(1,4);
        list.add(2,1);
        list.add(3,9);
        list.add(4,56);
        list.add(5,7);
        list.add(6,9);
        list.add(7,12);

        System.out.println(minDiff(list, 5));
    }
}
