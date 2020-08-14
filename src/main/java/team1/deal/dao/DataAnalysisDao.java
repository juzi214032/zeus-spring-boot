package team1.deal.dao;

public interface DataAnalysisDao {
    //阳光用户数量
    public long countSunUserNumber();

    //需求订单已经通过审核审批的数量
    public long countDemandNumber();

    //所有需求订单采购数量总量
    public long CountDemandProcurement();

    //总交易额
    public long totalvolume();



}
