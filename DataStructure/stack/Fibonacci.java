package stack;

/**
 * 裴波那契数列
 * f(n){  0  , 当n=0
 *        1, 当n=1
 *        f(n-1)+f(n-2) ,当n>1

 * }
 */
public class Fibonacci {

    public static void general(int size){
        int[] a=new int[size];
        a[0]=0;
        a[1]=1;
        for(int i=2;i<size;i++){
            a[i]=a[i-1]+a[i-2];
        }
//        for(int j=0;j<size;j++){
//            System.out.print(a[j]+" ");
//        }

        System.out.println(a[size-1]);
    }

    /**
     * 返回第i位裴波那契数
     * @param i
     * @return
     */
    public static int recursion(int i){
        if(i<2){
             return i==0? 0: 1;
        }
        return recursion(i-1)+recursion(i-2);

    }

    public static void fbi(int size){
//        for(int i=0;i<size;i++){
//            System.out.print(recursion(i)+" ");
//            recursion(i);
//        }
        System.out.println(recursion(size-1));
    }
    public static void main(String[] args) {
       int size=999;

        new Thread(new Runnable() {
            @Override
            public void run() {
                Long time=System.currentTimeMillis();
                general(size);

                System.out.println("general: "+(System.currentTimeMillis()-time));
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Long time=System.currentTimeMillis();
                fbi(size);

                System.out.println("recursion: "+(System.currentTimeMillis()-time));
            }
        }).start();


    }
}

