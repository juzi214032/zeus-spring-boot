package team1.deal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import team1.deal.dao.DataAnalysisDao;
import team1.deal.service.DataAnalysisService;

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

}
