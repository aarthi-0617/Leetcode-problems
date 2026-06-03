class Solution {
    public int maxProfit(int[] prices) {

        int minprice=prices[0];
        int maxprice=0;
        int price=0;

        for(int i=1;i<prices.length;i++)
        {
            price=prices[i]-minprice;

            if(price>maxprice)
            {
                maxprice=price;
            }
            if(prices[i]<minprice)
            {
                minprice=prices[i];
            }

        
        }
        return maxprice;

        
    }
}