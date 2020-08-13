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
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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

    @Range(min = 1,message = "需求订单id不合法")
    @ApiModelProperty(value = "需求表单id")
    @TableField("dId")
    private Integer dId;

    @Range(min = 1,message = "报价表单id不合法")
    @ApiModelProperty(value = "报价表单id")
    @TableField("qId")
    private Integer qId;

    @NotNull(message = "签约价格不合法")
    @ApiModelProperty(value = "签约价格")
    private BigDecimal price;

    @Range(min = 1,message = "签约量不合法")
    @ApiModelProperty(value = "签约量")
    private Integer amount;

    @Range(min = 0,max = 1,message = "合同状态不合法")
    @ApiModelProperty(value = "合同状态，0：合同创建状态，1：合同完成状态")
    private Integer status;

    @NotBlank(message = "必须上传合同")
    @ApiModelProperty(value = "合同附件保存的url")
    private String url;


}
