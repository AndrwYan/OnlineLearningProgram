package com.andrew.generator.server;
/*
* 服务端的service，DTO全部由ServerGenerator生成
*
* */


import com.andrew.generator.util.FreeMarkerUtil;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ServerGenerator {

    static String MODULE="business";
    static String toServicePath = "server\\src\\main\\java\\com\\andrew\\server\\service\\";
    static String toControllerPath = MODULE+"\\src\\main\\java\\com\\andrew\\"+MODULE+"\\controller\\admin\\";

    public static void main(String[] args) throws IOException, TemplateException {
        //
        String Domain="Section";
        String domain="section";
        String tableNameCn="小节";
        String module=MODULE;

        Map<String, Object> map = new HashMap<>();
        map.put("Domain",Domain);
        map.put("domain",domain);
        map.put("tableNameCn",tableNameCn);
        map.put("module",module);

        FreeMarkerUtil.initConfig("service.ftl");
        FreeMarkerUtil.
                generator(toServicePath + Domain + "Service.java",map);



        FreeMarkerUtil.initConfig("controller.ftl");
        FreeMarkerUtil.
                generator(toControllerPath + Domain + "controller.java",map);
    }
}
