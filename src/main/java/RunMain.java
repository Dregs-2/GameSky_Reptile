import matchers.HomePages;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class RunMain {
    public static void main(String[] args) throws IOException {
        if("0".equals(args[0])){
            for (String str : HomePages.getUrl()){
                String[] splits = str.split("/");
                String re = splits[splits.length-2]+splits[splits.length-1].split("\\.")[0];
                DownLoad_Images.mian(new String[]{str,re,args[1]});
            }
        }else if("1".equals(args[0])){
            String[] splits = args[2].split("/");
            String re = splits[splits.length-2]+splits[splits.length-1].split("\\.")[0];
            DownLoad_Images.mian(new String[]{args[2],re,args[1]});
        }else {
            System.out.println("\n参数一：0/1（0为下载单页全期/1为下载单期）");
            System.out.println("参数二：存储图片的根目录结尾加/");
            System.out.println("参数三：参数一为0时不需要填，参数一为1时填入要下载的单期链接\n");
        }
    }
}
