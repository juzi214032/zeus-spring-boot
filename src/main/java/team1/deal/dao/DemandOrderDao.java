package team1.deal.dao;

import org.apache.ibatis.annotations.Param;
import team1.deal.model.po.QuotedPriceInfoPO;

import java.util.List;

public interface DemandOrderDao {

    //根据订单id获取所有的报价信息
     List<QuotedPriceInfoPO> getQuotedPriceInfoList(@Param("id") Integer id);

}
