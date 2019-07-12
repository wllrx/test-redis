package com.zoe;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author zoe
 **/
public class Test {
    public static void main(String[] args) {

        Map<String,Object> map = new TreeMap<>();
        map.put("sd","1111");
        map.put("sa",2222);
        map.put("ad",9999);
        map.put("cd",888);
        map.put("cc",6666);
        map.put("bb",3333);
        System.out.println(map);
    }

}