package my.demo.collection;

/**
 * @author xuzhou
 * @version 1.0.0
 * @title Entry
 * @date 2021/3/3 14:08
 */
public class Entry {

    public Object key;
    public Object value;

    public Entry(Object key, Object value) {
        super();
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
