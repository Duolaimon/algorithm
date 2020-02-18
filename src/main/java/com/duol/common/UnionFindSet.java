package com.duol.common;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author HeJiaGeng
 * @date 2020/1/29
 * @desc 并查集
 */
public class UnionFindSet<T> {
    private Map<T, Element<T>> map;

    private static final int DEFAULT_SIZE = 1024;

    public UnionFindSet() {
        map = new HashMap<>(DEFAULT_SIZE);
    }

    public UnionFindSet(int size) {
        map = new HashMap<>(size);
    }

    public void union(T a1, T a2) {
        Element<T> e1 = findElement(a1);
        Element<T> e2 = findElement(a2);
        if (e1 == e2) {
            return;
        }
        e1.setParent(e2);
    }

    public T find(T a) {
        return findElement(a).getData();
    }

    public boolean isUnion(T a1, T a2) {
        return findElement(a1) == findElement(a2);
    }


    private Element<T> findElement(T a) {
        if (!map.containsKey(a)) {
            return addElement(a);
        }
        Element<T> element = map.get(a);
        while (element.getParent() != null) {
            element = element.getParent();
        }
        return element;
    }

    private Element<T> addElement(T a) {
        Element<T> element = new Element<>();
        element.setData(a);
        element.setParent(null);
        map.put(a, element);
        return element;
    }

    @Data
    private static class Element<T>{
        private T data;
        private Element<T> parent;
    }

    public static void main(String[] args) {
        UnionFindSet<String> unionFindSet = new UnionFindSet<>();
        unionFindSet.union("1", "5");
        unionFindSet.union("2", "3");
        unionFindSet.union("3", "4");
        System.out.println(unionFindSet.find("4"));
        System.out.println(unionFindSet.find("3"));
        System.out.println(unionFindSet.find("2"));
        System.out.println(unionFindSet.find("1"));
        System.out.println(unionFindSet.find("5"));
        System.out.println(unionFindSet.isUnion("1", "2"));
        System.out.println(unionFindSet.isUnion("2", "4"));
    }
}
