package team1.deal.controller.outUserList;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import team1.deal.model.dto.PageParamDTO;
import team1.deal.model.dto.UserList;
import team1.deal.model.po.UserPO;
import team1.deal.model.vo.DemandOrderInfoVO;
import team1.deal.model.vo.ResponseVO;
import team1.deal.service.DemandOrderService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Api(tags = "子公司筛选名单")
@RequestMapping("/Subsidiary")
@Slf4j
public class OutUserListController {

    @Autowired
    private DemandOrderService demandOrderService;

    @ApiOperation("采购信息列表")
    @GetMapping("/demandOrderList")
    public ResponseVO<Page<DemandOrderInfoVO>> demandOrderList(@RequestBody PageParamDTO pageParamDTO){
        Page<DemandOrderInfoVO> page = demandOrderService.getDemandOrderByPage(pageParamDTO);
        return new ResponseVO<>(page);
    }

    @ApiOperation("采购信息详情")
    @GetMapping("/demandOrderInfo/{orderId}")
    public ResponseVO<Map<String,Object>> demandOrderInfo(@ApiParam("采购订单id") @PathVariable Integer orderId){
        Map map = new HashMap();
        map.put("demandOrder",demandOrderService.getDemandOrderById(orderId));
        map.put("quotedPriceInfo",demandOrderService.getQuotedPriceInfoList(orderId));
        return  new ResponseVO<>(map);
    }

    @ApiOperation("子公司统一选择多个供应商")
    @PostMapping(value = "/outUserList")
    public List<UserPO> outUserList(@RequestBody UserList userList){
        return userList.getUserPOList();
    }

}
