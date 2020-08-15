package team1.deal.service;

import team1.deal.model.vo.ResponseVO;

import java.util.Map;

public interface DataAnalysisService {
    //阳光用户数量统计
    long getSunUserNumber();

    //需求订单已经通过审核审批的数量统计
    public long getContDemand();

    //所有需求订单采购数量总量统计
    public long ContDemandProcurement();

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


}