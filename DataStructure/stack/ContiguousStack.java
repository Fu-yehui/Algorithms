package stack;

public class ContiguousStack implements Stack {
    private Object[] list;

    private int top=-1;

    public ContiguousStack(int size){
        list=new Object[size];

    }
    @Override
    public void InitStack() {

    }

    @Override
    public void DestoryStack() {

    }

    @Override
    public void ClearStack() {
        top=-1;

    }

    @Override
    public boolean StackEmpty() {
        if(top==-1){
            return true;
        }
        return false;
    }

    @Override
    public Object GetTop() {
        if(top==-1){
            throw new IndexOutOfBoundsException();
        }
        return list[top];
    }

    @Override
    public void push(Object data) {

        if(top==list.length-1){
            throw new IndexOutOfBoundsException();
        }
        top++;
        list[top]=data;

    }

    @Override
    public Object pop() {
        if(top==-1){
            throw new IndexOutOfBoundsException();
        }
        Object o=list[top];
        top--;
        return o;
    }

    @Override
    public int StackLength() {
        return top+1;
    }

    public static void main(String[] args) {
        Stack stack=new ContiguousStack(10);
//        System.out.println(stack.StackLength());
//        System.out.println(stack.StackEmpty());
//        stack.push(1111);
//        System.out.println(stack.StackLength());
//        System.out.println(stack.StackEmpty());
//        System.out.println(stack.GetTop());
//        stack.push(2222);
//        System.out.println(stack.StackLength());
//        System.out.println(stack.StackEmpty());
//        System.out.println(stack.GetTop());
//        System.out.println("pop: "+stack.pop());
//        System.out.println(stack.StackLength());
//        System.out.println(stack.StackEmpty());
//        System.out.println(stack.GetTop());

        System.out.println("************");
        stack.push("#");
        System.out.println(stack.pop());
    }
}
