package my.demo.collection;

/**
 * @author xuzhou
 * @version 1.0.0
 * @title TestCollection
 * @date 2021/3/1 17:25
 */
public class TestCollection {
    public static void main(String[] args) {
       MyStack myStack = new MyStack();

       for(int i=0;i<5;i++){
           myStack.push(new Hero("name" + i));
       }


        Hero hero = myStack.pull();
        System.out.println(hero.toString());

        Hero hero1 = myStack.peek();
        System.out.println(hero1.toString());


    }
}

