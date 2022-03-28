package com.zhb.oop;

/**
 * @author zhb
 * @create 2022-02-05 19:14
 */
public class Test1 {
    public Test1() {
        Inner s1 = new Inner();
        s1.a = 10;
        Inner s2 = new Inner();
        s2.a = 20;
        Test1.Inner s3 = new Test1.Inner();
        System.out.println(s3.a);
    }
    class Inner {
        public int a = 5;
    }
    public static void main(String[] args) {
        Test1 t = new Test1();
        Inner r = t.new Inner();
        System.out.println(r.a);
    } }
