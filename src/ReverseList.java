public class ReverseList {

    // 鏈表反轉
    protected static class ListNode {
        int value;
        ListNode next;

        public ListNode(int value, ListNode next) {
            this.value = value;
            this.next = next;
        }
    }

    public static ListNode iterate(ListNode head) {
        ListNode prev= null;
        ListNode next;
        ListNode current = head;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static ListNode recursion(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        // 得從最後的元素開始
        ListNode newHead = recursion(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5,null);
        ListNode node4 = new ListNode(4,node5);
        ListNode node3 = new ListNode(3,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);

        ListNode recursion = recursion(node1);
        System.out.println(recursion);

        ListNode iterate = iterate(node1);
        System.out.println(iterate);
    }
}
