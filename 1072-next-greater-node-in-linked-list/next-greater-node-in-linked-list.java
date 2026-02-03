/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        ListNode temp = head;
        int c=0;
        List<Integer> arr = new ArrayList<>();
        while(head!=null){
            temp=head.next;
            while(temp!=null){
                if(temp.val>head.val){
                    arr.add(temp.val);
                    c=1;
                    break;
                }
                temp=temp.next;
            }
            if(c==0){
                arr.add(0);
            }
            else c=0;
            head=head.next;
        }
        int[] ans = new int[arr.size()];
        for(int i=0; i<arr.size(); i++){
            ans[i]=arr.get(i);
        }
        return ans;
    }
}