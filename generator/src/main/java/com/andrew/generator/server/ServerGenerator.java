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

    static String toServicePath = "server\\src\\main\\java\\com\\andrew\\server\\service\\";
    static String toControllerPath = "business\\src\\main\\java\\com\\andrew\\business\\controller\\admin\\";
    public static void main(String[] args) throws IOException, TemplateException {
        //
        String Domain="Section";
        String domain="section";
        Map<String, Object> map = new HashMap<>();
        map.put("Domain",Domain);
        map.put("domain",domain);

        FreeMarkerUtil.initConfig("service.ftl");
        FreeMarkerUtil.
                generator(toServicePath + Domain + "Service.java",map);



        FreeMarkerUtil.initConfig("controller.ftl");
        FreeMarkerUtil.
                generator(toControllerPath + Domain + "controller.java",map);
    }
}
