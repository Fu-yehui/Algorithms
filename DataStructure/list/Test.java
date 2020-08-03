package list;

import java.util.ArrayList;
import java.util.Random;

public class Test {

    private Object data;
    private Test prior;
    private Test next;
    private int length;

    public Test(){
        prior=this;
        next=this;
    }
    public Test(Object data){
        this.data=data;
    }

    public void insert(int i,Object data) throws IndexOutOfBoundsException{
        if(i<1||i>length+1){
            throw new IndexOutOfBoundsException();
        }

        Test point=currentNode(i);

        Test newNode= new Test(data);
        Test p=point.prior;
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
        Test point=currentNode(i);

        return point.data;


    }

    public Object selection(int i) throws IndexOutOfBoundsException{
        if(i<1||i>length){
            throw new IndexOutOfBoundsException();
        }
        Test point=priorNode(i);

        return point.data;


    }


    public Object delete(int i) throws IndexOutOfBoundsException{
        if(i<1||i>length){
            throw new IndexOutOfBoundsException();
        }
        Test point=currentNode(i);
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
    public Test currentNode(int i){
        Test point=this;
        for(int j=0;j<i;j++){
            point=point.next;
        }
        return point;
    }
    public Test priorNode(int i){
        Test point = this;
        if(i<=(length+1)/2) {
            System.out.println("i<=(length+1)/2");
            for (int j = 0; j < i; j++) {
                point = point.next;

            }
        }else {
            System.out.println("i>(length+1)/2");
            for (int j = 0; j < length + 1 - i; j++) {
                point = point.prior;

            }
        }
        return point;

    }
    public void foreach(){
        Test point=this.next;
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



    public static void main(String[] args){
        //ArrayList list=new ArrayList(2);
        //System.out.println(list.get(0));
        System.out.println("sss");
        Test list=new Test();
        list.insert(1,1);
        list.insert(2,2);
        list.insert(3,3);
        list.selection(3);
        list.selection(1);
        list.selection(2);
        }
    }

