import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 2019/5/2 0002
 * 下午 11:52
 * Dregs_2
 */
public class Match_Test {
    @Test
    public void match(){
        Pattern compile = Pattern.compile("https.*.jpg");
        Matcher matcher = compile.matcher("<a href=\"https://www.gamersky.com/showimage/id_gamersky.shtml?https://img1.gamersky.com/image2019/04/20190427_ljt_red_220_3/gamersky_024origin_047_20194271648172.jpg\" target=\"_blank\">");
        while (matcher.find())
            System.out.println(matcher.group());
    }
}
