package com.zhb.oop;

/**
 * @author zhb
 * @create 2022-02-03 22:24
 */
import org.junit.Test;
/*
 * 子类（Subclass,派生类） extends 父类（SuperClass，基类，超类）的所有field，method
 * 子类不能访问父类的private
 * Java 支持单继承，多层继承，不支持多重继承 // 树
 * 方法的重写（Override/Overwrite,重置，覆盖)
 *
 * 重写要求：
 * <同方法名，参数列表（同非static）//static方法属于类，同static则子类无法覆盖父类方法
 * <返回值类型不大于父类
 * <访问权限不小于父类//不能重写父类的private
 * <抛出的异常不大于父类
 *
 * 一种多态性：用不同的对象来区分调用的是同名方法中哪个
 * <SubClassInstance1.fun();//重写的fun()
 * <SuperClassInstance1.fun();
 *
 * private,default,protected,public 类内部（子类也不行），同包下，不同包的子类，同工程
 * super 的追溯不仅限于直接父类，super 代表父类的内存空间的标识
 * 子类构造器默认调super()；//父类空参构造器
 * 可this(parameters) 或 super(paras)显示调（首行），无则默认为super()
 *
 *
 */

/*
 * 对象的多态性：父类的引用指向子类的对象（可直接应用在抽象类和接口上）//可用于形参
 * 2种Java引用型变量：编译时类型（声明，看左）。运行时类型（实际赋的，看右边）
 * 编译时类型 != 运行时类型 ，就出现了对象的多态性（Polymorphism)
 * Object o = new Person();//子类可看为特殊的父类，upcasting向上转型
 * //属性是编译时确定，编译不通过
 * Person e =new Student();
 * e.school = "pku" //非法，不能访问子类中添加的属性方法。
 *
 * 虚拟方法调用(多态情况下)
 * < 方法重写，父类是虚拟方法，根据赋的对象动态调子类方法。编译期无法确定。
 * < 方法的调用是在运行时确定的
 * <Person p = new Student();
 * <p.getInfo(); //调Student的getInfo()
 *
 * 重载：各方法调用地址编译期便绑定，早绑定，静态绑定
 * 对于多态，只用等方法调用那一刻，解释运行器才确定要调用的具体方法。晚绑定，动态绑定。
 * Bruce Eckel : "不要犯傻，如果它不是晚绑定，它就不是多态"
 *
 * 多态小结：
 * 作用：提高代码通用性，接口重用
 * 前提：继承或实现关系，方法重写
 * 成员方法：
 * 成员变量：不具备多态性，只看引用变量所声明的类
 *
 * 造型： Java对象的强制类型转换
 * 子类向父类的转换自动，父类向子类强制//（n:1）
 *
 * public class Person{} === public class Person extends Object{}
 * Object obj = new Object();
 * obj.hashCode();
 * obj.toString();//返回String:类名与引用地址
 * obj.equals(obj1);
 * Object 的 equals 比地址，子类重写的equals 常比较内容。（File,String,Date,包装类Wrapper Class）
 * ==比地址（引用类型）
 * String 的 '+' 自动调toString,sout同理
 * ""+"hello" === "" + "hello".toString()
 * 基本数据类型转String，调的是包装类的toString()
 *
 *包装类(wrapper,封装类)
 * 父类Number:子类Byte,Short,Integer,Long,Float,Double,
 * Boolean,Character
 * 装箱：构造器 Integer i = new Integer(1); Double d = new Double("3.14")
 * 拆箱：成员方法。boolean b = bObj.booleanValue();
 *
 * Wrapper最常用于String转基本类型
 * int i = Integer.parseInt("123");
 * double d = Double.parseDouble("12.7")
 */

public class OopTest2 {
    public static void main(String[] args) {

    }
    @Test //[128]
    public void test2(){
        Integer i = new Integer(1);
        Integer j = new Integer(1);
        System.out.println(i == j);//false
        Integer m = 1;
        Integer n = 1;
        System.out.println(m == n);//true
        Integer x = 128;
        Integer y = 128;
        System.out.println(x == y);//false
    }
    @Test
    public void test1(){
        Object o1 = true ? 1: 2.0;
        System.out.println(o1);//1.0
        Object o2;
        if(true){o2 = 1;}
        else {o2 = 2.0;}
        System.out.println(o2);//1
    }

    @Test
    public void testWrapper(){
        Integer i = 12;//自动
        Double d = 12.3;
        Float f = Float.parseFloat("12.1");
        int i1 = i.intValue();
        String s = String.valueOf(111);
        System.out.println(i1);


    }
    @Test
    public void test(){
        char[] arr = new char[]{'a','b','c'};
        System.out.println(arr);//abc
        int[] arr1 = new int[]{1,2,3};
        System.out.println(arr1);
        double[] arr2 = new double[] {1.1,2.2,3.3};
        System.out.println(arr2);
    }
}
class Base{
    int count = 10;
    public void display(){
        System.out.println(this.count);
    }
}
class Sub extends Base{
    int count = 20 ;
    public void display(){
        System.out.println(this.count);
    }
    @Test
    //20,20,10,20,true,20,20
    public void test(){
        Sub s;
        s = new Sub();
        System.out.println(s.count);
        s.display();
        Base b;
        b = s;
        System.out.println(b.count);
        b.display();
        System.out.println(b == s);
        System.out.println(s.count);
        s.display();
    }
}

class PrivateTest{
    private int age = 12;

    public static void main(String[] args) {

    }
}