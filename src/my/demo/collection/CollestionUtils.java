package my.demo.collection;

import java.util.List;

/**
 * @author xuzhou
 * @version 1.0.0
 * @title CollestionUtils
 * @date 2021/3/1 17:25
 */
public class CollestionUtils {
    public static int contents(List list, Hero hero){
        for(int i=0; i<list.size();i++){
            if((((Hero)list.get(i)).name).equals(hero.name)){
                return i;
            }
        }
        return -1;
    }
}
