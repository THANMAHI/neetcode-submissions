class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[n - 1];
        String res = "";
        for(int i = 0; i < Math.min(first.length(), last.length()); i++){
            if(first.charAt(i) == last.charAt(i)) res+=first.charAt(i);
            else break;
        }
        return res;
    }
}