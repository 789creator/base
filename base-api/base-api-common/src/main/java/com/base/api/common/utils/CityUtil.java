package com.base.api.common.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.*;


/**
 * Created by zhangdaoyin on 2018/1/8.
 */
public class CityUtil {
    private static JSONArray object;

    private static JSONArray getJsonArrayObject(){
        if (object == null){
            InputStream inputStream = null;
            InputStreamReader reader =null;
            inputStream = CityUtil.class.getResourceAsStream("/citys.json");
            if (inputStream == null){
                throw new RuntimeException("城市校验文件不存在");
            }
            try {
                reader = new InputStreamReader(inputStream,"UTF-8");
                if (reader == null){
                    throw new RuntimeException("城市校验文件读取异常:");
                }else {
                    char[] chars = new char[20480];
                    int len = 0;
                    try {
                        len = reader.read(chars);
                        System.out.println(len);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    String str = new String(chars,0,len);
                    object = JSONObject.parseArray(str);
                }
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException("城市校验文件编码方式异常:"+e);

            }finally {
                try {
                    reader.close();
                } catch (IOException e) {
                    throw new RuntimeException("城市校验文件读取关闭异常:"+e);
                }
            }
        }
        return object;
    }

    public static boolean isCityUseable(String province,String city) throws IOException {
        if (province.isEmpty() || city.isEmpty()){
            return false;
        }
        JSONArray object = getJsonArrayObject();
        int size = object.size();
        for (int i = 0 ; i < size ; i++){
            JSONObject jsonObject = object.getJSONObject(i);
            if (jsonObject.get("Name").equals(province)){
                JSONArray jb = (JSONArray)jsonObject.get("City");
                int len = jb.size();
                for (int j = 0;j < len;j++){
                    JSONObject jObject = jb.getJSONObject(j);
                    if (jObject.get("Name").equals(city)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        String value = "广东:深圳";
        String[] str = value.split(":");
        System.out.println(str.length);
        String province = str[0].trim();
        String city = str[1].trim();
        boolean bo = isCityUseable(province,city);
        System.out.print(bo);
//        JSONArray object = getJsonArrayObject();
//        int Size = object.size();
//        for (int i = 0 ; i < Size ; i++){
//            JSONObject jsonObject = object.getJSONObject(i);
////            System.out.println("[" + i + "]Name=" + jsonObject.get("Name"));
////            System.out.println("[" + i + "]City=" + jsonObject.get("City"));
////            System.out.println();
//            if (jsonObject.get("Name").equals(city)){
//                JSONArray jb = (JSONArray)jsonObject.get("City");
//                int num = jb.size();
//                for (int j = 0;j < num;j++){
//                    JSONObject jObject = jb.getJSONObject(j);
//                    System.out.println(jObject.get("Name"));
//                    if (jObject.get("Name").equals(cou)){
////                        System.out.println(jObject.get("Name"));
//                        System.out.println("###############YES");
//                        break;
//                    }
//                }
//            }
//        }

    }
}
