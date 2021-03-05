package my.demo.collection;

import my.demo.entity.Hero;

/**
 * @author xuzhou
 * @version 1.0.0
 * @title Stack
 * @date 2021/3/1 18:11
 */
public interface Stack {
    /**
     * 把英雄推入到最后位置
     */
    public void push(Hero hero);

    /**
     * 把最后一个英雄取出来
     */
    public Hero pull();

    /**
     * 查看最后一个英雄
     */
    public Hero peek();
}
