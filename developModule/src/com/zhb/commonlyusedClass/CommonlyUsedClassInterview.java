package com.zhb.commonlyusedClass;

/**
 * @author zhb
 * @create 2022-02-08 13:17
 */
/*
String s = new String("xyz");创建了哪些对象？
字符串常量池中有一个对象，堆中有一个字符串对象。


Math.round(11.5)等于多少? Math.round(-11.5)等于多少
答:  Math.round(11.5)==12;Math.round(-11.5)==-11;round方法返回与参数最接近的长整数，参数加1/2后求其floor

是否可以继承String类
答：String类是final类故不可以继承

String与StringBuffer的区别
答：String的长度是不可变的，StringBuffer的长度是可变的。如果你对字符串中的内容经常进行操作，特别是内容要修改时，那么使用StringBuffer，如果最后需要String，那么使用StringBuffer的toString()方法

3．已知 String 对象 s="abcdefg"，则s.substring(2, 5)的返回值为____。
A "bcde"
B "cde"
C "cdef"
D "def"
3.难度：较难
答案：B
知识点：substring(begpos, endpos)取出一个子串，该子串从begpos位置起至 endpos-1
为结束。

6.请看下面的代码 String s = “good”; 下面选项语句书写正确的是：
A s += “student”;
B char c = s[1];
C intlen = s .length;
D String t = s.toLowerCase( );

6.难度：适中
答案：AD
知识点：s 是字符串不是数组，因此 B 错误；C 错误是由于 length 后要加括号。



 */

public class CommonlyUsedClassInterview {
}
