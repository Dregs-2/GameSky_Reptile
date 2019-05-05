package downLoad;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static utils.StreamToBytes.readInputStream;

/**
 * 2019/5/3 0003
 * 上午 1:28
 * Dregs_2
 */
public class HTML_XML {
    public static String getXMLCode(String _url){
        URL url = null;
        try {
            url = new URL(_url);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(3 * 1000);
            connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            InputStream inputStream = connection.getInputStream();
            byte[] bytes = readInputStream(inputStream);
            return new String(bytes, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }

    }
}
