package com.iain.springdemo.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.iain.blog.domain.BaseBean;
import com.iain.blog.dto.TestBean;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Classname JsonTest
 * @Description TODO
 * @Date 2021/9/8 上午9:45
 * @Created by wht
 */
public class JsonTest {
    public static final Map<String, String> BANK_TYPE = new HashMap<String, String>(){
        private static final long serialVersionUID = 1L;//可有可无
        {
            put("ZX", "中信银行");
            put("PN", "平安银行");
            put("CB", "中国银行");
        }
    };

    public static void main(String[] args) {
        TestBean ttt;
//        HashMap<Object, Boolean> objectObjectHashMap = new HashMap<>();
//        if(objectObjectHashMap.get("1111")){
//            System.out.println(1);
//        }
//        TestBean testBean1 = new TestBean();
//        Object o = testBean1.BANK_TYPE.get("111");

//        HashMap filter = new HashMap(){
//            {
//            Object aaa = filter.put("111", "aaa");
//        }
//        };
//        Object o1 = filter.get("111");
        BaseBean baseBean = new BaseBean();
        baseBean.setCrtUsr("wwwww");
        baseBean.setCrtTm(new Date());
        String s = JSONObject.toJSONString(baseBean, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);
        s = "{\"crtTm\":\"20210926\",\"crtUsr\":\"wwwww\",\"uptTm\":null,\"uptUsr\":null}";
        System.out.println(s);
        BaseBean baseBean1 = JSON.parseObject(s, BaseBean.class);
        System.out.println(baseBean1.toString());
//        TestBean testBean = new TestBean();
//        testBean.setWang("wanggggg");
//        testBean.setHai(new BigDecimal("1111111111111111111111.1111111111111111111111").toString());
//        testBean.setBal(null);
//        testBean.setALong(11111111111111L);
//        BaseBean base = (BaseBean)testBean;
//        String name = base.getClass().getName();
//        System.out.println(name);
//        String t = JSONObject.toJSONString(base, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat, SerializerFeature.WriteNonStringValueAsString);
//        Map map = JSONObject.parseObject(t, Map.class);
//        System.out.println(t);
//        System.out.println(map);
//        String tMap = JSONObject.toJSONString(map, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);
//        System.out.println(tMap);



    }
}
//JSONArray array =JSONObject.parseArray(JSON.toJSONString(list, SerializerFeature.WriteNonStringValueAsString));
