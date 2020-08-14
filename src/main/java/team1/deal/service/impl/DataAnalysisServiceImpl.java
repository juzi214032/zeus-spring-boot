package team1.deal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team1.deal.dao.DataAnalysisDao;
import team1.deal.model.vo.ResponseVO;
import team1.deal.service.DataAnalysisService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DataAnalysisServiceImpl implements DataAnalysisService {

    @Autowired
    private DataAnalysisDao dataAnalysisDao;

    /**
     * 返回阳光用户数量
     * @return
     */
    public long getSunUserNumber() {
        return dataAnalysisDao.countSunUserNumber();
    }

    //需求订单已经通过审核审批的数量
    @Override
    public long getContDemand() {
        return dataAnalysisDao.countDemandNumber();
    }

    //所有需求订单采购数量总量
    @Override
    public long ContDemandProcurement() {
        if (dataAnalysisDao.countDemandNumber()!=0){
            return dataAnalysisDao.CountDemandProcurement();
        }
        return 0;
    }

    //总交易额
    @Override
    public long totalvolume() {
        if (dataAnalysisDao.countQuotedPriceNumber()!=0){
            return dataAnalysisDao.totalvolume();
        }
        return 0;
    }

    //折线图,各种煤的总量集合
    @Override
    public Map<String, Object> aggregateOfAllKindsOfCoal() {
        Map<String,Object> map = new HashMap<>();
        if (dataAnalysisDao.existOrNotExist("煤种1")!=0){
            map.put("煤种1",dataAnalysisDao.KindsOfCoal("煤种1"));
        }if (dataAnalysisDao.existOrNotExist("煤种2")!=0){
            map.put("煤种2",dataAnalysisDao.KindsOfCoal("煤种2"));
        }if (dataAnalysisDao.existOrNotExist("煤种3")!=0){
            map.put("煤种3",dataAnalysisDao.KindsOfCoal("煤种3"));
        }
        return map;
    }

}
