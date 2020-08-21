package team1.deal.controller.echo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import team1.deal.model.dto.PageParamDTO;
import team1.deal.model.po.UserPO;
import team1.deal.model.vo.DemandOrderBriefInfoVO;
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


    @ApiOperation("需求订单简要信息回显")
    @GetMapping(value = "/demandEchoBrief")
    public ResponseVO<IPage<DemandOrderBriefInfoVO>> DemandEchoBrief(PageParamDTO pageParamDTO, HttpServletRequest httpServletRequest){
        UserPO userPO = redisTemplate.opsForValue().get(httpServletRequest.getHeader("Token"));
        return new ResponseVO(echoService.getDemandOrderBriefInfo(pageParamDTO,userPO.getId()));
    }


    @ApiOperation("需求订单详细信息回显")
    @GetMapping(value = "/demandEchoDetail/{orderId}")
    public ResponseVO DemandEchoDetail(@ApiParam("需求订单id") @PathVariable Integer orderId){
        return new ResponseVO(demandOrderService.getDemandOrderById(orderId));
    }


    @ApiOperation("报价阶段需求订单简要信息回显")
    @GetMapping(value = "/demandEchoBrief/quoted")
    public ResponseVO<IPage<DemandOrderBriefInfoVO>> DemandEchoBriefQuoted(PageParamDTO pageParamDTO, HttpServletRequest httpServletRequest){
        UserPO userPO = redisTemplate.opsForValue().get(httpServletRequest.getHeader("Token"));
        return new ResponseVO(echoService.getDemandOrderBriefInfoQuoted(pageParamDTO,userPO.getId()));
    }


    @ApiOperation("报价简要信息回显")
    @GetMapping("/quotedEchoBrief")
    public ResponseVO<IPage<QuotedPriceBriefInfoVO>> quotedEchoBrief(PageParamDTO pageParamDTO, HttpServletRequest httpServletRequest){
        UserPO userPO = redisTemplate.opsForValue().get(httpServletRequest.getHeader("Token"));
        return new ResponseVO<>(quotedPriceInfoService.getQuotedBriefList(pageParamDTO,userPO.getId()));
    }

    @ApiOperation(value = "报价详细信息回显",notes = "审核审批人员访问")
    @GetMapping("/quotedEchoDetail/{orderId}")
    public ResponseVO<Map<String,Object>> quotedEchoDetail(@ApiParam("需求订单id") @PathVariable Integer orderId, HttpServletRequest httpServletRequest){
        Map map = new HashMap();
        map.put("demandOrder",demandOrderService.getDemandOrderById(orderId));
        UserPO userPO = redisTemplate.opsForValue().get(httpServletRequest.getHeader("Token"));
        map.put("quotedPriceInfo",userService.selectSupplier(orderId,userPO.getId()));
        return  new ResponseVO<>(map);
    }

    @ApiOperation(value = "报价详细信息回显",notes = "阳光用户访问")
    @GetMapping("/quotedEchoDetail/sunUser/{quotedId}")
    public ResponseVO<Map<String,Object>> demandOrderInfoUser(@ApiParam("报价订单id") @PathVariable Integer quotedId){
        Map map = new HashMap();
        map.put("demandOrder",quotedPriceInfoService.getDemandOrder(quotedId));
        map.put("quotedPriceInfo",quotedPriceInfoService.getQuotedInfoVO(quotedId));
        return  new ResponseVO<>(map);
    }


    @ApiOperation("保存需求订单回显")
    @PostMapping(value = "/SaveDemandEcho")
    public ResponseVO SaveDemandEcho(){
        return new ResponseVO(echoService.SaveDemandEcho());
    }



    @ApiOperation("保存报价订单回显")
    @PostMapping(value = "/SaveQuotedPriceEcho")
    public ResponseVO SaveQuotedPriceEcho(){
        return new ResponseVO(echoService.SaveQuotedPriceEcho());
    }

}
