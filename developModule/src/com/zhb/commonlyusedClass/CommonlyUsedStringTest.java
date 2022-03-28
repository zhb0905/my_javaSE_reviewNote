package com.zhb.commonlyusedClass;

import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;

/**
 * @author zhb
 * @create 2022-02-07 12:19
 */
/*
1 字符串相关类 //String,StringBuffer,StringBuilder
2 jdk 8 前日期时间API //System 静态方法，Date类，Calendar类，SimpleDateFormat类
3 jdk 8 中新日期时间API // LocalDate、LocalTime、LocalDateTime、instant、DateTimeFormatter、其他类
4 Java比较器 //Comparable接口，Comparator接口
5 System类
6 Math类
7 BigInteger,BigDecimal

 */

/*
9-1 字符串相关的类
String的特性
 String类：代表字符串。Java 程序中的所有字符串字面值（如 "abc" ）都作
为此类的实例实现。
 String是一个final类，代表不可变的字符序列。
 字符串是常量，用双引号引起来表示。它们的值在创建之后不能更改。  String对象的字符内容是存储在一个字符数组value[]中的。
public final class String
implements java.io.Serializable, Comparable<String>, CharSequence {

private final char value[];// The value is used for character storage.

private int hash; // Default to 0// Cache the hash code for the string

String s = "abc"//指向方法区，不经过堆
方法区（含字符串常量池）
对里的value指向常量池

String对象的创建
String str = "hello";
//本质上this.value = new char[0];
String s1 = new String();
//this.value = original.value;
String s2 = new String(String original);
//this.value = Arrays.copyOf(value, value.length);
String s3 = new String(char[] a);
String s4 = new String(char[] a,int startIndex,int count);

String str1 = “abc”;与String str2 = new String(“abc”);的区别？
 字符串常量存储在
字符串常量池，目
的是共享
 字符串非常量对象
存储在堆中。

结论：
 常量与常量的拼接结果在常量池。且常量池中不会存在相同内容的常量。
  只要其中有一个是变量，结果就在堆中
 如果拼接的结果调用intern()方法，返回值就在常量池中

String使用陷阱
 String s1 = "a";
说明：在字符串常量池中创建了一个字面量为"a"的字符串。
 s1 = s1 + "b";
说明：实际上原来的“a”字符串对象已经丢弃了，现在在堆空间中产生了一个字符
串s1+"b"（也就是"ab")。如果多次执行这些改变串内容的操作，会导致大量副本
字符串对象存留在内存中，降低效率。如果这样的操作放到循环中，会极大影响
程序的性能。  String s2 = "ab";
说明：直接在字符串常量池中创建一个字面量为"ab"的字符串。
 String s3 = "a" + "b";
说明：s3指向字符串常量池中已经创建的"ab"的字符串。
String s4 = s1.intern();
说明：堆空间的s1对象在调用intern()之后，会将常量池中已经存在的"ab"字符串
赋值给s4。

String常用方法1
 int length()：返回字符串的长度： return value.length
 char charAt(int index)： 返回某索引处的字符return value[index]
  boolean isEmpty()：判断是否是空字符串：return value.length == 0
   String toLowerCase()：使用默认语言环境，将 String 中的所有字符转换为小写
 String toUpperCase()：使用默认语言环境，将 String 中的所有字符转换为大写
 String trim()：返回字符串的副本，忽略前导空白和尾部空白
 boolean equals(Object obj)：比较字符串的内容是否相同
 boolean equalsIgnoreCase(String anotherString)：与equals方法类似，
忽略大小写
 String concat(String str)：将指定字符串连接到此字符串的结尾。 等价于用“+”
 int compareTo(String anotherString)：比较两个字符串的大小
 String substring(int beginIndex)：返回一个新的字符串，它是此字符串的从
beginIndex开始截取到最后的一个子字符串。
 String substring(int beginIndex, int endIndex) ：返回一个新字符串，它是此字
符串从beginIndex开始截取到endIndex(不包含)的一个子字符串。
 boolean endsWith(String suffix)：测试此字符串是否以指定的后缀结束
 boolean startsWith(String prefix)：测试此字符串是否以指定的前缀开始
 boolean startsWith(String prefix, int offset)：测试此字符串从指定索引开始的
子字符串是否以指定前缀开始
 boolean contains(CharSequence s)：当且仅当此字符串包含指定的 char 值序列
时，返回 true
 int indexOf(String str)：返回指定子字符串在此字符串中第一次出现处的索引
 int indexOf(String str, int fromIndex)：返回指定子字符串在此字符串中第一次出
现处的索引，从指定的索引开始
 int lastIndexOf(String str)：返回指定子字符串在此字符串中最右边出现处的索引
 int lastIndexOf(String str, int fromIndex)：返回指定子字符串在此字符串中最后
一次出现处的索引，从指定的索引开始反向搜索
注：indexOf和lastIndexOf方法如果未找到都是返回-1
 String replace(char oldChar, char newChar)：返回一个新的字符串，它是
通过用 newChar 替换此字符串中出现的所有 oldChar 得到的。
  String replace(CharSequence target, CharSequence replacement)：使
用指定的字面值替换序列替换此字符串所有匹配字面值目标序列的子字符串。
 String replaceAll(String regex, String replacement) ： 使 用 给 定 的
replacement 替换此字符串所有匹配给定的正则表达式的子字符串。
  String replaceFirst(String regex, String replacement) ： 使 用 给 定 的
replacement 替换此字符串匹配给定的正则表达式的第一个子字符串。
 boolean matches(String regex)：告知此字符串是否匹配给定的正则表达式。
  String[] split(String regex)：根据给定正则表达式的匹配拆分此字符串。
   String[] split(String regex, int limit)：根据匹配给定的正则表达式来拆分此
字符串，最多不超过limit个，如果超过了，剩下的全部都放到最后一个元素中。

String与基本数据类型转换
复 习
字符串  基本数据类型、包装类
Integer包装类的public static int parseInt(String s)：可以将由“数字”字
符组成的字符串转换为整型。
类似地,使用java.lang包中的Byte、Short、Long、Float、Double类调相应
的类方法可以将由“数字”字符组成的字符串，转化为相应的基本数据类型。
基本数据类型、包装类  字符串
调用String类的public String valueOf(int n)可将int型转换为字符串
相应的valueOf(byte b)、valueOf(long l)、valueOf(float f)、valueOf(double
d)、valueOf(boolean b)可由参数的相应类型到字符串的转换

String与字符数组转换
 字符数组  字符串
String 类的构造器：String(char[]) 和 String(char[]，int offset，int
length) 分别用字符数组中的全部字符和部分字符创建字符串对象。
 字符串  字符数组
public char[] toCharArray()：将字符串中的全部字符存放在一个字符数组
中的方法。
public void getChars(int srcBegin, int srcEnd, char[] dst,
int dstBegin)：提供了将指定索引范围内的字符串存放到数组中的方法。

String与字节数组转换
 字节数组  字符串
String(byte[])：通过使用平台的默认字符集解码指定的 byte 数组，构
造一个新的 String。
 String(byte[]，int offset，int length) ：用指定的字节数组的一部分，
即从数组起始位置offset开始取length个字节构造一个字符串对象。
 字符串  字节数组
public byte[] getBytes() ：使用平台的默认字符集将此 String 编码为
byte 序列，并将结果存储到一个新的 byte 数组中。
public byte[] getBytes(String charsetName) ：
使用指定的字符集将 此 String 编码到 byte 序列，并将结果存储到新的 byte 数组。




 */

