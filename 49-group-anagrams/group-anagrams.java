// class Solution {
//     public List<List<String>> groupAnagrams(String[] strs) {
        
//     }
//     public static String GetKey(String s){

//     }
// }

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        return group_anagram(strs);
    }
    public static List<List<String>> group_anagram(String[] arr){
        HashMap<String , List<String>> map= new HashMap<>();
        for(int i=0;i<arr.length;i++){
            String key= Getkey(arr[i]);
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());

            }
            map.get(key).add(arr[i]);
        }
        List<List<String>> ll= new ArrayList<>();
        for(String key:map.keySet()){
            ll.add(map.get(key));
        }
        return ll;

    }
    public static String Getkey(String s){
        int[] freq= new int[26];
        for(int i=0;i<s.length();i++){
            char ch= s.charAt(i);
            freq[ch-'a']++;

        }
        StringBuilder sb= new StringBuilder();
        for(int ele:freq){
            sb.append(ele+" ");
        }
        return sb.toString();
    }
}