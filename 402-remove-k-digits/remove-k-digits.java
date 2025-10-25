class Solution {
    public String removeKdigits(String num, int k) {
        if (num.length() == k) return "0"; // remove all digits → 0

        StringBuilder sb = new StringBuilder();
        for (char c : num.toCharArray()) {
            // remove digits from the end if they are bigger than current digit
            while (k > 0 && sb.length() > 0 && sb.charAt(sb.length() - 1) > c) {
                sb.deleteCharAt(sb.length() - 1);
                k--;
            }
            sb.append(c);
        }

        // if k is still left, remove from the end
        while (k > 0 && sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
            k--;
        }

        // remove leading zeros
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        // if empty, return "0"
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
