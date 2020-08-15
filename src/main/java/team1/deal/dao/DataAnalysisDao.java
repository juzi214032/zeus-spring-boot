package team1.deal.dao;

public interface DataAnalysisDao {
    //阳光用户数量
    public long countSunUserNumber();

    //状态为3的报价订单总数
    public long countQuotedPriceNumber();

    //需求订单已经通过审核审批的数量
    public long countDemandNumber();

    //所有需求订单采购数量总量
    public long CountDemandProcurement();

    //总交易额
    public long totalvolume();

    //某一种煤的总量
    public long KindsOfCoal(String coalType);

    //某一种煤有没有
    public long existOrNotExist(String coalType);

    //运输方式统计
    public long modeOfTransportStatistics(String transportType);



}
