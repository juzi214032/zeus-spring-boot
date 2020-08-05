package team1.deal.model.po;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
@TableName("quotedpriceinfo")
public class QuotedpriceinfoPO implements Serializable {


    /**
     * 表单id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 需求订单id
     */
    @TableField("dId")
    private Integer dId;

    /**
     * 供应商id（在user表中）
     */
    @TableField("uId")
    private Integer uId;

    /**
     * 状态代码（0：待审核状态，1：电厂一级审核通过状态，2：电厂二级审核通过状态，
     *3：子公司一级审核通过状态，4：一级审核通过状态，5：完成状态
 ，-1：出局状态
     */
    private Integer status;

    /**
     * 供货量
     */
    @TableField("supplyQuantity")
    private Integer supplyQuantity;

    /**
     * 热值
     */
    @TableField("calorificValue")
    private Integer calorificValue;

    /**
     * 原煤单价
     */
    @TableField("rawCoalPrice")
    private BigDecimal rawCoalPrice;

    /**
     * 全硫
     */
    @TableField("sulfurContent")
    private BigDecimal sulfurContent;

    /**
     * 产地
     */
    @TableField("producingArea")
    private String producingArea;

    /**
     * 运费单价
     */
    @TableField("itemPrice")
    private BigDecimal itemPrice;

    /**
     * 挥发分
     */
    @TableField("volatileQuantity")
    private BigDecimal volatileQuantity;

    /**
     * 发货港口
     */
    private String port;

    /**
     * 空干基灰分
     */
    private BigDecimal aad;

    /**
     * 全水分
     */
    @TableField("totalMoisture")
    private BigDecimal totalMoisture;


}
