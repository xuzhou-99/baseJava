package my.demo.optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import my.demo.entity.CodeType;

/**
 * @author xuzhou
 * @version 1.0.0
 * @title TestOptional
 * @date 2021/4/8 17:07
 */
public class TestOptional {
    public static void main(String[] args) {

//        orElsethrown(null);

//        optional_filter();

//        optional_map();

//        optional_equals();

//        optional_hashCode();

        optional_toString();

    }

    public static void optional_toString(){

        System.out.println(Optional.empty().toString());

        Optional<String> test = Optional.ofNullable("test");
        System.out.println(test.toString());

        CodeType codeType = new CodeType();
        codeType.setCode("1");
        codeType.setCodeType("001");
        System.out.println(Optional.ofNullable(codeType).toString());

        List<CodeType> list = new ArrayList<>();
        list.add(codeType);
        System.out.println(Optional.ofNullable(list).toString());
    }

    public static void optional_hashCode(){

        System.out.println(Optional.empty().hashCode());

        Optional<String> test = Optional.ofNullable("test");
        System.out.println(test.hashCode());

        Optional<String> test1 = test;
        System.out.println(test1.hashCode());

        Optional<String> test2 = Optional.ofNullable("test");
        System.out.println(test2.hashCode());

        Optional<String> test3 = Optional.ofNullable("tt");
        System.out.println(test3.hashCode());
    }

    public static void optional_equals(){
        Optional<String> test = Optional.ofNullable("test");
        Optional<String> test1 = test;
        Optional<String> test2 = Optional.ofNullable("test");
        Optional<String> test3 = Optional.ofNullable("tt");


        // false
        System.out.println(test.equals("test"));
        // true
        System.out.println(test.equals(test1));
        // true
        System.out.println(test.equals(test2));
        // false
        System.out.println(test.equals(test3));
    }

    public static void optional_flatMap(){
        String name;
        CodeType codeType = new CodeType();
        codeType.setCodeType("001");
        codeType.setCode("1");
        codeType.setName("test");

        // Optional：map可以嵌套
        name = Optional.ofNullable(codeType)
                // 取出name
                .map(o -> o.getName())
                // 对name进行操作
                .map(x -> x.toUpperCase())
                .orElse("no name");

        // Optional
        Optional<String> optional = Optional.ofNullable(codeType)
                .flatMap(o -> Optional.of(o.getCode()));

        System.out.println(name);
    }

    public static void optional_map(){
        String name;
        CodeType codeType = new CodeType();
        codeType.setCodeType("001");
        codeType.setCode("1");
        codeType.setName("test");

        // Optional
        name = Optional.ofNullable(codeType)
                .map(o -> o.getName())
                .map(x -> x.toUpperCase())
                .orElse("no name");
        System.out.println(name);
    }

    public static void optional_filter(){
        CodeType codeType = new CodeType();
        codeType.setCodeType("001");
        codeType.setCode("1");
        codeType.setName("小白");
        Optional.ofNullable(codeType)
                .filter(x -> "001".equals(x.getCodeType()))
                .ifPresent(x -> {
                    x.setCode("001");
                    System.out.println(x);
                } );
    }

    public static String orElsethrown(String Id){
        try {
//            String Id = getId();
            return Optional.ofNullable(Id).orElseThrow(() -> (Exception) new IllegalStateException("xx的Id不能为空"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    private static void orElseGet(){
        // 对返回结果赋予默认值
        String str = "112";
        String result = Optional.ofNullable(str).orElseGet(() -> {
            // do something here
            return "0";
        });
        System.out.println(result);
    }

    public static void optional(){
        Optional<String> empty = Optional.empty();

        // Optional contain String which is not null
        String str = "test";
        Optional<String> optional = Optional.of(str);
        System.out.println("Optional value: " + str);
        System.out.println("optional.isPresent() = " + optional.isPresent());
        System.out.println(optional.get());

        // Optional contain String which is null
        String str1 = null;
        Optional<String> optional1 = Optional.ofNullable(str1);
        System.out.println("optional1 value: " + str1);
        System.out.println("optional1.isPresent() = " + optional1.isPresent());

        // Optional contain object which is not null
        CodeType c1 = new CodeType();
        c1.setCodeType("001");
        c1.setCode("1");
        c1.setName("字符串");
        Optional<CodeType> optional2 = Optional.ofNullable(c1);
        System.out.println("optional2 value: " + c1);
        System.out.println("optional2.isPresent() = " + optional2.isPresent());
        System.out.println(optional2.get());

        // Optional contain object which is new Object
        CodeType c2 = new CodeType();
        Optional<CodeType> optional3 = Optional.ofNullable(c2);
        System.out.println("optional3 value: " + c2);
        System.out.println("optional3.isPresent() = " + optional3.isPresent());
        System.out.println(optional3.get());

        // Optional contain object which is null
        CodeType c3 = null;
        Optional<CodeType> optional4 = Optional.ofNullable(c3);
        System.out.println("optional4 value: " + c3);
        System.out.println("optional4.isPresent() = " + optional4.isPresent());

        // Optional contain list which size is 0
        List<CodeType> list = new ArrayList<>();
        Optional<List<CodeType>> optional5 = Optional.ofNullable(list);
        System.out.println("optional5 value: " + list);
        System.out.println("optional5.isPresent() = " + optional5.isPresent());
        System.out.println(optional5.get());
    }
}
