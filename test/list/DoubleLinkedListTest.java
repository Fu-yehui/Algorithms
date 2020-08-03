package list;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class DoubleLinkedListTest {


    @Test
    public void insert() {
    }

    @Test
    public void get() {
        Random random=new Random();

        int N=100000,T=1000;
        DoubleLinkedList list1=new DoubleLinkedList();
        for(int j=1;j<N+1;j++){
            list1.insert(j,random.nextInt(1000));
        }
        Long time=0L;
        Long sum=0L;
        int k;



        for (k = 0; k < T; k++) {
            list1.get(random.nextInt(N) + 1);
        }


    }

    @Test
    public void selection() {


        int N=100000,T=1000;
        DoubleLinkedList list=new DoubleLinkedList();
            Random random=new Random();
            for(int j=1;j<N+1;j++){
                list.insert(j,random.nextInt(1000));
            }
            Long time=0L;
            Long sum=0L;
            int k;



                for (k = 0; k < T; k++) {
                     list.get(random.nextInt(N) + 1);
                }




    }

    @Test
    public void delete() {
    }

    @Test
    public void currentNode() {
    }

    @Test
    public void priorNode() {
    }

    @Test
    public void foreach() {
    }

    @Test
    public void testTime() {
    }

    @Test
    public void main() {
    }
}