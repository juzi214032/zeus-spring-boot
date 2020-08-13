package team1.deal.controller.quotedPrice;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import team1.deal.model.dto.QuotedPriceInfoPOListDTO;
import team1.deal.model.po.DemandOrderPO;
import team1.deal.model.po.QuotedPriceInfoPO;
import team1.deal.model.vo.MessageResponseVO;
import team1.deal.model.vo.ResponseVO;
import team1.deal.service.QuotedPriceService;
import team1.deal.service.UserService;

import java.math.BigDecimal;
import java.util.List;

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
    public ResponseVO auditAllow(@RequestBody @Validated QuotedPriceInfoPO quotedPriceInfoPO){
        quotedPriceService.auditAllow(quotedPriceInfoPO);
        return new MessageResponseVO(20001);
    }


    /**
     * 报价审核不通过
     * @param quotedPriceInfoPO
     * @return
     */
    @ApiOperation("报价审核不通过")
    @PostMapping(value = "/auditFailure")
    public ResponseVO auditFailure(@RequestBody @Validated QuotedPriceInfoPO quotedPriceInfoPO){
        quotedPriceService.auditFailure(quotedPriceInfoPO);
        return new MessageResponseVO(20002);
    }


    /**
     * 报价审批通过
     * @param quotedPriceInfoPO
     * @return
     */
    @ApiOperation("报价审批通过")
    @PostMapping(value = "/approvalAllow")
    public ResponseVO approvalAllow(@RequestBody @Validated QuotedPriceInfoPO quotedPriceInfoPO){
        quotedPriceService.approvalAllow(quotedPriceInfoPO);
        return new MessageResponseVO(20003);
    }


    /**
     * 报价审批不通过
     * @param quotedPriceInfoPO
     * @return
     */
    @ApiOperation("报价审批不通过")
    @PostMapping(value = "/approvalFailure")
    public ResponseVO approvalFailure(@RequestBody @Validated QuotedPriceInfoPO quotedPriceInfoPO){
        quotedPriceService.approvalFailure(quotedPriceInfoPO);
        return new MessageResponseVO(20004);
    }

    //******************************************


    /**
     * 报价批量审核通过
     * @param quotedPriceInfoPOListDTO
     * @return
     */
    @ApiOperation("报价批量审核通过")
    @PostMapping(value = "/batchauditAllow")
    public ResponseVO batchauditAllow(@RequestBody QuotedPriceInfoPOListDTO quotedPriceInfoPOListDTO){
        quotedPriceService.batchauditAllow(quotedPriceInfoPOListDTO);

        return new MessageResponseVO(20011);
    }

    /**
     * 报价批量审核不通过
     * @param quotedPriceInfoPOListDTO
     * @return
     */
    @ApiOperation("报价批量审核不通过")
    @PostMapping(value = "/batchauditFailure")
    public ResponseVO batchauditFailure(@RequestBody QuotedPriceInfoPOListDTO quotedPriceInfoPOListDTO){
        quotedPriceService.batchauditFailure(quotedPriceInfoPOListDTO);

        return new MessageResponseVO(20012);
    }

    /**
     * 报价批量审批通过
     * @param quotedPriceInfoPOListDTO
     * @return
     */
    @ApiOperation("报价批量审批通过")
    @PostMapping(value = "/batchapprovalAllow")
    public ResponseVO batchapprovalAllow(@RequestBody QuotedPriceInfoPOListDTO quotedPriceInfoPOListDTO){
        quotedPriceService.batchapprovalAllow(quotedPriceInfoPOListDTO);

        return new MessageResponseVO(20013);
    }

    /**
     * 报价批量审批不通过
     * @param quotedPriceInfoPOListDTO
     * @return
     */
    @ApiOperation("报价批量审批不通过")
    @PostMapping(value = "/batchapprovalFailure")
    public ResponseVO batchapprovalFailure(@RequestBody QuotedPriceInfoPOListDTO quotedPriceInfoPOListDTO){
        quotedPriceService.batchapprovalFailure(quotedPriceInfoPOListDTO);

        return new MessageResponseVO(20014);
    }

}

