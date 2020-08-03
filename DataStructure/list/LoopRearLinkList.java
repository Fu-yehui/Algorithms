package list;

public class LoopRearLinkList {
    private Object data;
    private LoopRearLinkList node;
    private int length=0;
    private LoopRearLinkList rear;   //尾指针

    /**
     * 生成空链表时调用的构造器
     */
    public LoopRearLinkList(){
        node=this;
        rear=this;
        rear.node=this;
    }

    /**
     * 生成新节点时调用的构造器
     * @param data
     */
    public LoopRearLinkList(Object data){
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

        LoopRearLinkList point=rear;  //指向尾节点
        /**
         * 找到第i-1位元素
         */
        for(int j=0;j<i;j++){
            point=point.node;
        }
        LoopRearLinkList newNode=new LoopRearLinkList(data);
        newNode.node=point.node;
        point.node=newNode;
        while(point.node!=this){   //找到尾节点
            point=point.node;
        }
        rear=point;      //将尾指针重新指向尾节点
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
        LoopRearLinkList point=rear;
        for(int j=0;j<i+1;j++){
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
        LoopRearLinkList point=this;
        for(int j=0;j<i-1;j++){
            point=point.node;
        }
        LoopRearLinkList oldNode=point.node;
        point.node=oldNode.node;
        Object o=oldNode.data;
        oldNode=null;
        length--;

        while(point.node!=this){   //找到尾节点
            point=point.node;
        }
        rear=point;      //将尾指针重新指向尾节点


        return o;

    }
    /**
     * 在链表最后插入新节点
     * @param data
     * @throws IndexOutOfBoundsException
     */
    public void add(Object data) throws IndexOutOfBoundsException{
        LoopRearLinkList point=this;
        while(point.node !=this){
            point=point.node;
        }
        LoopRearLinkList newNode=new LoopRearLinkList(data);
        point.node=newNode;
        newNode.node=this;
        length++;

        while(point.node!=this){   //找到尾节点
            point=point.node;
        }
        rear=point;      //将尾指针重新指向尾节点

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

        LoopRearLinkList point=this;
        while(point.node!=this){
            point=point.node;
        }
        return point.data;
    }

    /**
     * 将两个循环链表合并成一个
     * @param list
     */
    public void meger(LoopRearLinkList list){
        LoopRearLinkList p=list.rear.node;   //指向链表list中的头节点
        list.rear.node=this.rear.node.node;    //将链表list的最后一位节点的指针域指向this链表的第一个节点
        this.rear.node.node=p.node;
        p=null;




    }

    public void foreach(){
        LoopRearLinkList point=this.node;
        while(point!=this){
            System.out.println(point.data);
        }
    }
    public static void main(String[] args) {
        LoopRearLinkList list=new LoopRearLinkList();
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
        System.out.println("*********************");
        LoopRearLinkList list2=new LoopRearLinkList();
        list2.insert(1,9999);
        list2.insert(2,8888);
        list2.insert(3,7777);
        for(int i=1;i<4;i++){
            System.out.println(list2.get(i));
        }
        System.out.println("*********************");

        list.meger(list2);
        for(int i=1;i<7;i++){
            System.out.println(list2.get(i));
        }
    }

}
