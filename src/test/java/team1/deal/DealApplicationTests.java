package team1.deal;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import team1.deal.dao.DataAnalysisDao;
import team1.deal.model.po.UserPO;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
class DealApplicationTests {

    @Autowired
    private RedisTemplate<Object, UserPO> redisTemplate;
    @Autowired
    private DataAnalysisDao dataAnalysisDao;

    @Test
    void test1() {
        UserPO person = new UserPO();
        person.setName("chen");
        person.setUsername("账户");
        person.setPassword("123");
        person.setId(1);
        //String k = UUID.randomUUID() + "";
        redisTemplate.opsForValue().set("k",person, Duration.ofHours(23L));
        System.out.println(redisTemplate.opsForValue().get("k"));
    }

    @Test
    void test2(){
        LocalDateTime beginlocalDateTime = DateUtil.parseLocalDateTime("2020-01-01 00:00:00");
        LocalDateTime endlocalDateTime = DateUtil.parseLocalDateTime("2021-09-05 19:11:27");
        System.out.println(dataAnalysisDao.kindsOfCoal("煤种1",beginlocalDateTime,endlocalDateTime));
    }


}
