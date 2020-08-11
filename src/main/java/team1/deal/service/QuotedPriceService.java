package team1.deal.service;

import team1.deal.model.dto.QuotedPriceInfoPOListDTO;
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


    //***************************************************************

    //报价批量审核通过
    public void batchauditAllow(QuotedPriceInfoPOListDTO quotedPriceInfoPOListDTO);

    //报价批量审核不通过
    public void batchauditFailure(QuotedPriceInfoPOListDTO quotedPriceInfoPOListDTO);

    //报价批量审批通过
    public void batchapprovalAllow(QuotedPriceInfoPOListDTO quotedPriceInfoPOListDTO);

    //报价批量审批不通过
    public void batchapprovalFailure(QuotedPriceInfoPOListDTO quotedPriceInfoPOListDTO);


}
