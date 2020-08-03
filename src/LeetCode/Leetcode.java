package LeetCode;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Leetcode {




    /**
     * Initialize your data structure here.
     */
    public Leetcode() {

    }

    public String decodeString(String s) {
        LinkedList<Character> stack=new LinkedList<Character>();
        StringBuilder result=new StringBuilder();
        for(int i=0;i<s.length();i++){
            switch (s.charAt(i)){
                case ']':{
                    StringBuilder sb=new StringBuilder();
                    while(stack.peekFirst()!='['){
                        sb.append(stack.pollFirst());
                    }
                    stack.pollFirst(); //将 [ 弹出
                    int count=Character.getNumericValue(stack.pollFirst()); //循环次数
                    sb=sb.reverse();
                    String r=sb.toString();
                    for(int j=0;j<count;j++){
                      result.append(r);
                    }


                }break;
                default:stack.addFirst(s.charAt(i));

            }
        }
        return result.toString();
    }





    public static void main(String[] args) {

//        Leetcode leetcode=new Leetcode();
//        String a=leetcode.decodeString("3[a]2[bc]");
//        System.out.println(a);

        System.out.println((1+1-4)%4);

    }

}
