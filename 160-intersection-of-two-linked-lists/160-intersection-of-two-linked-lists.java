/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode d1 = headA;
        ListNode d2 = headB;
        ListNode ans = null;
        while(d1 != null || d2 != null){
            if(d1 == null){
                d1 = headB;
            }
            if(d2 == null){
                d2 = headA;
            }
            if(d1 == d2){
                ans =d1;
                break;
            }
            d1 = d1.next;
            d2 = d2.next;
        }
        return ans ;
    }
    
}