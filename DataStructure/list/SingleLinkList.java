package list;


import java.util.Random;

/**
 * 链式结构实现的线性表
 * 单链表
 */
public class SingleLinkList {
    private SingleLinkList node;
    private Object data;
    private int length;
    public SingleLinkList(Object data){
        this.data=data;

    }

    public SingleLinkList(){

    }
    public long getLength(){
        return length;
    }


    /**
     *
     * @param i 返回第i的个元素
     * @return
     * @throws Exception
     */
    public Object get(int i) throws IndexOutOfBoundsException{
        int j=1;
        SingleLinkList point=node; //point指向第一个节点
        while(point!=null&&j<i){
            point=point.node;
            j++;
        }
        if(point==null||j>i) {
            throw new IndexOutOfBoundsException();
        }

        return point.data;
    }

    /**
     *
     * @param i 在第i个元素之前插入
     * @param data
     * @throws Exception
     */
    public void insert(int i,Object data) throws Exception{
        int j=1;
        SingleLinkList point=this;  //point指向头节点
        while(point!=null&&j<i){
            point=point.node;
            j++;
        }
        if(point==null||j>i) {
            throw new IndexOutOfBoundsException();
        }
        SingleLinkList q=new SingleLinkList(data);
        q.node=point.node;
        point.node=q;
        length++;

    }

    /**
     *
     * @param i 删除第i的元素
     * @return
     * @throws IndexOutOfBoundsException
     */
    public Object delete(int i) throws IndexOutOfBoundsException{
        int j=1;
        SingleLinkList point=this;
        while(point.node!=null&&j<i){
            point=point.node;
            j++;
        }
        if(point.node==null||j>i){
            throw new IndexOutOfBoundsException();
        }

        Object o=point.node.data;
        SingleLinkList q=point.node;  //q为需要删除的对象
        point.node=q.node;
        q=null;    //将对象引用q值为null，断开与堆中对象的联系，使得q所指的对象变成不可达，方便gc回收
        length--;
        return o;

    }

    /**
     * 随即生成n个元素的单链表，元素始终插入第一位
     * @param n
     * @throws Exception
     */
    public void createListHead(int n) throws Exception {
        Random random= new Random(47);
        for(int i=0;i<n;i++){
          //  insert(1,random.nextInt(20));
            SingleLinkList q=new SingleLinkList(random.nextInt(20));
            q.node=node;
            node=q;

        }
        length=n;
    }

    /**
     * 随即生成n个元素的单链表，元素始终插入最后一位
     * @param n
     * @throws Exception
     */
    public void createListTail(int n) throws Exception {
        Random random= new Random(47);
        SingleLinkList point=this;
        for(int i=0;i<n;i++){


            SingleLinkList q=new SingleLinkList(random.nextInt(20));
            point.node=q;
            point=point.node;


        }
    length=n;
    }


    /**
     * 将单链表删除，将所有元素释放
     */
    public void clearList(){
        SingleLinkList point=node;
        while(point!=null){
            SingleLinkList q=point;
            point=point.node;
            q=null;  //使堆上的对象不可达，gc释放内存
            length--;
        }
    }
    public static void main(String[] args) throws Exception {
          SingleLinkList list1=new SingleLinkList();
          SingleLinkList list2=new SingleLinkList();

//        list.insert(1,1111);
//        list.insert(2,2222);
//        list.insert(3,4444);
//        System.out.println(list.get(1));
//        System.out.println(list.get(2));
//        System.out.println(list.get(3));
//        list.delete(1);
//        list.delete(1);
//        System.out.println(list.get(1));
          int N=5;
          list1.createListHead(N);
          for(int i=1;i<=N;i++){
              System.out.println(list1.get(i));
          }
        System.out.println("list1.length="+list1.getLength());


        list2.createListTail(N);
        for(int i=1;i<=N;i++){
            System.out.println(list2.get(i));
        }
        System.out.println("list2.length="+list2.getLength());

        list1.clearList();
        list2.clearList();
        System.out.println("list1.length="+list1.getLength());
        System.out.println("list2.length="+list2.getLength());


    }
}


