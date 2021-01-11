package com.ssh.jsonorder;

import cn.hutool.core.lang.Assert;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.*;

/**
 * @author ssh
 * @description
 * @date 2021/1/11 9:23
 */
public class Demo {
    public static void main(String[] args) {
        testJsonObjectOrder1();
        testJsonObjectOrder2();
    }

    public static void testJsonObjectOrder1() {
        String res1, res2;
        List<Map<String, Object>> nList;
        Map<String, Object> data = new HashMap<>();
        data.put("d", "cd");
        data.put("a", 1);
        data.put("b", 0.45);
        data.put("total", 333);
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> item1 = new HashMap<>();
        item1.put("aa", 1);
        item1.put("ee", 5);
        item1.put("bb", 6);
        item1.put("nn", null);
        list.add(item1);
        Map<String, Object> item2 = new HashMap<>();
        item2.put("xxx", "000");
        item2.put("q", 2);
        item2.put("a", "aa");
        list.add(item2);
        data.put("sub", list);


        Map<String, Object> nData = new HashMap<>(data);
        nData.put("c", null);
        nData.put("abc", null);

        res1 = JSONObject.toJSONString(data);
        res2 = JSONObject.parseObject(JSONObject.toJSONString(nData)).toJSONString();
        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res1.equals(res2));
        //Assert.assertEquals("序列化结果不相等default", res1, res2);

        res2 = JSONObject.toJSONString(JSONObject.parseObject(
                JSONObject.toJSONString(nData, SerializerFeature.SortField)),
                SerializerFeature.SortField);
        //Assert.assertEquals("序列化结果不相等sort", res1, res2);
        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res1.equals(res2));

        nList = new ArrayList<>();
        nList.add(item2);
        nList.add(item1);
        nData.put("sub", nList);
        res2 = JSONObject.parseObject(JSONObject.toJSONString(nData)).toJSONString();
        //Assert.assertEquals("序列化结果不相等array", res1, res2);
        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res1.equals(res2));
    }
    public static void testJsonObjectOrder2() {
        String res1, res2;
        List<Map<String, Object>> nList;
        Map<String, Object> data = new HashMap<>();
        data.put("d", "cd");
        data.put("a", 1);
        data.put("b", 0.45);
        data.put("total", 333);
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> item1 = new HashMap<>();
        item1.put("aa", 1);
        item1.put("ee", 5);
        item1.put("bb", 6);
        item1.put("nn", null);
        list.add(item1);
        Map<String, Object> item2 = new HashMap<>();
        item2.put("xxx", "000");
        item2.put("q", 2);
        item2.put("a", "aa");
        list.add(item2);
        data.put("sub", list);


        Map<String, Object> nData = new HashMap<>(data);
        nData.put("c", null);
        nData.put("abc", null);

        res1 = JSONObject.toJSONString(data);
        res2 = JSONObject.parseObject(JSONObject.toJSONString(nData)).toJSONString();
        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res1.equals(res2));
        //Assert.assertEquals("序列化结果不相等default", res1, res2);

        res2 = JSONObject.toJSONString(JSONObject.parseObject(
                JSONObject.toJSONString(nData, SerializerFeature.SortField)),
                SerializerFeature.SortField);
        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res1.equals(res2));
        //Assert.assertEquals("序列化结果不相等sort", res1, res2);

        res2 = JSONObject.toJSONString(JSONObject.parseObject(
                JSONObject.toJSONString(nData, SerializerFeature.WriteMapNullValue)),
                SerializerFeature.WriteMapNullValue);
        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res1.equals(res2));
        //Assert.assertEquals("序列化结果不相等null", res1, res2);

        nList = new ArrayList<>();
        nList.add(item2);
        nList.add(item1);
        nData.put("sub", nList);
        res2 = JSONObject.parseObject(JSONObject.toJSONString(nData)).toJSONString();
        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res1.equals(res2));
        //Assert.assertEquals("序列化结果不相等array", res1, res2);

        nList = new ArrayList<>();
        nList.add(item2);
        nList.add(item1);
        nData.put("sub", nList);
        res1 = transformDataToJSONAsOrderWay(data);
        res2 = transformDataToJSONAsOrderWay(nData);
        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res1.equals(res2));
        //Assert.assertEquals("序列化结果不相等array-s", res1, res2);
    }

    /**
     * 将原始数据转换为有序的集合
     */
    public static String transformDataToJSONAsOrderWay(Map<String, Object> data) {
        TreeMap<String, Object> transformedData = new TreeMap<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            if(entry.getValue() == null) {
                continue;
            }
            if(entry.getValue() instanceof List) {
                TreeMap<String, Integer> tmpMap = new TreeMap<>();
                List value = (List) entry.getValue();
                for (int i = 0; i < (value).size(); i++) {
                    Object it1 = value.get(i);
                    // 假设只支持二维数组嵌套
                    tmpMap.put(transformDataToJSONAsOrderWay((Map<String, Object>) it1), i);
                }
                List<Object> orderedList = new ArrayList<>(tmpMap.size());
                for (Integer listNo : tmpMap.values()) {
                    orderedList.add(value.get(listNo));
                }
                transformedData.put(entry.getKey(), orderedList);
                continue;
            }
            transformedData.put(entry.getKey(), entry.getValue());
        }
        return JSONObject.toJSONString(transformedData);
    }
}
