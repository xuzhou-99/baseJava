package my.demo.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import com.sun.xml.internal.ws.util.StringUtils;

import my.demo.entity.CodeType;
import my.demo.entity.Hero;

/**
 * @author xuzhou
 * @version 1.0.0
 * @title TestLambda
 * @date 2021/3/4 14:36
 */
public class TestLambda {
    public static void main(String[] args) {

        lambda();

    }

    public static void filterHero(List<Hero> list) {
        for (Hero hero : list) {
            if (hero.hp > 100 && hero.damage < 50) {
                System.out.println(hero);
            }
        }
    }

    public static void filterHero2(List<Hero> heroList, HeroChecker heroChecker) {

        for (Hero hero : heroList) {
            if (heroChecker.test(hero)) {
                System.out.println(hero);
            }
        }

    }
    public static void normal(){
        Random r = new Random();
        ArrayList<Hero> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Hero hero = new Hero();
            hero.name = "hero-" + i;
            hero.hp = r.nextInt(1000);
            hero.damage = r.nextInt(100);

            list.add(hero);
        }
        Hero hero1;
        hero1 = list.get(0);
        list.add(hero1);

        System.out.println("初始化集合数据：");
        list.stream()
                .forEach(System.out::print);

        System.out.println("满足hp>100 && damage<50的英雄");
        list.stream()
                .filter(h -> h.hp > 100 && h.damage < 50)
                .forEach(System.out::print);

        System.out.println("去除重复的数据：");
        list.stream()
                .distinct()
                .forEach(System.out::print);

        System.out.println("按照血量排序：");
        list.stream()
                .sorted((h1, h2) -> h1.hp > h2.hp ? 1 : -1)
                .forEach(System.out::print);

        System.out.println("保留前3个：");
        list.stream()
                .limit(3)
                .forEach(System.out::print);

        System.out.println("忽略前3个：");
        list.stream()
                .skip(3)
                .forEach(System.out::print);

        System.out.println("返回一个数组：");
        Object[] array = list.stream()
                .toArray();
        System.out.println(Arrays.toString(array));

        System.out.println("返回伤害最小的：");
        Optional<Hero> hero = list.stream()
                .min((h1, h2) -> h1.damage > h2.damage ? 1 : -1);

        hero.ifPresent(System.out::println);

        System.out.println("返回伤害最大的：");
        Optional<Hero> hero2 = list.stream()
                .max((h1, h2) -> h1.damage > h2.damage ? 1 : -1);
        hero2.ifPresent(System.out::println);


        System.out.println("返回数据总数：");
        long count = list.stream()
                .count();
        System.out.println(count);

        System.out.println("返回第一个元素：");
        Optional<Hero> hero3 = list.stream()
                .findFirst();

        hero3.ifPresent(System.out::println);

        System.out.println("排名第三高的：");
        Optional<Hero> hero4 = list.stream()
                .sorted((h1, h2) -> (h1.hp < h2.hp ? 1 : -1))
                .skip(2)
                .findFirst();
        hero4.ifPresent(System.out::println);
    }

    public static void lambda(){
        List<CodeType> list = new ArrayList<>();

        CodeType c1 = new CodeType();
        c1.setCodeType("001");
        c1.setCode("1");
        c1.setName("字符串");
        list.add(c1);

        CodeType c2 = new CodeType();
        c2.setCodeType("002");
        c2.setCode("2");
        c2.setName("数组");
        list.add(c2);

        CodeType c3 = new CodeType();
        c3.setCodeType("001");
        c3.setCode("1");
        c3.setName("整形");
        list.add(c3);
        // 根据codeType来分组，相同codeType合成一个List
        Map<String, List<CodeType>> listMap = list.stream()
                .filter(Objects::nonNull)
                // groupingBy以某个字段作为分组
                // mapping传入两个参数：对象、操作
                .collect(Collectors.groupingBy(CodeType::getCodeType, Collectors.mapping(x -> x, Collectors.toList())));

        Map<String, List<CodeType>> listMap2 = list.stream()
                .filter(Objects::nonNull)
                // groupingBy以某个字段作为分组
                .collect(Collectors.groupingBy(CodeType::getCodeType));


    }
}
