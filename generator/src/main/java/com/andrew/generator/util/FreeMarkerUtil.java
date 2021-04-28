
package com.andrew.generator.util;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/*
*
*制作生成代码的工具类
*
* */

public class FreeMarkerUtil {

    //ftlPath是模板文件所在路径,一般不会变
    static String ftlPath = "generator\\src\\main\\java\\com\\andrew\\generator\\ftl\\";

    static Template temp;//提取成公共属性
    public static void initConfig(String ftlName) throws IOException {
        //读模板
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_29);
        cfg.setDirectoryForTemplateLoading(new File(ftlPath));
        cfg.setObjectWrapper(new DefaultObjectWrapper(Configuration.VERSION_2_3_29));
        temp = cfg.getTemplate("test.ftl");
        /*
        *  会用代码生成器生成controller,service,dto,vue的代码，这些代码的路径都不一样，toPath是变化的，所以把toPath变成入参
        *
        * */
    }
    public static void generator(String fileName) throws IOException, TemplateException {
        FileWriter fw = new FileWriter(fileName);
        BufferedWriter bw = new BufferedWriter(fw);
        temp.process(null, bw);
        bw.flush();
        fw.close();
    }
}
