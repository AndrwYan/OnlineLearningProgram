package com.andrew.generator.test;


import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TestUtil {

    //ftlPath是模板文件所在路径
    static String ftlPath = "generator\\src\\main\\java\\com\\andrew\\generator\\test\\";
    //toPath是要生成的路径
    static String toPath = "generator\\src\\main\\java\\com\\andrew\\generator\\test\\";

    public static void main(String[] args) throws IOException, TemplateException {
        //读模板
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_29);
        cfg.setDirectoryForTemplateLoading(new File(ftlPath));
        cfg.setObjectWrapper(new DefaultObjectWrapper(Configuration.VERSION_2_3_29));
        Template temp = cfg.getTemplate("test.ftl");

        FileWriter fw = new FileWriter(toPath + "Test.java");
        BufferedWriter bw = new BufferedWriter(fw);
        temp.process(null, bw);
        bw.flush();
        fw.close();
    }
}
