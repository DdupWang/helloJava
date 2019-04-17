package Regex;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {
    public static void main(String[] args) {
        Pattern pattern=Pattern.compile("\\d+");
/*        String[] str=pattern.split("我的QQ是:456456我的电话是:0532214我的邮箱是:aaa@aaa.com");
        Arrays.stream(str).forEach(System.out::println);
        Boolean bool=Pattern.matches(pattern.pattern(),"12345");
        System.out.println(bool);*/
        Matcher matcher =pattern.matcher("123abc456");
        while (matcher.find()) {
            System.out.println(1);
        }
    }
}
