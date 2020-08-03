package stack;

import java.util.Scanner;

public class Calculator {
    private LinkStack stack = new LinkStack();


    private double calculate(String[] suffix){
        for(int i=0;i<suffix.length;i++){
            if(suffix[i].charAt(0)==' '){
                continue;
            }
           if (Character.isDigit(suffix[i].charAt(0))){
               stack.push(suffix[i]);
           }else {
               double d1=Double.parseDouble((String)stack.pop());

               double d2=Double.parseDouble((String)stack.pop());
               switch (suffix[i].charAt(0)){
                   case '+' :  d1+=d2;break;
                   case '-' :  d1=d2-d1;break;
                   case '/' :  d1=d2/d1;break;
                   case '*' :  d1=d2*d1;break;

               }
               stack.push(String.valueOf(d1));
           }
        }

        return Double.parseDouble((String)stack.pop());

    }
//    private String[] infixToSuffix(String[] infix){
//        String result="";
//        stack.push("#");
//        int count=0;
//        for(int i=0;i<infix.length;i++) {
//            if (Character.isDigit(infix[i].charAt(0))) {
//                result = result + infix[i] + " ";
//            } else if (id(infix[i]) == 1) {
//
//                stack.push(infix[i]);
//            } else if (id(infix[i]) == 6) {
//                while (true) {
//                    String s = (String) stack.pop();
//                    if (id(s) == 1) {
//                        break;
//                    }
//                    result = result + s + " ";
//
//                }
//
//            } else {
//
//                while (priority(infix[i]) <= priority((String) stack.GetTop())) {
//                    result = result + (String) stack.pop() + " ";
//
//                }
//                stack.push(infix[i]);
//            }
//        }
//           while(stack.GetTop()!="#"){
//            result=result+(String)stack.pop()+" ";
//        }
//
//        return result.split(" ");
//
//    }



    private String[] convert(String infix){
        String result="";
        stack.push('#');
        int count=0;
        for(int i=0;i<infix.length();i++) {
            if (Character.isDigit(infix.charAt(i))||infix.charAt(i)=='.') {
                result = result + String.valueOf(infix.charAt(i)) ;
            } else if (id(infix.charAt(i)) == 1) {

                stack.push(infix.charAt(i));

            } else if (id(infix.charAt(i)) == 6) {
                result+=" ";
                while (true) {
                    char s = (char)stack.pop();
                    if (id(s) == 1) {
                        break;
                    }
                    result = result + String.valueOf(s) + " ";

                }

                /**
                 * 每当左右括号匹配完，result都会多一个“ ” ，因为右括号下一个一定是符号
                 * 所以每当这段执行完，就将count+1
                 */
                count++;
            } else {

                /**
                 * 每次匹配到符号都会查看count是否等于1
                 *  true:意味上一个符号是右括号，result会多一个“ ”，所以就不加“ ”
                 *  false:意味上一个符号不是右括号，是普通符号或者是数字，则加“ ”
                 */
                if(count==0) {
                    result += " ";

                    while (priority(infix.charAt(i)) <= priority((char) stack.GetTop())) {
                        result = result + String.valueOf((char) stack.pop()) + " ";

                    }
                    stack.push(infix.charAt(i));
                }else{
                    while (priority(infix.charAt(i)) <= priority((char) stack.GetTop())) {
                        result = result + String.valueOf((char) stack.pop()) + " ";

                    }
                    stack.push(infix.charAt(i));
                    count--;
                }
            }
        }
        result+=" ";
        while((char)stack.GetTop()!='#'){
            result = result + String.valueOf((char) stack.pop()) + " ";
        }

        return result.split(" ");

    }

    public int priority(char s){
        switch (s){
            case '#':  return -2;
            case '(' : return 0;

            case '+' :

            case '-' : return 1;

            case '*' :

            case '/' : return 2;

            default : return -1;

        }
    }

    public int id(char s){
        switch (s){
            case '#':  return -2;
            case '(' : return 1;

            case '+' : return 2;

            case '-' : return 3;

            case '*' : return 4;

            case '/' : return 5;

            case ')' : return 6;
            default : return -1;

        }
    }
    public static void main(String[] args) {
        Calculator calculator=new Calculator();
//
//        String data="9.1 3.2 1 - 3 * + 10 2 / +   ";
//        String[] s=data.split(" ");
//
//        System.out.println(calculator.calculate(s));
        Scanner in=new Scanner(System.in);
        String data=in.nextLine();
//        String data="9 + ( 3 - 1 ) * 3 + 10 / 2";
//        String test="+ ( - ) * + /";
        String[] a=calculator.convert(data);
        for(String o:a){
            System.out.println(o);
        }
        System.out.println(calculator.calculate(calculator.convert(data)));



    }
}