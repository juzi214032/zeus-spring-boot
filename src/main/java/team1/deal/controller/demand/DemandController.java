package team1.deal.controller.demand;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import team1.deal.model.po.DemandOrderPO;
import team1.deal.model.vo.ResponseVO;
import team1.deal.service.DemandService;

@RestController
@Api(tags = "电厂或者子公司，需求多级审核")
@RequestMapping("/Demand")
public class DemandController {

    @Autowired
    private DemandService demandService;



    /**
     * 需求审核通过
     * @param demandOrderPO
     * @return
     */
    @ApiOperation("需求审核通过")
    @PostMapping(value = "/auditAllow")
    public ResponseVO<DemandOrderPO> auditAllow(@RequestBody DemandOrderPO demandOrderPO){
        demandService.auditAllow(demandOrderPO);

        return new ResponseVO<>(demandOrderPO);
    }

    /**
     * 需求审核不通过
     * @param demandOrderPO
     * @return
     */
    @ApiOperation("需求审核不通过")
    @PostMapping(value = "/auditFailure")
    public ResponseVO<DemandOrderPO> auditFailure(@RequestBody DemandOrderPO demandOrderPO){
        demandService.auditFailure(demandOrderPO);

        return new ResponseVO<>(demandOrderPO);
    }

    /**
     * 需求审批通过
     * @param demandOrderPO
     * @return
     */
    @ApiOperation("需求审批通过")
    @PostMapping(value = "/approvalAllow")
    public ResponseVO<DemandOrderPO> approvalAllow(@RequestBody DemandOrderPO demandOrderPO){
        demandService.approvalAllow(demandOrderPO);

        return new ResponseVO<>(demandOrderPO);
    }

    /**
     * 需求审批不通过
     * @param demandOrderPO
     * @return
     */
    @ApiOperation("需求审批不通过")
    @PostMapping(value = "/approvalFailure")
    public ResponseVO<DemandOrderPO> approvalFailure(@RequestBody DemandOrderPO demandOrderPO){
        demandService.approvalFailure(demandOrderPO);

        return new ResponseVO<>(demandOrderPO);
    }

}
