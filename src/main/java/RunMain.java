import matchers.HomePages;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Properties;

import static java.lang.System.out;

public class RunMain {
    public static boolean bool = false;
    public static void main(String[] args) throws IOException {
        if(args.length==0){
            help();
        }
        if(args.length>3)
            bool = args[3].equals("1");
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
        }else if("2".equals(args[0])){
            Properties properties = new Properties();
            ArrayList<Integer> list = new ArrayList<Integer>();
            FileInputStream stream = new FileInputStream(new File(args[2]));
            properties.load(stream);
            Enumeration<?> names = properties.propertyNames();
            while (names.hasMoreElements())
                list.add(Integer.parseInt ((String) names.nextElement()));
            Collections.sort(list);
            int num = 0;
            if(args.length>4)
                num = Integer.parseInt(args[4])-1;
            for (;num < list.size();num++){
                String[] splits = properties.getProperty(list.get(num).toString()).split("/");
                String re = splits[splits.length-2]+splits[splits.length-1].split("\\.")[0];
                DownLoad_Images.mian(new String[]{properties.getProperty(list.get(num).toString()),re,args[1]});
                out.println((num+1)+" / "+list.size());
            }

        }else {
            help();
        }
    }
    public static void help(){
        out.println("\n参数一：0/1/2（0为下载单页全期/1为下载单期/2为下载指定文件中的所有期）");
        out.println("参数二：存储图片的根目录结尾加/");
        out.println("参数三：参数一为0时不需要填，参数一为1时填入要下载的单期链接，参数一为2时填入指定文件的全路径");
        out.println("参数四：0/1 输出方式，0为输出下载链接地址，1为输出-字符");
        out.println("参数五：配合下载文件所有期使用，指定从哪里开始下载\n");
    }
}
