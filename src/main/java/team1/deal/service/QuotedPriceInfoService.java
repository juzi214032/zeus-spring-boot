package team1.deal.service;

import team1.deal.model.po.DemandOrderPO;
import team1.deal.model.po.QuotedPriceInfoPO;
import com.baomidou.mybatisplus.extension.service.IService;
import team1.deal.model.vo.QuotedPriceBriefInfoVO;
import team1.deal.model.vo.QuotedPriceInfoVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author team1
 * @since 2020-08-05
 */
public interface QuotedPriceInfoService extends IService<QuotedPriceInfoPO> {
    List<QuotedPriceBriefInfoVO> getQuotedBriefList(Integer userId);

    DemandOrderPO getDemandOrder(Integer quotedId);

    QuotedPriceInfoVO getQuotedInfoVO(Integer quotedId);
}
