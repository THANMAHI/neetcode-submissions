class Solution {
    public int maxi(int[] arr, int i, int n){
        int max = 0;
        for(int k = i; k < n;k++){
            max = Math.max(max, arr[k]);
        }
        return max;
    }
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        int max = 0;
        for(int i = 0; i < n; i++){
            max = maxi(arr, i+1, n);
            arr[i] = max;
            if(i == n - 1) break;
        }
        arr[n - 1] = -1;
        return arr;
    }
}