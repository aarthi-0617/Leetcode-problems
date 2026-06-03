class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer>num=new HashSet<>();
        for(Integer n:nums)
        {
            if(num.contains(n))
            {
                return true;
            }
            num.add(n);
        }
        return false;
        
    }
}