package com.zhb.token;

/**
 * @author zhb
 * @create 2022-01-30 19:41
 */
/* * 强类型语言
 * 作用域内变量名唯一
 * 基本数据类型(primitive type)：byte,short,int,long,float.double.char,boolean
 * 引用数据类型(reference type):class(包括String)，interface,数组([])
 * 成员变量：实例变量(不以static修饰)，类变量(以static修饰)
 * 局部变量:形参，方法、代码块内。
 * 默认int，double;long ldemo = 123L;float fdemo = 1.1f; double ddemo = 5.12e-2;
 * char：字符，2字节，Unicode编码，一个char可存一个字母或汉字或其他字符。可运算。
 * 转义字符: '\'
 * Unicode值表示char: char cdemo = '\u000a';
 * ASCII码；128个字符，首位0，'A':65;后128个：扩展(高)ASII，许多基于x86的系统支持。
 * Unicode:全球符号统一编码
 * UTF-8: 互联网最广的Unicode实现方式。变长，1-6字节表示一个字符。单字节：等同ASCII。
        多字节：n字节，首字节前n位1，n+1位为0，剩余的编码。非首字节10开头，6位编码。
 * 自动类型转换：byte,short,char都向int转。*/
public class VariableTest {
 public static void main(String[] args) {
  String str = "45";
  int baozhaolei = Integer.parseInt(str);
  System.out.println(baozhaolei);
 }
}
