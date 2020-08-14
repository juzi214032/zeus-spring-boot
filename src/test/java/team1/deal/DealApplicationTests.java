package team1.deal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import team1.deal.mapper.DeptMapper;
import team1.deal.model.po.DemandOrderPO;
import team1.deal.model.po.UserPO;
import team1.deal.service.impl.EchoServiceImpl;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class DealApplicationTests {

    @Autowired
    private RedisTemplate<Object, UserPO> redisTemplate;


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

    }


}
