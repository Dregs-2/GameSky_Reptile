package utils;


import java.io.UnsupportedEncodingException;

/**
 * 2019/5/3 0003
 * 上午 12:36
 * Dregs_2
 */
public class BytesToString {

    public static String To(byte[] bytes){
        String string;
        try {
            string = new String(bytes,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "转换错误";
        }
        return string;
    }
}
