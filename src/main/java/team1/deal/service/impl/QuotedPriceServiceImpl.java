package team1.deal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team1.deal.mapper.QuotedPriceInfoMapper;
import team1.deal.model.po.QuotedPriceInfoPO;
import team1.deal.service.QuotedPriceService;

@Service
public class QuotedPriceServiceImpl implements QuotedPriceService {

    @Autowired
    private QuotedPriceInfoMapper quotedPriceInfoMapper;


    //报价审核通过
    @Override
    public void auditAllow(QuotedPriceInfoPO quotedPriceInfoPO) {
        quotedPriceInfoPO.setStatus(quotedPriceInfoPO.getStatus()+1);
        //将修改的结果存入数据库
        quotedPriceInfoMapper.updateById(quotedPriceInfoPO);
    }

    //报价审核不通过
    @Override
    public void auditFailure(QuotedPriceInfoPO quotedPriceInfoPO) {
        quotedPriceInfoPO.setStatus(-1);
        //将修改的结果存入数据库
        quotedPriceInfoMapper.updateById(quotedPriceInfoPO);
    }

    //报价审批通过
    @Override
    public void approvalAllow(QuotedPriceInfoPO quotedPriceInfoPO) {
        quotedPriceInfoPO.setStatus(quotedPriceInfoPO.getStatus()+1);
        //将修改的结果存入数据库
        quotedPriceInfoMapper.updateById(quotedPriceInfoPO);
    }

    //报价审批不通过
    @Override
    public void approvalFailure(QuotedPriceInfoPO quotedPriceInfoPO) {
        quotedPriceInfoPO.setStatus(-1);
        //将修改的结果存入数据库
        quotedPriceInfoMapper.updateById(quotedPriceInfoPO);
    }
}
