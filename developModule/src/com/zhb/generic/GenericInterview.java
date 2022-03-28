package com.zhb.generic;

/**
 * @author zhb
 * @create 2022-02-09 15:51
 */

/*

：List<Integer>。我们说 List 是一个带一个类型
参数的泛型接口(a generic interface that takes a type parameter)，本
例中，类型参数是 Integer。我们在创建这个 List 对象的时候也指定了一个
类型参数。

下面是从java.util包中的List接口和Iterator 接口的定义中摘录的片断：
public interface List<E> {
void add(E x);
Iterator<E> iterator();
}
public interface Iterator<E> {
E next();
boolean hasNext();
}

这些都应该是很熟悉的，除了尖括号中的部分，那是接口 List 和 Iterat
or 中的形式类型参数的声明(the declarations of the formal type param
eters of the interfaces List and Iterator)。
类型参数在整个类的声明中可用，几乎是所有可以使用其他普通类型的
地方

在介绍那一节我们看到了对泛型类型声明 List (the generic type decl
aration List) 的调用，如 List<Integer>。在这个调用中(通常称作一个参数
化类型 a parameterized type)，所有出现的形式类型参数(formal type pa
rameter,这里是 E)都被替换成实体类型参数(actual type argument)(这里
是 Integer)。
你可能想象,List<Integer>代表一个 E 被全部替换成 Integer 的版本：

类型参数就跟在方法或构造函数中普通的参数一样。就像一个方法有形
式参数(formal value parameters)来描述它操作的参数的种类一样，一个
泛型声明也有形式类型参数(formal type parameters)。当一个方法被调用，
实参(actual arguments)替换形参，方法体被执行。当一个泛型声明被调用，
实际类型参数(actual type arguments)取代形式类型参数。
一个命名的习惯：推荐用简练的名字作为形式类型参数的名字(如果可
能，单个字符)。最好避免小写字母


3. 泛型和子类继承
让我们测试一下我们对泛型的理解。下面的代码片断合法么？
List<String> ls = new ArrayList<String>(); //1
List<Object> lo = ls; //2 第 1 行当然合法，但是这个问题的狡猾之处在于第 2 行。
这产生一个问题：
一个 String 的 List 是一个 Object 的 List 么？大多数人的直觉是回答：
“当然！”。
好，在看下面的几行：
lo.add(new Object()); // 3
String s = ls.get(0); // 4: 试图把 Object 赋值给 String
这里，我们使用 lo 指向 ls。我们通过 lo 来访问 ls,一个 String 的 list。
我们可以插入任意对象进去。结果是 ls 中保存的不再是 String。当我们试
图从中取出元素的时候，会得到意外的结果。
java 编译器当然会阻止这种情况的发生。第 2 行会导致一个编译错误。
总之，如果 Foo 是 Bar 的一个子类型(子类或者子接口)，而 G 是某种
泛型声明，那么 G<Foo>是 G<Bar>的子类型并不成立!!
为了处理这种情况，考虑一些更灵活的泛型类型很有用。到现在为止我
们看到的规则限制比较大。

4. 通配符(Wildcards)
考虑写一个例程来打印一个集合(Collection)中的所有元素。下面是在老
的语言中你可能写的代码：
void printCollection(Collection c) {
Iterator i = c.iterator();
for (int k = 0; k < c.size(); k++) {
System.out.println(i.next());
} }
下面是一个使用泛型的幼稚的尝试(使用了新的循环语法):
void printCollection(Collection<Object> c) {
for (Object e : c) {
System.out.println(e);
} }
问题是新版本的用处比老版本小多了。老版本的代码可以使用任何类型
的 Collection 作为参数，而新版本则只能使用 Collection<Object>，我们刚
才阐述了，它不是所有类型的 collections 的父类。
那么什么是各种 collections 的父类呢？它写作： Collection<?>(发音
为:"collection of unknown")，就是，一个集合，它的元素类型可以匹配任
何类型。显然，它被称为通配符。我们可以写：
void printCollection(Collection<?> c) {
for (Object e : c) {
System.out.println(e);
} }
现在，我们可以使用任何类型的 collection 来调用它。注意，我们仍然
可以读取 c 中的元素，其类型是 Object。这永远是安全的，因为不管 colle
ction 的真实类型是什么，它包含的都是 Object。
但是将任意元素加入到其中不是类型安全的：
Collection<?> c = new ArrayList<String>();
c.add(new Object()); // 编译时错误
因为我们不知道 c 的元素类型，我们不能向其中添加对象。
add 方法有类型参数 E 作为集合的元素类型。我们传给 add 的任何参
数都必须是一个未知类型的子类。因为我们不知道那是什么类型，所以我
们无法传任何东西进去。唯一的例外是 null，它是所有类型的成员。
另一方面，我们可以调用 get()方法并使用其返回值。返回值是一个未
知的类型，但是我们知道，它总是一个 Object

像平常一样，要得到使用通配符的灵活性有些代价。这个代价是，现在
向 shapes 中写入是非法的。比如下面的代码是不允许的：
public void addRectangle(List<? extends Shape> shapes) {
shapes.add(0, new Rectangle()); // compile-time error!
}
你应该能够指出为什么上面的代码是不允许的。因为 shapes.add 的第
二个参数类型是 ? extends Shape ——一个 Shape 未知的子类。因此我
们不知道这个类型是什么，我们不知道它是不是 Rectangle 的父类；它可
能是也可能不是一个父类，所以这里传递一个 Rectangle 不安全。


 */
public class GenericInterview {
}
