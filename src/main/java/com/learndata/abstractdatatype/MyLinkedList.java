package com.learndata.abstractdatatype;

import lombok.Data;

import java.util.Iterator;

/**
 * @ClassName MyLinkedList
 * @Description
 * @Author Crazy
 * @Date 2020/10/17 11:23
 */
@Data
public class MyLinkedList<T> implements Iterable<T> {

    private int size;


    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }


    @Data
    private class Node<T> {

        public T data;

        /**
         * 上一一个节点
         */
        public Node<T> prev;

        /**
         * 下一个节点
         */
        public Node<T> next;

        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }
}