/*
StringBuffer类
java.lang.StringBuffer代表可变的字符序列，JDK1.0中声明，可以对字符
串内容进行增删，此时不会产生新的对象。
 很多方法与String相同。
 作为参数传递时，方法内部可以改变值。

继承树
Object
    AbstractStringBuilder
        StringBuffer
        StringBuilder

abstract class AbstractStringBuilder implements Appendable,CharSequence {
    char[] value;//value没有final声明,value可以不断扩容。
    int count//count记录有效字符的个数。

StringBuffer类不同于String，其对象必须使用构造器生成。
有三个构造器：
StringBuffer()：初始容量为16的字符串缓冲区
StringBuffer(int size)：构造指定容量的字符串缓冲区
StringBuffer(String str)：将内容初始化为指定字符串内容

StringBuffer类的常用方法

StringBuffer append(xxx)：提供了很多的append()方法，用于进行字符串拼接
StringBuffer delete(int start,int end)：删除指定位置的内容
StringBuffer replace(int start, int end, String str)
：把[start,end)位置替换为str
StringBuffer insert(int offset, xxx)：在指定位置插入xxx
StringBuffer reverse() ：把当前字符序列逆转
此外，还定义了如下的方法：
public int indexOf(String str)
public String substring(int start,int end)
public int length()
public char charAt(int n )
public void setCharAt(int n ,char ch)
 当append和insert时，如果原来value数组长度不够，可扩容。
 如上这些方法支持方法链操作。
 方法链的原理：
@Override
public StringBuilder append(String str) {
    super.append(str);
    return this;//
}

StringBuilder类
StringBuilder 和 StringBuffer 非常类似，均代表可变的字符序列，而且
提供相关功能的方法也一样
面试题：对比String、StringBuffer、StringBuilder
String(JDK1.0)：不可变字符序列
StringBuffer(JDK1.0)：可变字符序列、效率低、线程安全
StringBuilder(JDK 5.0)：可变字符序列、效率高、线程不安全
注意：作为参数传递的话，方法内部String不会改变其值，
StringBuffer和StringBuilder
会改变其值。


}
 */

