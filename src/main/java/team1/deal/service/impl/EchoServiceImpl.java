package team1.deal.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team1.deal.dao.UserDao;
import team1.deal.mapper.DemandOrderMapper;
import team1.deal.mapper.SaveDemandOrderMapper;
import team1.deal.mapper.SaveQuotedPriceInfoMapper;
import team1.deal.model.po.DemandOrderPO;
import team1.deal.model.po.SaveDemandOrderPO;
import team1.deal.model.po.SaveQuotedPriceInfoPO;
import team1.deal.model.vo.DemandOrderInfoVO;
import team1.deal.service.EchoService;

import java.sql.Wrapper;
import java.util.ArrayList;
import java.util.List;

@Service
public class EchoServiceImpl implements EchoService {
    @Autowired
    private DemandOrderMapper demandOrderMapper;
    @Autowired
    private UserDao userDao;
    @Autowired
    private SaveDemandOrderMapper saveDemandOrderMapper;
    @Autowired
    private SaveQuotedPriceInfoMapper saveQuotedPriceInfoMapper;


    //获取待审核订单
    public List<DemandOrderInfoVO> getToAudit(Integer userId){
        //获取用户所在部门
        String dept = userDao.getUserDept(userId).getDeptName();
        //获取用户所拥有的权限id
        List<String> authorityList = new ArrayList<>();
        userDao.getUserAuthority(userId).forEach(s->{
            authorityList.add(s.getAuthority());
        });
        QueryWrapper<DemandOrderPO> wrapper =new QueryWrapper<>();
        //接下来根据部门和权限做出相应的回应
        if (authorityList.contains("提出需求")&&dept.equals("电厂")){
            return changeToVO(demandOrderMapper.selectList(wrapper));
        }else if (authorityList.contains("审核")&&dept.equals("电厂")){
            wrapper.eq("status",0);
            return changeToVO(demandOrderMapper.selectList(wrapper));
        }else if (authorityList.contains("审批")&&dept.equals("电厂")){
            wrapper.eq("status",1);
            return changeToVO(demandOrderMapper.selectList(wrapper));
        }else if (authorityList.contains("审核")&&dept.equals("子公司")){
            wrapper.eq("status",2);
            return changeToVO(demandOrderMapper.selectList(wrapper));
        }else if (authorityList.contains("审批")&&dept.equals("子公司")){
            wrapper.eq("status",3);
            return changeToVO(demandOrderMapper.selectList(wrapper));
        }else {
            wrapper.eq("status",4);
            return changeToVO(demandOrderMapper.selectList(wrapper));
        }
    }


    //保存需求订单回显
    @Override
    public SaveDemandOrderPO SaveDemandEcho() {
        //在保存订单的数据中，在某一时刻只能最多保存一个
        QueryWrapper wrapper = new QueryWrapper();
        return saveDemandOrderMapper.selectOne(wrapper);
    }

    //保存报价订单回显
    @Override
    public SaveQuotedPriceInfoPO SaveQuotedPriceEcho() {
        QueryWrapper wrapper = new QueryWrapper();
        return saveQuotedPriceInfoMapper.selectOne(wrapper);
    }

    //订单类转返回消息
    private List<DemandOrderInfoVO> changeToVO(List<DemandOrderPO> list){
        List<DemandOrderInfoVO> voList = new ArrayList<>();
        list.forEach(s->{
            DemandOrderInfoVO demandOrderInfoVO = new DemandOrderInfoVO();
            BeanUtils.copyProperties(s, demandOrderInfoVO);
            demandOrderInfoVO.setReceiptNumber(demandOrderInfoVO.getApplyUnit() + "-" + demandOrderInfoVO.getApplyTime().toLocalDate());
            voList.add(demandOrderInfoVO);
        });
        return voList;
    }
}
