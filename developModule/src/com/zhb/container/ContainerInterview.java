package com.zhb.container;

/**
 * @author zhb
 * @create 2022-02-09 12:53
 */

/*
Collection 和 Collections的区别
答：Collection是集合类的上级接口，继承于他的接口主要有Set 和List.
Collections是针对集合类的一个帮助类，他提供一系列静态方法实现对各种集合的搜索、排序、线程安全化等操作

Set里的元素是不能重复的，那么用什么方法来区分重复与否呢? 是用==还是equals()? 它们有何区别
答：Set里的元素是不能重复的，用equals()方法判读两个Set是否相等
    equals()和==方法决定引用值是否指向同一对象equals()在类中被覆盖，为的是当两个分离的对象的内容和类型相配的话，返回真值

List, Set, Map是否继承自Collection接口
答： List，Set是，Map不是

两个对象值相同(x.equals(y) == true)，但却可有不同的hash code，这句话对不对
答：不对，有相同的hash code

说出ArrayList,Vector, LinkedList的存储性能和特性
答：ArrayList和Vector都是使用数组方式存储数据，此数组元素数大于实际存储的数据以便增加和插入元素，
它们都允许直接按序号索引元素，但是插入元素要涉及数组元素移动等内存操作，所以索引数据快而插入数据慢，
Vector由于使用了synchronized方法（线程安全），通常性能上较ArrayList差，
而LinkedList使用双向链表实现存储，按序号索引数据需要进行前向或后向遍历，
但是插入数据时只需要记录本项的前后项即可，所以插入速度较快。

HashMap和Hashtable的区别
答：
1.HashMap与Hashtable都实现了Map接口。由于HashMap的非线程安全性，效率上可能高于Hashtable。Hashtable的方法是Synchronize的，而HashMap不是，在多个线程访问Hashtable时，不需要自己为它的方法实现同步，而HashMap 就必须为之提供外同步。
2. HashMap允许将null作为一个entry的key或者value，而Hashtable不允许。
3.HashMap把Hashtable的contains方法去掉了，改成containsvalue和containsKey。因为contains方法容易让人引起误解。
4.Hashtable继承自Dictionary类，而HashMap是Java1.2引进的Map interface的一个实现。
5.Hashtable和HashMap采用的hash/rehash算法都大概一样，所以性能不会有很大的差异。


ArrayList和Vector的区别
答：就ArrayList与Vector主要从二方面来说.
一.同步性:Vector是线程安全的，也就是说是同步的，而ArrayList是线程序不安全的，不是同步的
二.数据增长:当需要增长时,Vector默认增长为原来一培，而ArrayList却是原来的一半

你所知道的集合类都有哪些？主要方法？
答：最常用的集合类是 List 和 Map。 List 的具体实现包括 ArrayList 和 Vector，它们是可变大小的列表，比较适合构建、存储和操作任何类型对象的元素列表。 List 适用于按数值索引访问元素的情形。
Map 提供了一个更通用的元素存储方法。 Map 集合类用于存储元素对（称作"键"和"值"），其中每个键映射到一个值。

以下代码的运行结果？
	public static void main(String[] args) {
		Integer[] datas = {1,2,3,4,5};
		List<Integer> list = Arrays.asList(datas);
		list.add(5);
		System.out.println(list.size());
	}
运行异常，不允许添加元素

 */

public class ContainerInterview {
}
