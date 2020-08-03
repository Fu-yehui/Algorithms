package list;

/**
 * 静态链表：用数组实现的链表，也称为：游标实现法
 */
public class StaticLinkList {
    /**
     * ，在声明了自定义类的数组之后，对每一个数组元素的初始化，
     * 都要为其new一个对象出来使得指针指向该对象，
     * Java语言本身是不提供在自定义类数组声明时候自动创建新对象的方式的
     */
    private Node[] space;

    public StaticLinkList(int size) {
        space = new Node[size];
        for (int i = 0; i < size; i++) {
            space[i] = new Node();
        }
        for (int i = 0; i < size - 1; i++) {
            space[i].cursor = i + 1;
        }
        space[size - 1].cursor = 0;


    }


    /**
     * 获取备用链表的第一个下标，并返回
     *
     * @return
     * @throws IndexOutOfBoundsException
     */
    public int reserveIndex() throws IndexOutOfBoundsException {
        int i = space[0].cursor;
        if (i != 0) {
            space[0].cursor = space[i].cursor;  //将i的后一位下标至为备用链表第一位
            //若数组填满，i此时为备用链表的最后一位节点，
        }
        return i;

    }

    /**
     * 将下标为k的节点回收到备用链表
     */
    public void freeIndex(int k) {
        space[k].cursor = space[0].cursor;
        space[0].cursor = k;


    }

    /**
     * 删除链表中第i个数据元素
     *
     * @param i
     * @throws IndexOutOfBoundsException
     */
    public Object listDelete(int i) throws IndexOutOfBoundsException {
        if (i < 1 || i > listLength()) {
            throw new IndexOutOfBoundsException();
        }
        int k = space.length - 1;
        for (int j = 1; j <= i - 1; j++) {
            k = space[k].cursor;     //找到第i-1个元素下标
        }
        int n = space[k].cursor;      //要删除元素的下标
        space[k].cursor = space[n].cursor;
        freeIndex(n);
        return space[n].data;

    }

    /**
     * 在第i个元素之前插入新的数据元素data
     *
     * @param i
     * @param data
     * @throws IndexOutOfBoundsException
     */
    public void insert(int i, Object data) throws IndexOutOfBoundsException {
        int k = space.length - 1;  //最后一位元素的下标
        int j = reserveIndex();   //获取备用链表第一位下标
        if (i < 1 || i > listLength() + 1 || j == 0) {
            throw new IndexOutOfBoundsException();
        }


        space[j].data = data;
        k = space.length - 1;      //最后一位元素的下标
        for (int l = 1; l <= i - 1; l++) {  //找到第i-1位元素的下标
            k = space[k].cursor;     //循环n次 就找到第n个元素
        }
        space[j].cursor = space[k].cursor;   //将新插入元素的游标指向第i位的元素
        space[k].cursor = j;           //将i-1位元素的游标指向新插入的元素下标

    }

    /**
     * 返回第i个元素的值
     *
     * @param i
     * @return
     */
    public Object get(int i) throws IndexOutOfBoundsException {
        if (i < 1 || i > listLength()) {
            throw new IndexOutOfBoundsException();
        }
        int k = space.length - 1;
        for (int j = 0; j < i; j++) {
            k = space[k].cursor;
        }
        return space[k].data;

    }


    /**
     * 返回链表中数据元素的个数
     * 链表中最后一位有值数据的cursor为0
     *
     * @return
     */
    public int listLength() {
        int j = 0;
        int i = space[space.length - 1].cursor;
        while (i != 0) {
            i = space[i].cursor;
            j++;
        }
        return j;
    }


    public static void main(String[] args) {
        StaticLinkList list = new StaticLinkList(5);
        list.insert(1, 1111);
        System.out.println(list.listLength());
        System.out.println(list.space.length);
        list.insert(1, 2222);
        list.insert(2, 3333);
        System.out.println(list.listLength());
        for (int i = 1; i < 4; i++) {
            System.out.println(list.get(i));
        }
        list.listDelete(2);
        for (int i = 1; i < 3; i++) {
            System.out.println(list.get(i));
        }

    }

}


/**
 * 拥有一个数据域
 * 一个指针域（游标-----指向下一位元素）
 */
class Node{
    public Object data;
    public int cursor;

    public Node(){

    }
}