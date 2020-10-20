package com.learndata.subject;

import com.learndata.abstractdatatype.OneLinkedList;
import lombok.Data;

import java.util.Objects;

/**
 * @ClassName LinkedList
 * @Description TODO
 * @Author Crazy
 * @Date 2020/10/20 22:21
 */
@Data
public class LinkedList<T> {

    public Node head = new Node(0);
    public Node last;

    private int size;

    @Data
    public class Node<T> {
        public T data;

        public Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

    }


    /**
     * 尾插入
     *
     * @param value
     */
    public void addValue(T value) {
        if (Objects.isNull(value)) {
            throw new RuntimeException("value not null");
        }
        final LinkedList.Node newNode = new LinkedList.Node(value);
        if (head.next == null) {
            head.next = newNode;
            last = newNode;
            size++;
            return;
        }
        last.next = newNode;
        last = newNode;
        size++;
    }

    /**
     * 因为单链表没有指向上一个节点的指针
     * 所以需要创建一个temp节点来存储上一个节点
     * 传入节点的时候 需要判断下一个节点是不是null
     *
     * 创建next null节点
     * 创建cur 赋值当前节点
     * 创建prev null节点
     *
     * next = 当前节点的下一个节点
     * curNode.next = prev 节点当前节点的下一个节点等于上一个节点
     * prev = curNode 向前移动节点
     * curNode = next 向后移动一个节点
     *
     *
     * @param node
     */
    public void reversalNode(Node node) {
        if (Objects.isNull(node.next)) {
            throw new RuntimeException();
        }
        Node curNode = node;
        Node prev = null;
        Node next = null;

        while (curNode != null) {
            next = curNode.next;
            curNode.next = prev;
            prev = curNode;
            curNode = next;
        }

    }

    public static void main(String[] args) {
        LinkedList<String> oneLinkedList = new LinkedList<String>();
        oneLinkedList.addValue("第一个节点");
        oneLinkedList.addValue("第er个节点");
        oneLinkedList.addValue("第3个节点");
        oneLinkedList.addValue("第4个节点");

        oneLinkedList.reversalNode(oneLinkedList.head);
    }

}
