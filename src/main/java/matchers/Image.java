package matchers;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 2019/5/3 0003
 * 上午 12:28
 * Dregs_2
 */
public class Image {
    static ArrayList<String> strings;
    public static List<String> getImageUrls(String context){
        strings = new ArrayList<String>();
        String[] split = context.split("\n");
        for(String str : split){
            match(str);
        }

        return strings;
    }
    private static void match(String context){
        boolean flag = false;
        //对于不同日期的网页，切换以下两种匹配规则进行爬取
        //Pattern compile = Pattern.compile("https.*.jpg\"\\star");
        Pattern compile = Pattern.compile("k\"\\shref=\"https.*.jpg");
        Matcher matcher = compile.matcher(context);
        while (matcher.find()){
            flag = true;
            strings.add(matcher.group().split("\"")[2]);
        }
        if(!flag){
            Pattern compile_ = Pattern.compile("https.*.jpg\"\\star");
            Matcher matcher_ = compile_.matcher(context);
            while (matcher_.find()){
                strings.add(matcher_.group().split("\"")[0]);
            }
        }
    }
}
