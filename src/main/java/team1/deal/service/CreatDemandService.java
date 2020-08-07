package team1.deal.service;

import team1.deal.model.po.DemandOrderPO;
import team1.deal.model.po.SaveDemandOrderPO;

public interface CreatDemandService {

    //创建需求
    public void CreatDemand(DemandOrderPO demandOrderPO);

    //保存需求
    public void SaveDemand(SaveDemandOrderPO saveDemandOrderPO);


}
