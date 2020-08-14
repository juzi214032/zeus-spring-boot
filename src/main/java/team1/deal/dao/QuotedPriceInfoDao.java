package team1.deal.dao;

import org.apache.ibatis.annotations.Param;
import team1.deal.model.po.DemandOrderPO;
import team1.deal.model.vo.QuotedPriceBriefInfoVO;

import java.util.List;

public interface QuotedPriceInfoDao {
    DemandOrderPO getDemandOrder(@Param("id") Integer id);

    List<QuotedPriceBriefInfoVO> getQuotedPriceBriefInfo(@Param("id") Integer userId,@Param("status")Integer status);

}
