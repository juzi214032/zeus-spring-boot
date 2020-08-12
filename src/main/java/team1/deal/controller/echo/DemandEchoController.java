package team1.deal.controller.echo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import team1.deal.model.po.DemandOrderPO;
import team1.deal.model.po.UserPO;
import team1.deal.model.vo.ResponseVO;
import team1.deal.service.EchoService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@Api(tags = "回显控制")
@RequestMapping("/Echo")
public class DemandEchoController {

    @Autowired
    private EchoService echoService;

    @Autowired
    private RedisTemplate<Object, UserPO> redisTemplate;

    @ApiOperation("获取需求订单")
    @PostMapping(value = "/DemandEcho")
    public ResponseVO DemandEcho(HttpServletRequest httpServletRequest){
        UserPO userPO = redisTemplate.opsForValue().get(httpServletRequest.getHeader("Token"));
        return new ResponseVO(echoService.getToAudit(userPO.getId()));
    }

}
