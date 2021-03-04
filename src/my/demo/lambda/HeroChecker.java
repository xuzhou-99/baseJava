package my.demo.lambda;

import my.demo.collection.Hero;

/**
 * @author xuzhou
 * @version 1.0.0
 * @title HeroChecker
 * @date 2021/3/4 15:15
 */
public interface HeroChecker {
    public boolean test(Hero hero);
}
