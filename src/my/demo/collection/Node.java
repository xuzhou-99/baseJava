package my.demo.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuzhou
 * @version 1.0.0
 * @title Node
 * @date 2021/3/2 10:07
 */
public class Node {
    /**
     * 左节点
     */
    public Node leftNode;
    /**
     * 右节点
     */
    public Node rightNode;
    /**
     * 值
     */
    public Object value;

    /**
     * 添加节点
     * 比节点小在左侧，比节点大或等于在右侧
     * @param v 值
     */
    public void add(Object v){
        // 当前节点为null
        if(null == value){
            // 将值赋予当前节点
            value = v;
        }else {
            if((int)v < (int)value){
                // 要添加节点的值 < 当前节点
                if(null == leftNode){
                    // 当前节点无左子节点
                    leftNode = new Node();
                }
                // 当前节点有左子节点
                leftNode.add(v);
            }else {
                // 值 >= 当前节点值
                if(null == rightNode){
                    // 当前节点无右子节点
                    rightNode = new Node();
                }
                // 当前节点有右子节点
                rightNode.add(v);
            }
        }
    }

    /**
     * 中序遍历 In-order traversal
     * 左-中-右
     * @return List<Object> 遍历集合
     */
    public List<Object> traverseLBR(){
        ArrayList<Object> values = new ArrayList<>();
        // 1、将左子节点的值添加入list
        if(null != leftNode){
            // 当前节点存在左子节点
            // 递归循环左子节点
            values.addAll(leftNode.traverseLBR());
        }
        // 2、将当前节点的值添加入list
        values.add(value);
        // 3、将右子节点的值添加入list
        if(null != rightNode){
            // 当前节点存在右子节点
            // 递归循环右子节点
            values.addAll(rightNode.traverseLBR());
        }
        return values;
    }
    /**
     * 先序遍历 Preorder traversal
     * 中-左-右
     * @return List<Object> 遍历集合
     */
    public List<Object> traverseBLR(){
        ArrayList<Object> values = new ArrayList<>();
        // 1、将当前节点的值添加入list
        values.add(value);
        // 2、将左子节点的值添加入list
        if(null != leftNode){
            // 当前节点存在左子节点
            // 递归循环左子节点
            values.addAll(leftNode.traverseBLR());
        }
        // 3、将右子节点的值添加入list
        if(null != rightNode){
            // 当前节点存在右子节点
            // 递归循环右子节点
            values.addAll(rightNode.traverseBLR());
        }
        return values;
    }
    /**
     * 后序遍历 Subsequent traversal
     * 左-右-中
     * @return List<Object> 遍历集合
     */
    public List<Object> traverseLRB(){
        ArrayList<Object> values = new ArrayList<>();
        // 1、将左子节点的值添加入list
        if(null != leftNode){
            // 当前节点存在左子节点
            // 递归循环左子节点
            values.addAll(leftNode.traverseLRB());
        }
        // 2、将右子节点的值添加入list
        if(null != rightNode){
            // 当前节点存在右子节点
            // 递归循环右子节点
            values.addAll(rightNode.traverseLRB());
        }
        // 3、将当前节点的值添加入list
        values.add(value);
        return values;
    }

}
