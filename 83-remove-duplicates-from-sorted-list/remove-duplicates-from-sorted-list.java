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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return null;
        return Duplicate(head,head);
    }
    public ListNode Duplicate(ListNode head,ListNode temp){
        if(temp.next==null){
            return head; 
        }
        if(temp.val==temp.next.val){
            temp.next=temp.next.next;
            return Duplicate(head, temp);
        }
        return Duplicate(head,temp.next);        
    }
}