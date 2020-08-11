package team1.deal.controller.quotedPrice;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import team1.deal.model.dto.PageParamDTO;
import team1.deal.model.vo.DemandOrderInfoVO;
import team1.deal.model.vo.ResponseVO;
import team1.deal.service.DemandOrderService;
import team1.deal.service.UserService;

import java.util.HashMap;
import java.util.Map;

@RestController
@Api(tags = "报价阶段信息")
@RequestMapping("/selectList")
@Slf4j
public class QuotedPriceInfoController {

    @Autowired
    private DemandOrderService demandOrderService;

    @Autowired
    private UserService userService;

    @ApiOperation("采购信息列表")
    @GetMapping("/demandOrderList")
    public ResponseVO<Page<DemandOrderInfoVO>> demandOrderList(@RequestBody(required = false) PageParamDTO pageParamDTO){
        Page<DemandOrderInfoVO> page = demandOrderService.getDemandOrderByPage(pageParamDTO);
        return new ResponseVO<>(page);
    }

    @ApiOperation("国电用户查看采购信息详情")
    @GetMapping("/demandOrderInfo/{orderId}")
    public ResponseVO<Map<String,Object>> demandOrderInfoCompany(@ApiParam("采购订单id") @PathVariable Integer orderId){
        Map map = new HashMap();
        map.put("demandOrder",demandOrderService.getDemandOrderById(orderId));
        //模拟用户id，后头可用token替换
        map.put("quotedPriceInfo",userService.selectSupplier(1));
        return  new ResponseVO<>(map);
    }

    @ApiOperation("阳光用户查看采购信息详情")
    @GetMapping("/demandOrderInfo/{orderId}")
    public ResponseVO<DemandOrderInfoVO> demandOrderInfoUser(@ApiParam("采购订单id") @PathVariable Integer orderId){
        return  new ResponseVO<>(demandOrderService.getDemandOrderById(orderId));
    }

}
