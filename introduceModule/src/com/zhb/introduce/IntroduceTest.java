package com.zhb.introduce;

/**
 * @author zhb
 * @create 2022-02-12 18:52
 */

/*
第1章 Java语言概述
Java基础是学习JavaEE、大数据、Android开发
的基石！
举例：Spring – Rest(Spring MVC)
举例：Spark – Spark Streaming
Java基础知识图解


 */

/**
 * 这些Java程序被称为Java小程序（applet）。
 * 1999年，Java分成J2SE、J2EE和J2ME，JSP/Servlet技术诞生
 *
 *Java EE(Java Enterprise Edition)企业版
 * 是为开发企业环境下的应用程序提供的一套解决方案。该技术体系中包含的技术如
 * :Servlet 、Jsp等，主要针对于Web应用程序开发。版本以前称为J2EE
 * Java ME(Java Micro Edition)小型版
 * 支持Java程序运行在移动终端（手机、PDA）上的平台，对Java API有所精简，并加
 * 入了针对移动终端的支持，此版本以前称为J2ME
 * Java Card
 * 支持一些Java小程序（Applets）运行在小内存设备（如智能卡）上的平台
 *
 *
 * Java舍弃了C语言中容易引起错误的指针（以
 * 引用取代）、运算符重载（operator overloading）、多重继承
 * （以接口取代）等特性，增加了垃圾回收器功能用于回收不再被引用
 * 的对象所占据的内存空间。JDK1.5又引入了泛型编程（Generic
 * Programming）、类型安全的枚举、不定长参数和自动装/拆箱
 *
 *• Java语言是分布式的。Java语言支持Internet应用的开发，在基本的Java应用编
 * 程接口中有一个网络应用编程接口（java net），它提供了用于网络应用编程的类
 * 库，包括URL、URLConnection、Socket、ServerSocket等。Java的RMI（远程
 * 方法激活）机制也是开发分布式应用的重要手段。
 * • Java语言是健壮的。Java的强类型机制、异常处理、垃圾的自动收集等是Java程序
 * 健壮性的重要保证。对指针的丢弃是Java的明智选择
 *
 * • Java语言是安全的。Java通常被用在网络环境中，为此，Java提供了一个安全机
 * 制以防恶意代码的攻击。如：安全防范机制（类ClassLoader），如分配不同的
 * 名字空间以防替代本地的同名类、字节代码检查。
 * • Java语言是体系结构中立的。Java程序（后缀为java的文件）在Java平台上被
 * 编译为体系结构中立的字节码格式（后缀为class的文件），然后可以在实现这个
 * Java平台的任何系统中运行。
 * • Java语言是解释型的。如前所述，Java程序在Java平台上被编译为字节码格式，
 * 然后可以在实现这个Java平台的任何系统的解释器中运行。
 * • Java是性能略高的。与那些解释型的高级脚本语言相比，Java的性能还是较优的。
 * • Java语言是原生支持多线程的。在Java语言中，线程是一种特殊的对象，它必须
 * 由Thread类或其子（孙）类来创建。
 *
 * 1 软件开发介绍
 * 2 计算机编程语言介绍
 * 3 Java语言概述
 * 4 运行机制与运行过程
 * 5 Java的环境搭建
 * 6 开发体验——Helloworld
 * 5 常见问题及解决方法
 * 6 注释（Comment）
 * 7 JavaAPI文档
 * 8 良好的编程风格
 * 9 常用的Java开发工具
 */

