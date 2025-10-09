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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast= fast.next.next;
        }
        ListNode first=head;
        ListNode second = reverse(slow.next);
        slow.next=null;

        while(second!=null){
            ListNode next1 = first.next;
            ListNode next2 = second.next;
            first.next=second;
            second.next=next1;
            first=next1;
            second=next2;
        }
    }
    public ListNode reverse(ListNode head){
        ListNode prev= null;
        ListNode curr = head;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}