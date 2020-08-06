package team1.deal.controller.demand;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import team1.deal.model.po.DemandOrderPO;
import team1.deal.model.vo.ResponseVO;

@RestController
@Api(tags = "电厂，需求多级审核")
@RequestMapping("/Demand/PowerPlant")
public class DemandPowerPlantController {

    /**
     * audit审核
     * @param demandOrderPO
     * @return
     */
    @ApiOperation("电厂需求审核")
    @RequestMapping(value = "/audit")
    public ResponseVO<DemandOrderPO> audit(@RequestPart DemandOrderPO demandOrderPO){

        return null;
    }

    /**
     * approval审批
     * @param demandOrderPO
     * @return
     */
    @ApiOperation("电厂需求审批")
    @RequestMapping(value = "/approval")
    public ResponseVO<DemandOrderPO> approval(@RequestPart DemandOrderPO demandOrderPO){

        return null;
    }


}
