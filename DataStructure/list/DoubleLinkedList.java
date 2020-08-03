package list;

import java.util.Random;
import java.util.zip.DeflaterOutputStream;

public class DoubleLinkedList {
    private Object data;
    private DoubleLinkedList prior;
    private DoubleLinkedList next;
    private int length;

    public DoubleLinkedList(){
        prior=this;
        next=this;
    }
    public DoubleLinkedList(Object data){
        this.data=data;
    }

    public void insert(int i,Object data) throws IndexOutOfBoundsException{
        if(i<1||i>length+1){
            throw new IndexOutOfBoundsException();
        }

        DoubleLinkedList point=currentNode(i);

        DoubleLinkedList newNode= new DoubleLinkedList(data);
        DoubleLinkedList p=point.prior;
        newNode.prior=p;
        newNode.next=point;
        p.next=newNode;
        point.prior=newNode;
        length++;

    }

    public Object get(int i) throws IndexOutOfBoundsException{
        if(i<1||i>length){
            throw new IndexOutOfBoundsException();
        }
        DoubleLinkedList point=currentNode(i);

        return point.data;


    }

    public Object selection(int i) throws IndexOutOfBoundsException{
        if(i<1||i>length){
            throw new IndexOutOfBoundsException();
        }
        DoubleLinkedList point=priorNode(i);

        return point.data;


    }


    public Object delete(int i) throws IndexOutOfBoundsException{
        if(i<1||i>length){
            throw new IndexOutOfBoundsException();
        }
        DoubleLinkedList point=currentNode(i);
        point.prior.next=point.next;
        point.next.prior=point.prior;
        Object o=point.data;
        length--;
        return o;
    }

    /**
     * 返回第i位节点
     * @param i
     * @return
     */
    public DoubleLinkedList currentNode(int i){
        DoubleLinkedList point=this;
        for(int j=0;j<i;j++){
            point=point.next;
        }
        return point;
    }
        public DoubleLinkedList priorNode(int i){
            DoubleLinkedList point = this;
            if(i<=(length+1)/2) {
                for (int j = 0; j < i; j++) {
                    point = point.next;
                }
            }else {
                for (int j = 0; j < length + 1 - i; j++) {
                    point = point.prior;
                }
            }
                return point;

        }
    public void foreach(){
        DoubleLinkedList point=this.next;
        while(point!=this){
            System.out.println(point.data);
            point=point.next;

        }

    }



    public void testTime(int N,int T,boolean isSelection){
        new Thread(new Runnable() {
            @Override
            public void run() {
                Random random=new Random();
                for(int j=1;j<N+1;j++){
                    insert(j,random.nextInt(1000));
                }
                Long time=0L;
                Long sum=0L;
                int k;

                if(!isSelection) {

                    for (k = 0; k < T; k++) {


                        time = System.currentTimeMillis();
                        get(random.nextInt(N) + 1);
                        time = System.currentTimeMillis() - time;
                        sum += time;

                    }



                }
                else {
                    for (k = 0; k < T; k++) {


                        time = System.currentTimeMillis();
                        selection(random.nextInt(N) + 1);
                        time = System.currentTimeMillis() - time;
                        sum += time;

                    }
                }
                System.out.println((double) sum / (double) T);

            }
        }).start();




    }




    public static void main(String[] args) {
        DoubleLinkedList list=new DoubleLinkedList();
//        list.insert(1,1111);
//        list.insert(1,2222);
//        System.out.println(list.get(1));
//        System.out.println(list.get(2));
//        System.out.println("********************");
//        list.insert(3,3333);
//        list.foreach();
//        System.out.println("********************");
//
//        list.delete(2);
//        list.foreach();
//        list.testTime(1000000,100000,false);
//        list.testTime(1000000,100000,true);
        list.testTime(1000000,100,false);
        list.testTime(1000000,100,true);

    }

}
