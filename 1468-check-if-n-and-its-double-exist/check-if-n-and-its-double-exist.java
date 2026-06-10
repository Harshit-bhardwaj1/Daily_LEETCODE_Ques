// class Solution {
//     public boolean checkIfExist(int[] arr) {
//         return Check(arr);
//     }
//     public static boolean Check(int[] arr){
//         Arrays.sort(arr);
//         int i=0;
//         for(int x: arr){
//             if(Condition(x,arr,i)){
//                 return true;
//             }
//             i++;
//         }
//         return false;
//     }
//     public static boolean Condition(int x, int[] arr, int i){
//         int lo=i+1;
//         int hi=arr.length-1;
//         while(lo<=hi){
//             int mid=lo+(hi-lo)/2;
//             if(x==2*arr[mid]){
//                 return true;
//             }
//             else if(x>2*arr[mid]){
//                 lo=mid+1;
//             }
//             else{
//                 hi=mid-1;
//             }
//         }
//         return false;
//     }
// }


class Solution {
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> set = new HashSet();
        for(int num : arr){
            if(set.contains(num*2)) return true;
            else if(num % 2 == 0 && set.contains(num/2)) return true;
            
            set.add(num);
        }
        return false;
    }
}