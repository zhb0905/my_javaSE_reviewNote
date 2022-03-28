package com.zhb.oop;

/**
 * @author zhb
 * @create 2022-02-05 19:51
 */

/*
Java的内存管理之垃圾回收（了解）
分配：由JVM自动为其分配相应的内存空间
释放：由JVM提供垃圾回收机制自动的释放内存空间
垃圾回收机制（GC：Garbage Collection）：将垃圾对象所占用的堆内存进行回收。Java的垃圾回收机制是JVM提供的能力，由单独的系统级垃圾回收线程在空闲时间以不定时的方式动态回收。
垃圾对象：不再被任何引用指向的对象。

面试题：
问：在程序中是否可以通知垃圾回收机制过来回收垃圾？
能，通过调用System.gc();或Runtime.getRuntime().gc();

再问：调用了System.gc();或Runtime.getRuntime().gc();后是立刻执行垃圾回收吗？
不是，该调用并不会立刻启动垃圾回收机制开始回收，但会加快垃圾回收机制的运行。

构造器Constructor是否可被override
答：构造器Constructor不能被继承，因此不能重写Override，但可以被重载Overload

当一个对象被当作参数传递到一个方法后，此方法可改变这个对象的属性，并可返回变化后的结果，那么这里到底是值传递还是引用传递?

答：是值传递。Java 编程语言只有值传递参数。当一个对象实例作为一个参数被传递到方法中时，参数的值就是对该对象的引用。对象的内容可以在被调用的方法中改变，但对象的引用是永远不会改变的

垃圾回收机制关键点


垃圾回收机制只回收JVM堆内存里的对象空间。


对其他物理连接，比如数据库连接、输入流输出流、Socket连接无能为力


现在的JVM有多种垃圾回收实现算法，表现各异。


垃圾回收发生具有不可预知性，程序无法精确控制垃圾回收机制执行。


可以将对象的引用变量设置为null，暗示垃圾回收机制可以回收该对象。


程序员可以通过System.gc()或者Runtime.getRuntime().gc()来通知系统进行垃圾回收，会有
一些效果，但是系统是否进行垃圾回收依然不确定。


垃圾回收机制回收任何对象之前，总会先调用它的finalize方法（如果覆盖该方法，让一
个新的引用变量重新引用该对象，则会重新激活对象）。


永远不要主动调用某个对象的finalize方法，应该交给垃圾回收机制调用。

native 关键的理解
使用 native 关键字说明这个方法是原生函数，也就是这个方法是用 C/C++等非
Java 语言实现的，并且被编译成了 DLL，由 java 去调用。
（1）为什么要用 native 方法
java 使用起来非常方便，然而有些层次的任务用 java 实现起来不容易，或者我们
对程序的效率很在意时，问题就来了。例如：有时 java 应用需要与 java 外面的
环境交互。这是本地方法存在的主要原因，你可以想想 java 需要与一些底层系
统如操作系统或某些硬件交换信息时的情况。本地方法正是这样一种交流机制：
它为我们提供了一个非常简洁的接口，而且我们无需去了解 java 应用之外的繁
琐的细节。
（2）native 声明的方法，对于调用者，可以当做和其他 Java 方法一样使用
一个 native method 方法可以返回任何 java 类型，包括非基本类型，而且同样可
以进行异常控制。
native method 的存在并不会对其他类调用这些本地方法产生任何影响，实际上
调用这些方法的其他类甚至不知道它所调用的是一个本地方法。JVM 将控制调用
本地方法的所有细节。
如果一个含有本地方法的类被继承，子类会继承这个本地方法并且可以用 java
语言重写这个方法（如果需要的话）

java类是否可以多继承，怎么实现多继承？
答：java没有多继承，但可以通过接口的形式来达到多继承的目地。

重载（overload)和重写(overried，有的书也叫做“覆盖”）的区别？
答：方法的重写Overriding和重载Overloading是Java多态性的不同表现。重写Overriding是父类与子类之间多态性的一种表现，重载Overloading是一个类中多态性的一种表现。如果在子类中定义某方法与其父类有相同的名称和参数，我们说该方法被重写 (Overriding)。子类的对象使用这个方法时，将调用子类中的定义，对它而言，父类中的定义如同被"屏蔽"了。如果在一个类中定义了多个同名的方法，它们或有不同的参数个数或有不同的参数类型，则称为方法的重载(Overloading)。

Overload的方法是否可以改变返回值的类型？
Overloaded的方法是可以改变返回值的类型

包装类的使用
写出8中基本数据类型的包装类
int 和 Integer 有什么区别
答：Java 提供两种不同的类型：引用类型和原始类型（或内置类型）。
int是java的原始数据类型，Integer是java为int提供的封装类。Java为每个原始类型提供了封装类。
原始类型封装类型及其对应的包装类：boolean Boolean,char Character,byte Byte,short Short,int Integer,long Long,float  Float,doubl  Double
引用类型和原始类型的行为完全不同，并且它们具有不同的语义。
引用类型和原始类型具有不同的特征和用法，它们包括：大小和速度问题，这种类型以哪种类型的数据结构存储，当引用类型和原始类型用作某个类的实例数据时所指定的缺省值。对象引用实例变量的缺省值为 null，而原始类型实例变量的缺省值与它们的类型有关。

Integer的i1和i2是对象，他们==比较的是地址。如果-128~127范围，那么使用缓存的常量对象，如果超过这个范围，是新new的对象，不是常量对象

abstract class 和interface 有什么区别?
答：声明方法的存在而不去实现它的类被叫做抽象类（abstract class），它用于要创建一个体现某些基本行为的类，并为该类声明方法，但不能在该类中实现该类的情况。不能创建abstract 类的实例。然而可以创建一个变量，其类型是一个抽象类，并让它指向具体子类的一个实例。不能有抽象构造函数或抽象静态方法。Abstract 类的子类为它们父类中的所有抽象方法提供实现，否则它们也是抽象类。取而代之，在子类中实现该方法。知道其行为的其它类可以在类中实现这些方法

接口（interface）是抽象类的变体。在接口中，所有方法都是抽象的。多继承性可通过实现这样的接口而获得。接口中的所有方法都是抽象的，没有一个有程序体。接口只可以定义static final成员变量。接口的实现与子类相似，除了该实现类不能从接口定义中继承行为。当类实现特殊接口时，它定义（即将程序体给予）所有这种接口的方法。然后，它可以在实现了该接口的类的任何对象上调用接口的方法。由于有抽象类，它允许使用接口名作为引用变量的类型。通常的动态联编将生效。引用可以转换到接口类型或从接口类型转换，instanceof 运算符可以用来决定某对象的类是否实现了接口
接口是否可继承接口? 抽象类是否可实现(implements)接口? 抽象类是否可继承实体类(concrete class)?

答案是：   接口可以继承接口。抽象类可以实现(implements)接口，
抽象类可继承实体类，但实体类必须不能是如下两种情况之一：
1，final修饰符修饰的类是不能的
2，如果此实体类有且仅有私有的构造函数也是不能的。

对于父类的变量,可以用super.x来明确，
而接口的属性默认隐含为 public static final.所以可以通过Intefacename.x来明确。

Anonymous Inner Class (匿名内部类) 是否可以extends(继承)其它类，是否可以implements(实现)interface(接口)

答：匿名的内部类是没有名字的内部类。不能extends(继承) 其它类，但一个内部类可以作为一个接口，由另一个内部类实现


Static Nested Class 和 Inner Class的不同
答：Nested Class （一般是C++的说法），Inner Class (一般是JAVA的说法)。
Java内部类与C++嵌套类最大的不同就在于是否有指向外部的引用上。
注： 静态内部类（Inner Class）意味着
1创建一个static内部类的对象，不需要一个外部类对象，2不能从一个static内部类的一个对象访问一个外部类对象

静态内部类可以有静态成员，而非静态内部类则不能有静态成员。 故 A、B 错
二.静态内部类的非静态成员可以访问外部类的静态变量，而不可访问外部类的非静态变量；return d1 出错。
故 D 错
三.非静态内部类的非静态成员可以访问外部类的非静态变量。 故 C 正确

判断题
1)内部类（可以/不可以）了解外部类
2)静态内部类用修饰。
3)外部类（可以/不可以）通过类名访问静态内部类里的静态成员（变量和方法）
4)外部类（可以/不可以）通过类名访问非静态内部类里的成员（变量和方法）
5)非静态内部类可以访问外部类的成员，也能访问外部类的成员
6)静态内部类可以访问外部类的成员，不能访问外部类的成员
7)非静态内部类（可以/不可以）用static修饰她的成员（变量和方法）

抽象类与抽象方法
abstract 的method 是否可同时是static，是否可同时是native，是否可同时是synchronized？
答：都不能

抽象类和抽象方法之间的关系
定义抽象类和抽象方法的关键字是（）。抽象类中（）（可以/不可以）有抽象方法，（）（可以/不可以）有普通方法（）（可以/不可以）有属性；一个类中定义了抽象方法，那这个类（）（必须/不必须）用abstract修饰，即抽象类。


SingleTon其他形式:
定义一个类，它的构造函数为private的，所有方法为static的。

final关键字
谈谈final, finally, finalize的区别(后面异常中讲finally)
答：final—修饰符（关键字）如果一个类被声明为final，意味着它不能再派生出新的子类，不能作为父类被继承。因此一个类不能既被声明为 abstract的，又被声明为final的。将变量或方法声明为final，可以保证它们在使用中不被改变。被声明为final的变量必须在声明时给定初值，而在以后的引用中只能读取，不可修改。被声明为final的方法也同样只能使用，不能重载

finally—再异常处理时提供 finally 块来执行任何清除操作。如果抛出一个异常，那么相匹配的 catch 子句就会执行，然后控制就会进入 finally 块（如果有的话）

finalize—方法名。Java 技术允许使用 finalize() 方法在垃圾收集器将对象从内存中清除出去之前做必要的清理工作。这个方法是由垃圾收集器在确定这个对象没有被引用时对这个对象调用的。它是在 Object 类中定义的，因此所有的类都继承了它。子类覆盖 finalize() 方法以整理系统资源或者执行其他清理工作。finalize() 方法是在垃圾收集器删除对象之前对这个对象调用的

final int i是个final的instant variable (实例变量，或叫成员变量)。final的instant variable没有default value，必须在constructor (构造器)结束之前被赋予一个明确的值。可以修改为"final int i = 0;"


 */

