package team1.deal.service;

import team1.deal.model.po.DemandOrderPO;

public interface DemandService {

    //审核通过
    public void auditAllow(DemandOrderPO demandOrderPO);

    //审核不通过
    public void auditFailure(DemandOrderPO demandOrderPO);

    //审批通过
    public void approvalAllow(DemandOrderPO demandOrderPO);

    //审批不通过
    public void approvalFailure(DemandOrderPO demandOrderPO);
}
