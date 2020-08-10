package team1.deal.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team1.deal.mapper.DemandOrderMapper;
import team1.deal.model.po.DemandOrderPO;
import team1.deal.service.EchoService;

import java.util.List;

@Service
public class EchoServiceImpl implements EchoService {

    @Autowired
    private DemandOrderMapper demandOrderMapper;


    //根据status获取对应的列表
    public List<DemandOrderPO> get_by_status(Integer status){
        QueryWrapper wrapper = new QueryWrapper();
        if (status == 0){
            wrapper.eq("status",0);
            return demandOrderMapper.selectList(wrapper);
        }else if (status == 1){
            wrapper.eq("status",1);
            return demandOrderMapper.selectList(wrapper);
        }else if (status == 2){
            wrapper.eq("status",2);
            return demandOrderMapper.selectList(wrapper);
        }else if (status == 3){
            wrapper.eq("status",3);
            return demandOrderMapper.selectList(wrapper);
        }else if (status == 4){
            wrapper.eq("status",4);
            return demandOrderMapper.selectList(wrapper);
        }
        wrapper.eq("status",5);
        return demandOrderMapper.selectList(wrapper);
    }
}
