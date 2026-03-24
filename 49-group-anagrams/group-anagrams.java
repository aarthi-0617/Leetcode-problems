import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        
        Map<String, List<String>> map = new HashMap<>();
        
        for (String s : strs) {
            // Convert string to char array, sort it, and turn back to string
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            
            // If the key doesn't exist, create a new list
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            
            // Add the original string to the list corresponding to the sorted key
            map.get(key).add(s);
        }
        
        // Return all the lists stored in the map values
        return new ArrayList<>(map.values());
    }
}
