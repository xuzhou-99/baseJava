package my.demo.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * TestGenerics
 * 泛型-参数化类型，将具体的类型参数化，不限制传参类型，调用的时候传入具体的类型
 * 在类、接口和方法中使用，称为泛型类、泛型接口、泛型方法
 * 泛型只在编译阶段有效
 *
 * @author xuzhou
 * @version v1.0.0
 * @create 2021/5/11 18:30
 */
public class TestGenerics {


    public static void main(String[] args) {


        test();

        testMethod();

        testMaximum();

        testClass();


    }

    /**
     * 泛型
     * 编译之后会采用去泛型化的措施
     * 编译过程中，正确检测泛型结果后，将泛型的相关信息输出，
     * 在对象进入和离开方法的边界处添加类型检查和类型转换的方法
     */
    public static void test() {
        List<String> stringList = new ArrayList<>();
        List<Integer> integerList = new ArrayList<>();


        Class aClass = stringList.getClass();
        Class aClass1 = integerList.getClass();

        if (aClass.equals(aClass1)) {
            // result is true
            System.out.println("泛型测试：类型相同");
        } else {
            System.out.println("泛型测试：类型不相同");
        }
    }


    /**
     * 泛型方法
     * 调用时接收不同类型的参数
     * 根据传参的不同，编译器适当地处理每一个方法的调用
     * rules：
     * 1. 泛型方法声明都有一个类型参数声明（<>），在方法返回类型之前（such as < E >）
     * 2. 类型参数声明部门包含一个或多个类型参数，参数用逗号隔开
     * 3. 类型参数能被用来声明返回值类型并且能做为泛型方法得到的实际参数类型的占位符
     * 4， 泛型方法体的声明和其他方法一样，参数类型只能代表引用型类型，不能是原始类型
     *
     * @param inputArray 泛型参数数组
     * @param <E>        类型参数声明
     */
    public static <E> void printArray(E[] inputArray) {
        for (E e :
                inputArray) {
            System.out.printf("%s ", e);
        }
        System.out.println();
    }

    public static void testMethod() {
        Integer[] integers = {1, 2, 3, 4, 5, 6};
        Double[] doubles = {1.1, 2.2, 3.3, 4.4, 5.5};
        Character[] characters = {'a', 's', 'd', 'f'};

        System.out.println("Array integers contains: ");
        printArray(integers);

        System.out.println("Array doubles contains: ");
        printArray(doubles);

        System.out.println("Array characters contains: ");
        printArray(characters);
    }


    /**
     * 有界的类型参数
     * 方法中只接受指定的类型范围
     * method：参数类型名称 extends 上界
     * such as ：
     * 只接受实现了 {@link Comparable<T>}接口的类型
     * String 调用的是 {@link String#compareTo(String)} 方法
     * Integer 调用的是 {@link Integer#compareTo(Integer)} 方法
     */
    public static <T extends Comparable<T>> T maximum(T x, T y, T z) {
        T max = x;

        if (y.compareTo(max) > 0) {
            max = y;
        }
        if (z.compareTo(max) > 0) {
            max = z;
        }

        return max;
    }

    public static <T extends Comparable<T>> T minimum(T x, T y, T z) {
        T min = x;

        if (y.compareTo(min) < 0) {
            min = y;
        }
        if (z.compareTo(min) < 0) {
            min = z;
        }

        return min;
    }

    public static void testMaximum() {
        System.out.printf("Max of %d, %d, %d is %d \n\n", 3, 4, 5, maximum(3, 4, 5));

        System.out.printf("Max of %.1f, %.1f, %.1f is %.1f \n\n", 3.3, 4.4, 5.5, maximum(3.3, 4.4, 5.5));

        System.out.printf("Max of %s, %s, %s is %s \n\n", "char", "pet", "apple", maximum("char", "pet", "apple"));

        System.out.printf("Min of %s, %s, %s is %s \n\n", "char", "pet", "apple", minimum("char", "pet", "apple"));
    }

    /**
     * 泛型类
     * 类名后面添加类型参数声明部分
     * 类型参数声明部门包含一个或多个类型参数，参数用逗号隔开
     *
     * @param <T>
     */
    public static class Box<T> {
        private T t;

        public void setT(T t) {
            this.t = t;
        }

        public T getT() {
            return t;
        }
    }

    public static void testClass() {
        Box<Integer> integerBox = new Box<>();
        Box<String> stringBox = new Box<>();

        integerBox.setT(100);
        stringBox.setT("test");

        System.out.printf("Integer vale :%d\n\n", integerBox.getT());
        System.out.printf("String vale :%s\n\n", stringBox.getT());

    }
}
