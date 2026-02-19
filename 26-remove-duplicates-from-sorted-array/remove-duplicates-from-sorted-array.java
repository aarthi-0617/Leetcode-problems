class Solution {
    public int removeDuplicates(int[] nums) {
        int [] res=new int[nums.length];
        int wpos=0;
        if(nums.length==0)
        {
            return 0;
        }
         for(int rpos=1;rpos<nums.length;rpos++)
         {
            if(nums[rpos]!=nums[wpos])
            {
                wpos++;
                nums[wpos]=nums[rpos];
                
            }
         }
        return wpos+1;
    }
}