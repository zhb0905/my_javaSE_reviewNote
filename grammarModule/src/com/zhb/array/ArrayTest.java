package com.zhb.array;

import java.util.Arrays;

/**
 * @author zhb
 * @create 2022-01-31 16:40
 */
/*
 * 插入：直接，折半，希尔（减小缩量排序5（分成5组分别插排），2，1）
 * 交换：冒泡，快排（分区交换排序）//对撞指针,空间O（nlogn），递归栈
 * 选择：直接，堆//堆创建（n/2倒序），堆维护（调整heapadjust）
 * 2-路归并//递归，迭代
 * 基数排序//分配+收集;多关键字排序（MSD，LSD），链式基数排序（O(d(n+j))）
 * 快，堆，归平均O（nlogn）。快排：最快内排，分治法思想，20世纪十大算法之一，发明者：图灵将得主Tony Hoare；
 * 两种数组异常：角标越界，空指针
 * int[] a = new int[]{1,2,3,4,5};//array 是不可变长
 * String a1[] = {"a","b"};
 * boolean b= 5==a.length;w
 * int a[5];//非法
 * 从数组底层的运行机制看，其实没有多维数组
 * int[][] arr = new int[3][2];
 * int[] x,y[];//x一维，y二维
 * int[][] arr3 = new int[][]{{1,2,3}{4,5,6}};
 * int arr1[][] = new int[3][];//3个null指针
 * int[][] arr2 = new int[][2];//非法
 */
public class ArrayTest {
    public static void main(String[] args) {
       double random = Math.random()*90.0+10.0;
       int randomInt = (int) random;
       int number[] = {1,2,5,69,43,1,3};
       Arrays.sort(number);
        for (int i = 0; i < number.length; i++) {
            System.out.print(number[i]+"\t");
        }
        System.out.println(number.toString());
    }
}
