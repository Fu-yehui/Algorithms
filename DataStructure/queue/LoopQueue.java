package queue;

import java.security.acl.LastOwnerException;

public class LoopQueue implements Queue {
    private Object[] list;
    private int front;
    private int rear;

    public LoopQueue(int size){
        list=new Object[size];
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
    }

    @Override
    public boolean queueEmpty() {
        if(rear==front){
            return true;
        }
        return false;
    }

    @Override
    public Object getHead() {
        if(rear==front){
            throw new IndexOutOfBoundsException();
        }
        return list[front];


    }

    @Override
    public void addQueue(Object data) {
        if((rear+1)%list.length==front){
            throw new IndexOutOfBoundsException();
        }
        list[rear]=data;
        rear=(rear+1)%list.length;  //加%list.length是为了从最后移到数组头部

    }

    @Override
    public Object deleteQueue() {
        if(rear==front){
            throw new IndexOutOfBoundsException();
        }
        Object o=list[front];
        front=(front+1)%list.length;
        return o;
    }

    @Override
    public int queueLength() {
        return (rear-front+list.length)%list.length;
    }

    public static void main(String[] args) {
        LoopQueue queue=new LoopQueue(10);
        queue.addQueue(1111);
        System.out.println(queue.getHead());
        queue.addQueue(2222);
        System.out.println(queue.getHead());

        queue.addQueue(3333);
        System.out.println(queue.getHead());

        System.out.println(queue.queueEmpty());
        System.out.println(queue.queueLength());
        System.out.println(queue.deleteQueue());
        System.out.println(queue.getHead());


        System.out.println(queue.queueLength());
        queue.clearQueue();

        System.out.println(queue.queueLength());

    }
}
