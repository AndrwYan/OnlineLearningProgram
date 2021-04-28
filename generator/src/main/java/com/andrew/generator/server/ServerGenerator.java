package com.andrew.generator.server;
/*
* 服务端的service，DTO全部由ServerGenerator生成
*
* */

import com.andrew.generator.util.FreeMarkerUtil;
import freemarker.template.TemplateException;
import java.io.IOException;
public class ServerGenerator {
    static String toPath = "generator\\src\\main\\java\\com\\andrew\\generator\\test\\";
    public static void main(String[] args) throws IOException, TemplateException {
        FreeMarkerUtil.initConfig("test.ftl");
        FreeMarkerUtil.
                generator(toPath+"Test.java");
    }
}
