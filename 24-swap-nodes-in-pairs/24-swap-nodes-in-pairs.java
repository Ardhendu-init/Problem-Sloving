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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode cur = head.next.next;
        ListNode prev = head;
        head = head.next;
        head.next = prev;
        while(cur != null && cur.next != null){
            prev.next = cur.next;
            prev = cur ;
            ListNode temp = cur.next.next;
            cur.next.next = prev;
            cur = temp;
        }
        prev.next = cur;
        return head;
    }
}