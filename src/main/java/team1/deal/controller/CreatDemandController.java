package team1.deal.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import team1.deal.model.po.DemandOrderPO;
import team1.deal.model.po.SaveDemandOrderPO;
import team1.deal.model.po.UserPO;
import team1.deal.model.vo.MessageResponseVO;
import team1.deal.model.vo.PartDemandOrderInfo;
import team1.deal.model.vo.ResponseVO;
import team1.deal.service.CreatDemandService;
import team1.deal.service.DemandOrderService;

import javax.servlet.http.HttpServletRequest;

@RestController
@Api(tags = "创建|保存需求")
@RequestMapping(value = "/creatDemand")
public class CreatDemandController {

    @Autowired
    private CreatDemandService creatDemandService;

    @Autowired
    private DemandOrderService demandOrderService;

    @Autowired
    private RedisTemplate<Object, UserPO> redisTemplate;

    /**
     * 创建并提交
     * @param demandOrderPO
     * @return
     */
    @ApiOperation("需求点击创建")
    @PostMapping(value = "/buttonCreatDemand")
    public ResponseVO CreatDemand(@RequestBody @Validated DemandOrderPO demandOrderPO){
        creatDemandService.CreatDemand(demandOrderPO);
        return new MessageResponseVO(20005);
    }

    /**
     * 创建后保存
     * @param saveDemandOrderPO
     * @return
     */
    @ApiOperation("需求点击保存")
    @PostMapping(value = "/buttonSaveDemand")
    public ResponseVO SaveDemand(@RequestBody @Validated SaveDemandOrderPO saveDemandOrderPO){
        creatDemandService.SaveDemand(saveDemandOrderPO);
        return new MessageResponseVO(20006);
    }

    @ApiOperation("审核不通过修改按钮订单信息回显")
    @GetMapping(value = "/OrderInfo/{orderId}")
    public ResponseVO changeButtonOrderInfo(@ApiParam("需求订单id") @PathVariable Integer orderId, HttpServletRequest httpServletRequest){
        PartDemandOrderInfo  partDemandOrderInfo =new PartDemandOrderInfo();
        BeanUtils.copyProperties(demandOrderService.getById(orderId),partDemandOrderInfo);
        SaveDemandOrderPO saveDemandOrderPO = new SaveDemandOrderPO();
        BeanUtils.copyProperties(partDemandOrderInfo,saveDemandOrderPO);
        saveDemandOrderPO.setUId(redisTemplate.opsForValue().get(httpServletRequest.getHeader("Token")).getId());
        creatDemandService.SaveDemand(saveDemandOrderPO);
        return new ResponseVO(partDemandOrderInfo);
    }
}