/*
9-2 JDK8之前日期时间API
java.util.Timezone
    java.util.Calendar
        java.util.GregorianCalendar
    java.util.Date
        java.sql.Date
        java.sql.Time
        java.sql.Timestamp
    java.text.DataFormat
        java.text.SimpleDateFormat

1. java.lang.System类
System类提供的public static long currentTimeMillis()用来返回当前时
间与1970年1月1日0时0分0秒之间以毫秒为单位的时间差。
 此方法适于计算时间差。
计算世界时间的主要标准有：
UTC(Coordinated Universal Time)
GMT(Greenwich Mean Time)
CST(Central Standard Time)

2. java.util.Date类
表示特定的瞬间，精确到毫秒
 构造器：
 Date()：使用无参构造器创建的对象可以获取本地当前时间。
 Date(long date)
 常用方法
 getTime():返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象
表示的毫秒数。
 toString():把此 Date 对象转换为以下形式的 String： dow mon dd
hh:mm:ss zzz yyyy 其中： dow 是一周中的某一天 (Sun, Mon, Tue,
Wed, Thu, Fri, Sat)，zzz是时间标准。
 其它很多方法都过时了。
import java.util.Date;
Date date = new Date();
System.out.println(date);
System.out.println(System.currentTimeMillis());
System.out.println(date.getTime());
System.out.println(date.toString());

3. java.text.SimpleDateFormat类
 Date类的API不易于国际化，大部分被废弃了，java.text.SimpleDateFormat
类是一个不与语言环境有关的方式来格式化和解析日期的具体类。
 它允许进行格式化：日期文本、解析：文本日期
 格式化：
 SimpleDateFormat() ：默认的模式和语言环境创建对象
 public SimpleDateFormat(String pattern)：该构造方法可以用参数pattern
指定的格式创建一个对象，该对象调用：
 public String format(Date date)：方法格式化时间对象date
 解析：
 public Date parse(String source)：从给定字符串的开始解析文本，以生成
一个日期

Object
    Calendar
        GregorianCalendar
            BuddhistCalendar



4. java.util.Calendar(日历)类
 Calendar是一个抽象基类，主用用于完成日期字段之间相互操作的功能。
 获取Calendar实例的方法
 使用Calendar.getInstance()方法
 调用它的子类GregorianCalendar的构造器。
 一个Calendar的实例是系统时间的抽象表示，通过get(int field)方法来取得想
要的时间信息。比如YEAR、MONTH、DAY_OF_WEEK、HOUR_OF_DAY 、
MINUTE、SECOND
 public void set(int field,int value)
 public void add(int field,int amount)
 public final Date getTime()
 public final void setTime(Date date)
 注意:  获取月份时：一月是0，二月是1，以此类推，12月是11
 获取星期时：周日是1，周二是2 ， 。。。。周六是7

 */

