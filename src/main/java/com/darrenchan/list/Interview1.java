package com.darrenchan.list;

/**
 * 一个链表，奇数位升序，偶数位降序，对该链表进行排序
 * 1 8 3 6 5 4 7 2 9
 * 1 2 3 4 5 6 7 8 9
 * O(n)
 */
public class Interview1 {
    /**
     * 分成三步：
     * 1. 按照奇数位和偶数位拆分成两个链表
     * 2. 对偶数位链表进行反转
     * 3. 将两个有序链表进行合并
     */
    public static ListNode[] getLists(ListNode head){
        ListNode head1 = null;
        ListNode head2 = null;

        ListNode cur1 = null;
        ListNode cur2 = null;
        int count = 1;//用来计数

        while(head != null){
            if(count % 2 == 1){
                if(cur1 != null){
                    cur1.next = head;
                    cur1 = cur1.next;
                }else{
                    cur1 = head;
                    head1 = cur1;
                }
            }else{
                if(cur2 != null){
                    cur2.next = head;
                    cur2 = cur2.next;
                }else{
                    cur2 = head;
                    head2 = cur2;
                }
            }
            head = head.next;
            count++;
        }

        cur1.next = null;
        cur2.next = null;

        ListNode[] nodes = new ListNode[]{head1, head2};
        return nodes;
    }

    public static ListNode reverseList(ListNode head){
        ListNode pre = null;
        ListNode next = null;
        while(head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static ListNode mergeTwoList(ListNode head1, ListNode head2){
        if(head1 == null && head2 == null){
            return null;
        }
        if(head1 == null){
            return head2;
        }
        if(head2 == null){
            return head1;
        }
        ListNode head = null;
        if(head1.value > head2.value){
            head = head2;
            head.next = mergeTwoList(head1, head2.next);
        }else{
            head = head1;
            head.next = mergeTwoList(head1.next, head2);
        }
        return head;
    }

    public static ListNode init(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(8);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(6);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(2);
        ListNode node9 = new ListNode(9);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;

        return node1;
    }
    public static void main(String[] args) {
        ListNode head = init();
        ListNode[] lists = getLists(head);

        ListNode head1 = lists[0];
        ListNode head2 = lists[1];

        head2 = reverseList(head2);

        head = mergeTwoList(head1, head2);

        while(head != null){
            System.out.print(head.value + " ");
            head = head.next;
        }
    }


}
