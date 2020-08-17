package team1.deal.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team1.deal.dao.DataAnalysisDao;
import team1.deal.mapper.CityMapper;
import team1.deal.model.dto.DispatchDestinationDTO;
import team1.deal.model.dto.LatitudeAndIongitudeAndNumberDTO;
import team1.deal.model.po.CityPO;
import team1.deal.model.vo.ResponseVO;
import team1.deal.service.DataAnalysisService;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DataAnalysisServiceImpl implements DataAnalysisService {

    @Autowired
    private DataAnalysisDao dataAnalysisDao;
    @Autowired
    private CityMapper cityMapper;

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
    public Map<String, Object> aggregateOfAllKindsOfCoal() {
        Map<String,Object> map = new HashMap<>();
        if (dataAnalysisDao.existOrNotExist("煤种1")!=0){
            map.put("煤种1",dataAnalysisDao.kindsOfCoal("煤种1"));
        }if (dataAnalysisDao.existOrNotExist("煤种2")!=0){
            map.put("煤种2",dataAnalysisDao.kindsOfCoal("煤种2"));
        }if (dataAnalysisDao.existOrNotExist("煤种3")!=0){
            map.put("煤种3",dataAnalysisDao.kindsOfCoal("煤种3"));
        }
        return map;
    }

    //运输方式统计
    @Transactional
    @Override
    public Map<String, Object> modeOfTransportStatistics() {
        Map<String,Object> map = new HashMap<>();
        //查询一共有哪些方式的运输方式
        List<String> transportTypelist = dataAnalysisDao.transportTypelist();
        for (String transportType:transportTypelist){
            long modeOfTransport = dataAnalysisDao.modeOfTransportStatistics(transportType);
            if (modeOfTransport!=0){
                map.put(transportType,modeOfTransport);
            }
        }
        return map;
    }

    //地区煤炭分布统计
    @Transactional
    @Override
    public Map<String, Object> regionalCoalDistribution() {
        //先获取一共有哪些地区
        List<String> producingArealist = dataAnalysisDao.region();
        Map<String,Object> map = new HashMap<>();
        for (String producingArea:producingArealist){
            map.put(producingArea,dataAnalysisDao.regionalCoalDistribution(producingArea));
        }
        return map;
    }

    //关注程度统计
    @Transactional
    @Override
    public Map<String, Object> attention() {
        //先获取有哪些需求订单
        List<Integer> DemandIdList = dataAnalysisDao.getDemandIds();
        Map<String,Object> map = new HashMap<>();
        for (Integer did:DemandIdList){
            map.put(""+did,dataAnalysisDao.attention(did));
        }
        return map;
    }


    //煤炭流向统计
    @Transactional
    @Override
    public Map<Object,Object> coalFlowStatistics() {
        List<DispatchDestinationDTO> dispatchDestinationDTOList = new ArrayList<>();
        //先获取有哪些需求订单
        List<Integer> DemandIdList = dataAnalysisDao.getDemandIds();
        for (Integer did:DemandIdList){
            for (DispatchDestinationDTO dispatchDestinationDTO:dataAnalysisDao.getDispatchDestinationDTO(did)){
                dispatchDestinationDTOList.add(dispatchDestinationDTO);
            }
        }



        Map<Object,Object> map = new HashMap<>();
        for (DispatchDestinationDTO dispatchDestinationDTO:dispatchDestinationDTOList){
            QueryWrapper wrapper1 = new QueryWrapper();
            wrapper1.eq("cityName",dispatchDestinationDTO.getPort());
            CityPO Portcity = cityMapper.selectOne(wrapper1);
            QueryWrapper wrapper2 = new QueryWrapper();
            wrapper2.eq("cityName",dispatchDestinationDTO.getDeliveryPlace());
            CityPO DeliveryPlacecity = cityMapper.selectOne(wrapper2);
            //获取发送地的经纬度
            List<BigDecimal> port = new ArrayList<>();
            port.add(0,Portcity.getLongitude());
            port.add(1,Portcity.getLatitude());
            //获取收货地的经纬度
            List<BigDecimal> deliveryPlace = new ArrayList<>();
            deliveryPlace.add(0,DeliveryPlacecity.getLongitude());
            deliveryPlace.add(1,DeliveryPlacecity.getLatitude());
            //将发货地-收货地的经纬度信息，封装
            LatitudeAndIongitudeAndNumberDTO latitudeAndIongitudeAndNumberDTO = new LatitudeAndIongitudeAndNumberDTO();
            latitudeAndIongitudeAndNumberDTO.setPort(port);
            latitudeAndIongitudeAndNumberDTO.setDeliveryPlace(deliveryPlace);
            //将latitudeAndIongitudeAndNumberDTO作为键可以避免重复
            map.put(latitudeAndIongitudeAndNumberDTO,latitudeAndIongitudeAndNumberDTO);
        }
        return map;
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
