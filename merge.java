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
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode Merge(ListNode head, ListNode halfhead){
        ListNode result;
        while(head == null || halfhead == null){
            if(head.val <= halfhead.val){
                /** detach the head node and from head list and add it to result.
                  Forward the head list as well. **/
                ListNode temp = head;
                temp.next = null;
                result.next = temp;
                head = head.next;
            } else{
                ListNode temp = head;
                temp.next = null;
                result.next = temp;
                halfhead = halfhead.next;
            }
        }

        /** invert the pile **/
        if(head == null) {
            result.next = halfhead;
        }else {
            result.next = head;
        }
        return result.next;
    }


    public ListNode sortList(ListNode head) {
        /** basic thing is to sortList(head) = sortList(head till half) + sortList(half to rest)
         *  and MERGE.
         */
        int length = 0;
        ListNode traverseHead = head;
        while(traverseHead.next!= null) {
            length++;
            traverseHead = traverseHead.next;
        }

        int half = length/2;

        /** Traverse till the half and create two seperate heads **/
        int count = 0;
        traverseHead = head;
        while(count != half){
            count++;
            traverseHead = traverseHead.next;
        }
        ListNode halfhead = traverseHead;
        ListNode result = Merge(head, halfhead);
        return result;
    }
}
