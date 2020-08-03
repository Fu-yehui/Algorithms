package stack;

import org.omg.PortableServer.LIFESPAN_POLICY_ID;

public class LinkStack implements Stack {
    //栈顶指针
    private StackNode top;
    private int count;

    private class StackNode{
        private Object data;
        private StackNode next;

        public StackNode(Object data){
            this.data=data;
        }
    }

    public LinkStack(){

    }
    @Override
    public void InitStack() {

    }

    @Override
    public void DestoryStack() {

    }

    @Override
    public void ClearStack() {

        top=null;
    }

    @Override
    public boolean StackEmpty() {
        if(top==null){
            return true;
        }
        return false;
    }

    @Override
    public Object GetTop() {
        return top.data;
    }

    @Override
    public void push(Object data) {
        StackNode node=new StackNode(data);
        node.next=top;
        top=node;
        count++;
    }

    @Override
    public Object pop() {
        if(top==null){
            throw new IndexOutOfBoundsException();
        }
        Object o=top.data;
        StackNode p=top;
        top=top.next;
        p=null;
        count--;
        return o;

    }

    @Override
    public int StackLength() {
        return count;
    }

    public static void main(String[] args) {
        LinkStack stack=new LinkStack();
        stack.push(11112);
    }
}


