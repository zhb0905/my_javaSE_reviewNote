package com.zhb.oop;
import org.junit.Test;
/**
 * @author zhb
 * @create 2022-02-04 18:19
 */

/*
 * static 。内存独一份。类属性，类方法。
 * static 修饰field,method,block(代码块),innerclass(内部类)
 * static int a = 1;//！只跑一次
 * static 修饰的成员：
 * <随类加载而加载
 * <优先于对象存在
 * <被共享
 * <直接类调用
 *
 * 方法区 : 类的加载信息，静态域，常量池
 *
 * 类方法内只能访问static修饰的属性方法，不能访问非static结构
 * 类方法类不能有this，super。//因为this，super指的都是对象
 * 类方法不能被重写。
 *
 */
 // 单例(Singleton)设计模式（例:java.lang.Runtime）
// 1.私有化构造器
// 2  public 的 类方法 getInstance
// 3 配合2 的类变量（一个实例）

//SingleTon应用例：网站计数器，应用程序的日志应用（因共享的日志一直打开，一个实例去操作，否则不好追加）
// 数据库连接池（因数据库连接是一种数据库资源），读取配置文件的类，Application,
// Windows 的 Task Manager(任务管理器)，Recycle Bin（回收站）

/*
 * psvm
 * Java虚拟机调用类的main()，不创建对象,故public，static。
 * 接收的args保存java命令时传递给所运行的类的参数
 *java OopTest3 "Tom" "Jerry" "ss"
 * args[0]=Tom
 * args[1]=jerry
 * args[2]=ss
 *
 *代码块（初始化块）：进行初始化。仅两种：static（静态代码块） ，非static
 *static block 随 类加载而加载，只执行一次。先于非static block执行
 * 非static block 每次创建对象都执行一次。先于构造器执行//!int i = 1;成员变量看成代码块
 *非static block可调用static 的 field ，method。
 *
 * 成员变量赋值顺序：
 * 声明的默认值->显示初始化、多个初始化块依次执行->构造器->对象.属性 或 对象.方法
 *
 * final class （太监类）不能继承。String，System，StringBuffer
 * final method 不能OverWrite  如Object.getclass()
 * final 变量 即称为常量。大写，只能赋值一次。要显式赋值才能用。 final double MY_PI = 3.14;
 * static final 全局常量
 *
 * abstract classname 抽象类 含抽象方法则必须声明为抽象类
 * 抽象类不能被实例化。用于被继承。子类需重写抽象方法，若未重写全部抽象方法，仍为抽象类。
 * abstract methodname 抽象方法。只有声明，无实现,以分号结束
 * public abstract void talk();
 * abstract 不能修饰变量、代码块、构造器
 * abstract 不能修饰私有方法，静态方法，final方法，final类
 *
 *
 * 多态的应用：模板方法设计模式（TemplateMethod）
 * 父类实现确定的、固定、通用部分，易变、不确定部分暴露给子类实现
 * TemplateMethod 编程常用模式。各框架、类库都有它影子：
 * <数据库访问的封装
 * <Junit单元测试
 * <JavaWeb的Servlet中关于doGet/DoPost方法调用
 * <Hibernate中模板程序
 * <Spring中JDBCTemplate、HibermateTemplate等
 *
 * interface接口:可实现多重继承效果。（无is-a关系）抽象出行为特征，
 * 接口就是规范，定义一组规则，继承是“是不是”，接口是“能不能”
 * 接口本质是契约，标准，规范。
 *
 * interface是抽象方法和常量值定义得集合，特点：
 * >用interface定义
 * >所有成员变量默认public static final
 * >所有抽象方法默认public abstract
 * >无构造器
 * >接口采用多继承机制
 *
 * 接口可继承多个接口（优先于抽象类，因可避免单继承局限）
 * 实现接口得类需搞得接口所有方法，才能实例化。否则，仍为抽象类。
 * 接口主要用途：被实现类实现。（面向接口编程）
 * 接口与实现类间有多态性，类似继承
 * interface 与 class 并列关系，或看为特殊的类。本质上，interface是特殊的抽象类
 * ，这种抽象类中只有常量和方法定义（jdk7.0以前），无变量和方法实现。
 *
 * 代理（proxy）模式：java开发使用较多。为其他对象提供一种代理以控制对这个对象的访问。
 * 应用场景：
 * >安全代理 屏蔽对真实角色的直接访问
 * >远程代理 通过代理类处理远程方法调用（RMI）
 * >延迟加载 先加载轻量级的代理对象，真正需要再加载真实对象
 * 分类
 * >静态代理（静态定义代理类）
 * >动态代理（动态生成代理类） jdk自带的动态代理，需要反射等知识
 * 接口的应用 工厂模式
 *
 * interface 组成 常量，抽象方法，默认方法，静态方法
 * java 8 可为interface添加静态方法，默认方法。
 * 静态方法 static。通过接口直接调用静态方法。常在相互一起使用的类中使用静态方法。
 *          如Collection/Collections或Path/Paths这样成对的接口和类
 * 默认方法 default 修饰。可通过实现类对象调用。//Collection、List、Comparator等
 *
 * 一接口定义默认方法，另一接口有同名同参数方法时，实现类同时实现两接口会出现：接口冲突。
 * 解决方法 实现类方法覆盖
 * 接口定义默认方法，分类有同名同参数非抽象方法。不冲突，类优先。
 *
 * inner class 在定义它的类或语句块之内，在外部引用必须给出完整名称。
 * > 编译得OuterClass$InnerClass.class字节码文件
 * 成员inner class  static,非 static（内部类成员不能static），private，protected，final，abstract.可调外部类结构
 *
 * 局部inner class（不谈修饰符）、匿名内部类
 *
 * 局部inner class
 * 只在声明其的method。block内部可用
 * 但它的对象可通过外部方法的返回值返回使用，返回值类型只能是局部内部类的父类或父接口类型
 * 编译为.class,前冠以外部类类名,$，数字编号
 * 局部innerclass可用外部方法得局部变量，但必须是final的。由局部innerclass和局部变量生命周期不同所致。
 * 与局部变量地位类似，不能用public,protected,default,private
 * 不能static，不能含static 成员
 *
 * 匿名内部类
 * 不能定义任何静态成员、方法、类，只能创建匿名内部类的一个实例
 * // new后面，隐含实现一个接口或实现一个类
 * new 父类构造器（实参）| 实现接口（）{
 *      //匿名內部类的类体部分
 *
 *  匿名内部类的特点
 匿名内部类必须继承父类或实现接口
 匿名内部类只能有一个对象
 匿名内部类对象只能使用多态形式引用
 *
 *
 *
 * class OuterClass {
 *      method(){
 *          class 局部内部类{
 *          }
 *      }
 *      {
 *          class 局部内部类{
 *          }
 *      }
 * }
 *
 */

