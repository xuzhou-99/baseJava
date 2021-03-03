package my.demo.collection;

import java.util.LinkedList;

/**
 * @author xuzhou
 * @version 1.0.0
 * @title MyHashMap
 * @date 2021/3/3 13:57
 */
public class MyHashMap implements IHashMap {

    private LinkedList<Entry>[] array = new LinkedList[2000];

    public static int hashCode(String string) {
        if (string.length() == 0) {
            return 0;
        }
        char[] chars = string.toCharArray();
        int count = 0;
        for (char c : chars) {
            count += c;
        }
        count = count * 23;
        if (count < 0) {
            count = -count;
        }
        return (count > 1999) ? count % 2000 : count;
    }

    @Override
    public void put(String key, Object value) {
        int p = hashCode(key);
        LinkedList<Entry> entries = array[p];
        if (null == entries) {
            array[p] = new LinkedList<>();
        }
        boolean found = false;
        for (Entry entry : array[p]) {
            if (key.equals(entry.key)) {
                entry.value = value;
                found = true;
            }
        }
        if (!found) {
            array[p].add(new Entry(key, value));
        }
    }

    @Override
    public Object get(String key) {
        int hashcode = hashCode(key);
        if (array[hashcode] == null) {
            return null;
        }
        for (Entry entry : array[hashcode]) {
            if (key.equals(entry.key)) {
                return entry.value;
            }
        }
        return null;
    }
}
