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
    public boolean isPalindrome(ListNode head) {
        if(head==null) return false;
        List<Integer> ll = new ArrayList<>();
        // return Palindrome1(head,ll);
        return Palindrome2(head);
    }
    // Approach 1 Arrays List
    public boolean Palindrome1(ListNode head, List<Integer> ll){
        while(head!=null){
            ll.add(head.val);
            head=head.next;
        }
        int i=0;
        int j = ll.size()-1;
        while(i<=j){
            if(ll.get(i)!=ll.get(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public boolean Palindrome2(ListNode head){
        Stack<Integer> st = new Stack<>();
        ListNode curr=head;
        while(head!=null){
            st.push(head.val);
            head=head.next;
        }
        while(curr!=null){
            if(curr.val!=st.pop()){
                return false;
            }
            curr=curr.next;
        }
        return true;
    }
}