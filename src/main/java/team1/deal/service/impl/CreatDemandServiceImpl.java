package team1.deal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team1.deal.mapper.DemandOrderMapper;
import team1.deal.mapper.SaveDemandOrderMapper;
import team1.deal.model.po.DemandOrderPO;
import team1.deal.model.po.SaveDemandOrderPO;
import team1.deal.service.CreatDemandService;

@Service
public class CreatDemandServiceImpl implements CreatDemandService {

    @Autowired
    private DemandOrderMapper demandOrderMapper;
    @Autowired
    private SaveDemandOrderMapper saveDemandOrderMapper;


    //创建需求
    @Override
    public void CreatDemand(DemandOrderPO demandOrderPO) {
        //设置需求订单的状态
        demandOrderPO.setStatus(0);
        //将需求订单的id设置为null,防止保存的id与提交后的id冲突
        demandOrderPO.setId(null);

        demandOrderMapper.insert(demandOrderPO);
    }


    //保存需求
    @Override
    public void SaveDemand(SaveDemandOrderPO saveDemandOrderPO) {
        //设置需求订单的状态为-2代表没有
        saveDemandOrderPO.setStatus(-2);
        //将需求订单保存的id设置为null
        saveDemandOrderPO.setId(null);

        saveDemandOrderMapper.insert(saveDemandOrderPO);
    }


}
