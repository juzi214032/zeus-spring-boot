package team1.deal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team1.deal.dao.DataAnalysisDao;
import team1.deal.model.vo.ResponseVO;
import team1.deal.service.DataAnalysisService;

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

}
