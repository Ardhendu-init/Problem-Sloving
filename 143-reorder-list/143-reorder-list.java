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
        left = head;
        foldll(head , 0);
        
    }
    ListNode left = null;;
    int size = 0;
    public void foldll(ListNode right , int floor){
        if(right == null){
            size = floor;
            return ;
        }
        foldll(right.next , floor+1);
        ListNode temp = left.next;
        if(floor > size/2){
            left.next = right ;
            right.next = temp;
            left = temp;
        }else if(floor ==size/2){
            
            right.next = null;
        }
        
    }
}