/*
面向对象三大特征的说明
答：面向对象有三大特点：封装、继承、多态。(如果要回答四个，可加上 抽象性 这一特点)
1.继承性：
继承是一种联结类的层次模型，并且允许和鼓励类的重用，它提供了一种明确表述共性的方法。对象的一个新类可以从现有的类中派生，这个过程称为类继承。新类继承了原始类的特性，新类称为原始类的派生类（子类），而原始类称为新类的基类（父类）。派生类可以从它的基类那里继承方法和实例变量，并且类可以修改或增加新的方法使之更适合特殊的需要。
2.封装性：
封装是把过程和数据包围起来，对数据的访问只能通过已定义的界面。面向对象计算始于这个基本概念，即现实世界可以被描绘成一系列完全自治、封装的对象，这些对象通过一个受保护的接口访问其他对象。
3. 多态性：
多态性是指允许不同类的对象对同一消息作出响应。多态性包括参数化多态性和包含多态性。多态性语言具有灵活、抽象、行为共享、代码共享的优势，很好的解决了应用程序函数同名问题。
4.抽象性：
抽象就是忽略一个主题中与当前目标无关的那些方面，以便更充分地注意与当前目标有关的方面。抽象并不打算了解全部问题，而只是选择其中的一部分，暂时不用部分细节。抽象包括两个方面，一是过程抽象，二是数据抽象。
 */

/*class Outer {
    private int s;
    public class Inner {
        public void mb(){
            s = 100;
            System.out.println("在内部类Inner中s="+ s);
        }
    }
    public void ma(){
        Inner i = new Inner();
        i.mb();
    }
}
class InnterTest {
    public static void main(String[] args) {
        Outer o = new Outer();
        o.ma();
    }
}*/



