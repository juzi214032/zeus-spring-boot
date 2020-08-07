package team1.deal.service;

import team1.deal.model.po.QuotedPriceInfoPO;
import team1.deal.model.po.SaveQuotedPriceInfoPO;

public interface CreatQuotedPriceService {

    //创建报价
    public void CreatQuotedPrice(QuotedPriceInfoPO quotedPriceInfoPO);

    //保存报价
    public void SaveQuotedPrice(SaveQuotedPriceInfoPO saveQuotedPriceInfoPO);


}