/*
1-1 软件开发介绍
 软件开发
软件，即一系列按照特定顺序组织的计算机数据和指令的集合。有系统软 件和应用软件之分。
 人机交互方式
 图形化界面(Graphical User Interface GUI)这种方式简单直观，使用
者易于接受，容易上手操作。
 命令行方式(Command Line Interface CLI)：需要有一个控制台，输
入特定的指令，让计算机完成一些操作。较为麻烦，需要记录住一些
命令。
Pascal之父Nicklaus Wirth： “Algorithms+Data Structures=Programs”

常用的DOS命令
dir : 列出当前目录下的文件以及文件夹
md : 创建目录
rd : 删除目录
cd : 进入指定目录
cd.. : 退回到上一级目录
cd\: 退回到根目录
del : 删除文件
exit : 退出 dos 命令行
 补充：echo javase>1.doc
 常用快捷键
 ← →：移动光标
 ↑ ↓：调阅历史操作命令
 Delete和Backspace：删除字符

1.2 计算机编程语言介绍

什么是计算机语言
语言：是人与人之间用于沟通的一种方式。例如：中国人与中国人用普通话沟通。而
中国人要和英国人交流，就要学习英语。
计算机语言：人与计算机交流的方式。
如果人要与计算机交流，那么就要学习计算机语言。
计算机语言有很多种。如：C ,C++ ,Java ,PHP , Kotlin，Python，Scala等。

 第一代语言
 机器语言。指令以二进制代码形式存在。
 第二代语言
 汇编语言。使用助记符表示一条机器指令。

 第三代语言：高级语言
 C、Pascal、Fortran面向过程的语言
 C++面向过程/面向对象
 Java跨平台的纯面向对象的语言
 .NET跨语言的平台
 Python、Scala…

1-3 Java语言概述

 是SUN(Stanford University Network，斯坦福大学网络公司 ) 1995年推出的一
门高级编程语言。
 是一种面向Internet的编程语言。Java一开始富有吸引力是因为Java程序可以
在Web浏览器中运行。这些Java程序被称为Java小程序（applet）。applet使
用现代的图形用户界面与Web用户进行交互。 applet内嵌在HTML代码中。
 随着Java技术在web方面的不断成熟，已经成为Web应用程序的首选开发语言。

后台开发：Java、PHP、Python、Go、Node.js

Java简史
 1991年 Green项目，开发语言最初命名为Oak (橡树)  1994年，开发组意识到Oak 非常适合于互联网
 1996年，发布JDK 1.0，约8.3万个网页应用Java技术来制作
 1997年，发布JDK 1.1，JavaOne会议召开，创当时全球同类会议规模之最
 1998年，发布JDK 1.2，同年发布企业平台J2EE
 1999年，Java分成J2SE、J2EE和J2ME，JSP/Servlet技术诞生
 2004年，发布里程碑式版本：JDK 1.5，为突出此版本的重要性，更名为JDK 5.0
 2005年，J2SE -> JavaSE，J2EE -> JavaEE，J2ME -> JavaME
 2009年，Oracle公司收购SUN，交易价格74亿美元
 2011年，发布JDK 7.0
 2014年，发布JDK 8.0，是继JDK 5.0以来变化最大的版本
 2017年，发布JDK 9.0，最大限度实现模块化
 2018年3月，发布JDK 10.0，版本号也称为18.3
 2018年9月，发布JDK 11.0，版本号也称为18.9

Java技术体系平台
Java SE(Java Standard Edition)标准版
支持面向桌面级应用（如Windows下的应用程序）的Java平台，提供了完整的Java核 心API，此版本以前称为J2SE
Java EE(Java Enterprise Edition)企业版
是为开发企业环境下的应用程序提供的一套解决方案。该技术体系中包含的技术如
:Servlet 、Jsp等，主要针对于Web应用程序开发。版本以前称为J2EE
Java ME(Java Micro Edition)小型版
支持Java程序运行在移动终端（手机、PDA）上的平台，对Java API有所精简，并加
入了针对移动终端的支持，此版本以前称为J2ME
Java Card
支持一些Java小程序（Applets）运行在小内存设备（如智能卡）上的平台


Java在各领域的应用
• 从Java的应用领域来分，Java语言的应用方向主要表现在以下几个方面：

• 企业级应用：主要指复杂的大企业的软件系统、各种类型的网站。Java的安全机制以及
它的跨平台的优势，使它在分布式系统领域开发中有广泛应用。应用领域包括金融、电
信、交通、电子商务等。

• Android平台应用：Android应用程序使用Java语言编写。Android开发水平的高低
很大程度上取决于Java语言核心能力是否扎实。

• 大数据平台开发：各类框架有Hadoop，spark，storm，flink等，就这类技术生态
圈来讲，还有各种中间件如flume，kafka，sqoop等等 ，这些框架以及工具大多数
是用Java编写而成，但提供诸如Java，scala，Python，R等各种语言API供编程。

• 移动领域应用：主要表现在消费和嵌入式领域，是指在各种小型设备上的应用，包括手
机、PDA、机顶盒、汽车通信设备等。


Java语言的诞生
java之父James Gosling团队在开发”Green”项目时，发现C缺少垃圾回收系统，
还有可移植的安全性、分布程序设计和多线程功能。最后，他们想要一种易于移植到
各种设备上的平台。

Java确实是从C语言和C++语言继承了许多成份，甚至可以将Java看
成是类C语言发展和衍生的产物。比如Java语言的变量声明，操作符
形式，参数传递，流程控制等方面和C语言、C++语言完全相同。但同
时，Java是一个纯粹的面向对象的程序设计语言，它继承了C++语言
面向对象技术的核心。Java舍弃了C语言中容易引起错误的指针（以
引用取代）、运算符重载（operator overloading）、多重继承
（以接口取代）等特性，增加了垃圾回收器功能用于回收不再被引用
的对象所占据的内存空间。JDK1.5又引入了泛型编程（Generic
Programming）、类型安全的枚举、不定长参数和自动装/拆箱

主要特性
• Java语言是易学的。Java语言的语法与C语言和C++语言很接近，使得大多数程序员
很容易学习和使用Java。
• Java语言是强制面向对象的。Java语言提供类、接口和继承等原语，为了简单起见，
只支持类之间的单继承，但支持接口之间的多继承，并支持类与接口之间的实现机制
（关键字为implements）。
• Java语言是分布式的。Java语言支持Internet应用的开发，在基本的Java应用编
程接口中有一个网络应用编程接口（java net），它提供了用于网络应用编程的类
库，包括URL、URLConnection、Socket、ServerSocket等。Java的RMI（远程
方法激活）机制也是开发分布式应用的重要手段。
• Java语言是健壮的。Java的强类型机制、异常处理、垃圾的自动收集等是Java程序
健壮性的重要保证。对指针的丢弃是Java的明智选择。


• Java语言是安全的。Java通常被用在网络环境中，为此，Java提供了一个安全机
制以防恶意代码的攻击。如：安全防范机制（类ClassLoader），如分配不同的
名字空间以防替代本地的同名类、字节代码检查。
• Java语言是体系结构中立的。Java程序（后缀为java的文件）在Java平台上被
编译为体系结构中立的字节码格式（后缀为class的文件），然后可以在实现这个
Java平台的任何系统中运行。
• Java语言是解释型的。如前所述，Java程序在Java平台上被编译为字节码格式，
然后可以在实现这个Java平台的任何系统的解释器中运行。
• Java是性能略高的。与那些解释型的高级脚本语言相比，Java的性能还是较优的。
• Java语言是原生支持多线程的。在Java

Java语言运行机制及运行过程

特点一：面向对象
两个基本概念：类、对象
三大特性：封装、继承、多态
特点二：健壮性
吸收了C/C++语言的优点，但去掉了其影响程序健壮性的部分（如指针、内存的申请与
释放等），提供了一个相对安全的内存管理和访问机制
特点三：跨平台性
跨平台性：通过Java语言编写的应用程序在不同的系统平台上都可以运行。“Write
once , Run Anywhere” 原理：只要在需要运行 java 应用程序的操作系统上，先安装一个Java虚拟机 (JVM Java
Virtual Machine) 即可。由JVM来负责Java程序在该系统中的运行。

JAVA程序
Win版的JVM linux版的JVM Mac版的JVM
Windows操作系统 Linux操作系统 Mac操作系统

因为有了JVM，同一个Java 程序在三个不同的操作系统中都可以执行。这
样就实现了Java 程序的跨平台性。

Java两种核心机制
Java虚拟机 (Java Virtal Machine) 垃圾收集机制 (Garbage Collection)

核心机制—Java虚拟机
JVM是一个虚拟的计算机，具有指令集并使用不同的存储区域。负责执行指
令，管理数据、内存、寄存器。 对于不同的平台，有不同的虚拟机。
只有某平台提供了对应的java虚拟机，java程序才可在此平台运行
Java虚拟机机制屏蔽了底层运行平台的差别，实现了“一次编译，到处运行”

核心机制—垃圾回收
不再使用的内存空间应回收—— 垃圾回收。
在C/C++等语言中，由程序员负责回收无用内存。
Java 语言消除了程序员回收无用内存空间的责任：它提供一种系统级线程跟踪存储空
间的分配情况。并在JVM空闲时，检查并释放那些可被释放的存储空间。
垃圾回收在Java程序运行过程中自动进行，程序员无法精确控制和干预。
Java程序还会出现内存泄漏和内存溢出问题吗？Yes!

1-5 Java语言的环境搭建

明确什么是JDK, JRE
下载 JDK
安装 JDK
配置环境变量
path：windows系统执行命令时要搜寻的路径。
验证是否成功：javac java
选择合适的文本编辑器或 IDE 开发

什么是JDK，JRE
JDK(Java Development Kit Java开发工具包)
JDK是提供给Java开发人员使用的，其中包含了java的开发工具，也包括了
JRE。所以安装了JDK，就不用在单独安装JRE了。
 其中的开发工具：编译工具(javac.exe) 打包工具(jar.exe)等
JRE(Java Runtime Environment Java运行环境)
包括Java虚拟机(JVM Java Virtual Machine)和Java程序所需的核心类库等，
如果想要运行一个开发好的Java程序，计算机中只需要安装JRE即可。
简单而言，使用JDK的开发工具完成的java程序，交给JRE去运行。

JDK、JRE、JVM关系

• JDK = JRE + 开发工具集（例如Javac编译工具等）
• JRE = JVM + Java SE标准类库


注：
对于单行和多行注释，被注释的文字，不会被JVM（java虚拟机）解释执行。
多行注释里面不允许有多行注释嵌套。

文档注释（Java特有）
格式：/**
@author 指定java程序的作者
@version 指定源文件的版本
*/
/*
 注释内容可以被JDK提供的工具 javadoc 所解析，生成一套以网页文件形
        式体现的该程序的说明文档。
         操作方式
javadoc -d mydoc -author -version HelloWorld.java

Java源文件以“java”为扩展名。源文件的基本组成部分是类（class），如 本例中的HelloWorld类。
Java应用程序的执行入口是main()方法。它有固定的书写格式：
public static void main(String[] args) {...}
Java语言严格区分大小写。
Java方法由一条条语句构成，每个语句以“;”结束。
大括号都是成对出现的，缺一不可。
一个源文件中最多只能有一个public类。其它类的个数不限，如果源文件包含
一个public类，则文件名必须按该类名命名。

1-9 Java API文档

API （Application Programming Interface,应用程序编程接口）是 Java 提供
的基本编程接口。
Java语言提供了大量的基础类，因此 Oracle 也为这些基础类提供了相应的
API文档，用于告诉开发者如何使用这些类，以及这些类里包含的方法。
下载API：
http://www.oracle.com/technetwork/java/javase/downloads/index.html
Additional Resources-Java SE 8 Documentation下载。 详见：JDK8的下载-安装-配置.doc

 正确的注释和注释风格
 使用文档注释来注释整个类或整个方法。
 如果注释方法中的某一个步骤，使用单行或多行注释。
 正确的缩进和空白
 使用一次tab操作，实现缩进
 运算符两边习惯性各加一个空格。比如：2 + 4 * 5。  块的风格
 Java API 源代码选择了行尾风格
public class Test {
public static void main(String[] args){
System.out.println("Block Style!");
} }
行尾风格
public class Test
{
public static void main(String[] args)
{
System.out.println("Block Style!");
}
}
 次行风格

1-11 常用的Java开发工具
(Integrated Development Environment)

文本编辑工具：
 记事本
 UltraEdit
 EditPlus
 TextPad
 NotePad

Java集成开发环境（IDE)：
  JBuilder
 NetBeans
 Eclipse
 MyEclipse
 IntelliJ IDEA

 */
public class IntroduceTest {
}
