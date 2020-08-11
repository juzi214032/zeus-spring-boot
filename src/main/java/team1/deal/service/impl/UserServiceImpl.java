package team1.deal.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import team1.deal.dao.UserDao;
import team1.deal.mapper.QuotedPriceInfoMapper;
import team1.deal.model.po.QuotedPriceInfoPO;
import team1.deal.model.po.UserPO;
import team1.deal.mapper.UserMapper;
import team1.deal.model.vo.QuotedPriceInfoVO;
import team1.deal.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author team1
 * @since 2020-08-05
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserPO> implements UserService {
    @Autowired
    private QuotedPriceInfoMapper quotedPriceInfoMapper;

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserMapper userMapper;


    /**根据部门和权限，返回供应商列表
     * 在这里模拟的id和对应的值
     * 部门
     * 1     电厂
     * 2     分公司
     * 权限
     * 1      审核
     * 2      审批
     */
    public List<QuotedPriceInfoVO> selectSupplier(Integer userId){
        //获取用户所在部门id
        Integer deptId = userDao.getUserDept(userId).getId();
        //获取用户所拥有的权限id
        List<Integer> authorityIds = new ArrayList<>();
        userDao.getUserAuthority(userId).forEach(s->{
            authorityIds.add(s.getId());
        });
        List<QuotedPriceInfoPO> poList;
        //如果是电厂人员
        if (deptId == 1){
            for (Integer i :authorityIds) {
                //如果是电厂部门的监察人员
                if (i == 1){
                    poList = quotedPriceInfoMapper.selectList(new LambdaQueryWrapper<QuotedPriceInfoPO>().eq(QuotedPriceInfoPO::getStatus,0));
                    return changeToVO(poList);
                }
                //如果是电产部门的管理人员
                if (i == 2){
                    poList = quotedPriceInfoMapper.selectList(new LambdaQueryWrapper<QuotedPriceInfoPO>().eq(QuotedPriceInfoPO::getStatus,1));
                    return changeToVO(poList);
                }
            }
        }
        //如果是分公司人员
        if (deptId == 2){
            for (Integer i :authorityIds) {
                //如果是分公司的监察人员
                if (i == 1){
                    poList = quotedPriceInfoMapper.selectList(new LambdaQueryWrapper<QuotedPriceInfoPO>().eq(QuotedPriceInfoPO::getStatus,2));
                    return changeToVO(poList);
                }
                //如果是分公司的管理人员
                if (i == 2){
                    poList = quotedPriceInfoMapper.selectList(new LambdaQueryWrapper<QuotedPriceInfoPO>().eq(QuotedPriceInfoPO::getStatus,3));
                    return changeToVO(poList);
                }
            }
        }
        return null;
    }

    //订单类转返回消息
    private List<QuotedPriceInfoVO> changeToVO(List<QuotedPriceInfoPO> list){
        List<QuotedPriceInfoVO> voList = new ArrayList<>();
        list.forEach(s->{
            QuotedPriceInfoVO quotedPriceInfoVO = new QuotedPriceInfoVO();
            BeanUtils.copyProperties(s,quotedPriceInfoVO);
            quotedPriceInfoVO.setName(userMapper.selectById(s.getUId()).getName());
            quotedPriceInfoVO.setType("临时供应商");
            voList.add(quotedPriceInfoVO);
        });
        return voList;
    }
}
