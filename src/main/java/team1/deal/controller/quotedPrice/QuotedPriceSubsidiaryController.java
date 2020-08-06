package team1.deal.controller.quotedPrice;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import team1.deal.model.po.QuotedPriceInfoPO;
import team1.deal.model.po.UserPO;
import team1.deal.model.vo.ResponseVO;

import java.util.List;
import java.util.Map;

@RestController
@Api(tags = "子公司，筛选名单给电厂，报价审核")
@RequestMapping("/QuotedPrice/Subsidiary")
public class QuotedPriceSubsidiaryController {


    @ApiOperation("子公司通过某种规则选出供应商名单")
    @RequestMapping(value = "/outUserList")
    public ResponseVO<List<Integer>> outUserList(Map<String,Object> map){

        return null;
    }



    @ApiOperation("子公司报价审批")
    @RequestMapping(value = "/approval")
    public ResponseVO<QuotedPriceInfoPO> approval(List<Integer> userIdList){

        return null;
    }
}