/*
9-3 JDK8中新日期时间API
JDK 1.0中包含了一个java.util.Date类，
但是它的大多数方法已经在JDK 1.1引入Calendar类之后被弃用
了。而Calendar并不比Date好多少。它们面临的问题是：
可变性：像日期和时间这样的类应该是不可变的。
偏移性：Date中的年份是从1900开始的，而月份都从0开始。
格式化：格式化只对Date有用，Calendar则不行。
此外，它们也不是线程安全的；不能处理闰秒等。
总结：对日期和时间的操作一直是Java程序员最痛苦的地方之一。

新时间日期API
 第三次引入的API是成功的，并且Java 8中引入的java.time API 已经纠正了
过去的缺陷，将来很长一段时间内它都会为我们服务。
 Java 8 吸收了 Joda-Time 的精华，以一个新的开始为 Java 创建优秀的 API。
新的 java.time 中包含了所有关于本地日期（LocalDate）、本地时间
（LocalTime）、本地日期时间（LocalDateTime）、时区（ZonedDateTime）
和持续时间（Duration）的类。历史悠久的 Date 类新增了 toInstant() 方法，
用于把 Date 转换成新的表示形式。这些新增的本地化时间日期 API 大大简
化了日期时间和本地化的管理。

新时间日期API
java.time – 包含值对象的基础包
java.time.chrono – 提供对不同的日历系统的访问//chrono时钟
java.time.format – 格式化和解析时间和日期
java.time.temporal – 包括底层框架和扩展特性//temporal时间的
java.time.zone – 包含时区支持的类
说明：大多数开发者只会用到基础包和format包，也可能会用到temporal包。因此，尽
管有68个新的公开类型，大多数开发者，大概将只会用到其中的三分之一。

 LocalDate、LocalTime、LocalDateTime 类是其中较重要的几个类，它们的实例
是不可变的对象，分别表示使用 ISO-8601日历系统的日期、时间、日期和时间。
它们提供了简单的本地日期或时间，并不包含当前的时间信息，也不包含与时区
相关的信息。
 LocalDate代表IOS格式（yyyy-MM-dd）的日期,可以存储 生日、纪念日等日期。
LocalTime表示一个时间，而不是日期。
LocalDateTime是用来表示日期和时间的，这是一个最常用的类之一。
注：ISO-8601日历系统是国际标准化组织制定的现代公民的日期和时间的表示
法，也就是公历


方法 描述
now() / * now(ZoneId zone) 静态方法，根据当前时间创建对象/指定时区的对象
of() 静态方法，根据指定日期/时间创建对象
getDayOfMonth()/getDayOfYear() 获得月份天数(1-31) /获得年份天数(1-366)
getDayOfWeek() 获得星期几(返回一个 DayOfWeek 枚举值)
getMonth() 获得月份, 返回一个 Month 枚举值
getMonthValue() / getYear() 获得月份(1-12) /获得年份
getHour()/getMinute()/getSecond() 获得当前对象对应的小时、分钟、秒
withDayOfMonth()/withDayOfYear()/
withMonth()/withYear() 将月份天数、年份天数、月份、年份修改为指定的值并返回新的对象
plusDays(), plusWeeks(),
plusMonths(), plusYears(),plusHours() 向当前对象添加几天、几周、几个月、几年、几小时
minusMonths() / minusWeeks()/
minusDays()/minusYears()/minusHours() 从当前对象减去几月、几周、几天、几年、几小时
//minus[ˈmaɪnəs]

9.3.2 瞬时：Instant

 Instant：时间线上的一个瞬时点。 这可能被用来记录应用程序中的事件时间戳。
  在处理时间和日期的时候，我们通常会想到年,月,日,时,分,秒。然而，这只是
时间的一个模型，是面向人类的。第二种通用模型是面向机器的，或者说是连
续的。在此模型中，时间线中的一个点表示为一个很大的数，这有利于计算机
处理。在UNIX中，这个数从1970年开始，以秒为的单位；同样的，在Java中，
也是从1970年开始，但以毫秒为单位。
 java.time包通过值类型Instant提供机器视图，不提供处理人类意义上的时间
单位。Instant表示时间线上的一点，而不需要任何上下文信息，例如，时区。
概念上讲，它只是简单的表示自1970年1月1日0时0分0秒（UTC）开始的秒
数。因为java.time包是基于纳秒计算的，所以Instant的精度可以达到纳秒级。
 (1 ns = 10-9 s) 1秒 = 1000毫秒 =10^6微秒=10^9纳秒

方法 描述
now() 静态方法，返回默认UTC时区的Instant类的对象
ofEpochMilli(long epochMilli) 静态方法，返回在1970-01-01 00:00:00基
础上加上指定毫秒数之后的Instant类的对象//epoch纪元
atOffset(ZoneOffset offset) 结合即时的偏移来创建一个 OffsetDateTime
toEpochMilli() 返回1970-01-01 00:00:00到当前时间的毫秒数，即为时间戳
时间戳是指格林威治时间1970年01月01日00时00分00秒(北京时间1970年01月01
日08时00分00秒)起至现在的总秒数

9.3.3 格式化与解析日期或时间
java.time.format.DateTimeFormatter 类：该类提供了三种格式化方法：
 预定义的标准格式。如：
ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME
 本地化相关的格式。如：ofLocalizedDateTime(FormatStyle.LONG)
 自定义的格式。如：ofPattern(“yyyy-MM-dd hh:mm:ss”)
方 法 描 述
ofPattern(String pattern) 静态方法 ，
 返 回 一 个 指 定 字 符 串 格 式 的DateTimeFormatter
format(TemporalAccessor t) 格式化一个日期、时间，返回字符串
parse(CharSequence text) 将指定格式的字符序列解析为一个日期、时间

9.3.4 其它API
 ZoneId：该类中包含了所有的时区信息，一个时区的ID，如 Europe/Paris
 ZonedDateTime：一个在ISO-8601日历系统时区的日期时间，如 2007-12-
03T10:15:30+01:00 Europe/Paris。
     其中每个时区都对应着ID，地区ID都为“{区域}/{城市}”的格式，例如：Asia/Shanghai
  Clock：使用时区提供对当前即时、日期和时间的访问的时钟。
  持续时间：Duration，用于计算两个“时间”间隔
 日期间隔：Period，用于计算两个“日期”间隔
 TemporalAdjuster : 时间校正器。有时我们可能需要获取例如：将日期调整
到“下一个工作日”等操作。
 TemporalAdjusters : 该类通过静态方法
(firstDayOfXxx()/lastDayOfXxx()/nextXxx())提供了大量的常用
TemporalAdjuster 的实现。


locateDateTime
ZonedDatetime
ZoneId
.now()
.of()
Duration
Period
between()

Datetime,zone,formatter,instant,TemporalAdjuster

9.3.5 参考：与传统日期处理的转换
类 To 遗留类 From 遗留类
java.time.Instant与java.util.Date Date.from(instant) date.toInstant()
java.time.Instant与java.sql.Timestamp Timestamp.from(instant) timestamp.toInstant()
java.time.ZonedDateTime与
java.util.GregorianCalendar GregorianCalendar.from(zonedDateTime) cal.toZonedDateTime()
java.time.LocalDate与java.sql.Time Date.valueOf(localDate) date.toLocalDate()
java.time.LocalTime与java.sql.Time Date.valueOf(localDate) date.toLocalTime()
java.time.LocalDateTime与
java.sql.Timestamp Timestamp.valueOf(localDateTime) timestamp.toLocalDateTime()
java.time.ZoneId与java.util.TimeZone Timezone.getTimeZone(id) timeZone.toZoneId()
java.time.format.DateTimeFormatter与
java.text.DateFormat formatter.toFormat() 无



 */

