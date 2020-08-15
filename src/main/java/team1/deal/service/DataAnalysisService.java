package team1.deal.service;

import team1.deal.model.vo.ResponseVO;

import java.util.Map;

public interface DataAnalysisService {
    long getSunUserNumber();

    //需求订单已经通过审核审批的数量
    public long getContDemand();

    //所有需求订单采购数量总量
    public long ContDemandProcurement();

    //总交易额
    public long totalvolume();

    //折线图,各种煤的总量集合
    public Map<String,Object> aggregateOfAllKindsOfCoal();

    //运输方式统计
    public Map<String,Object> modeOfTransportStatistics();


}