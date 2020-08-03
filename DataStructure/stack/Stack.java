package stack;

public interface Stack {

    void InitStack();
    void DestoryStack();
    void ClearStack();
    boolean StackEmpty();
    Object GetTop();
    void push(Object data);
    Object pop();
    int StackLength();
}
