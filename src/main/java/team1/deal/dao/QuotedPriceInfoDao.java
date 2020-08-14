package team1.deal.dao;

import org.apache.ibatis.annotations.Param;
import team1.deal.model.po.DemandOrderPO;

public interface QuotedPriceInfoDao {
    DemandOrderPO getDemandOrder(@Param("id") Integer id);
}