/*

9-4 Java比较器
 在Java中经常会涉及到对象数组的排序问题，那么就涉及到对象之间
的比较问题。
 Java实现对象排序的方式有两种：
 自然排序：java.lang.Comparable
 定制排序：java.util.Comparator

方式一：自然排序：java.lang.Comparable
 Comparable接口强行对实现它的每个类的对象进行整体排序。这种排序被称
为类的自然排序。
 实现 Comparable 的类必须实现 compareTo(Object obj) 方法，两个对象即
通过 compareTo(Object obj) 方法的返回值来比较大小。
如果当前对象this大 于形参对象obj，则返回正整数，如果当前对象this小于形参对象obj，则返回
负整数，如果当前对象this等于形参对象obj，则返回零。
 实现Comparable接口的对象列表（和数组）可以通过 Collections.sort 或
Arrays.sort进行自动排序。实现此接口的对象可以用作有序映射中的键或有
序集合中的元素，无需指定比较器。
  对于类 C 的每一个 e1 和 e2 来说，当且仅当 e1.compareTo(e2) == 0 与
e1.equals(e2) 具有相同的 boolean 值时，类 C 的自然排序才叫做与 equals
一致。建议（虽然不是必需的）最好使自然排序与 equals 一致。
Comparable 的典型实现：(默认都是从小到大排列的)
String：按照字符串中字符的Unicode值进行比较
Character：按照字符的Unicode值来进行比较
数值类型对应的包装类以及BigInteger、BigDecimal：按照它们对应的数值
大小进行比较
Boolean：true 对应的包装类实例大于 false 对应的包装类实例
Date、Time等：后面的日期时间比前面的日期时间大

方式二：定制排序：java.util.Comparator
 当元素的类型没有实现java.lang.Comparable接口而又不方便修改代码，
或者实现了java.lang.Comparable接口的排序规则不适合当前的操作，那
么可以考虑使用 Comparator 的对象来排序，强行对多个对象进行整体排序的比较。
 重写compare(Object o1,Object o2)方法，比较o1和o2的大小：如果方法返
回正整数，则表示o1大于o2；如果返回0，表示相等；返回负整数，表示
o1小于o2。
  可以将 Comparator 传递给 sort 方法（如 Collections.sort 或 Arrays.sort），
从而允许在排序顺序上实现精确控制。
 还可以使用 Comparator 来控制某些数据结构（如有序 set或有序映射）的
顺序，或者为那些没有自然顺序的对象 collection 提供排序。

Goods[] all = new Goods[4];
all[0] = new Goods("War and Peace", 100);
all[1] = new Goods("Childhood", 80);
all[2] = new Goods("Scarlet and Black", 140);
all[3] = new Goods("Notre Dame de Paris", 120);
Arrays.sort(all, new Comparator() {
@Override
public int compare(Object o1, Object o2) {
Goods g1 = (Goods) o1;
Goods g2 = (Goods) o2;
return g1.getName().compareTo(g2.getName());
}
});
System.out.println(Arrays.toString(all));

 */

