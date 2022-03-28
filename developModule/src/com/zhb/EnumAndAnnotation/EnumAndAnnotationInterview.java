package com.zhb.EnumAndAnnotation;

/**
 * @author zhb
 * @create 2022-02-08 17:02
 */

/*
5、我没有指定父类，也没有实现接口，还能不能写匿名内部类。
答案：
new Object(){
	void fun(){}
}.fun();


6、对成员内部类的继承说明
public class Test1 extends WithInner.Inner {
	Test1(WithInner w){
		w.super();
	}
}
class WithInner{
	class Inner{

	}
}

自定义annotation，里面包括1个String类型的属性，一个有默认值类型的属性，使用自定义的annotation

定义一个Student类，要求重写toString()的方法，并且此方法要使用Annotation的三个基本的注释，创建Test类，输出Student类的toString方法的所有注释

自定义一个Annotation，定义Teacher类，定义say()方法，使用Annotation的三个基本的注释和自定义的Annotation，打印出Teacher类的say()的自定义的注释，并输出注释的属性值

自定义一个Annotation，要求只能在方法的声明上使用，定义完成后测试Annotation的功能

定义一个Annotation，要求在生成的文档中含有注释信息
 */
public class EnumAndAnnotationInterview {
}
