package list;



/**循环链表
 * 与单链表不同的是： 最后一位元素的指针域不是指向null，而是指向头节点
 * @author roger
 */
public class LoopLinkList {
    private Object data;
    private LoopLinkList node;
    private int length=0;

    /**
     * 生成空链表时调用的构造器
     */
    public LoopLinkList(){
        node=this;
    }

    /**
     * 生成新节点时调用的构造器
     * @param data
     */
    public LoopLinkList(Object data){
        this.data=data;
    }

    /**
     * 在第i位元素之前插入新节点
     * @param i
     * @param data
     * @throws IndexOutOfBoundsException
     */
    public void insert(int i,Object data) throws IndexOutOfBoundsException{

        if(i<1||i>length+1){
            throw new IndexOutOfBoundsException();
        }

        LoopLinkList point=this;  //指向头节点
        /**
         * 找到第i-1位元素
         */
        for(int j=0;j<i-1;j++){
            point=point.node;
        }
        LoopLinkList newNode=new LoopLinkList(data);
        newNode.node=point.node;
        point.node=newNode;
        length++;

    }

    /**
     * 返回第i位的元素
     * @param i
     * @return
     * @throws IndexOutOfBoundsException
     */
    public Object get(int i)throws IndexOutOfBoundsException{
        if(i<1||i>length){
            throw new IndexOutOfBoundsException();
        }
        LoopLinkList point=this;
        for(int j=0;j<i;j++){
            point=point.node;
        }
        return point.data;
    }

    /**
     * 删除第i位元素，并返回该元素的值
     * @param i
     * @return
     * @throws IndexOutOfBoundsException
     */
    public Object delete(int i) throws IndexOutOfBoundsException{
        if(i<1||i>length){
            throw new IndexOutOfBoundsException();
        }
        LoopLinkList point=this;
        for(int j=0;j<i-1;j++){
            point=point.node;
        }
        LoopLinkList oldNode=point.node;
        point.node=oldNode.node;
        Object o=oldNode.data;
        oldNode=null;
        length--;
        return o;

    }
    /**
     * 在链表最后插入新节点
     * @param data
     * @throws IndexOutOfBoundsException
     */
    public void add(Object data) throws IndexOutOfBoundsException{
        LoopLinkList point=this;
        while(point.node !=this){
            point=point.node;
        }
        LoopLinkList newNode=new LoopLinkList(data);
        point.node=newNode;
        newNode.node=this;

        length++;
    }

    /**
     * 查询并返回最后一位元素的值
     * @return
     * @throws IndexOutOfBoundsException
     */
    public Object get()throws IndexOutOfBoundsException{
        if(node==this){
            throw new IndexOutOfBoundsException();
        }

        LoopLinkList point=this;
        while(point.node!=this){
            point=point.node;
        }
        return point.data;
    }
    public static void main(String[] args) {
        LoopLinkList list=new LoopLinkList();
        list.add(111);
        System.out.println(list.get());
        list.add(222);
        System.out.println(list.get());
        list.insert(3,1111);
        list.insert(4,4444);
        System.out.println(list.get());
        System.out.println("*********************");
        for(int i=1;i<5;i++){
            System.out.println(list.get(i));
        }
        System.out.println("删除第3位元素："+list.delete(3));
        for(int i=1;i<4;i++){
            System.out.println(list.get(i));
        }

    }

}
