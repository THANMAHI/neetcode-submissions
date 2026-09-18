class Solution {
    public static void conquer(int[] nums, int low, int mid, int high){
        int[] ans = new int[high-low+1];
        int i=low;
        int j=mid+1;
        int k=0;

        while(i<=mid && j<=high){
            if(nums[i]<=nums[j]){
                ans[k++]=nums[i];
                i++;
            }
            else{
                ans[k++]=nums[j];
                j++;
            }
        }
        while(i<=mid){
            ans[k++]=nums[i++];
        }
        while(j<=high){
            ans[k++]=nums[j++];
        }
        for(int x=0, p=low; x<ans.length;x++,p++){
            nums[p]=ans[x];
        }
    }
    public static void divide(int[] nums, int low, int high){
        if(low<high){
            int mid = low+(high-low)/2;
            divide(nums, low, mid);
            divide(nums, mid+1, high);
            conquer(nums, low, mid, high);
        }
    }
    public int[] sortColors(int[] nums) {
        int n = nums.length;
        divide(nums, 0, n-1);
        return nums;
    }
}