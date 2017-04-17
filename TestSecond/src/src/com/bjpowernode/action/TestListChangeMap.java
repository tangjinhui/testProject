package src.com.bjpowernode.action;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import src.com.bjpowernode.entity.City;

/**
 * 类TestListChangeMap.java的实现描述：
 * list的值直接转为map
 * 
 * @author tangjinhui 2017年3月31日 下午5:42:38
 */
public class TestListChangeMap {
    public static void main(String[] args) {
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

        Map<Integer, City> map = Maps.uniqueIndex(attachmentList, new Function<City, Integer>() {
            @Override
            public Integer apply(City input) {
                return input.getCid();
            }
        });
        System.out.println("Map的值" + JSON.toJSON(map));
    }
}
