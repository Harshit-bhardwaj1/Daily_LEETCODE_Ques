class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int  i : nums1){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        List<Integer> ll = new ArrayList<>();
        for(int num : nums2){
            if (map.containsKey(num) && map.get(num) > 0) {
                ll.add(num);
                map.put(num, map.get(num) - 1);
            }
        }
        
        int[] arr = new int[ll.size()];
        for(int i=0; i<arr.length; i++){
            arr[i]=ll.get(i);
        }
        return arr;
    }
}