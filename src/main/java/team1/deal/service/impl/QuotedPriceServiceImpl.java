package team1.deal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team1.deal.mapper.QuotedPriceInfoMapper;
import team1.deal.model.dto.QuotedPriceInfoPOListDTO;
import team1.deal.model.po.QuotedPriceInfoPO;
import team1.deal.model.vo.ResponseVO;
import team1.deal.service.QuotedPriceService;

import java.util.List;

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

    //*************************************************************************

    //报价批量审核通过
    @Transactional
    @Override
    public void batchauditAllow(QuotedPriceInfoPOListDTO quotedPriceInfoPOListDTO) {
        for (QuotedPriceInfoPO quotedPriceInfoPO:quotedPriceInfoPOListDTO.getQuotedPriceInfoPOList()){
            quotedPriceInfoPO.setStatus(quotedPriceInfoPO.getStatus()+1);
            //将修改的结果存入数据库
            quotedPriceInfoMapper.updateById(quotedPriceInfoPO);
        }
    }

    //报价批量审核不通过
    @Transactional
    @Override
    public void batchauditFailure(QuotedPriceInfoPOListDTO quotedPriceInfoPOListDTO) {
        for (QuotedPriceInfoPO quotedPriceInfoPO:quotedPriceInfoPOListDTO.getQuotedPriceInfoPOList()){
            quotedPriceInfoPO.setStatus(-1);
            //将修改的结果存入数据库
            quotedPriceInfoMapper.updateById(quotedPriceInfoPO);
        }
    }

    //报价批量审批通过
    @Transactional
    @Override
    public void batchapprovalAllow(QuotedPriceInfoPOListDTO quotedPriceInfoPOListDTO) {
        for (QuotedPriceInfoPO quotedPriceInfoPO:quotedPriceInfoPOListDTO.getQuotedPriceInfoPOList()){
            quotedPriceInfoPO.setStatus(quotedPriceInfoPO.getStatus()+1);
            //将修改的结果存入数据库
            quotedPriceInfoMapper.updateById(quotedPriceInfoPO);
        }
    }

    //报价批量审批不通过3
    @Transactional
    @Override
    public void batchapprovalFailure(QuotedPriceInfoPOListDTO quotedPriceInfoPOListDTO) {
        for (QuotedPriceInfoPO quotedPriceInfoPO:quotedPriceInfoPOListDTO.getQuotedPriceInfoPOList()){
            quotedPriceInfoPO.setStatus(-1);
            //将修改的结果存入数据库
            quotedPriceInfoMapper.updateById(quotedPriceInfoPO);
        }
    }



}
