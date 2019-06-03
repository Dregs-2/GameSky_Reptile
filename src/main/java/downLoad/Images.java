package downLoad;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.UUID;


import utils.*;

/**
 * 2019/5/3 0003
 * 上午 12:30
 * Dregs_2
 */
public class Images {
    static String ROOTDIR;
    static File _file;
    public static boolean mkdir_exists(String ROOTDIR_,String inurl,String dir){
        ROOTDIR = ROOTDIR_;
        _file = new File(ROOTDIR+dir);
        if(!_file.exists())
            _file.mkdir();
        return download(inurl,dir);
    }

    static boolean download(String inurl,String dir){
        //HttpGet
        try {
            URL url = new URL(inurl);

            String path = url.getPath();
            String[] split = path.split("/");
            File file = new File(ROOTDIR+dir+"\\"+url.getHost()+split[split.length-1].split("\\.")[0]+".jpg");
            URLConnection connection = url.openConnection();
            connection.setConnectTimeout(5 * 1000);
            BufferedInputStream input = new BufferedInputStream(connection.getInputStream());
            BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(file));
            byte[] buf = new byte[4096];
            int length = input.read(buf);
            while(length != -1) {
                output.write(buf, 0, length);
                length = input.read(buf);
            }
            output.close();
            input.close();
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
