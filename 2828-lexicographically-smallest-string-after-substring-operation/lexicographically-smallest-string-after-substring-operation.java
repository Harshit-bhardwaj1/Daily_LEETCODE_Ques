class Solution {
    public String smallestString(String s) {
        return String(s);
    }
    public String String(String s){
        char[] arr = s.toCharArray();
        int n = arr.length;
        int i = 0;

        // skip all leading 'a'
        while (i < n && arr[i] == 'a') {
            i++;
        }

        // if all characters are 'a'
        if (i == n) {
            arr[n - 1] = 'z';
            return new String(arr);
        }

        // decrease characters until 'a' appears
        while (i < n && arr[i] != 'a') {
            arr[i] = (char)(arr[i] - 1);
            i++;
        }

        return new String(arr);
    }
}