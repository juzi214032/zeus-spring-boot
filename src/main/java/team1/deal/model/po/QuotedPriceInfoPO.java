package team1.deal.model.po;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * 
 * </p>
 *
 * @author team1
 * @since 2020-08-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("quoted_price_info")
@ApiModel(value="QuotedPriceInfoPO对象", description="报价订单类")
public class QuotedPriceInfoPO implements Serializable {


    @ApiModelProperty(value = "表单id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @Range(min = 1,message = "需求订单id不合法")
    @ApiModelProperty(value = "需求订单id")
    @TableField("dId")
    private Integer dId;

    @Range(min = 1,message = "供应商id不合法")
    @ApiModelProperty(value = "供应商id（在user表中）")
    @TableField("uId")
    private Integer uId;

    @Range(min = -2,max = 4,message = "报价状态不合法")
    @ApiModelProperty(value = "状态代码（0：待审核状态，1：电厂一级审核通过状态，2：电厂二级审核通过状态， *3：子公司审批通过状态，4：完成状态，-1：出局状态，-2保存状态")
    private Integer status;

    @Range(min = 1,message = "供货量不合法")
    @ApiModelProperty(value = "供货量")
    @TableField("supplyQuantity")
    private Integer supplyQuantity;

    @NotNull(message = "热值不合法")
    @ApiModelProperty(value = "热值")
    @TableField("calorificValue")
    private BigDecimal calorificValue;

    @NotNull(message = "原煤单价不合法")
    @ApiModelProperty(value = "原煤单价")
    @TableField("rawCoalPrice")
    private BigDecimal rawCoalPrice;

    @NotNull(message = "全硫不合法")
    @ApiModelProperty(value = "全硫")
    @TableField("sulfurContent")
    private BigDecimal sulfurContent;

    @NotBlank(message = "产地不合法")
    @ApiModelProperty(value = "产地")
    @TableField("producingArea")
    private String producingArea;

    @NotNull(message = "运费单价不合法")
    @ApiModelProperty(value = "运费单价")
    @TableField("itemPrice")
    private BigDecimal itemPrice;

    @NotNull(message = "挥发分不合法")
    @ApiModelProperty(value = "挥发分")
    @TableField("volatileQuantity")
    private BigDecimal volatileQuantity;

    @NotBlank(message = "发货港口不合法")
    @ApiModelProperty(value = "发货港口")
    private String port;

    @NotNull(message = "空干基灰分不合法")
    @ApiModelProperty(value = "空干基灰分")
    private BigDecimal aad;

    @NotNull(message = "全水分不合法")
    @ApiModelProperty(value = "全水分")
    @TableField("totalMoisture")
    private BigDecimal totalMoisture;


}
