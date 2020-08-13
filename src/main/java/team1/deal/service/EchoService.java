package team1.deal.service;

import team1.deal.model.po.SaveDemandOrderPO;
import team1.deal.model.po.SaveQuotedPriceInfoPO;
import team1.deal.model.vo.DemandOrderInfoVO;

import java.util.List;

public interface EchoService {

     List<DemandOrderInfoVO> getToAudit(Integer userId);

     //保存需求订单回显
     public SaveDemandOrderPO SaveDemandEcho();

     //保存报价订单回显
     public SaveQuotedPriceInfoPO SaveQuotedPriceEcho();

}
