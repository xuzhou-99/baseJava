package my.demo.collection;

import my.demo.entity.Hero;

import java.util.*;

import static my.demo.collection.CollectionUtils.randomCreateString;

/**
 * @author xuzhou
 * @version 1.0.0
 * @title TestCollection
 * @date 2021/3/1 17:25
 */
public class TestCollection {
    public static void main(String[] args) {

        Random random = new Random();
        Node<Integer> node = new Node<>();
        for (int i = 0; i < 5; i++) {
            node.add(random.nextInt(100));
        }
        System.out.println(node);


    }

    public static void testLinkedHashSet() {
        LinkedHashSet<Character> objects = new LinkedHashSet<>();
        char[] array = String.valueOf(Math.PI).toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (i == 1) {
                continue;
            }
            objects.add(array[i]);
        }
        System.out.println(array);
        System.out.println(objects);
    }

    public static void testInsertMid(List<Integer> list, String type) {
        int total = 1000 * 100;
        int num = 5;

        long start = System.currentTimeMillis();
        for (int i = 0; i < total; i++) {
            list.add(i / 2, num);
        }
        long end = System.currentTimeMillis();
        System.out.printf("在%s中间插入%d条数据，总计耗时：%d",type, total, end-start);
        System.out.println();
    }

    public static void testInsertAfter(List<Integer> list, String type){
        int total = 1000*100;
        int num = 5;

        long start = System.currentTimeMillis();
        for(int i=0;i<total;i++){
            list.add(num);
        }
        long end = System.currentTimeMillis();
        System.out.printf("在%s最后面插入%d条数据，总计耗时：%d",type, total, end-start);
        System.out.println();
    }

    public static void testInsertBefore(List<Integer> list, String type){
        int total = 1000*100;
        int num = 5;

        long start = System.currentTimeMillis();
        for(int i=0;i<total;i++){
            list.add(0, num);
        }
        long end = System.currentTimeMillis();
        System.out.printf("在%s最前面插入%d条数据，总计耗时：%d",type, total, end-start);
        System.out.println();
    }

    public static void testCollections1(){
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<10;i++){
            list.add(i);
        }

        int count = 0;
        for(int i=0;i<1000000;i++){
            Collections.shuffle(list);
            if(list.get(0)==3 && list.get(1)==1 && list.get(2)==4){
                count++;
            }
        }

        System.out.println("前三位为3 1 4的次数为："+count);
        System.out.println("概率为："+ (count*100.0/1000000)+"%");
    }

    public static void testCollections(){
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<10;i++){
            list.add(i);
        }
        System.out.println("集合中的数据："+ list);
        Collections.reverse(list);
        System.out.println("反转后的数据："+ list);
        Collections.shuffle(list);
        System.out.println("混淆后的数据："+ list);
        Collections.swap(list, 0, 9);
        System.out.println("交换后的数据："+ list);
        Collections.rotate(list, 1);
        System.out.println("滚动后的数据："+ list);
    }


    public static void testHashSet(){

        String[] strings = new String[100];
        for(int i=0;i<100;i++){
            strings[i] = randomCreateString(2);
            System.out.print(strings[i]+"  ");
            if((i+1)%10==0){
                System.out.println();
            }
        }



        HashSet<String> set = new HashSet<>(16);
        HashSet<String> set1 = new HashSet<>(16);
        for(int i =0;i<100;i++){
            if (!set.add(strings[i])){
                set1.add(strings[i]);
            }
        }

        System.out.println("重复字符串数量为："+set1.size());
        System.out.println(set1);


    }

    public static void testSortByHashMap(){
        Hero[] heroes = new Hero[3000000];
        for(int i=0;i < 3000000;i++){
            Hero hero = new Hero();
            hero.name = "hero-" + (int)(Math.random() * 9000 +1000);
            heroes[i] = hero;
        }

        long start = System.currentTimeMillis();
        int count=0;
        for(Hero hero: heroes){
            if(hero.name.equals("hero-5555")){
                count++;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("使用for循环查询时间为："+(end - start));
        System.out.println("共找到数量为："+count);


        start = System.currentTimeMillis();
        count=0;
        HashMap<String, List<Hero>> hashMap = new HashMap<>(16);

        for(Hero hero: heroes){
            List<Hero> list = hashMap.get(hero.name);
            if(null == list){
                list = new ArrayList<>();
            }
            list.add(hero);
            hashMap.put(hero.name, list);
        }

        count = hashMap.get("hero-5555").size();
        end = System.currentTimeMillis();
        System.out.println("使用for循环查询时间为："+(end - start));
        System.out.println("共找到数量为："+count);
    }


    public static void testSort1(){
        int[] a = new int[10000];
        for(int i= 0;i<a.length;i++){
            a[i] = (int) (Math.random()*10000);
        }
        long start = System.currentTimeMillis();
        CollectionUtils.bubbleSort(a);
        long end = System.currentTimeMillis();
        System.out.println("冒泡排序时长："+(end-start));
    }
    public static void testSort2(){
        int[] a = new int[10000];
        for(int i= 0;i<a.length;i++){
            a[i] = (int) (Math.random()*10000);
        }
        long start = System.currentTimeMillis();
        CollectionUtils.selectSort(a);
        long end = System.currentTimeMillis();
        System.out.println("选择排序时长："+(end-start));
    }
    public static void testSort3(){
        int[] a = new int[10000];
        for(int i= 0;i<a.length;i++){
            a[i] = (int) (Math.random()*10000);
        }

        long start = System.currentTimeMillis();
        Node node = new Node();
        for(int num:a){
            node.add(num);
        }
        long end = System.currentTimeMillis();
        System.out.println("二叉树排序时长："+(end-start));
        start = System.currentTimeMillis();
        List<Object> list = node.traverseLBR();
        end = System.currentTimeMillis();
        System.out.println("二叉树读取排序时长："+(end-start));
    }

    public static void testTree(){
        int randoms[] = new int[] { 67, 7, 30, 73, 10, 0, 78, 81, 10, 74 };
        Node root = new Node();
        for(int number : randoms){
            root.add(number);
        }

        System.out.println("先序遍历");
        List<Object> traverse1 = root.traverseBLR();
        System.out.println(traverse1);
        System.out.println("中序遍历");
        List<Object> traverse2 = root.traverseLBR();
        System.out.println(traverse2);
        System.out.println("后序遍历");
        List<Object> traverse3 = root.traverseLRB();
        System.out.println(traverse3);
    }

    public static void testTree2(){
        HeroNode root = new HeroNode();
        for(int i =0;i<10;i++){
            Hero hero = new Hero("hero" + i);
            hero.hp = (float) Math.random()*1000;
            root.add(hero);
        }


        System.out.println("中序遍历");
        List<Hero> traverse = root.values();
        System.out.println(traverse);
        for(Hero hero: traverse){
            System.out.print(hero.hp + "  ");
        }
    }
}

