package team1.deal.service;

import org.springframework.web.bind.annotation.RequestPart;
import team1.deal.model.po.QuotedPriceInfoPO;

public interface QuotedPriceService {

    //报价审核通过
    public void auditAllow(QuotedPriceInfoPO quotedPriceInfoPO);

    //报价审核不通过
    public void auditFailure(QuotedPriceInfoPO quotedPriceInfoPO);

    //报价审批通过
    public void approvalAllow(QuotedPriceInfoPO quotedPriceInfoPO);

    //报价审批不通过
    public void approvalFailure(QuotedPriceInfoPO quotedPriceInfoPO);

}
