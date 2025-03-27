# march27_2025
The problem that i solved today in leetcode

1.An element x of an integer array arr of length m is dominant if more than half the elements of arr have a value of x.

You are given a 0-indexed integer array nums of length n with one dominant element.

You can split nums at an index i into two arrays nums[0, ..., i] and nums[i + 1, ..., n - 1], but the split is only valid if:

0 <= i < n - 1
nums[0, ..., i], and nums[i + 1, ..., n - 1] have the same dominant element.
Here, nums[i, ..., j] denotes the subarray of nums starting at index i and ending at index j, both ends being inclusive. Particularly, if j < i then nums[i, ..., j] denotes an empty subarray.

Return the minimum index of a valid split. If no valid split exists, return -1.

Code:
class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n=nums.size();
        Map<Integer,Integer> m=new HashMap<>();
        int max=0,val=-1;
        for(int x:nums)
        {
            m.put(x,m.getOrDefault(x,0)+1);
            if(m.get(x)>max)
            {
                max=m.get(x);
                val=x;
            }
        }
        if(max<=n/2)
            return -1;
        int cnt=0;
        for(int i=0;i<n;i++)
        {
            if(nums.get(i)==val) cnt++;
            int l=i+1;
            int r=n-(i+1);
            if(cnt>l/2 && max-cnt>r/2)
                return i;
        }
        return -1;
    }
}
