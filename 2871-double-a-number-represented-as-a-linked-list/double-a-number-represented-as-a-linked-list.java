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
    public ListNode doubleIt(ListNode head) {
        head = Reverse(head);
        ListNode temp =head;
        int carry=0;
        while(temp!=null){
            ListNode next = temp.next;
            int val = temp.val;
            val=val*2+carry;
            temp.val=val%10;
            carry = val/10;
            if(temp.next==null && carry>0){
                temp.next=new ListNode(carry);
                break;
            }
            temp=temp.next;
        }
        return Reverse(head);
    }
    public ListNode Reverse(ListNode head){
        ListNode prev = null;
        ListNode temp=head;
        while(temp!=null){
            ListNode next=temp.next;
            temp.next=prev;
            prev=temp;
            temp=next;
        }
        return prev;
    }
}