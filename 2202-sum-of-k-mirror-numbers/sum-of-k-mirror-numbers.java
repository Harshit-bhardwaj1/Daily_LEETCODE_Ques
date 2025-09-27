// class Solution {
//     public long kMirror(int k, int n) {
//         int L = 1;

//         long sum=0L;
//         while(n>0){
//             int half = (L+1)/2;
//             int min= (int)Math.pow(10,half-1);
//             int max= (int)Math.pow(10,half)-1;
//             for(int num=min; num<=max; num++){
//                 long temp;
//                 if(L%2==0){
//                     temp= temp+rev(num);
//                 }
//                 else{
//                     temp=temp+rev(num/10);
//                 }
//                 if (isPalin(baseK(n, k))) {
//                     sum += n;
//                     n--;
//                 }
//             }
//             L++;
//         }
//         return sum;
//     }
//     public String baseK(int n,int k){
//         StringBuilder sb = new StringBuilder<>();
//         while(n>0){
//             sb.append(n%k);
//             n=n/k;
//         }
//         return sb.toString();
//     }

//     public boolean isPalin(String n){
//         int i=0;
//         int j=n.length()-1;
//         while(i<=j){
//             if(n.charAt(i)!=n.charAt(j)){
//                 return false;
//             }
//             i++;
//             j--;
//         }
//         return true;
//     }
// }


class Solution {
    public long kMirror(int k, int n) {
        int L = 1;  // length of palindrome
        long sum = 0L;

        while (n > 0) {
            int half = (L + 1) / 2;
            int min = (int) Math.pow(10, half - 1);
            int max = (int) Math.pow(10, half) - 1;

            for (int num = min; num <= max && n > 0; num++) {
                String halfStr = String.valueOf(num);
                String palStr;

                // If length is even, mirror fully
                if (L % 2 == 0) {
                    palStr = halfStr + new StringBuilder(halfStr).reverse().toString();
                } 
                // If length is odd, mirror without the last digit
                else {
                    palStr = halfStr + new StringBuilder(halfStr.substring(0, halfStr.length() - 1)).reverse().toString();
                }

                long pal = Long.parseLong(palStr);

                // Check if palindrome in base k
                if (isPalin(baseK(pal, k))) {
                    sum += pal;
                    n--;
                }
            }
            L++;
        }
        return sum;
    }

    // Convert number to base-k string
    public String baseK(long n, int k) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % k);
            n /= k;
        }
        return sb.reverse().toString();
    }

    // Check palindrome for a string
    public boolean isPalin(String s) {
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
