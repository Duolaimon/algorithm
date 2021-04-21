package com.duol.necessary;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author HeJiaGeng
 * @date 2021/3/30
 * @desc
 */
public class SortUtils {
    public static <T extends Comparable<T>> T[] quickSort(T[] array) {
        quickSort(array, 0, array.length - 1);
        return array;
    }

    private static <T extends Comparable<T>> void quickSort(T[] array, int left, int right) {
        if (left < right) {
            int mid = partition(array, left, right);
            quickSort(array, left, mid - 1);
            quickSort(array, mid + 1, right);
        }
    }

    private static <T extends Comparable<T>> int partition(T[] array, int left, int right) {
        T pivot = array[left];
        int i = left + 1;
        int j = right;
        while (true) {
            // 自左向右找到大于pivot的值
            while (i <= j && le(array[i], pivot)) i++;
            // 自右向左找到小于pivot的值
            while (i <= j && ge(array[j], pivot)) j--;
            if (i >= j) {
                break;
            }
            // 交换两个位置
            swap(array, i, j);
        }
        array[left] = array[j];
        array[j] = pivot;
        return j;
    }

    private static <T extends Comparable<T>> boolean eq(T i, T j) {
        return i.compareTo(j) == 0;
    }

    private static <T extends Comparable<T>> boolean lt(T i, T j) {
        return i.compareTo(j) < 0;
    }

    private static <T extends Comparable<T>> boolean gt(T i, T j) {
        return i.compareTo(j) > 0;
    }

    private static <T extends Comparable<T>> boolean le(T i, T j) {
        return i.compareTo(j) <= 0;
    }

    private static <T extends Comparable<T>> boolean ge(T i, T j) {
        return i.compareTo(j) >= 0;
    }

    private static <T extends Comparable<T>> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    public static void main(String[] args) {
        Integer[] array = new Integer[]{3, 5, 1, 4, 6, 2, 6, 1, 5, 8, 24, 54, 1, 6, 8};
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }
}

