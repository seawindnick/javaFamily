package com.java.study.algorithm.zuo.abasic.basic_class_03;

/**
 * 反转单向和双向链表
 * 【题目】
 * 分别实现反转单向链表和反转双向链表的函数。
 * 【要求】 如果链表长度为N，时间复杂度要求为O(N)，额外空间复杂度要求为O(1)
 */
public class Code_15_ReverseList {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }


    public static class DoubleNode {
        public int value;
        public DoubleNode last;
        public DoubleNode next;

        public DoubleNode(int data) {
            this.value = data;
        }
    }


    public static Node reverseNode(Node node) {
        if (node == null || node.next == null) {
            return node;
        }

        Node preNode = null;
        while (node != null) {

            Node nextNode = node.next;
            node.next = preNode;

            preNode = node;
            node = nextNode;
        }

        return preNode;
    }

    public static DoubleNode reverseDoubleNode(DoubleNode node) {
        if (node == null || node.next == null) {
            return node;
        }

        DoubleNode preNode = null;
        //只对当前节点的前后属性进行修改
        while (node != null) {
            DoubleNode nextNode = node.next;
            node.next = preNode;
            node.last = nextNode;

            preNode = node;

            node = nextNode;
        }
        return preNode;
    }


    public static void printLinkedList(Node head) {
        System.out.print("Linked List: ");
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void printDoubleLinkedList(DoubleNode head) {
        System.out.print("Double Linked List: ");
        DoubleNode end = null;
        while (head != null) {
            System.out.print(head.value + " ");
            end = head;
            head = head.next;
        }
        System.out.print("| ");
        while (end != null) {
            System.out.print(end.value + " ");
            end = end.last;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        printLinkedList(head1);
        head1 = reverseNode(head1);
        printLinkedList(head1);

        DoubleNode head2 = new DoubleNode(1);
        head2.next = new DoubleNode(2);
        head2.next.last = head2;
        head2.next.next = new DoubleNode(3);
        head2.next.next.last = head2.next;
        head2.next.next.next = new DoubleNode(4);
        head2.next.next.next.last = head2.next.next;
        printDoubleLinkedList(head2);
        printDoubleLinkedList(reverseDoubleNode(head2));

    }


}