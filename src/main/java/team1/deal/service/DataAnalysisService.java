package team1.deal.service;

import team1.deal.model.dto.DispatchDestinationDTO;
import team1.deal.model.vo.ResponseVO;

<<<<<<< HEAD
import java.util.List;
=======
import java.time.LocalDateTime;
>>>>>>> d2c5ad01fad5e46ca9fa9b9d50b8a3ec9e90457c
import java.util.Map;

public interface DataAnalysisService {
    //阳光用户数量统计
    long getSunUserNumber();

    //需求订单已经通过审核审批的数量统计
    public long getContDemand();

    //所有需求订单采购数量总量
    public long contDemandProcurement();

    //总交易额统计
    public long totalvolume();

    //折线图,各种煤的总量统计
    public Map<String,Object> aggregateOfAllKindsOfCoal();

    //运输方式统计
    public Map<String,Object> modeOfTransportStatistics();

    //地区煤炭分布统计
    public Map<String,Object> regionalCoalDistribution();

    //关注程度统计
    public Map<String,Object> attention();

<<<<<<< HEAD
    //煤炭流向统计
    public Map<Object,Object> coalFlowStatistics();

=======
    //本周新增需求订单
    long increaseOfDemand();

    //本周新增采购数量
    long increaseOfDemandProcurement();

    //最近新增阳光用户时间
    LocalDateTime getInsertRecentTime();
>>>>>>> d2c5ad01fad5e46ca9fa9b9d50b8a3ec9e90457c

}