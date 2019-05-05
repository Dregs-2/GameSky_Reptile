import com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe;
import org.junit.Test;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 2019/5/2 0002
 * 下午 11:29
 * Dregs_2
 */
public class DownLoad {
    @Test
    public void UrlTest() throws IOException {
        URL url = new URL("https://www.gamersky.com/ent/201904/1178074_3.shtml");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setConnectTimeout(3 * 1000);
        connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
        InputStream inputStream = connection.getInputStream();
        byte[] bytes = readInputStream(inputStream);
        String s = new String(bytes, "UTF-8");
        String[] split = s.split("\n");
        for(String str : split){
            match(str);
        }
        //System.out.println(s);

    }
    static byte[] readInputStream(InputStream inputStream) throws IOException {

        byte[] buffer = new byte[2048];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while ((len = inputStream.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        bos.close();
        return bos.toByteArray();
    }
    static void match(String str){
        Pattern compile = Pattern.compile("https.*.jpg\"\\star");
        Matcher matcher = compile.matcher(str);
        while (matcher.find()){
            Pattern compile2 = Pattern.compile(".*");
            Matcher matcher2 = compile2.matcher(matcher.group());
            if(matcher2.find()){
                    String[] s = matcher2.group().split("</a>");
                for(String st : s){
                    System.out.println(st);
                }}

        }
    }
}
