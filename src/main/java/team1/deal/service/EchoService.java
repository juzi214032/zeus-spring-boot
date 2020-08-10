package team1.deal.service;

import team1.deal.model.po.DemandOrderPO;

import java.util.List;

public interface EchoService {

    //根据status获取对应的列表
    public List<DemandOrderPO> get_by_status(Integer status);

}
