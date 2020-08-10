package team1.deal.model.po;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author team1
 * @since 2020-08-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("contract")
@ApiModel(value="ContractPO对象", description="")
public class ContractPO implements Serializable {


    @ApiModelProperty(value = "交易合同编号")
    @TableId(value = "transactionContractNumber", type = IdType.AUTO)
    private Integer transactionContractNumber;

    @ApiModelProperty(value = "签署日期")
    @TableField("signDate")
    private LocalDateTime signDate;

    @ApiModelProperty(value = "需求表单id")
    @TableField("dId")
    private Integer dId;

    @ApiModelProperty(value = "报价表单id")
    @TableField("qId")
    private Integer qId;

    @ApiModelProperty(value = "签约价格")
    private BigDecimal price;

    @ApiModelProperty(value = "签约量")
    private Integer amount;

    @ApiModelProperty(value = "合同状态，0：合同创建状态，1：合同完善状态（写合同+保存合同+签合同），2：合同完成状态")
    private Integer status;

    @ApiModelProperty(value = "合同附件保存的url")
    private String url;


}