class Test {
    static int x, y, z;

    static {
        int x = 5;
        x--;
    }

    static {
        x--;
    }

    public static void main(String[] args) {
        System.out.println("x=" + x);
        z--;
        method();
        System.out.println("result:" + (z + y + ++z));
    }

    public static void method() {
        y = z++ + ++z;
    }
}
interface Inter {
    void show(int a, int b);

    void func();
}

class Demo {
    public static void main(String[] args) {
        // 补足代码；调用两个函数，要求用匿名内部类
        Inter in = new Inter() {
            public void show(int a, int b) {

            }

            public void func() {

            }
        };

        in.show(4, 5);
        in.func();

    }
}
public class OopReview {
    public static void main(String[] args) {
        int i = 0;
        i=i++;
        System.out.println(i);
    }
}
class TestGC{
    public static void main(String[] args)throws Exception{
        for(int i=0; i<10; i++){
            MyClass m = new MyClass();//这里本次循环完，本次创建的对象就成为垃圾了
            System.out.println("创建第" + (i+1) + "的对象：" + m);
        }

        //通知垃圾回收机制来收集垃圾
        System.gc();

        //为了延缓程序结束
        for(int i=0; i<10; i++){
            Thread.sleep(1);
            System.out.println("程序在继续....");
        }
    }
}
class MyClass{
    //这个方法是垃圾回收机制在回收它的对象时，自动调用，理解成对象留临终遗言的方法
    public void finalize(){
        System.out.println("轻轻的我走了.....");
    }
}

class A {
    private int a;

    public void setA(int a) {
        this.a = a;
    }

    public int getA() {
        return a;
    }
}

class B extends A {
    private int a;

    public void setA(int a) {
        this.a = a;
    }
    // public int getA(){
    // return a;
    // }
}
class PersonTest {

    public static void main(String[] args) {
        A c = new B();

        c.setA(5);

        System.out.println(c.getA());
    }
}