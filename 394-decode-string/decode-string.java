class Solution {
    public String decodeString(String s) {
        return Decode(s);
    }
    public String Decode(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        String currStr = "";
        int k = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0'); // build multi-digit number
            } 
            else if (ch == '[') {
                numStack.push(k);
                strStack.push(currStr);
                k = 0;
                currStr = "";
            } 
            else if (ch == ']') {
                int repeat = numStack.pop();
                StringBuilder temp = new StringBuilder(strStack.pop());
                for (int j = 0; j < repeat; j++) {
                    temp.append(currStr);
                }
                currStr = temp.toString();
            } 
            else {
                currStr += ch;
            }
        }

        return currStr;
    }
}