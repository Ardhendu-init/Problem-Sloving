// { Driver Code Starts
import java.util.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class ReverseInSize
{
    static Node head;
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node tail = head;
            for(int i = 1; i < n; i++)
            {
                int a = sc.nextInt();
                // addToTheLast(new Node(a));
                tail.next = new Node(a);
                tail =tail.next;
            }
            
            int k = sc.nextInt();
            Solution ob = new Solution();
            Node res = ob.reverse(head, k);
            printList(res);
            System.out.println();
        }
    }
    
    public static void printList(Node node)
    {
        while(node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
    
}

// } Driver Code Ends


/*node class of the linked list

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/

class Solution
{
    static Node th =null;//temporary head
    static Node tt = null;//temporary tail
    public static Node reverse(Node node, int k)
    {
        if(node == null || node.next == null || k <= 1){
            return node;
        }
        int len = length(node);
        Node oh = null;
        Node ot = null;
        Node cur = node;
        while(cur != null){
            int tempk = 0;
            if(len >= k ){
                tempk = k;
            }else{
                tempk = len;
            }
            
            while(tempk --> 0){
                Node fwd = cur.next;
                cur.next = null;
                addFirst(cur);
                cur = fwd;
                len--;
            }
            if(oh == null){
               oh = th;
               ot = tt;
            }else{
                ot.next = th;
                ot = tt;
            }
            th = tt = null;
        }
        ot.next = cur;
        return oh;
    }
    private static int length(Node node){
        int len = 0;
        Node temp = node;
        while(temp!=null ){
            len++;
            temp = temp.next;
        }
        return len;
    }
    private static void addFirst(Node node){
        
        if(th == null){
            th = tt = node;
        }else{
            node.next = th;
            th = node;
        }
    }
}

