package team1.deal.service;

import team1.deal.model.vo.ResponseVO;

public interface DataAnalysisService {
    long getSunUserNumber();

    //需求订单已经通过审核审批的数量
    public long getContDemand();

    //所有需求订单采购数量总量
    public long ContDemandProcurement();

    //总交易额
    public long totalvolume();



}