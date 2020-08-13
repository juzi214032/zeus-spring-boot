package team1.deal.controller.echo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team1.deal.model.po.SaveDemandOrderPO;
import team1.deal.model.po.SaveQuotedPriceInfoPO;
import team1.deal.model.po.UserPO;
import team1.deal.model.vo.ResponseVO;
import team1.deal.service.EchoService;

import javax.servlet.http.HttpServletRequest;

@RestController
@Api(tags = "回显控制")
@RequestMapping("/Echo")
public class DemandEchoController {

    @Autowired
    private EchoService echoService;

    @Autowired
    private RedisTemplate<Object, UserPO> redisTemplate;

    @ApiOperation("需求订单回显")
    @PostMapping(value = "/DemandEcho")
    public ResponseVO DemandEcho(HttpServletRequest httpServletRequest){
        UserPO userPO = redisTemplate.opsForValue().get(httpServletRequest.getHeader("Token"));
        return new ResponseVO(echoService.getToAudit(userPO.getId()));
    }


    /**
     * 保存需求订单回显
     * @return
     */
    @ApiOperation("保存需求订单回显")
    @PostMapping(value = "/SaveDemandEcho")
    public SaveDemandOrderPO SaveDemandEcho(){
        return echoService.SaveDemandEcho();
    }


    /**
     * 保存报价订单回显
     * @return
     */
    @ApiOperation("保存报价订单回显")
    @PostMapping(value = "/SaveQuotedPriceEcho")
    public SaveQuotedPriceInfoPO SaveQuotedPriceEcho(){
        return echoService.SaveQuotedPriceEcho();
    }

}
