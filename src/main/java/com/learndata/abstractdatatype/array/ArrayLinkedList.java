package com.learndata.abstractdatatype.array;

import lombok.Data;

/**
 * 使用数组实现单链表
 * <p>
 * value[] value数组存放data
 * key []  key数组存放key
 * int  index 存放节点长度
 * <p>
 * 静态链表
 *
 * @ClassName ArrayLinkedList
 * @Description
 * @Author Crazy
 * @Date 2020/10/19 22:21
 */
@Data
public class ArrayLinkedList {

    private static int N = 100010;

    /**
     * 头结点下表
     */
    private static int head;
    /**
     * 节点i的值
     */
    private static int[] VALUE = new int[N];

    /**
     * 表示结点 i的 next指针是多少
     */
    private static int[] key = new int[N];

    /**
     * 表示存储当前结点已经使用结点的下一个结点
     * -1代表没有使用
     */
    private static int index;

    public ArrayLinkedList() {
        head = 0;
        index = 0;
    }


    /**
     * 添加元素到头部节点
     * index 位置赋值
     */
    public void addToHead(int value) {
        VALUE[index] = value;
        key[index] = head;
        head = index;
        index++;
    }

    public static void main(String[] args) {
        ArrayLinkedList arrayLinkedList = new ArrayLinkedList();
        arrayLinkedList.addToHead(1);
        System.out.println(VALUE.toString());
        System.out.println(key.toString());
        arrayLinkedList.addToHead(2);
        System.out.println("-------------------------");
        System.out.println(VALUE.toString());
        System.out.println(key.toString());

    }
}
