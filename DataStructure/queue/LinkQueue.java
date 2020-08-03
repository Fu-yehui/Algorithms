package queue;

public class LinkQueue implements Queue {

    private Node front;  //首指针指向头节点
    private Node rear;  //尾指针
    private int length;
    /**
     * 节点内部类
     */
    private class Node{
        private Object data;
        private Node next;

        public Node(Object data){
            this.data=data;
        }

        public Node(){

        }
    }

    /**
     * 初始化时front,rear都指向头指针
     */
    public LinkQueue(){
        front=new Node();
        rear=front;
    }
    @Override
    public void initQueue() {

    }

    @Override
    public void destoryQueue() {

    }

    @Override
    public void clearQueue() {
        rear=front;
        front.next=null;
        length=0;
    }

    @Override
    public boolean queueEmpty() {
        if(front==rear){
            return true;
        }
        return false;
    }

    @Override
    public Object getHead() {
        if(front==rear){
            throw new IndexOutOfBoundsException();
        }
        return front.next.data;
    }

    @Override
    public void addQueue(Object data) {
        Node newNode=new Node(data);
        rear.next=newNode;
        rear=newNode;
        length++;
    }

    @Override
    public Object deleteQueue() {
        if(front==rear){
            throw new IndexOutOfBoundsException();
        }
        Node point=front.next;
        front.next=point.next;
        Object o=point.data;
        if(point==rear){    //如果删除的是唯一一个元素（rear指向的元素)删除后将rear指向头节点,如若不然，rear将会指向null
            rear=front;
        }

        point=null;
        length--;
        return o;
    }

    @Override
    public int queueLength() {
        return length;
    }

    public static void main(String[] args) {
        LinkQueue queue=new LinkQueue();
        System.out.println(queue.queueEmpty());
        queue.addQueue(1111);
//        queue.addQueue(2222);
//        System.out.println(queue.queueLength());
//        System.out.println(queue.getHead());
//        System.out.println(queue.deleteQueue());
//        System.out.println(queue.queueLength());
//        System.out.println(queue.getHead());
//        System.out.println(queue.queueEmpty());
//
//        queue.clearQueue();
//
//        System.out.println(queue.queueEmpty());
//        System.out.println(queue.queueLength());

        System.out.println(queue.deleteQueue());
        System.out.println(queue.queueLength());
        queue.addQueue(9999);
        System.out.println(queue.queueLength());
        System.out.println(queue.getHead());
    }
}
