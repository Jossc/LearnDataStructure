package com.learndata.abstractdatatype;

import lombok.Data;

import java.util.LinkedList;
import java.util.Objects;

/**
 * @ClassName OneLinkedList
 * @Description 单向链表
 * @Author Crazy
 * @Date 2020/10/17 21:21
 */
@Data
public class OneLinkedList<T> {

    /**
     * 头结点
     */
    private Node<T> head = new Node<>(null);


    /**
     * 最后一个节点
     */
    private Node<T> last;

    /**
     * 统计链表的长度
     */
    private int size;


    @Data
    private class Node<T> {

        /**
         * 数据域
         */
        private T data;

        /**
         * 指针域
         */
        private Node<T> next;


        public Node(T data) {
            this.data = data;
            next = null;
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
        final Node<T> newNode = new Node(value);
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
     * 头插法
     *
     * @param value
     */
    public void headInsert(T value) {
        if (Objects.isNull(value)) {
            throw new RuntimeException("value not null");
        }
        final Node<T> newNode = new Node(value);
        if (head.next == null) {
            head.next = newNode;
            size++;
            last = newNode;
            return;
        }
        /**
         * 交换节点位置
         * 头部插入的次序和节点的顺序是相反的
         *
         * 使用temp来接手head的下一个节点
         * 然后头节点指向新节点
         * 新节点的next指向原来的头结点
         */
        Node<T> temp = head.next;
        head.next = newNode;
        newNode.next = temp;
        size++;
    }


    public static void main(String[] args) {
        OneLinkedList<String> oneLinkedList = new OneLinkedList<String>();
        oneLinkedList.headInsert("第一个节点");
        System.out.println(oneLinkedList.last.data);
        oneLinkedList.headInsert("第er个节点");
        System.out.println(oneLinkedList.last.data);
    }
}
