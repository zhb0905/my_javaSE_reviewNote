package com.zhb.IOStream;

/**
 * @author zhb
 * @create 2022-02-10 14:42
 */

/*

说明：如果使用单元测试，文件相对路径为当前module
          如果使用main()测试，文件相对路径为当前工程

什么是java序列化，如何实现java序列化？
答：序列化就是一种用来处理对象流的机制，所谓对象流也就是将对象的内容进行流化。
可以对流化后的对象进行读写操作，也可将流化后的对象传输于网络之间。
序列化是为了解决在对对象流进行读写操作时所引发的问题。
序列化的实现：将需要被序列化的类实现Serializable接口，该接口没有需要实现的方法，
implements Serializable只是为了标注该对象是可被序列化的，
然后使用一个输出流(如：FileOutputStream)来构造一个ObjectOutputStream(对象流)对象，
接着，使用ObjectOutputStream对象的writeObject(Object obj)方法就可以
将参数为obj的对象写出(即保存其状态)，要恢复的话则用输入流。



使用处理流的优势有哪些？如何识别所使用的流是处理流还是节点流？
【答案】
【优势】对开发人员来说，使用处理流进行输入/输出操作更简单；使用处理流的执行效率更高。
【判别】
处理流的构造器的参数不是一个物理节点，而是已经存在的流。而节点流都是直接以物理IO及节点作为构造器参数的。

Java中有几种类型的流？JDK为每种类型的流提供了一些抽象类以供继承，请指出它们分别是哪些类？
【答案】Java中按所操作的数据单元的不同，分为字节流和字符流。
字节流继承于InputStream和OutputStream类;
字符流继承于Reader和Writer。
按流的流向的不同，分为输入流和输出流。
按流的角色来分，可分为节点流和处理流。
缓冲流、转换流、对象流和打印流等都属于处理流，使得输入/输出更简单，执行效率更高。

什么是标准的I/O流？
在java语言中，用stdin表示键盘，用stdout表示监视器。
他们均被封装在System类的类变量in 和out中，
对应于系统调用System.in和System.out。
这样的两个流加上System.err统称为标准流，它们是在System类中声明的3个类变量：
public static InputStream in
publicstaticPrintStream out
public static PrintStream err

数组有没有length()方法？String有没有length()方法？File有没有length()方法？
ArrayList有没有length()方法？
数组没有length()方法，但是有length属性。
String和File有length()方法。
ArrayList没有length()方法，有size()方法获取有效元素个数。

2.计算机处理的最小数据单元称为▁▁。
A 位
B 字节
C 兆
D 文件

2.难度：容易答案：B 知识点：计算机处理的最小数据单元是字节。


4.▁▁文件流类的 close 方法可用于关闭文件。
A FileOutputStream
B FileInputStream
C RandomAccessFile
D FileWrite
5.RandomAccessFile 类的▁▁方法可用于从指定流上读取整数。
A readInt
B readLine
C seek
D close
6.RandomAccessFile 类的▁▁方法可用于从指定流上读取字符串。
A readInt
B readLine
C seek
D close
7.RandomAccessFile 类的▁▁方法可用于设置文件定位指针在文件中的位置。
A readInt
B readLiIne
C seek
D close
8.在FilterOutputStream类的构造方法中，下面哪个类是合法：
A File
B InputStream
C OutputStream
D FileOutputStream

4.难度：适中答案： ABC 知识点：FileOutStream、FileInputStream、RandomAccessFile
文件流类的 close 方法可用于关闭文件。
5.难度：适中答案：A 知识点：readInt方法的使用。
6.难度：适中答案：B 知识点：readLIne方法的使用。
7.难度：适中答案：C 知识点：seek 方法的使用。
8.难度：适中答案：C 知识点：在FilterOutputStream类中只有一种结构：public
FilterOutputStream(OutputStream)。



 */
public class IOStreamInterview {
}
