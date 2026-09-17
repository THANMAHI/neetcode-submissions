class Solution {
    public int longestConsecutive(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        if(n == 0) return 0;
        int max = 1, cnt = 1;
        for(int i = 0; i < n-1; i++){
            if(arr[i] == arr[i + 1] - 1){
                cnt++;
                if(cnt > max) max = cnt;
            }
            else if(arr[i] == arr[i+1]) continue;
            else cnt = 1;
        }
        return max;
    }
}
