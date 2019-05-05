import downLoad.HTML_XML;
import downLoad.Images;
import matchers.Image;
import matchers.Pages;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 2019/5/3 0003
 * 上午 12:22
 * Dregs_2
 */
public class DownLoad_Images {
    /**
     * URL 爬取初始页面的地址
     * DIR  存入本地目录下的地址，用于分目录存储
     * ROOTDIR  本地存储的根目录
     */
    static String URL = "https://www.gamersky.com/ent/201904/1178074.shtml";
    static String DIR = "2019-04-027";
    static String ROOTDIR = "E:\\图片\\code_download_images\\";
    public static void main(String[] args) {
        if (args.length==3){
            URL = args[0];
            DIR = args[1];
            ROOTDIR = args[2];
        }
        String code = HTML_XML.getXMLCode(URL);
        List<String> pages = Pages.getPage(code);
        for(String page : pages){
            for(String image : Image.getImageUrls(HTML_XML.getXMLCode(page))){
                System.out.println(image);
                Images.mkdir_exists(image.split("\\?")[1],DIR);
            }
        }
        List<String> images = Image.getImageUrls(code);
        for(String image : images){
            Images.mkdir_exists(image,"1");
        }
        /**
         * 清除多余小文件
         */
        File file = new File(ROOTDIR + DIR);
        File[] files = file.listFiles();
        for (File file1 : files){
            if(file1.length()<81920){
                file1.delete();
            }
        }
    }

}
