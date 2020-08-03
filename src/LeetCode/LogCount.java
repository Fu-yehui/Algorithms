package LeetCode;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogCount {

    public static void main(String[] args) throws FileNotFoundException {
        Set<String> day=new TreeSet<>();
        Map<String,Integer> dayCount=new HashMap<>();
        List<String> time=new ArrayList<>();
        File file=new File("/home/roger/.cache/JetBrains/IntelliJIdea2020.1/log/idea.log");
        System.out.println(file.getName());
        FileInputStream fileInputStream=new FileInputStream(file);
        Scanner in=new Scanner(new BufferedInputStream(fileInputStream));
        Matcher matcher= Pattern.compile("(\\d{4}[-]\\d{2}[-]\\d{2})\\s+(\\d{2}[:]\\d{2}[:]\\d{2},\\d+)").matcher("");


        while(in.hasNext()){
            String logData=in.nextLine();
//            System.out.println(logData);
            matcher.reset(logData);
            while (matcher.find()){
               // System.out.println(matcher.group(1));
                day.add(matcher.group(1));
                time.add(matcher.group(2));

                if(dayCount.get(matcher.group(1))==null){
                    dayCount.put(matcher.group(1),1);
                }else{
                    dayCount.put(matcher.group(1),dayCount.get(matcher.group(1))+1);
                }


            }
        }

        System.out.println(day.toString());
        System.out.println(day.size());

        System.out.println(time.toString());
        System.out.println(time.size());

        System.out.println(dayCount.toString());

    }
}
