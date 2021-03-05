package my.demo.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import my.demo.entity.Hero;

/**
 * @author xuzhou
 * @version 1.0.0
 * @title TestObjectStream
 * @date 2021/2/24 15:36
 */
public class TestObjectStream {

    static final String PATH = "d:/projects/garen.lol";

    public static void main(String[] args) {

        testObject();
        testObjects1();
        testObjects2();
    }

    private static void testObjects2(){
        // one file used to save hero
        File file = new File(PATH);

        try (FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(fos);

             FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)
        ) {
            Hero[] heroes = new Hero[10];
            for (int i = 0; i < heroes.length; i++) {
                Hero hero = new Hero();
                hero.name = "hero" + i;
                hero.hp = i * 100;
                heroes[i] = hero;
                // write to the file one by one
                oos.writeObject(hero);
            }

            // Read one object at a time
            for (int i = 0; i < heroes.length; i++) {
                // readObject()
                // the pointer moves to the next one
                Hero hero = (Hero) ois.readObject();
                System.out.println(hero.name + "  " + hero.hp);
            }
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    private static void testObjects1(){
        // one file used to save hero
        File file = new File(PATH);

        try (
                FileOutputStream fos = new FileOutputStream(file);
                ObjectOutputStream oos = new ObjectOutputStream(fos);

                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis)
        ) {
            Hero[] heroes = new Hero[10];
            for (int i = 0; i < heroes.length; i++) {
                Hero hero = new Hero();
                hero.name = "hero" + i;
                hero.hp = i * 100;
                heroes[i] = hero;
            }
            // Write to the file together
            oos.writeObject(heroes);

            // Read all objects at a time
            // turn into an array
            Hero[] heroes1 = (Hero[]) ois.readObject();
            for (Hero h : heroes1) {
                System.out.println(h.name);
            }
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }



    private static void testObject(){
        // one file used to save hero
        File file = new File(PATH);

        // create object hero
        Hero hero = new Hero();
        hero.name = "gg";
        hero.hp = 666;

        try (
                // create object output stream
                FileOutputStream fos = new FileOutputStream(file);
                ObjectOutputStream oos = new ObjectOutputStream(fos);

                // create object input stream
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis)
        ) {
            // write object into file
            oos.writeObject(hero);
            // read object from file
            Hero hero1 = (Hero) ois.readObject();
            System.out.println(hero1.name);
            System.out.println(hero1.hp);

        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
