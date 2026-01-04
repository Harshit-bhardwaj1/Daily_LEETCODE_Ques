class Solution {
    public int maxRepeating(String sequence, String word) {
        return Repeat(sequence, word);
    }
    public int Repeat(String sequence, String word){
        String temp = word;
        int k=0;
        while(true){
            if(sequence.contains(temp)){
                k++;
                temp+=word;
            }
            else{
                break;
            }
        }
        return k;
    }
}

















// class Solution {
//     public int maxRepeating(String sequence, String word) {
//         int count = 0;
//         String temp = word;

//         while (sequence.contains(temp)) {
//             count++;
//             temp = temp + word;
//         }

//         return count;
//     }
// }
