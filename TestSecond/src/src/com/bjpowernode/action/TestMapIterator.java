package src.com.bjpowernode.action;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import src.com.bjpowernode.entity.City;

import java.util.Set;

/**
 * 类TestMapIterator.java的实现描述：TODO 类实现描述
 *  map的遍历四种方式
 * @author tangjinhui 2017年3月31日 下午5:43:29
 */
public class TestMapIterator {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "value1");
        map.put("2", "value2");
        map.put("3", "value3");
        //第一种：普遍使用，二次取值
        //        System.out.println("通过Map.keySet遍历key和value：");
        for (String key : map.keySet()) {
            System.out.println("key= " + key + " and value= " + map.get(key));
        }
        //第二种
        System.out.println("通过Map.entrySet使用iterator遍历key和value：");

        Set<Entry<String, String>> entrySet = map.entrySet();
        Iterator<Entry<String, String>> iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Entry<String, String> entry = iterator.next();
            System.out.println(entry.getKey() + entry.getValue());
        }
        //第三种：推荐，尤其是容量大时
        System.out.println("通过Map.entrySet遍历key和value");
        for (Map.Entry<String, String> entry : entrySet) {
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }

        //第四种
        System.out.println("通过Map.values()遍历所有的value，但不能遍历key");
        for (String v : map.values()) {
            System.out.println("value= " + v);
        }
        List<City> attachmentList = Lists.newArrayList();
        City city1 = new City();
        city1.setCid(1);
        attachmentList.add(city1);

        City city2 = new City();
        city2.setCid(2);
        attachmentList.add(city2);

        City city3 = new City();
        city3.setCid(3);
        attachmentList.add(city3);

        Map<Integer, City> map1 = Maps.uniqueIndex(attachmentList, new Function<City, Integer>() {
            @Override
            public Integer apply(City input) {
                return input.getCid();
            }
        });
        System.out.println("Map的值" + JSON.toJSON(map1));

    }

}
