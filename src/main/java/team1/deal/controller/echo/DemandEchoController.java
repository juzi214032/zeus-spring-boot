package team1.deal.controller.echo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team1.deal.model.po.UserPO;
import team1.deal.model.vo.ResponseVO;
import team1.deal.service.DemandOrderService;
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

    @Autowired
    private DemandOrderService demandOrderService;

    /**
     * 需求订单简要信息回显
     * @param httpServletRequest
     * @return
     */
    @ApiOperation("需求订单简要信息回显")
    @PostMapping(value = "/DemandEchoBrief")
    public ResponseVO DemandEchoBrief(HttpServletRequest httpServletRequest){
        UserPO userPO = redisTemplate.opsForValue().get(httpServletRequest.getHeader("Token"));
        return new ResponseVO(echoService.getDemandOrderBriefInfo(2));
    }

    /**
     * 需求订单详细信息回显
     */
    @ApiOperation("需求订单详细信息回显")
    @PostMapping(value = "/DemandEchoDetail/{orderId}")
    public ResponseVO DemandEchoDetail(@ApiParam("订单id") @PathVariable Integer orderId){
        return new ResponseVO(demandOrderService.getDemandOrderById(orderId));
    }


    /**
     * 保存需求订单回显
     * @return
     */
    @ApiOperation("保存需求订单回显")
    @PostMapping(value = "/SaveDemandEcho")
    public ResponseVO SaveDemandEcho(){
        return new ResponseVO(echoService.SaveDemandEcho());
    }


    /**
     * 保存报价订单回显
     * @return
     */
    @ApiOperation("保存报价订单回显")
    @PostMapping(value = "/SaveQuotedPriceEcho")
    public ResponseVO SaveQuotedPriceEcho(){
        return new ResponseVO(echoService.SaveQuotedPriceEcho());
    }

}
