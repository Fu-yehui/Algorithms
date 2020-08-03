package stack;


import org.junit.runners.JUnit4;

import java.util.Random;

/**
 * 两栈共享空间
 * 应用场景： 当两栈的空间需求由相反关系时，（一个栈增长时，另一个栈在缩短）
 */
public class DoubleSharedStack {
    private Object[] list;
    private int top1;
    private int top2;


    public DoubleSharedStack(int size){
        list=new Object[size];
        top1=-1;
        top2=size;
    }

   public  void ClearStack(int stackNumber){
       if(stackNumber!=1&&stackNumber!=2){
           throw new IllegalArgumentException();
       }
       if(stackNumber==1){
           top1=-1;
       }else{
           top2=list.length;
       }
   }


   public  boolean StackEmpty(int stackNumber){
       if(stackNumber!=1&&stackNumber!=2){
           throw new IllegalArgumentException();
       }
       if(stackNumber==1){
           if(top1==-1){
               return true;
           }else {
               return false;
           }
       }else{
           if(top2==list.length){
               return true;
           }else{
               return false;
           }
       }
    }
    public Object GetTop(int stackNumber){

        if(stackNumber!=1&&stackNumber!=2){
            throw new IllegalArgumentException();
        }
        Object o;
        if(stackNumber==1){
            if(top1==-1){
                throw new IndexOutOfBoundsException();
            }
            o=list[top1];
        }else{
            if(top2==list.length){
                throw new IndexOutOfBoundsException();
            }
            o=list[top2];
        }

        return o;
    }
    public void push(Object data ,int stackNumber) {
       if(top1+1==top2) {
           throw new IndexOutOfBoundsException();
       }
       if(stackNumber!=1&&stackNumber!=2){
           throw new IllegalArgumentException();
       }

       if(stackNumber==1){
           list[++top1]=data;
       }else if(stackNumber==2){
           list[--top2]=data;
       }
    }
    public Object pop(int stackNumber){

        if(stackNumber!=1&&stackNumber!=2){
            throw new IllegalArgumentException();
        }
        Object o;
        if(stackNumber==1){
            if(top1==-1){
                throw new IndexOutOfBoundsException();
            }
             o=list[top1--];
        }else{
            if(top2==list.length){
                throw new IndexOutOfBoundsException();
            }
            o=list[top2++];
        }

        return o;
    }
   public  int StackLength(int stackNumber){
       if(stackNumber!=1&&stackNumber!=2){
           throw new IllegalArgumentException();
       }
       if(stackNumber==1){
           return top1+1;
       }else{
           return list.length-top2;
       }
    }

    public static void main(String[] args) {
        DoubleSharedStack stack=new DoubleSharedStack(10);
        System.out.println(stack.StackLength(1));
        System.out.println(stack.StackLength(2));
        System.out.println(stack.StackEmpty(1));
        System.out.println(stack.StackEmpty(2));
        stack.push(1111,1);
        stack.push("aaaa",2);
        System.out.println(stack.GetTop(1));
        System.out.println(stack.GetTop(2));
        stack.push(2222,1);
        System.out.println(stack.StackLength(1));
        System.out.println(stack.StackLength(2));

        System.out.println(stack.StackEmpty(1));
        System.out.println(stack.StackEmpty(2));
        System.out.println("stack1 pop: "+stack.pop(1));
        System.out.println("stack2 pop: "+stack.pop(2));
        System.out.println(stack.StackLength(1));
        System.out.println(stack.StackLength(2));

        System.out.println(stack.StackEmpty(1));
        System.out.println(stack.StackEmpty(2));
        stack.ClearStack(1);
        System.out.println(stack.StackLength(1));
        System.out.println(stack.StackLength(2));

        System.out.println(stack.StackEmpty(1));
        System.out.println(stack.StackEmpty(2));
        Random random=new Random();
        for(int i=0;i<5;i++){
            stack.push(random.nextInt(1000),1);
            stack.push(random.nextBoolean(),2);
        }
        System.out.println(stack.StackLength(1));
        System.out.println(stack.StackLength(2));

        System.out.println(stack.StackEmpty(1));
        System.out.println(stack.StackEmpty(2));
        System.out.println(stack.GetTop(1));
        System.out.println(stack.GetTop(2));
        System.out.println("stack1 pop: "+stack.pop(1));

        System.out.println(stack.StackLength(1));
        System.out.println(stack.StackLength(2));
        stack.push(random.nextBoolean(),2);
        System.out.println(stack.StackLength(1));
        System.out.println(stack.StackLength(2));


    }
}
