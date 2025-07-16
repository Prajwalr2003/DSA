public class BestTimeToBuySellStocks {

    public static int maxProfit(int[] prices){

        int n=prices.length;
        int buyPrice = Integer.MAX_VALUE;
        int maxPrice = 0;

        for(int i=0;i<n;i++){
            if(buyPrice < prices[i]){
                int profit = prices[i] - buyPrice;
                maxPrice = Math.max(profit, maxPrice);
            }
            else{
                buyPrice = prices[i];
            }
        }

        return maxPrice;
    }

    public static void main(String[] args){
        int prices[] = { 7, 1, 5, 3, 9, 4};
        System.out.println(maxProfit(prices));
    }
}
