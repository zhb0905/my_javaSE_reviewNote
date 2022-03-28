package com.zhb.exception;

/**
 * @author zhb
 * @create 2022-02-06 19:26
 */

/*

运行时异常与一般异常有何异同
答：异常表示程序运行过程中可能出现的非正常状态，运行时异常表示虚拟机的通常操作中可能遇到的异常，是一种常见运行错误。
java编译器要求方法必须声明抛出可能发生的非运行时异常，但是并不要求必须声明抛出未被捕获的运行时异常。
Java中的异常处理机制的简单原理和应用
答：当JAVA程序违反了JAVA的语义规则时，JAVA虚拟机就会将发生的错误表示为一个异常。
违反语义规则包括2种情况。一种是JAVA类库内置的语义检查。例如数组下标越界
,会引发IndexOutOfBoundsException;
访问null的对象时会引发NullPointerException。
另一种情况就是JAVA允许程序员扩展这种语义检查，
程序员可以创建自己的异常，并自由选择在何时用throw关键字引发异常。
所有的异常都是java.lang.Thowable的子类。

垃圾回收的优点和原理。并考虑2种回收机制
答：Java语言中一个显著的特点就是引入了垃圾回收机制，使c++程序员最头疼的内存管理的问题迎刃而解，它使得Java程序员在编写程序的时候不再需要考虑内存管理。由于有个垃圾回收机制，Java中的对象不再有"作用域"的概念，只有对象的引用才有"作用域"。
垃圾回收可以有效的防止内存泄露，有效的使用可以使用的内存。垃圾回收器通常是作为一个单独的低级别的线程运行，不可预知的情况下对内存堆中已经死亡的或者长时间没有使用的对象进行清楚和回收，程序员不能实时的调用垃圾回收器对某个对象或所有对象进行垃圾回收。回收机制有分代复制垃圾回收和标记垃圾回收，增量垃圾回收。

JAVA语言如何进行异常处理，关键字：throws,throw,try,catch,finally分别代表什么意义？在try块中可以抛出异常吗？
答：Java通过面向对象的方法进行异常处理，把各种不同的异常进行分类，并提供了良好的接口。在Java中，每个异常都是一个对象，它是Throwable类或其它子类的实例。当一个方法出现异常后便抛出一个异常对象，该对象中包含有异常信息，调用这个对象的方法可以捕获到这个异常并进行处理。Java的异常处理是通过5个关键词来实现的：try、catch、throw、throws和finally。一般情况下是用try来执行一段程序，如果出现异常，系统会抛出（throws）一个异常，这时候你可以通过它的类型来捕捉（catch）它，或最后（finally）由缺省处理器来处理。
用try来指定一块预防所有"异常"的程序。紧跟在try程序后面，应包含一个catch子句来指定你想要捕捉的"异常"的类型。
throw语句用来明确地抛出一个"异常"。
throws用来标明一个成员函数可能抛出的各种"异常"。
Finally为确保一段代码不管发生什么"异常"都被执行一段代码。
可以在一个成员函数调用的外面写一个try语句，在这个成员函数内部写另一个try语句保护其他代码。每当遇到一个try语句，"异常"的框架就放到堆栈上面，直到所有的try语句都完成。如果下一级的try语句没有对某种"异常"进行处理，堆栈就会展开，直到遇到有处理这种"异常"的try语句。

try {}里有一个return语句，那么紧跟在这个try后的finally {}里的code会不会被执行，什么时候被执行，在return前还是后?
答：会执行，在return前执行

给我一个你最常见到的runtime exception
答：常见的运行时异常有如下这些ArithmeticException, ArrayStoreException,
BufferOverflowException, BufferUnderflowException, CannotRedoException,
CannotUndoException, ClassCastException, CMMException, ConcurrentModificationException,
DOMException, EmptyStackException, IllegalArgumentException, IllegalMonitorStateException, IllegalPathStateException, IllegalStateException, ImagingOpException, IndexOutOfBoundsException, MissingResourceException, NegativeArraySizeException, NoSuchElementException, NullPointerException, ProfileDataException, ProviderException, RasterFormatException, SecurityException, SystemException, UndeclaredThrowableException, UnmodifiableSetException, UnsupportedOperationException

error和exception有什么区别
答：error 表示恢复不是不可能但很困难的情况下的一种严重问题。比如说内存溢出。不可能指望程序能处理这样的情况
    exception 表示一种设计或实现问题。也就是说，它表示如果程序运行正常，从不会发生的情况

*/
/*
class Demo {
    public static void func() {
        try {
            throw new Exception();
            //System.out.println("A");
        } catch (Exception e) {
            System.out.println("B");
        }
    }

    public static void main(String[] args) {
        try {
            func();
        } catch (Exception e) {
            System.out.println("C");
        }
        System.out.println("D");
    }
}*/
class Exc0 extends Exception {
}

class Exc1 extends Exc0 {
}

class Demo {
    public static void main(String[] args) {
        try {
            throw new Exc1();
        } catch (Exc0 e) {
            System.out.println("Exc0");
        } catch (Exception e) {
            System.out.println("Exception");
        }
    }
}
class Ordertest {//8
    public static void main(String[] args) {
        int test = test(3,5);
        System.out.println(test);
    }

    public static int test(int x, int y){
        int result = x;
        try{
            if(x<0 || y<0){
                return 0;
            }
            result = x + y;
            return result;
        }finally{
            result = x - y;
        }
    }
}
class ReturnExceptionDemo {
    static void methodA() {
        try {
            System.out.println("进入方法A");
            throw new RuntimeException("制造异常");
        } finally {
            System.out.println("用A方法的finally");
        }
    }

    static int methodB() {
        try {
            System.out.println("进入方法B");
            // throw new Exception();
            return 1;
        } catch (Exception e) {
            return 3;
        } finally {
            System.out.println("调用B方法的finally");
            // return 2;
        }
    }

    public static void main(String[] args) {
        try {
            methodA();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        int i = methodB();
        System.out.println(i);
    }
}
public class ExceptionInterview {
}