/*
9-5 System类
 System类代表系统，系统级的很多属性和控制方法都放置在该类的内部。
该类位于java.lang包。
  由于该类的构造器是private的，所以无法创建该类的对象，也就是无法实
例化该类。其内部的成员变量和成员方法都是static的，所以也可以很方便
的进行调用。
  成员变量
 System类内部包含in、out和err三个成员变量，分别代表标准输入流
(键盘输入)，标准输出流(显示器)和标准错误输出流(显示器)。
 成员方法
 native long currentTimeMillis()： 该方法的作用是返回当前的计算机时间，时间的表达格式为当前计算机时
间和GMT时间(格林威治时间)1970年1月1号0时0分0秒所差的毫秒数。
 void exit(int status)： 该方法的作用是退出程序。其中status的值为0代表正常退出，非零代表
异常退出。使用该方法可以在图形界面编程中实现程序的退出功能等。
 void gc()： 该方法的作用是请求系统进行垃圾回收。至于系统是否立刻回收，则
取决于系统中垃圾回收算法的实现以及系统执行时的情况。
 String getProperty(String key)： 该方法的作用是获得系统中属性名为key的属性对应的值。系统中常见
的属性名以及属性的作用如下表所示：
属性名/属性说明
java.version/java运行是环境版本
java.home/Java安装目录
os.name/os名称
os.version/
user.name/  用户的账户名称
user.home/用户的主目录
user.dir/用户的当前工作目录

 */

/*
9.6 Math类
java.lang.Math提供了一系列静态方法用于科学计算。其方法的参数和返回
值类型一般为double型。
abs 绝对值
acos,asin,atan,cos,sin,tan 三角函数
sqrt 平方根
pow(double a,doble b) a的b次幂
log 自然对数
exp e为底指数
max(double a,double b)
min(double a,double b)
random() 返回0.0到1.0的随机数
long round(double a) double型数据a转换为long型（四舍五入）
toDegrees(double angrad) 弧度—>角度
toRadians(double angdeg) 角度—>弧度

 */

/*
9.7 BigInteger与BigDecimal
 Integer类作为int的包装类，能存储的最大整型值为2
31-1，Long类也是有限的，
最大为2
63-1。如果要表示再大的整数，不管是基本数据类型还是他们的包装类
都无能为力，更不用说进行运算了。
 java.math包的BigInteger可以表示不可变的任意精度的整数。BigInteger 提供
所有 Java 的基本整数操作符的对应物，并提供 java.lang.Math 的所有相关方法。
另外，BigInteger 还提供以下运算：模算术、GCD 计算、质数测试、素数生成、
位操作以及一些其他操作。
 构造器  BigInteger(String val)：根据字符串构建BigInteger对象
 常用方法
 public BigInteger abs()：返回此 BigInteger 的绝对值的 BigInteger。
  BigInteger add(BigInteger val) ：返回其值为 (this + val) 的 BigInteger
 BigInteger subtract(BigInteger val) ：返回其值为 (this - val) 的 BigInteger
 BigInteger multiply(BigInteger val) ：返回其值为 (this * val) 的 BigInteger
 BigInteger divide(BigInteger val) ：返回其值为 (this / val) 的 BigInteger。整数
相除只保留整数部分。
//Remainder余数
  BigInteger remainder(BigInteger val) ：返回其值为 (this % val) 的 BigInteger。
 BigInteger[] divideAndRemainder(BigInteger val)：返回包含 (this / val) 后跟
(this % val) 的两个 BigInteger 的数组。
 BigInteger pow(int exponent) ：返回其值为 (this^exponent) 的 BigInteger。

  BigDecimal类
   一般的Float类和Double类可以用来做科学计算或工程计算，但在商业计算中，
要求数字精度比较高，故用到java.math.BigDecimal类。
  BigDecimal类支持不可变的、任意精度的有符号十进制定点数。
  构造器
  public BigDecimal(double val)
  public BigDecimal(String val)
  常用方法
 public BigDecimal add(BigDecimal augend)
 public BigDecimal subtract(BigDecimal subtrahend)
 public BigDecimal multiply(BigDecimal multiplicand)
 public BigDecimal divide(BigDecimal divisor, int scale, int roundingMode)

 */

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.*;

class TestBigIntegerBigDecimal {

    @Test
    public void test12(){
        BigInteger bigInteger = new BigInteger("123456789987654321");
        BigInteger bigInteger1 = new BigInteger("123");
        BigDecimal bigDecimal = new BigDecimal("12345.12345");
        BigDecimal bigDecimal1 = new BigDecimal("12.3");
        System.out.println(bigDecimal.add(bigDecimal1));
        //System.out.println(bigDecimal.divide(bigDecimal1));
        System.out.println(bigInteger.add(bigInteger1));
        System.out.println(bigInteger.divide(bigInteger1));
        System.out.println(bigDecimal.divide(bigDecimal1,15,BigDecimal.ROUND_HALF_UP));

    }

