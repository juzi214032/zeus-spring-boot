package team1.deal.controller.echo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import team1.deal.model.po.UserPO;
import team1.deal.model.vo.DemandOrderInfoVO;
import team1.deal.model.vo.QuotedPriceBriefInfoVO;
import team1.deal.model.vo.ResponseVO;
import team1.deal.service.DemandOrderService;
import team1.deal.service.EchoService;
import team1.deal.service.QuotedPriceInfoService;
import team1.deal.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Api(tags = "回显控制")
@RequestMapping("/echo")
public class EchoController {

    @Autowired
    private EchoService echoService;

    @Autowired
    private RedisTemplate<Object, UserPO> redisTemplate;

    @Autowired
    private DemandOrderService demandOrderService;

    @Autowired
    private UserService userService;

    @Autowired
    private QuotedPriceInfoService quotedPriceInfoService;


    /**
     * 需求订单简要信息回显
     * @param httpServletRequest
     * @return
     */
    @ApiOperation("需求订单简要信息回显")
    @GetMapping(value = "/demandEchoBrief")
    public ResponseVO DemandEchoBrief(HttpServletRequest httpServletRequest){
        UserPO userPO = redisTemplate.opsForValue().get(httpServletRequest.getHeader("Token"));
        return new ResponseVO(echoService.getDemandOrderBriefInfo(userPO.getId()));
    }

    /**
     * 需求订单详细信息回显
     */
    @ApiOperation("需求订单详细信息回显")
    @GetMapping(value = "/demandEchoDetail/{orderId}")
    public ResponseVO DemandEchoDetail(@ApiParam("需求订单id") @PathVariable Integer orderId){
        return new ResponseVO(demandOrderService.getDemandOrderById(orderId));
    }

    @ApiOperation("报价简要信息回显")
    @GetMapping("/quotedEchoBrief")
    public ResponseVO<List<QuotedPriceBriefInfoVO>> quotedEchoBrief(HttpServletRequest httpServletRequest){

        return new ResponseVO<>(quotedPriceInfoService.getQuotedBriefList(1));
    }

    @ApiOperation(value = "报价详细信息回显",notes = "审核审批人员访问")
    @GetMapping("/quotedEchoDetail/{id}")
    public ResponseVO<Map<String,Object>> quotedEchoDetail(@ApiParam("报价订单id") @PathVariable Integer quotedId, HttpServletRequest httpServletRequest){
        Map map = new HashMap();
        map.put("demandOrder",quotedPriceInfoService.getDemandOrder(quotedId));
        UserPO userPO = redisTemplate.opsForValue().get(httpServletRequest.getHeader("Token"));
        map.put("quotedPriceInfo",userService.selectSupplier(userPO.getId()));
        return  new ResponseVO<>(map);
    }

    @ApiOperation(value = "报价详细信息回显",notes = "阳光用户访问")
    @GetMapping("/quotedEchoDetail/sunUser/{id}")
    public ResponseVO<Map<String,Object>> demandOrderInfoUser(@ApiParam("报价订单id") @PathVariable Integer quotedId){
        Map map = new HashMap();
        map.put("demandOrder",quotedPriceInfoService.getDemandOrder(quotedId));
        map.put("quotedPriceInfo",quotedPriceInfoService.getQuotedInfoVO(quotedId));
        return  new ResponseVO<>(map);
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
