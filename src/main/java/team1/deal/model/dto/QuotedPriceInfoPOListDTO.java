package team1.deal.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import team1.deal.model.po.QuotedPriceInfoPO;

import java.util.List;

@Data
@ApiModel(value = "接收多个报价订单")
public class QuotedPriceInfoPOListDTO {
    @ApiModelProperty("报价订单集合")
    private List<QuotedPriceInfoPO> quotedPriceInfoPOList;
}
