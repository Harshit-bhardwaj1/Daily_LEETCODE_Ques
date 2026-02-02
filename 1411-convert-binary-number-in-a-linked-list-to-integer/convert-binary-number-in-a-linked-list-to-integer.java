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
    public int getDecimalValue(ListNode head) {
        StringBuilder str = new StringBuilder();
        while(head!=null){
            str.append(head.val);
            head=head.next;
        }
        int count=0;
        int sum=0;
        for(int i=str.length()-1; i>=0; i--){
            if(str.charAt(i)=='1'){
                sum += (1 << count);
            }
            count++;
        }
        return sum;
    }
}