    public static void main(String[] args) {

    }

}


class Goods implements Comparable{
    int price;
    String name;

    public Goods(int price,String name) {
        this.price = price;
        this.name = name;
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Goods){
            if(this.price>((Goods) o).price) return 1;
            else if (this.price<((Goods) o).price) return -1;
            else  return 0;
        }
        throw new RuntimeException("not Goods");
    }

}
class Testee {
    @Test
    public void test11(){
        System.out.println(System.getProperty("java.version"));
        System.out.println(System.getProperty("java.home"));
        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("os.version"));
        System.out.println(System.getProperty("user.name"));
        System.out.println(System.getProperty("user.home"));
        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("java.version"));
    }

    @Test
    public void test10(){
        System.out.println("hello");
        System.exit(0);
        System.out.println("world");
    }

    public static void main(String[] args) {

            Goods[] goods = new Goods[3];
            goods[0] = new Goods(3,"abc");
            goods[1] = new Goods(2,"acb");
            goods[2] = new Goods(1,"cba");
            //Arrays.sort(goods);
        Arrays.sort(goods, new Comparator<Goods>() {
            @Override
            public int compare(Goods o1, Goods o2) {
                return o1.name.compareTo(o2.name);
            }
        });
        for (Goods s:
             goods) {
            System.out.println(s.price +s.name);
        }
    }
}

class StringTest {
    String str = new String("good");
    char[] ch = { 't', 'e', 's', 't' };
    public void change(String str, char ch[]) {
        str = "test ok";
        ch[0] = 'b'; }
    @Test
    public void test9(){
        // TemporalAdjuster:时间校正器
// 获取当前日期的下一个周日是哪天？
        TemporalAdjuster temporalAdjuster = TemporalAdjusters.next(DayOfWeek.SUNDAY);
        LocalDateTime localDateTime = LocalDateTime.now().with(temporalAdjuster);
        System.out.println(localDateTime);
// 获取下一个工作日是哪天？
        LocalDate localDate = LocalDate.now().with(new TemporalAdjuster() {
            @Override
            public Temporal adjustInto(Temporal temporal) {
                LocalDate date = (LocalDate) temporal;
                if (date.getDayOfWeek().equals(DayOfWeek.FRIDAY)) {
                    return date.plusDays(3);
                } else if (date.getDayOfWeek().equals(DayOfWeek.SATURDAY)) {
                    return date.plusDays(2);
                } else {
                    return date.plusDays(1);
                }
            }
        });
        System.out.println("下一个工作日是：" + localDate);
    }
    @Test
    public void test8(){
        //ZoneId:类中包含了所有的时区信息
        // ZoneId的getAvailableZoneIds():获取所有的ZoneId
        /*Set<String> zoneIds = ZoneId.getAvailableZoneIds();
        for (String s : zoneIds) {
            System.out.println(s);
        }*/
        Set<String> zoneIds = ZoneId.getAvailableZoneIds();
        /*for (String s:
             zoneIds) {
            System.out.println(s);
        }*/
        /*try {
            Thread.sleep(33000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        // ZoneId的of():获取指定时区的时间
       /* LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("Asia/Tokyo"));
        System.out.println(localDateTime);*/
      /*  LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("Asia/Tokyo"));
        System.out.println(localDateTime);
//ZonedDateTime:带时区的日期时间
// ZonedDateTime的now():获取本时区的ZonedDateTime对象
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);
// ZonedDateTime的now(ZoneId id):获取指定时区的ZonedDateTime对象
        ZonedDateTime zonedDateTime1 = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
        System.out.println(zonedDateTime1);
        //Duration:用于计算两个“时间”间隔，以秒和纳秒为基准
        LocalTime localTime = LocalTime.now();
        LocalTime localTime1 = LocalTime.of(15, 23, 32);
//between():静态方法，返回Duration对象，表示两个时间的间隔
        Duration duration = Duration.between(localTime1, localTime);
        System.out.println(duration);
        System.out.println(duration.getSeconds());
        System.out.println(duration.getNano());*/
        LocalDateTime localDateTime = LocalDateTime.of(2016, 6, 12, 15, 23, 32);
        LocalDateTime localDateTime1 = LocalDateTime.of(2017, 6, 12, 15, 23, 32);
        Duration duration1 = Duration.between(localDateTime1, localDateTime);
        System.out.println(duration1.toDays());

        //Period:用于计算两个“日期”间隔，以年、月、日衡量
        LocalDate localDate = LocalDate.now();
        LocalDate localDate1 = LocalDate.of(2028, 3, 18);
        Period period = Period.between(localDate, localDate1);
        System.out.println(period);
        System.out.println(period.getYears());
        System.out.println(period.getMonths());
        System.out.println(period.getDays());
        Period period1 = period.withYears(2);
        System.out.println(period1);

        // TemporalAdjuster:时间校正器
// 获取当前日期的下一个周日是哪天？
        /*TemporalAdjuster temporalAdjuster = TemporalAdjusters.next(DayOfWeek.SUNDAY);
        LocalDateTime localDateTime = LocalDateTime.now().with(temporalAdjuster);
        System.out.println(localDateTime);
// 获取下一个工作日是哪天？
        LocalDate localDate = LocalDate.now().with(new TemporalAdjuster() {
            @Override
            public Temporal adjustInto(Temporal temporal) {
                LocalDate date = (LocalDate) temporal;
                if (date.getDayOfWeek().equals(DayOfWeek.FRIDAY)) {
                    return date.plusDays(3);
                } else if (date.getDayOfWeek().equals(DayOfWeek.SATURDAY)) {
                    return date.plusDays(2);
                } else {
                    return date.plusDays(1);
                }
            }
        });
        System.out.println("下一个工作日是：" + localDate);*/
    }




