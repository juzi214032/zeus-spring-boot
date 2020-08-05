package team1.deal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import team1.deal.mapper.DeptMapper;

@SpringBootTest
class DealApplicationTests {


    @Autowired(required = false)
    private DeptMapper deptMapper;

    @Test
    void test1() {

        System.out.println(deptMapper.selectById(1).toString());

    }

}
