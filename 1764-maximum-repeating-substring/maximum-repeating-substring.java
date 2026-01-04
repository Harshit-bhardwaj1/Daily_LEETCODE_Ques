// class Solution {
//     public int maxRepeating(String sequence, String word) {
//         return Repeat(sequence, word);
//     }
//     public int Repeat(String sequence, String word){
//         if(sequence.length()==1 && word.length()==1){
//             if(sequence.charAt(0)== word.charAt(0)){
//                 return 1;
//             }
//         }
//         int count =0;
//         int i=0;
//         int j=0;
//         while(i<sequence.length()){
//             if(sequence.charAt(i)==word.charAt(j)){
//                 i++;
//                 j++;
//                 if(j==word.length()){
//                     j=0;
//                     count++;
//                 }
//             }
//             else{
//                 i++;
//                 j=0;
//             }
//         }
//         return count;
//     }
// }


class Solution {
    public int maxRepeating(String sequence, String word) {
        int count = 0;
        String temp = word;

        while (sequence.contains(temp)) {
            count++;
            temp = temp + word;
        }

        return count;
    }
}
