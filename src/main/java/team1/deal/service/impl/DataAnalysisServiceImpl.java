package team1.deal.service.impl;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team1.deal.dao.DataAnalysisDao;
import team1.deal.dao.QuotedPriceInfoDao;
import team1.deal.mapper.CityMapper;
import team1.deal.model.dto.DispatchDestinationDTO;
import team1.deal.model.dto.LatitudeAndIongitudeAndNumberDTO;
import team1.deal.model.po.CityPO;
import team1.deal.model.vo.CoalInformationVO;
import team1.deal.model.vo.CoalYearNameGdpVO;
import team1.deal.model.vo.ResponseVO;
import team1.deal.model.vo.TransportInformationVO;
import team1.deal.service.DataAnalysisService;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.*;

@Service
public class DataAnalysisServiceImpl implements DataAnalysisService {

    @Autowired
    private DataAnalysisDao dataAnalysisDao;
    @Autowired
    private CityMapper cityMapper;
    @Autowired
    private QuotedPriceInfoDao quotedPriceInfoDao;

    //阳光用户数量统计
    public long getSunUserNumber() {
        return dataAnalysisDao.countSunUserNumber();
    }

    //需求订单已经通过审核审批的数量统计
    @Override
    public long getContDemand() {
        return dataAnalysisDao.countDemandNumber();
    }

    //所有需求订单采购数量总量统计
    @Transactional
    @Override
    public long contDemandProcurement() {
        if (dataAnalysisDao.countDemandNumber()!=0){
            return dataAnalysisDao.countDemandProcurement();
        }
        return 0;
    }

    //总交易额统计
    @Transactional
    @Override
    public long totalvolume() {
        if (dataAnalysisDao.countQuotedPriceNumber()!=0){
            return dataAnalysisDao.totalvolume();
        }
        return 0;
    }

    //折线图,各种煤的总量统计
    @Transactional
    @Override
    public List<CoalYearNameGdpVO> aggregateOfAllKindsOfCoal(Integer begin,Integer end) {
        List<CoalYearNameGdpVO> coalYearNameGdpVOList = new ArrayList<>();
        for (int i = begin ;i<=end ; i++){
            //设置开始时间，设置结束时间
            LocalDateTime beginlocalDateTime = DateUtil.parseLocalDateTime(i+"-01-01 00:00:00");
            LocalDateTime endlocalDateTime = DateUtil.parseLocalDateTime(++i+"-01-01 00:00:00");
            //查询出有多少种煤
            List<String> kindsOfCoallist = dataAnalysisDao.kindsOfCoallist(beginlocalDateTime,endlocalDateTime);
            for (String Coal:kindsOfCoallist){
                if (dataAnalysisDao.existOrNotExist(Coal)!=0){
                    coalYearNameGdpVOList.add(new CoalYearNameGdpVO(Coal,Convert.toStr(beginlocalDateTime.getYear()), dataAnalysisDao.kindsOfCoal(Coal,beginlocalDateTime,endlocalDateTime)));
                }
            }
        }
        return coalYearNameGdpVOList;
    }

    //运输方式统计
    @Transactional
    @Override
    public List<TransportInformationVO> modeOfTransportStatistics() {
        List<TransportInformationVO> transportInformationVOList = new ArrayList<>();
        //查询一共有哪些方式的运输方式
        List<String> transportTypelist = dataAnalysisDao.transportTypelist();
        for (String transportType:transportTypelist){
            long modeOfTransport = dataAnalysisDao.modeOfTransportStatistics(transportType);
            if (modeOfTransport!=0){
                transportInformationVOList.add(new TransportInformationVO(transportType,modeOfTransport));
            }
        }
        return transportInformationVOList;
    }

    //地区煤炭分布统计
    @Transactional
    @Override
    public List<CoalInformationVO> regionalCoalDistribution() {
        List<CoalInformationVO> coalInformationVOList = new ArrayList<>();
        //先获取一共有哪些地区
        List<String> producingArealist = dataAnalysisDao.region();
        for (String producingArea:producingArealist){
            //查询某个地区有哪些煤种
            List<String> coalTypeList = dataAnalysisDao.CoallistbyProducingArea(producingArea);
            for (String coalType:coalTypeList){
                coalInformationVOList.add(new CoalInformationVO(coalType,producingArea,
                        dataAnalysisDao.regionalCoalDistribution(producingArea,coalType)));
            }
        }

        List<CoalInformationVO> coalInformationVOList2 = new ArrayList<>();
        for (CoalInformationVO coalInformationVO:coalInformationVOList){
            if (coalInformationVO.getProducingArea().equals("沿海城市")){
                coalInformationVOList2.add(coalInformationVO);
            }else if (coalInformationVO.getProducingArea().equals("内陆城市")){
                coalInformationVOList2.add(coalInformationVO);
            }
        }


        return coalInformationVOList2;
    }

    //关注程度统计
    @Transactional
    @Override
    public Map<String, Object> attention() {
        //先获取有哪些需求订单
        List<Integer> DemandIdList = dataAnalysisDao.getDemandIds();
        Map<String,Object> map = new HashMap<>();
        for (Integer did:DemandIdList){
            map.put(Convert.toStr(did),dataAnalysisDao.attention(did));
        }
        return map;
    }

    //煤炭流向统计
    @Override
    public List<Map<String,String>> coalFlowStatistics() {
        List<DispatchDestinationDTO> list = dataAnalysisDao.getDispatchDestinationDTO();
        List<Map<String,String>> fromTo = new ArrayList<>();
        list.forEach(s->{
            CityPO cityFrom = cityMapper.selectOne(Wrappers.lambdaQuery(CityPO.class).eq(CityPO::getCityName,s.getPort()));
            CityPO cityTo = cityMapper.selectOne(Wrappers.lambdaQuery(CityPO.class).eq(CityPO::getCityName,s.getDeliveryPlace()));
            Map<String,String> map = new HashMap<>();
            map.put("from",cityFrom.toString());
            map.put("to",cityTo.toString());
            fromTo.add(map);
        });
        return fromTo;
    }

    @Override
    public List<Map<String,BigDecimal>> coalDeliveryPlace(){
        List<CityPO> list = quotedPriceInfoDao.getDeliveryPlace();
        List<Map<String,BigDecimal>> deliveryPlace = new ArrayList<>();
        list.forEach(s->{
            Map<String,BigDecimal> map = new HashMap<>();
            map.put("lng",s.getLongitude());
            map.put("lat",s.getLatitude());
            deliveryPlace.add(map);
        });
        return deliveryPlace;
    }

    @Override
    public long increaseOfDemand(){
        LocalDate now = LocalDate.now();
        // 求这个日期的周一、周日
        LocalDate monday = now.with(TemporalAdjusters.previous(DayOfWeek.SUNDAY)).plusDays(1);
        LocalDate sunday = now.with(TemporalAdjusters.next(DayOfWeek.MONDAY)).minusDays(1);
        return dataAnalysisDao.increaseOfDemand(monday,sunday);
    }

    @Override
    public long increaseOfDemandProcurement(){
        LocalDate now = LocalDate.now();
        // 求这个日期的周一、周日
        LocalDate monday = now.with(TemporalAdjusters.previous(DayOfWeek.SUNDAY)).plusDays(1);
        LocalDate sunday = now.with(TemporalAdjusters.next(DayOfWeek.MONDAY)).minusDays(1);
        return dataAnalysisDao.increaseOfDemandProcurement(monday,sunday);
    }

    @Override
    public LocalDateTime getInsertRecentTime(){
        return dataAnalysisDao.selectRecentTime();
    }
}
