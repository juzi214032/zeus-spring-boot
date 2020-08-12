package team1.deal.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team1.deal.dao.UserDao;
import team1.deal.mapper.DemandOrderMapper;
import team1.deal.model.po.DemandOrderPO;
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

    //获取待审核订单
    public List<DemandOrderInfoVO> getToAudit(Integer userId){
        //获取用户所在部门id
        Integer deptId = userDao.getUserDept(userId).getId();
        //获取用户所拥有的权限id
        List<Integer> authorityIds = new ArrayList<>();
        userDao.getUserAuthority(userId).forEach(s->{
            authorityIds.add(s.getId());
        });
        LambdaQueryWrapper<DemandOrderPO> lambdaQueryWrapper =new LambdaQueryWrapper();
        List<DemandOrderPO> poList;
        //如果是电厂人员
        if (deptId == 1){
            for (Integer i :authorityIds) {
                //如果是电厂部门的监察人员
                if (i == 1){
                    poList = demandOrderMapper.selectList(lambdaQueryWrapper.eq(DemandOrderPO::getStatus,0));
                    return changeToVO(poList);
                }
                //如果是电产部门的管理人员
                if (i == 2){
                    poList = demandOrderMapper.selectList(lambdaQueryWrapper.eq(DemandOrderPO::getStatus,1));
                    return changeToVO(poList);
                }
            }
        }
        //如果是分公司人员
        if (deptId == 2){
            for (Integer i :authorityIds) {
                //如果是分公司的监察人员
                if (i == 1){
                    poList = demandOrderMapper.selectList(lambdaQueryWrapper.eq(DemandOrderPO::getStatus,2));
                    return changeToVO(poList);
                }
                //如果是分公司的管理人员
                if (i == 2){
                    poList = demandOrderMapper.selectList(lambdaQueryWrapper.eq(DemandOrderPO::getStatus,3));
                    return changeToVO(poList);
                }
            }
        }
        return null;
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
