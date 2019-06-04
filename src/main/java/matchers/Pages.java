package matchers;

import downLoad.HTML_XML;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 2019/5/3 0003
 * 上午 12:28
 * Dregs_2
 */
public class Pages {
    static HashMap<Integer, String> map;
    public static List<String> getPage(String code){
        map = new HashMap<Integer, String>();
        ArrayList<String> list = new ArrayList<String>();
        String[] split = code.split("\n");
        for (String context : split)
        {
            match(context);
        }
        Integer max = Collections.max(map.keySet());
        String code1 = HTML_XML.getXMLCode(map.get(max));
        String[] split1 = code.split("\n");
        for (String context : split1)
        {
            match(context);
        }
        for(String str : map.values()){
            list.add(str);
        }
        return list;
    }
    private static void match(String context){
        Pattern compile = Pattern.compile("<a href.*>\\d</a>");
        Matcher matcher = compile.matcher(context);
        if(matcher.find()){
            String[] split = matcher.group().split("</a>");
            for(String str : split){
                Matcher matcher1 = Pattern.compile("http.*.shtml").matcher(str);
                if(matcher1.find()){
                    String newstr = matcher1.group();
                    map.put(Integer.parseInt(str.split("\">")[1]),newstr);
                }
            }
        }
    }
}
