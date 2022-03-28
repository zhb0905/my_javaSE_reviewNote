package com.zhb.oop;

/**
 * @author zhb
 * @create 2022-02-03 13:29
 */
/*
 * POP:Procedure Oriented Programming,OOP:Object
 * java虚拟机规范：所有的对象实例以及数组都要在堆上分配
 * 方法区method Area:存已被虚拟机加载的类信息、常量、静态变量、即时编译器编译后的代码等数据
 * 重载Overload
 * Varargs(Variable number of arguments)机制：可变个数形参//与多个实参相匹配
 *       public static void test(int a, String...books);//String[] books;
 *       需放在形参列表最后
 * Java参数传递只有值传递
 * 虚拟机栈，本地方法栈
 * 匿名对象：不定义对象的句柄。常作为实参。new Person().shout();
 * 类变量：static 修饰的。成员变量：非static
 * 递归调用树、递归调用栈与树遍历，迭代与队列
 * 权限：private,缺省，protected,public:类内部，同一个包，不同包的子类，同一个工程；
 * class只有public,default。default类可被同一包下的类访问。
 * 构造器（方法）不能被 static,final,synchronized,abstract,native修饰，不能有return
 * 默认构造器和类修饰符一致
 * 父类的构造器不可被子类继承
 * 属性赋值顺序：默认值->显示初始化->构造器中初始化->通过对象显示赋值；
 */

/*
 * JavaBean:Java写成的可重用组件，是如下类：类公共，有无参构造器，有属性及其get和set方法。
 * 可用JavaBean将功能、处理、值、数据库访问和其他任意可用Java代码创建的对象打包，并且其他的开发者可通过内部的JSP
 *      页面、Servlet、其他JavaBean、applet程序或者应用来使用这些对象。可认为JavaBean提供了一种随时随地的复制和粘贴功能，而不用关心任何改变。
 * UML类图：
 *      Account
 * -balance: double//+:punlic;-:private;#protected;
 * +account(amt :double):double//构造方法有下划线
 *
 * this 找的属性方法若本类未找到，就去父类找
 * 构造器调用：this（形参列表）//要放首行。//有向无环图DAG
 *
 * MVC设计模式：model，controller，view//输入输出，数据处理，数据的展示
 *
 * 模型层  model 主要处理数据
 * >数据对象封装 model.bean/domain
 * >数据库操作类 model.dao
 * >数据库 model.db
 *
 * 控制层 controller 处理业务逻辑
 * >应用界面相关 controller.activity
 * >存放fragment controller.fragment
 * >显示列表的适配器 controller.adapter
 * >服务相关的 controller.service
 * >抽取的基类 controller.base
 *
 * 视图层 view 显示数据
 * >相关工具类 view.utils
 * >自定义view view.ui
 *
 *
 * jdk主要包：
 * java.lang  含Java核心类:String,Math,Integer,System,Thread,提供常用功能
 * java.net   含执行和网络相关的操作的类和接口
 * java.io   多种io类
 * java.util 实用工具类：定义系统特性、接口的集合框架类、日期日历函数
 * java.text java格式化相关的类
 * java.sql  java进行JDBC数据库编程的相关类/接口
 * java.awt  抽象窗口工具类（abstract window toolkits），这些类被用来构建和管理应用程序的GUI
 * 已导入java.a包下的类，又需a包的子包下的类时，仍需要导入
 * import static 组合使用： 调用指定类或接口下的静态的属性或方法。
 */
import org.junit.Test;
public class OopTest1 {
}
//recursion test
class RT{
    public static void main(String[] args) {
        RT rt = new RT();
        int fun10 = rt.fun(10);
        System.out.println(fun10);
    }

    @Test
    public void binomial() { recursion(10);}

    private static int count =0;
    public static int recursion(int k ){
        count++;
        System.out.println(count+"\t"+k);
        if(k<=0){
            return 0;
        }
        return recursion(k-1)+ recursion(k-2);
    }

    public int fun(int n ){
        if (n==0){
            return 1;
        }
        if (1==n){
            return 4;
        }
        return 2*fun(n-1)+fun(n-2);
    }
}
//demo
class Person {
    String name;
    boolean isMarried;

    public Person(){};
    public Person(String name , boolean isMarried){
        this.name = name;
        this.isMarried = isMarried;
    }

    public void walk(){}
    //代码块
    {
        name = "HanMeiMei";
        isMarried = true;
    }
    //内部类
    class pet {
        String name;
        float weight;
    }
}
