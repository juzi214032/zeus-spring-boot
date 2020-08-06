package team1.deal.controller.quotedPrice;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import team1.deal.model.po.DemandOrderPO;
import team1.deal.model.po.QuotedPriceInfoPO;
import team1.deal.model.vo.ResponseVO;
import team1.deal.service.QuotedPriceService;

import java.math.BigDecimal;

@RestController
@Api(tags = "电厂或者子公司，报价多级审核")
@RequestMapping("/QuotedPrice")
public class QuotedPriceController {

    @Autowired
    private QuotedPriceService quotedPriceService;


    /**
     * 报价审核通过
     * @param quotedPriceInfoPO
     * @return
     */
    @ApiOperation("报价审核通过")
    @PostMapping(value = "/auditAllow")
    public ResponseVO<QuotedPriceInfoPO> auditAllow(@RequestBody QuotedPriceInfoPO quotedPriceInfoPO){
        quotedPriceService.auditAllow(quotedPriceInfoPO);

        return new ResponseVO<>(quotedPriceInfoPO);
    }


    /**
     * 报价审核不通过
     * @param quotedPriceInfoPO
     * @return
     */
    @ApiOperation("报价审核不通过")
    @PostMapping(value = "/auditFailure")
    public ResponseVO<QuotedPriceInfoPO> auditFailure(@RequestBody QuotedPriceInfoPO quotedPriceInfoPO){
        quotedPriceService.auditFailure(quotedPriceInfoPO);

        return new ResponseVO<>(quotedPriceInfoPO);
    }


    /**
     * 报价审批通过
     * @param quotedPriceInfoPO
     * @return
     */
    @ApiOperation("报价审批通过")
    @PostMapping(value = "/approvalAllow")
    public ResponseVO<QuotedPriceInfoPO> approvalAllow(@RequestBody QuotedPriceInfoPO quotedPriceInfoPO){
        quotedPriceService.approvalAllow(quotedPriceInfoPO);

        return new ResponseVO<>(quotedPriceInfoPO);
    }


    /**
     * 报价审批不通过
     * @param quotedPriceInfoPO
     * @return
     */
    @ApiOperation("报价审批不通过")
    @PostMapping(value = "/approvalFailure")
    public ResponseVO<QuotedPriceInfoPO> approvalFailure(@RequestBody QuotedPriceInfoPO quotedPriceInfoPO){
        quotedPriceService.approvalFailure(quotedPriceInfoPO);

        return new ResponseVO<>(quotedPriceInfoPO);
    }

}

