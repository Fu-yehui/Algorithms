package stack;

import java.awt.Event;

public class test {
    public static void main(String[] args) {
        int x=-123;
        int n=x*-1;
        System.out.println(n);

        int a=x/100;
        System.out.println(a);
        int c=x%10;
        System.out.println(c);
        int b=(x-a*100-c)/10;
        System.out.println(b);
        System.out.println((c*100+b*10+a));

        System.out.println((c*100+b*10+a)*-1);





    }
}
