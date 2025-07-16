
public class BuySellStocksAtMostTwice
{
    public static int buySellStocks(int prices[], int n){

        int firstBuy = Integer.MAX_VALUE;
        int firstSell = 0;
        int secondBuy = Integer.MAX_VALUE;
        int secondSell = 0;

        for(int i=0;i<n;i++){

            firstBuy = Math.min(firstBuy, prices[i]);
            firstSell = Math.max(firstSell, prices[i]-firstBuy);
            secondBuy =  Math.min(secondBuy, prices[i]-firstSell);
            secondSell = Math.max(secondSell, prices[i]-secondBuy);
        }

        return secondSell;

    }
    public static void main(String[] args){
        int arr[] = { 10, 22, 5, 75, 65, 80};
        int n = arr.length;

        System.out.println(buySellStocks(arr, n));
    }
}