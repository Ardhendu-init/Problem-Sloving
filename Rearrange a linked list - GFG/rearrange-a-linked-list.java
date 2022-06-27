// { Driver Code Starts
import java.util.*;
import java.io.*;

class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
    
}
class GFG{
	static void printList(Node node) 
	{ 
		while (node != null) 
		{ 
			System.out.print(node.data + " "); 
			node = node.next; 
		} 
		System.out.println(); 
	}
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
        	int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            for(int i=0; i<n-1; i++)
            {
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
            }
            new Solution().rearrangeEvenOdd(head);
            printList(head); 
            t--;
        }
    } 
} 
// } Driver Code Ends


/*

class Node {

    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
This is method only submission.
You only need to complete the below method.
*/
class Solution
{

   // Should rearrange given linked list such that all even
   // positioned Nodes are before odd positioned.
   // Returns nothing
   void rearrangeEvenOdd(Node head)
   {
         //  The task is to complete this method
         
         ArrayList<Integer> odd = new ArrayList<Integer>();
         ArrayList<Integer> even = new ArrayList<Integer>();
         
         Node temp = head;
         
         int i=1;
         while(temp!=null){
             
             if(i%2==0){
                 
                 even.add(temp.data);
             }else{
                 
                 odd.add(temp.data);
             }
             
             i++;
             temp = temp.next;
             
         }
         
         
         for(int j=0; j<odd.size(); j++){
             
             head.data = odd.get(j);
             head = head.next;
         }
         
           for(int j=0; j<even.size(); j++){
             
             head.data = even.get(j);
             head = head.next;
         }
         
         
         
    }
}
