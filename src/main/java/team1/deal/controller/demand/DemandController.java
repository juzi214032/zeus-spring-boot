package team1.deal.controller.demand;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import team1.deal.model.po.DemandOrderPO;
import team1.deal.model.vo.MessageResponseVO;
import team1.deal.model.vo.ResponseVO;
import team1.deal.service.DemandService;

@RestController
@Api(tags = "电厂或者子公司，需求多级审核")
@RequestMapping("/Demand")
public class DemandController {

    @Autowired
    private DemandService demandService;


    @ApiOperation("需求审核通过")
    @PostMapping(value = "/auditAllow")
    public ResponseVO auditAllow(@RequestBody @Validated DemandOrderPO demandOrderPO){
        demandService.auditAllow(demandOrderPO);
        return new MessageResponseVO(20001);
    }


    @ApiOperation("需求审核不通过")
    @PostMapping(value = "/auditFailure")
    public ResponseVO auditFailure(@RequestBody @Validated DemandOrderPO demandOrderPO){
        demandService.auditFailure(demandOrderPO);
        return new MessageResponseVO(20002);
    }


    @ApiOperation("需求审批通过")
    @PostMapping(value = "/approvalAllow")
    public ResponseVO approvalAllow(@RequestBody @Validated DemandOrderPO demandOrderPO){
        demandService.approvalAllow(demandOrderPO);
        return new MessageResponseVO(20003);
    }


    @ApiOperation("需求审批不通过")
    @PostMapping(value = "/approvalFailure")
    public ResponseVO approvalFailure(@RequestBody @Validated DemandOrderPO demandOrderPO){
        demandService.approvalFailure(demandOrderPO);
        return new MessageResponseVO(20004);
    }

}
