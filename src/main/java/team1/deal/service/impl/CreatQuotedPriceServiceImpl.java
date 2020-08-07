package team1.deal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team1.deal.mapper.QuotedPriceInfoMapper;
import team1.deal.mapper.SaveQuotedPriceInfoMapper;
import team1.deal.model.po.QuotedPriceInfoPO;
import team1.deal.model.po.SaveQuotedPriceInfoPO;
import team1.deal.service.CreatQuotedPriceService;

@Service
public class CreatQuotedPriceServiceImpl implements CreatQuotedPriceService {

    @Autowired
    private QuotedPriceInfoMapper quotedPriceInfoMapper;
    @Autowired
    private SaveQuotedPriceInfoMapper saveQuotedPriceInfoMapper;

    //创建报价
    @Override
    public void CreatQuotedPrice(QuotedPriceInfoPO quotedPriceInfoPO) {
        //设置报价订单的状态
        quotedPriceInfoPO.setStatus(0);
        //将报价订单的id设置为null,防止保存的id与提交后的id冲突
        quotedPriceInfoPO.setId(null);

        quotedPriceInfoMapper.insert(quotedPriceInfoPO);
    }

    //保存报价
    @Override
    public void SaveQuotedPrice(SaveQuotedPriceInfoPO saveQuotedPriceInfoPO) {
        //设置报价订单的状态
        saveQuotedPriceInfoPO.setStatus(-2);
        /**
         * 判断在数据库中该数据是否已经存在
         * 存在则修改保存
         * 不存在则创建新保存
         */
        if (saveQuotedPriceInfoMapper.selectById(saveQuotedPriceInfoPO.getId())!=null){
            saveQuotedPriceInfoMapper.updateById(saveQuotedPriceInfoPO);
        }else {
            //将报价订单保存的id设置为null
            saveQuotedPriceInfoPO.setId(null);
            saveQuotedPriceInfoMapper.insert(saveQuotedPriceInfoPO);
        }
    }
}
