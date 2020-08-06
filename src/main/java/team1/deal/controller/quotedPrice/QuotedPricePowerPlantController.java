package team1.deal.controller.quotedPrice;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import team1.deal.model.po.DemandOrderPO;
import team1.deal.model.po.QuotedPriceInfoPO;
import team1.deal.model.vo.ResponseVO;

@RestController
@Api(tags = "电厂，报价多级审核")
@RequestMapping("/QuotedPrice/PowerPlant")
public class QuotedPricePowerPlantController {
    /**
     * audit审核
     * @param quotedPriceInfoPO
     * @return
     */
    @ApiOperation("电厂报价审核")
    @RequestMapping(value = "/audit")
    public ResponseVO<QuotedPriceInfoPO> audit(@RequestPart QuotedPriceInfoPO quotedPriceInfoPO){

        return null;
    }

    /**
     * approval审批
     * @param quotedPriceInfoPO
     * @return
     */
    @ApiOperation("电厂报价审批")
    @RequestMapping(value = "/approval")
    public ResponseVO<QuotedPriceInfoPO> approval(@RequestPart QuotedPriceInfoPO quotedPriceInfoPO){

        return null;
    }

}

