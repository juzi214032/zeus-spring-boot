package team1.deal.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@ApiModel("部分订单信息")
@Data
public class PartDemandOrderInfo {

    @ApiModelProperty(value = "需求订单id")
    private Integer id;

    @ApiModelProperty(value = "煤炭种类")
    private String coalType;

    @ApiModelProperty(value = "采购数量")
    private Integer coalNumber;

    @ApiModelProperty(value = "运输方式")
    private String transportType;

    @ApiModelProperty(value = "交货地点")
    private String deliveryPlace;

    @ApiModelProperty(value = "结算方式")
    private String paymentType;

    @ApiModelProperty(value = "验收方式")
    private String checkType;

    @ApiModelProperty(value = "最高限价，不能为空")
    private String maxPrice;

    @ApiModelProperty(value = "最低限价,可以为空")
    private String minPrice;

    @ApiModelProperty(value = "限价说明")
    private String priceDescription;

    @ApiModelProperty(value = "每吨煤,报价保证金额")
    private BigDecimal offerMargin;

    @ApiModelProperty(value = "每吨煤,执行保证金额")
    private BigDecimal performMargin;

    @ApiModelProperty(value = "热值")
    private BigDecimal calorificValue;

    @ApiModelProperty(value = "全硫")
    private BigDecimal sulfurContent;

    @ApiModelProperty(value = "挥发分")
    private BigDecimal volatileQuantity;

    @ApiModelProperty(value = "空干基灰分")
    private BigDecimal aad;
}
