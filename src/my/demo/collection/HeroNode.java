package my.demo.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuzhou
 * @version 1.0.0
 * @title HeroNode
 * @date 2021/3/2 11:22
 */
public class HeroNode {
    public HeroNode leftHeroNode;
    public HeroNode rightHeroNode;
    public Hero value;


    public void add(Hero hero){
        if(null == value){
            value = hero;
        }else {
            if(hero.hp < value.hp){
                if(null == leftHeroNode){
                    leftHeroNode = new HeroNode();
                }
                leftHeroNode.add(hero);
            }else {
                if(null == rightHeroNode){
                    rightHeroNode = new HeroNode();
                }
                rightHeroNode.add(hero);
            }
        }
    }

    public List<Hero> values(){
        ArrayList<Hero> list = new ArrayList<>();
        if(null != leftHeroNode){
            list.addAll(leftHeroNode.values());
        }
        list.add(value);
        if (null != rightHeroNode){
            list.addAll(rightHeroNode.values());
        }

        return list;
    }

}
