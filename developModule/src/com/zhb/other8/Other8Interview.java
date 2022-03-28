package com.zhb.other8;

import org.junit.jupiter.api.Test;

/*import javax.swing.text.Utilities;*/

/**
 * @author zhb
 * @create 2022-02-12 14:16
 */
public class Other8Interview {
    @Test
    public void test() {
        int[] numbers = null;
        /*Arrays.parallelSort(numbers);
        Arrays.stream(numbers).parallel().collect(
                Map<Boolean,List<Integer>> groupbyPrimary =
                Collectors.groupingBy(s->Utitlty.isPrime(s)));
        1. 使用多核对数组进行排序： 1 Arrays.parallelSort(numbers);
        2. 根据特定的条件（比如：素数和非素数）对数组进行分组： 12
        Map<Boolean, List<Integer>> groupByPrimary = numbers
                .parallelStream().collect(Collectors.groupingBy(s -> Utility.isPrime(s)));
        3. 对数组进行过滤： 12
        Integer[] prims = numbers.parallelStream().filter(s -> Utility.isPrime(s))
                .toArray();
    }*/
      /*  跟自己写多线程程序来实现相同的功能比较，生产力提高太多了！在这个新的体
        系中，我个人最喜欢的是一个叫 Spliterator 的新概念，将一个集合分成多个块，
        并行处理这多个块并将处理结果汇合到一起。就像它的哥哥 iterator，它也被用
        来遍历一个集合的元素，只不过它更加灵活，允许你编写检查和分离集合的自定
        义行为，并在遍历时直接插入。*/
    }
   /* 虽然这些都是非常强大和易于使用的 API，但它们不是银弹。我们仍然需要花费
    精力去判断何时应该使用它们。如果你事先知道你会做多个处理并行操作，那么
    考虑使用排队架构，并使并发操作数和你的处理器数量相匹配可能是一个好主
    意。这里的难点在于运行时性能将依赖于实际的硬件体系结构和服务器所处的压
    力情况。你可能只有在压力测试或者生产环境中才能看到代码的运行时性能，使
    之成为一个“易编码，难调试”的经典案例*/
}
