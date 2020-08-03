package String;

import java.lang.String;
public class PlainPatternMatching {
//    public static int index(String X,String T){
//        int i=0;
//
//        int j=0;
//
//        while(i<X.length() && j<T.length()){
//            if(X.charAt(i)==T.charAt(j)){
//                ++i;
//                ++j;
//            }else{
//
//            }
//        }
//
//    }
    public static int index(String X,String T){


        for(int i=0;i<X.length();i++){
            if(X.charAt(i)!=T.charAt(0)){
                continue;
            }

            int n=i+1;
            int j=1;




            while(n<X.length() && j< T.length()){
                if(X.charAt(n)==T.charAt(j)){
                    ++n;
                    ++j;
                }else{
                    break;
                }
            }


            if(j==T.length()){
                return i;
            }


        }
        return -1;
    }

    public static int bf(String X,String T){
        int i=0,j=0;
        while(i<X.length() && j<T.length()){
            if(X.charAt(i)==T.charAt(j)){
                i++;
                j++;
            }else{
                i=i-j+1;     //i-j=i的起始值 i的增长量和j的增长量是一样的，将i往后移一位
                j=0;       //重新从子串的首部开始比较
            }
        }


        if(j==T.length()){
            return i-j;
        }
        return -1;
    }


    public static void main(String[] args) {
        java.lang.String x="0000000000000000000000000000000000000001";

        String t="0000000001";
        System.out.println(bf(x,t));
    }
}
