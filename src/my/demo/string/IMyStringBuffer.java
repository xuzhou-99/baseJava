package my.demo.string;

/**
 * @author xuzhou
 * @version 1.0.0
 * @title MyStringBuffer
 * @description
 * @date 2020/10/22 17:52
 */
public interface IMyStringBuffer {
    /**
     * 追加字符串
     * @param str 字符串
     */
    public void append(String str);
    /**
     * 追加字符
     * @param c 字符
     */
    public void appedn(char c);

    /**
     * 指定位置插入字符
     * @param pos 指定位置
     * @param b 字符
     */
    public void insert(int pos,char b);

    /**
     * 指定位置插入字符串
     * @param pos 指定位置
     * @param str 字符串
     */
    public void insert(int pos,String str);

    /**
     * 删除开始位置-结束
     * @param start 开始位置
     */
    public void delete(int start);

    /**
     * 删除从开始位置-结束位置-1
     * @param start 开始位置
     * @param end 结束位置
     */
    public void delete(int start,int end);

    /**
     * 反转
     */
    public void reverse();

    /**
     * 内容长度
     * @return int
     */
    public int length();
}
