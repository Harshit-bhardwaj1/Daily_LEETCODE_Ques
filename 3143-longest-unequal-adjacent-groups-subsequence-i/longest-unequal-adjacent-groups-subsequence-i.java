class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        return Words(words, groups);
    }
    public List<String> Words(String[] words, int[] groups){
        int temp = groups[0];
        List<String> str = new ArrayList<>();
        str.add(words[0]);
        for(int i=1; i<words.length; i++){
            if(groups[i]!=temp){
                temp=groups[i];
                str.add(words[i]);
            }
        }
        return str;
    }
}