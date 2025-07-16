
import java.util.ArrayList;

public class SellStockArrayList {
    // Function to find the days of buying and selling stock for max profit.
    ArrayList<ArrayList<Integer>> stockBuySell(int arr[], int n) {
        
        ArrayList<ArrayList<Integer>> buySellPairs = new ArrayList<>();
        
        int buyDay = 0;
        int sellDay = 0;
        
        for(int i=1;i<n;i++){
            if(arr[i]<arr[i-1]){
                if(buyDay != sellDay){
                    ArrayList<Integer> pairs = new ArrayList<>();
                    pairs.add(buyDay);
                    pairs.add(sellDay);
                    buySellPairs.add(pairs);
                    
                }
                buyDay=i;
            }
            sellDay = i;
        }
        
        if(buyDay != sellDay){
            ArrayList<Integer> pairs = new ArrayList<>();
            pairs.add(buyDay);
            pairs.add(sellDay);
            buySellPairs.add(pairs);
        }
        
        return buySellPairs;
    }

    private static void printBuySellPairs(ArrayList<ArrayList<Integer>> buySellPairs) {
        if (buySellPairs.isEmpty()) {
            System.out.println("No Profit");
        } else {
            for (ArrayList<Integer> pair : buySellPairs) {
                int buyDay = pair.get(0);
                int sellDay = pair.get(1);
                System.out.println("Buy on day " + buyDay + " and sell on day " + sellDay);
            }
        }
    }

    public static void main(String[] args){
        SellStockArrayList solution = new SellStockArrayList();
        int[] arr1 = {100, 180, 260, 310, 40, 535, 695};
        int n1 = arr1.length;
        ArrayList<ArrayList<Integer>> result1 = solution.stockBuySell(arr1, n1);
        printBuySellPairs(result1);
    }
}