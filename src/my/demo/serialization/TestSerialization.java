package my.demo.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.sun.corba.se.impl.io.ObjectStreamClass;

import my.demo.entity.CodeType;
import my.demo.entity.Hero;
import my.demo.entity.Hero2;

/**
 * TestSerialization
 * Java对象序列化
 * 一个对象表示为一个字节序列：对象的数据、对象类型信息、存储在对象中数据的类型
 * JVM独立，可以跨平台进行反序列化
 * 序列化和反序列化对象方法：{@link java.io.ObjectInputStream} 和 {@link java.io.ObjectOutputStream}
 * required:
 * 1. 实现{@link java.io.Serializable}接口
 * 2. 属性可序列化
 *
 * @author xuzhou
 * @version v1.0.0
 * @create 2021/5/12 10:47
 */
public class TestSerialization {


    public static void main(String[] args) {

        testWrite();

        getDefauleUID();

    }

    /**
     * 获取实现了{@link java.io.Serializable}接口的类的默认serialVersionUID
     * serialver:
     * 没有显示指定 serialVersionUID ，则会自动调用JDK自带的 serialver 命令来生成一个
     * 1. (javac Hero.java) 先编译，生成class文件
     * 2. (serialver Hero) 获取 serialVersionUID
     * 获取：
     * 使用{@link ObjectStreamClass#getActualSerialVersionUID(Class)} ()} 方法获取类的 serialVersionUID
     * 根据属性生成：
     * 1. 类名不同，属性相同，则相同
     * 2. 类名不同。属性不同，则不同
     * 同一个类：
     * 1. 增加字段或方法而没有改变旧版本中已有的东西，保证 serialVersionUID 相同即可进行反序列化
     * 2. 否则，Field 的变化需要在 readObject 和 writeObject 方法中进行处理
     */
    public static void getDefauleUID() {
        System.out.println("1L = " + 1L);
        System.out.println("Hero serialVersionUID = " + ObjectStreamClass.getActualSerialVersionUID(Hero.class));
        System.out.println("Hero2 serialVersionUID = " + ObjectStreamClass.getActualSerialVersionUID(Hero2.class));
        System.out.println("CodeType serialVersionUID = " + ObjectStreamClass.getActualSerialVersionUID(CodeType.class));
    }


    public static void testWrite() {

        String path = "D:\\MyProject\\fileToTest\\serialized.out";

        Hero heroSource = new Hero();
        heroSource.setName("Ali");
        heroSource.setHp(100.50f);
        heroSource.setDamage(100);

        write(heroSource, path);

        System.out.println("泛型方法：反序列化为同属性同类的Hero:");
        Hero hero = new Hero();
        read(hero, path);


        System.out.println("泛型方法：反序列化为不同属性不同类的CodeType:");
        CodeType codeType = new CodeType();
       read(codeType, path);


        System.out.println("泛型方法：反序列化为相同属性不同类的Hero2：");
        Hero2 hero2 = new Hero2();
        read(hero2,path);


        System.out.println("指定类型：反序列化为相同属性不同类的Hero2：");
        readHero2(path);


        System.out.println("指定类型：反序列化为不同属性不同类的CodeType:");
        readCo(path);


    }

    public static <T> void write(T t, String path) {
        File file = new File(path);
        try (FileOutputStream os = new FileOutputStream(file);
             ObjectOutputStream out = new ObjectOutputStream(os)) {

            out.writeObject(t);

            os.flush();

            System.out.println("Serialized data is saved in :" + path);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static <T> void read(T t, String path) {
        File file = new File(path);
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            t = (T) ois.readObject();

            System.out.println("Deserialized  data:" + t.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Hero class not found");
            e.printStackTrace();
        }
    }


    public static void readCo(String path) {
        File file = new File(path);
        CodeType codeType;
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            codeType = (CodeType) ois.readObject();


            System.out.println("Deserialized  data:");
            System.out.println("codeType:" + codeType.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Hero class not found");
            e.printStackTrace();
        }
    }

    public static void readHero2(String path) {
        File file = new File(path);
        Hero2 h;
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            h = (Hero2) ois.readObject();


            System.out.println("Deserialized  data:");
            System.out.println("Hero2:" + h.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Hero class not found");
            e.printStackTrace();
        }
    }
}
