package team1.deal.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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

        //判断保存表中有无已保存的数据，有则删除旧，保存新的
        QueryWrapper wrapper = new QueryWrapper();
        SaveDemandOrderPO saveDemandOrderPO1 = saveDemandOrderMapper.selectOne(wrapper);
        if (saveDemandOrderPO1!=null){
            //删除旧数据
            saveDemandOrderMapper.deleteById(saveDemandOrderPO1.getId());
        }
        saveDemandOrderMapper.insert(saveDemandOrderPO);
    }


}
