package team1.deal.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import team1.deal.model.dto.DispatchDestinationDTO;
import team1.deal.model.vo.CoalYearNameGdpVO;
import team1.deal.model.vo.RadarMapVO;
import team1.deal.model.vo.TransportInformationVO;

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

    //折线图
    public List<CoalYearNameGdpVO> kindsOfCoal();


    //某一种煤有没有
    public long existOrNotExist(String coalType);

    //运输方式统计
    public List<TransportInformationVO> modeOfTransportStatistics();


    //地区煤炭分布统计,根据地区和煤种
    public long regionalCoalDistribution(String producingArea,String coalType);

    //查询一共有哪些产地
    public List<String> region();

    //查询某个地区有哪些煤种
    public List<String> CoallistbyProducingArea(String producingArea);

    //雷达图
    public List<RadarMapVO> attention();

    //查询出发送地-目的地
    public List<DispatchDestinationDTO> getDispatchDestinationDTO();


    //本周新增需求订单
    long increaseOfDemand(@Param("monday") LocalDate monday, @Param("sunday")LocalDate sunday);

    //本周新增采购数量
    long increaseOfDemandProcurement(@Param("monday") LocalDate monday, @Param("sunday")LocalDate sunday);

    //获取最近一次新加入的阳光用户时间
    LocalDateTime selectRecentTime();
}
