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