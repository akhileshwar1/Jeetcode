import leet.ListNode;

class swapPairs{
     public ListNode swap(ListNode head){
           ListNode current = head;
           ListNode result;
           if(current.next != null){
                ListNode first = current.next;
                first.next = current;
                result = first;
           }
           else{
               result = head;
           }
           return result;
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode rest;
        if(head.next != null && head.next.next != null){
            rest = swapPairs(head.next.next);
        }
        else{ 
            rest = null;
        }

        ListNode first = swap(head);
        first.next.next = rest;
        return first;
    }   
}
