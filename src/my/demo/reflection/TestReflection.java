package my.demo.reflection;

import my.demo.entity.Hero;

/**
 * @author xuzhou
 * @version 1.0.0
 * @title TestReflection
 * @date 2021/3/9 11:50
 */
public class TestReflection {
    public static void main(String[] args) {
        String className = "my.demo.entity.Hero";
        try {
            Class<?> aClass = Class.forName(className);
            Class<Hero> aClass1 = Hero.class;
            Class<? extends Hero> aClass2 = new Hero().getClass();

            System.out.println(aClass == aClass1);
            System.out.println(aClass == aClass2);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
