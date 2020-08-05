package team1.deal.model.po;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
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
@TableName("demandorder")
public class DemandorderPO implements Serializable {


    /**
     * 需求订单id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户id
     */
    @TableField("uId")
    private Integer uId;

    /**
     * 状态代码（0：待审核状态，1：电厂一级审核通过状态，2：电厂二级审核通过状态，3：子公司一级审核通过状态，4：一级审核通过状态，5完成状态，-1：待修改状态
     */
    private Integer status;

    /**
     * 审核意见
     */
    private String idea;

    /**
     * 报价截止时间
     */
    @TableField("lastTime")
    private LocalDateTime lastTime;

    /**
     * 申请单位
     */
    @TableField("applyUnit")
    private String applyUnit;

    /**
     * 申请日期
     */
    @TableField("applyTime")
    private LocalDateTime applyTime;

    /**
     * 交货日期
     */
    @TableField("deliveryTime")
    private LocalDateTime deliveryTime;

    /**
     * 煤炭种类
     */
    @TableField("coalType")
    private String coalType;

    /**
     * 采购数量
     */
    @TableField("coalNumber")
    private Integer coalNumber;

    /**
     * 运输方式
     */
    @TableField("transportType")
    private String transportType;

    /**
     * 交货地点
     */
    @TableField("deliveryPlace")
    private String deliveryPlace;

    /**
     * 结算方式
     */
    @TableField("paymentType")
    private String paymentType;

    /**
     * 验收方式
     */
    @TableField("checkType")
    private String checkType;

    /**
     * 最高限价，不能为空
     */
    @TableField("maxPrice")
    private BigDecimal maxPrice;

    /**
     * 最低限价,可以为空
     */
    @TableField("minPrice")
    private BigDecimal minPrice;

    /**
     * 限价说明
     */
    @TableField("priceDescription")
    private String priceDescription;

    /**
     * 每吨煤,报价保证金额
     */
    @TableField("offerMargin")
    private BigDecimal offerMargin;

    /**
     * 每吨煤,执行保证金额
     */
    @TableField("performMargin")
    private BigDecimal performMargin;

    /**
     * 热值
     */
    @TableField("calorificValue")
    private BigDecimal calorificValue;

    /**
     * 全硫
     */
    @TableField("sulfurContent")
    private BigDecimal sulfurContent;

    /**
     * 挥发分
     */
    @TableField("volatileQuantity")
    private BigDecimal volatileQuantity;

    /**
     * 空干基灰分
     */
    private BigDecimal aad;


}
