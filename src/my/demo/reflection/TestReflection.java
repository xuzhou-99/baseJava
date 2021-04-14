package my.demo.reflection;

import my.demo.entity.Hero;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author xuzhou
 * @version 1.0.0
 * @title TestReflection
 * @date 2021/3/9 11:50
 */
public class TestReflection {
    public static void main(String[] args) {

//        testCreate();

//        testFiled();

        testMothed();
    }

    public static void testMothed(){
        Hero hero = new Hero();
        try {
            Method m = hero.getClass().getMethod("setName", String.class);
            m.invoke(hero, "盖伦");
            System.out.println(hero.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void testFiled(){
        Hero hero = new Hero();
        hero.name = "gareen";
        System.out.println(hero.name);
        Hero hero1 = new Hero();
        hero1.name = "teemo";
        System.out.println(hero1.name);


        try {
            Field name = hero.getClass().getDeclaredField("name");
            name.set(hero, "xx");
            System.out.println(hero.name);
            name.set(hero1, "oo");
            System.out.println(hero1.name);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
    public static void testCreate(){

        Hero hero1 = new Hero();
        hero1.name= "teemo";
        System.out.println(hero1);

        try {
            //使用反射的方式创建对象
            String className = "my.demo.entity.Hero";
            //类对象
            Class pClass=Class.forName(className);
            //构造器
            Constructor c= pClass.getConstructor();
            //通过构造器实例化
            Hero h2= (Hero) c.newInstance();
            h2.name="gareen";
            System.out.println(h2);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    public static void test(){
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
