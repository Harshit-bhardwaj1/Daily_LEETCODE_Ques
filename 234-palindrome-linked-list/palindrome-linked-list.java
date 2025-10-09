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
    ListNode curr;
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null) return true;
        List<Integer> ll = new ArrayList<>();
        // return Palindrome1(head,ll);
        // return Palindrome2(head);
        curr=head;
        // return Palindrome3(head);
        return Palindrome4(head);
        

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

    // Approach 2 stack
    public boolean Palindrome2(ListNode head){
        Stack<Integer> st = new Stack<>();
        ListNode temp=head;
        while(head!=null){
            st.push(head.val);
            head=head.next;
        }
        while(temp!=null){
            if(temp.val!=st.pop()){
                return false;
            }
            temp=temp.next;
        }
        return true;
    }
    
    // Approach 3 recursion
    public boolean Palindrome3(ListNode head){
        if(head==null) return true;

        boolean ans = Palindrome3(head.next) && head.val == curr.val;
        curr= curr.next;
        return ans;
    }

    // Approach 4 half pointer
    public boolean Palindrome4(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast= fast.next.next;
        }

        ListNode firsthalf = head;
        ListNode secondhalf= reverse(slow);

        while(secondhalf!=null){
            if(secondhalf.val!=firsthalf.val){
                return false;
            }
            firsthalf=firsthalf.next;
            secondhalf = secondhalf.next;
        }
        return true;
    }
    public ListNode reverse(ListNode head){
        ListNode prev= null;
        ListNode curr1 = head;
        while(curr1!=null){
            ListNode next = curr1.next;
            curr1.next=prev;
            prev=curr1;
            curr1=next;
        }
        return prev;
    }
}