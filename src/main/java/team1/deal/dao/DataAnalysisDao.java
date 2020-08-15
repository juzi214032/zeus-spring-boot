package team1.deal.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import java.time.LocalDate;

public interface DataAnalysisDao {
    //阳光用户数量
    public long countSunUserNumber();

    //状态为3的报价订单总数
    public long countQuotedPriceNumber();

    //需求订单已经通过审核审批的数量
    public long countDemandNumber();

    //所有需求订单采购数量总量
    public long countDemandProcurement();

    //总交易额
    public long totalvolume();

    //某一种煤的总量
    public long kindsOfCoal(String coalType);

    //某一种煤有没有
    public long existOrNotExist(String coalType);

    //运输方式统计
    public long modeOfTransportStatistics(String transportType);

    //地区煤炭分布统计
    public long regionalCoalDistribution(String producingArea);

    //查询一共有哪些产地
    public List<String> region();

    //关注程度统计
    public long attention(Integer did);

    //获取全都需求订单的id号
    public List<Integer> getDemandIds();

    //本周新增需求订单
    long increaseOfDemand(@Param("monday") LocalDate monday, @Param("sunday")LocalDate sunday);

    //本周新增采购数量
    long increaseOfDemandProcurement(@Param("monday") LocalDate monday, @Param("sunday")LocalDate sunday);

}
