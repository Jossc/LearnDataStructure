package com.learndata.abstractdatatype;

import lombok.Data;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 抽象数据类型
 *
 * @author 一方通行
 * @title: MyArrayList
 * @projectName LearnDataStructure
 * @date 2020/10/12 23:04ArrayList
 */
@Data
public class MyArrayList<T> implements Iterable<T> {

    /**
     * 默认大小就是10
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 元素大小
     */
    private int initSize;

    transient Object[] array;

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    public MyArrayList() {
        array = new Object[DEFAULT_CAPACITY];
    }

    /**
     * 返回当前集合中有多少元素
     *
     * @return
     */
    public int size() {
        return initSize;
    }

    public void clear() {
        initSize = 0;
        array = null;
    }

    private void doClear() {

    }

    public boolean add(T value) {
        add(size(), value);
        return true;
    }

    private T set(int index, T value) {
        if (index < 0 || index > size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        T old = (T) array[index];
        array[index] = value;
        return old;
    }

    /**
     * 默认添加是最后一个添加 然后移动索引位置
     *
     * @param index
     * @param v
     */
    private void add(int index, T v) {
        if (array.length == size()) {
            // 如果位置相等了说明这里需要扩容了
            ensureExplicitCapacity(size() >> 1);
        }
        for (int i = initSize; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = v;
        initSize++;
    }


    /**
     * 删除位置需要前移
     *
     * @param index
     * @return
     */
    public T remove(int index) {
        T remove = (T) array[index];
        for (int i = index; i < size() - 1; i++) {
            array[i] = array[i + 1];
        }
        initSize--;
        return remove;
    }


    /**
     * 扩容
     *
     * @param newSize
     */
    private void ensureExplicitCapacity(int newSize) {
        if (newSize < initSize) {
            return;
        }
        Object[] old = array;
        array = new Object[newSize];
        for (int i = 0; i < size(); i++) {
            array[i] = old[i];
        }
    }

    /**
     * 根据index 获取元素
     *
     * @param index
     * @return
     */
    public T get(int index) {
        if (index < 0 || index > size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return (T) array[index];
    }

    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add("aaa");
    }

    private class IterableList<T> implements Iterable<T> {

        private int current = 0;


        public boolean hasNext() {
            return current < size();
        }

        public T next() {
            return (T) array[current++];
        }

        public void remove() {
            MyArrayList.this.remove(--current);
            ;
        }

        @Override
        public Iterator iterator() {
            return (Iterator) new MyArrayList<T>();
        }
    }
}

