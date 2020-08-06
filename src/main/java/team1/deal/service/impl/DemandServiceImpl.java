package team1.deal.service.impl;
import org.springframework.stereotype.Service;
import team1.deal.model.po.DemandOrderPO;
import team1.deal.service.DemandService;

@Service
public class DemandServiceImpl implements DemandService {


    //审核通过
    @Override
    public void auditAllow(DemandOrderPO demandOrderPO) {
        demandOrderPO.setStatus(demandOrderPO.getStatus()+1);
    }

    //审核不通过
    @Override
    public void auditFailure(DemandOrderPO demandOrderPO) {
        demandOrderPO.setStatus(-1);
    }

    //审批通过
    @Override
    public void approvalAllow(DemandOrderPO demandOrderPO){
        demandOrderPO.setStatus(demandOrderPO.getStatus()+1);
    }

    //审批不通过
    @Override
    public void approvalFailure(DemandOrderPO demandOrderPO){
        demandOrderPO.setStatus(-1);
    }






}
