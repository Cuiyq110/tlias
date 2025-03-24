package com.cuiyq;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Iterator;

//@SpringBootTest
class TliasApplicationTests {

    @Test
    void contextLoads() {
        ArrayList<String> list = new ArrayList<>();
        list.add("cuiyq");
        list.add("徐婕2");
        list.add("徐婕3");
        list.add("徐婕4");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
//            获取下一个元素
            String next = iterator.next();
//          如果下一个元素是徐婕2就删除
            if ("徐婕2".equals(next)) {
                iterator.remove();
            }
            System.out.println(next);
        }
        System.out.println("==============");
    }

}
