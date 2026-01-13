class Solution {
    public int strStr(String haystack, String needle) {
        return Check(haystack, needle);
    }
    public static int Check(String haystack, String needle){
        if(needle.length()>haystack.length()){
            return -1;
        }
        else if(needle.length()==haystack.length() && needle.equals(haystack)){
            return 0;
        }
        else{
            int n= needle.length();
            for(int i=0; i<=haystack.length()-n; i++){
                if(haystack.substring(i,i+n).equals(needle)){
                    return i;
                    
                }
            }
        }
        return -1;
    }
}