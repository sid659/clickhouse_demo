package com.click.house;

import com.click.house.service.TestService;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ClickHouseTest {

    @Resource
    private TestService testService;

    @Test
    public void saveTest() {
        com.click.house.entity.Test test = new com.click.house.entity.Test();
        test.setPointId(1);
        test.setDataTime(202011071200L);
        test.setVal(2.01F);
        testService.save(test);
    }

    @Test
    public void batchInsertTest() throws InterruptedException {
        //2020 07 13 23 30
        Date timeStart = new Date(120, 6, 13, 23, 35, 0);
        Date timeEnd = new Date(120, 7, 1, 0, 0, 0);
        Integer pointStart = 1;
        Integer pointEnd = 100000;
        Date time = timeStart;
        while (time.before(timeEnd)) {
            List<com.click.house.entity.Test> list = new ArrayList<>(1000);
            Long tmp = Long.valueOf(DateFormatUtils.format(time, "yyyyMMddHHmm"));
            for (Integer point = pointStart; point < pointEnd; point++) {
                com.click.house.entity.Test test = new com.click.house.entity.Test();
                test.setPointId(point);
                test.setDataTime(tmp);
                test.setVal(new Random().nextFloat() * 10);
                list.add(test);

                if (point % 1000 == 0) {
                    System.out.println("list count:" + list.size());
                    testService.batchInsert(list);
                    list.clear();
                    Thread.sleep(60L);
                }
            }
            if (list.size() > 0) {
                System.out.println("list count2:" + list.size());
                testService.batchInsert(list);
                list.clear();
            }
            time = DateUtils.addMinutes(time, 5);
        }
    }

    @Test
    public void selectTest(){
        long start = System.currentTimeMillis();
        List<com.click.house.entity.Test> list = testService.select();
        long end = System.currentTimeMillis();

        System.out.println("use:" + (end - start));
    }
}