interface A1 {
    public abstract void fun1();
}
class Outer {
    public static void main(String[] args) {
        new Outer().callInner(new A1(){
            //接口是不能new但此处比较特殊是子类对象实现接口，只不过没有为对象取名
            public void fun1(){
                System.out.println("implement for fun1");
            }
        });// 两步写成一步了
    }
    public void callInner(A1 a) {
        a.fun1();
    }
}

/*
class Outer {
    public static void main(String[] args) {
        Outer a = new Outer();
        Outer.Inner b = a.new Inner();
        b.mb(333);

    }
    private int s =111;
    public class Inner {
        private int s = 222;
        public void mb(int s) {
            System.out.println(s);
            System.out.println(this.s);
            System.out.println(Outer.this.s);
        }
    }
}
*/

//饿汉式
class Singleton1{
    int a = 21;
    private Singleton1(){}
    private static Singleton1 single = new Singleton1();
    public static Singleton1 getInstance(){
        return single;
    }



}
//test


class test1{

    @Test
    public void test(){
        //Singleton1 t = new Singleton1();
        Singleton1 test = Singleton1.getInstance();
        System.out.println(test.a);
        test.a++;
        Singleton1 test1 = Singleton1.getInstance();
        System.out.println(test1.a);
    }
    @Test
    public void test1(){
       //SingleTon2 test = new SingleTon2();
        SingleTon2 test2 = SingleTon2.getInstance();
        System.out.println(test2.b);
        test2.b++;
        SingleTon2 test3 = SingleTon2.getInstance();
        System.out.println(test3.b);
    }
}
//懒汉式,有线程安全问题，可修复
class SingleTon2{
    int b = 2;
    private SingleTon2(){}
    private static SingleTon2 single;
    public static SingleTon2 getInstance(){
        if (single==null){
            single = new SingleTon2();
        }
        return single;
    }


}

/*
 *
 *
 *
 *
 *
 *
 *
 */
public class OopTest3 {
    public static void main(String[] args) {

    }
}

class t{
    public static void main(String[] t_to_do) {
        System.out.println(1);

    }
   /* @Test
    public void test(){
        System.out.println(addOne(1));
    }*/
   /* public int addOne(final int x){
        return x++;
    }*/
}

class Something {
    public static void main(String[] args) {
        Other o = new Other();
        new Something().addOne(o);
    }
    public void addOne(final Other o) {
// o = new Other();
        o.i++;
    } }
class Other {
    public int i; }

interface MyInterface{
    public void absM1();
}
interface  SubInterface extends MyInterface{
    public  void absM2();
}

class SubAdapter implements SubInterface{
//需实现抽象方法，否则，仍需声明为abstract
    @Override
    public void absM1() {
        System.out.println("absM1");
    }

    @Override
    public void absM2() {
        System.out.println("absM2");
    }
}

interface Network{
    public void browse();
}
//被代理类
class RealServer implements Network{
    @Override
    public void browse() {
        System.out.println("真实服务器上网浏览信息");
    }
}
//代理类
class ProxyServer implements Network{
    private Network network;
    public ProxyServer(Network network){
        this.network = network;
    }
    public void check(){
        System.out.println("检查网络连接等操作");
    }
    public void browse(){
        check();
        network.browse();
    }
}
class ProxyDemo{
    public static void main(String[] args) {
        Network net = new ProxyServer(new RealServer());
        net.browse();
    }
}

/*
interface A {
    int x = 0;
}
class B {
    int x = 1;
}
class C extends B implements A {
    public void pX() {
        System.out.println(x);
    }
    public static void main(String[] args) {
        new C().pX();
    } }*/
/*
interface Playable {
    void play();
}
interface Bounceable {
    void play();
}
interface Rollable extends Playable,
        Bounceable {
    Ball ball = new Ball("PingPang");
}
class Ball implements Rollable {
    private String name;
    public String getName() {
        return name; }
    public Ball(String name) {
        this.name = name; }
    public void play() {
        ball = new Ball("Football");
        System.out.println(ball.getName());
    } }*/

interface Filial {// 孝顺的
    default void help() {
        System.out.println("老妈，我来救你了");
    } }
interface Spoony {// 痴情的
    default void help() {
        System.out.println("媳妇，别怕，我来了");
    } }
class Man implements Filial, Spoony {
    @Override
public void help() {
    System.out.println("我该怎么办呢？");
    Filial.super.help();
    Spoony.super.help();
}
@Test
    public void test(){
        new Man().help();
    }
}