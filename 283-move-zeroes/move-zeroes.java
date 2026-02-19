class Solution {
    public void moveZeroes(int[] nums) {
        int n=nums.length;
        int[] res=new int[n];
        int wpos=0;
        for(int i=0;i<n;i++)
        {
            if(nums[i]!=0)
            {
                res[wpos++]=nums[i];
            }
        }
        while(wpos<nums.length)
        {
            res[wpos++]=0;
        }
        System.arraycopy(res,0,nums,0,n); 
        }
}