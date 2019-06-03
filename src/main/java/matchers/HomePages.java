package matchers;

import downLoad.HTML_XML;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HomePages {
    static ArrayList<String> strings;

    public static void main(String[] args) {
        getImageUrls(HTML_XML.getXMLCode("https://www.gamersky.com/ent/wp/"));
    }
    public static List<String> getUrl(){
        return getImageUrls(HTML_XML.getXMLCode("https://www.gamersky.com/ent/wp/"));
    }
    public static List<String> getImageUrls(String context){
        strings = new ArrayList<String>();
        String[] split = context.split("\n");
        for(String str : split){
            match(str);
        }

        return strings;
    }
    private static void match(String context){
        Pattern compile = Pattern.compile("img\"><a href=\"https.*.shtml");
        Matcher matcher = compile.matcher(context);
        while (matcher.find()){
            String str = matcher.group().split("\"")[2];
            strings.add(str);
        }
    }
}
