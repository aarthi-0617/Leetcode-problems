class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        int m = restrictions.length;
        int[][] res = Arrays.copyOf(restrictions, m + 2);
        
        // Add boundary conditions as implicit restrictions
        res[m] = new int[]{1, 0};
        res[m + 1] = new int[]{n, n - 1};
        
        // Sort restrictions by building ID
        Arrays.sort(res, (a, b) -> Integer.compare(a[0], b[0]));
        
        int len = res.length;
        
        // Pass 1: Left-to-Right propagation
        for (int i = 1; i < len; i++) {
            int dist = res[i][0] - res[i - 1][0];
            res[i][1] = Math.min(res[i][1], res[i - 1][1] + dist);
        }
        
        // Pass 2: Right-to-Left propagation
        for (int i = len - 2; i >= 0; i--) {
            int dist = res[i + 1][0] - res[i][0];
            res[i][1] = Math.min(res[i][1], res[i + 1][1] + dist);
        }
        
        // Calculate the maximum possible peak between any two adjacent restricted buildings
        int maxHeight = 0;
        for (int i = 1; i < len; i++) {
            int id1 = res[i - 1][0];
            int h1 = res[i - 1][1];
            int id2 = res[i][0];
            int h2 = res[i][1];
            
            // Peak formula derived from: h1 + x = h2 + (id2 - id1 - x)
            int peak = (h1 + h2 + (id2 - id1)) / 2;
            maxHeight = Math.max(maxHeight, peak);
        }
        
        return maxHeight;
        
    }
}