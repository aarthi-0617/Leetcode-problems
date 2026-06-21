import java.util.Arrays;

class Solution {
    public int maxIceCream(int[] costs, int coins) {
        // Sort costs to prioritize the cheapest ice cream bars
        Arrays.sort(costs);
        int barsBought = 0;
        
        for (int cost : costs) {
            if (coins >= cost) {
                coins -= cost;
                barsBought++;
            } else {
                // If we cannot afford the current cheapest, we cannot afford any remaining ones
                break;
            }
        }
        
        return barsBought;
    }
}
