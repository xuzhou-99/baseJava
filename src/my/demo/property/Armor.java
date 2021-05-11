package my.demo.property;

/**
 * @author xuzhou
 * @version 1.0.0
 * @title Armor
 * @description
 * @date 2020/10/21 10:54
 */
public class Armor extends Item {
    int ac;

    @Override
    public String toString(){
        return name+" "+price+"  "+ac;
    }


    public static void main(String[] args) {
        Armor clothArmor = new Armor();
        clothArmor.name="布甲";
        clothArmor.price= 300;
        clothArmor.ac=15;

        Armor chainMail = new Armor();
        chainMail.name = "锁子甲";
        chainMail.price = 500;
        chainMail.ac = 40;

        System.out.println("名称"+"  "+"价格"+"  "+"护甲等级");
        System.out.println(clothArmor.name+" "+clothArmor.price+"  "+clothArmor.ac);
        System.out.println(chainMail.name+" "+chainMail.price+"  "+chainMail.ac);

        System.out.println(clothArmor.toString());
    }
}
