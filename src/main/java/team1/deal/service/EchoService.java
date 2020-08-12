package team1.deal.service;

import team1.deal.model.vo.DemandOrderInfoVO;

import java.util.List;

public interface EchoService {

     List<DemandOrderInfoVO> getToAudit(Integer userId);

}
