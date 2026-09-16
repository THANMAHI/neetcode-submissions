class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String k = new String(c);
            if(!map.containsKey(k)){
                map.put(k, new ArrayList<>());
            }
            map.get(k).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
