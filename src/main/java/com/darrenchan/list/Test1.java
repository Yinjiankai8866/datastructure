package com.darrenchan.list;

public class Test1 {
    /**
     * 反转链表
     * O(n) O(1)
     */
    public static ListNode reverseList(ListNode head){
        ListNode pre = null;//当前节点的上一个
        ListNode next = null;//当前节点的下一个
        while(head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 取中间节点(偶数个取得中间节点是前面那个)
     */
    public static ListNode getMid(ListNode head){
        if(head == null){
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = null;

        System.out.println(getMid(node1).value);

        ListNode listNode = reverseList(node1);
        while(listNode != null){
            System.out.print(listNode.value + " ");
            listNode = listNode.next;
        }
    }
}
