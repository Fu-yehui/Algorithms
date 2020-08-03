package stack;

import org.junit.Test;

import static org.junit.Assert.*;

public class LinkStackTest {

    @Test
    public void initStack() {
    }

    @Test
    public void destoryStack() {
    }

    @Test
    public void clearStack() {
        LinkStack stack=new LinkStack();
        stack.push(1111);
        stack.ClearStack();
    }

    @Test
    public void stackEmpty() {
        LinkStack stack=new LinkStack();
        stack.push(1111);
        System.out.println(stack.StackEmpty());
    }

    @Test
    public void getTop() {
        LinkStack stack=new LinkStack();
        stack.push(1111);
        System.out.println(stack.GetTop());
    }

    @Test
    public void push() {
        LinkStack stack=new LinkStack();
        stack.push(1111);
    }

    @Test
    public void pop() {
        LinkStack stack=new LinkStack();
        stack.push(1111);
        System.out.println(stack.pop());
    }

    @Test
    public void stackLength() {
        LinkStack stack=new LinkStack();
        stack.push(1111);
        System.out.println(stack.StackLength());
    }
}