    @Test
    public void test7(){
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        date = new Date(234234235235L);
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH,8);
        System.out.println(calendar.getTime());
        calendar.add(Calendar.HOUR,2);
        System.out.println(calendar.getTime());
        calendar.add(Calendar.MONTH,-2);
        System.out.println(calendar.getTime());
    }
    @Test
    public void test6(){
        Date date = new Date();
        SimpleDateFormat formater = new SimpleDateFormat();
        System.out.println(formater.format(date));
        SimpleDateFormat formater2 = new SimpleDateFormat("yyyy年MM月dd日 EEE HH:mm:ss");
        System.out.println(formater2.format(date));
        Date date2 = null;
        try {
            date2 = formater2.parse("2008年08月08日 星期一 08:08:08");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(date2.toString());

    }
    @Test
    public void test5(){
        Date date = new Date();
        System.out.println(date);
        System.out.println(System.currentTimeMillis());
        System.out.println(date.getTime());
        System.out.println(date.toString());
    }
    @Test
    public void test4(){
        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);
        System.out.println(sb.length());//
        System.out.println(sb);//
        StringBuffer sb1 = new StringBuffer(str);
        System.out.println(sb1);//
    }
    @Test
    public void test3(){
        //初始设置
        long startTime = 0L;
        long endTime = 0L;
        String text = "";
        StringBuffer buffer = new StringBuffer("");
        StringBuilder builder = new StringBuilder("");
//开始对比
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            buffer.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer的执行时间：" + (endTime - startTime));
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            builder.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder的执行时间：" + (endTime - startTime));
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            text = text + i; }
        endTime = System.currentTimeMillis();
        System.out.println("String的执行时间：" + (endTime - startTime));
    }
    @Test
    public void test(){
        /*String str = "12hello34world5java7891mysql456";
        //把字符串中的数字替换成,，如果结果中开头和结尾有，的话去掉
        String string  = str.replaceAll("\\d+",",").replaceAll("^,|,$","");
        System.out.println(string);*/
        /*String str = "12345";
//判断str字符串中是否全部有数字组成，即有1-n个数字组成
        System.out.println(str.matches("\\d+"));
        String tel = "0571-4534289";
//判断这是否是一个杭州的固定电话
        boolean result = tel.matches("0571-\\d{7,8}");
        System.out.println(result);*/
        String str = "hello|world|java";
        String[] strs = str.split("\\|");
        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]);
        }
        System.out.println();
        String str2 = "hello.world.java";
        String[] strs2 = str2.split("\\.");
        for (int i = 0; i < strs2.length; i++) {
            System.out.println(strs2[i]);
        }
    }
@Test
public void test2(){
    String str = "中";
    try {
        System.out.println(str.getBytes("ISO8859-1").length);// -128~127
        System.out.println(str.getBytes("GBK").length);
        System.out.println(str.getBytes("UTF-8").length);
        System.out.println(new String(str.getBytes("ISO8859-1"),
                "ISO8859-1"));// 乱码，表示不了中文
        System.out.println(new String(str.getBytes("GBK"), "GBK"));
        System.out.println(new String(str.getBytes("UTF-8"), "UTF-8"));
    } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
    }

}
    public static void main(String[] args) {
        StringTest ex = new StringTest();
        ex.change(ex.str, ex.ch);
        System.out.print(ex.str + " and ");//good
        System.out.println(ex.ch);//best
    }


}

public class CommonlyUsedStringTest {
}
