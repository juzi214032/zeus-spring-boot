package team1.deal.controller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team1.deal.dao.DataAnalysisDao;
import team1.deal.model.vo.ResponseVO;
import team1.deal.service.DataAnalysisService;

@RestController
@RequestMapping("/data")
@ApiModel("数据分析")
public class DataAnalysisController{

    @Autowired
    private DataAnalysisService dataAnalysisService;

    //阳光用户数量统计
    @GetMapping("/sunUserNumber")
    @ApiOperation("阳光用户数量")
    public ResponseVO getSunUser(){
        return new ResponseVO(dataAnalysisService.getSunUserNumber());
    }

    //需求订单已经通过审核审批的数量统计
    @GetMapping("/CountDemand")
    @ApiOperation("需求订单数量统计")
    public ResponseVO getContDemand(){
        return new ResponseVO(dataAnalysisService.getContDemand());
    }

    //所有需求订单采购数量总量统计
    @GetMapping("/CountDemandProcurement")
    @ApiOperation("采购数量总量统计")
    public ResponseVO contDemandProcurement(){
        return new ResponseVO(dataAnalysisService.contDemandProcurement());
    }

    //总交易额统计
    @GetMapping("/totalvolume")
    @ApiOperation("总交易额统计")
    public ResponseVO totalvolume(){
        return new ResponseVO(dataAnalysisService.totalvolume());
    }

    //折线图,各种煤的总量统计
    @GetMapping("/aggregateOfAllKindsOfCoal")
    @ApiOperation("各种煤的总量统计")
    public ResponseVO aggregateOfAllKindsOfCoal(){
        return new ResponseVO(dataAnalysisService.aggregateOfAllKindsOfCoal());
    }

    //运输方式统计
    @GetMapping("/modeOfTransportStatistics")
    @ApiOperation("运输方式统计")
    public ResponseVO modeOfTransportStatistics(){
        return new ResponseVO(dataAnalysisService.modeOfTransportStatistics());
    }

    //地区煤炭分布统计
    @GetMapping("/regionalCoalDistribution")
    @ApiOperation("地区煤炭分布统计")
    public ResponseVO regionalCoalDistribution(){
        return new ResponseVO(dataAnalysisService.regionalCoalDistribution());
    }

    //关注程度统计
    @GetMapping("/attention")
    @ApiOperation("关注程度统计")
    public ResponseVO attention(){
        return new ResponseVO(dataAnalysisService.attention());
    }

    //煤炭流向统计
    @GetMapping("/coalFlowStatistics")
    @ApiOperation("煤炭流向统计")
    public ResponseVO coalFlowStatistics(){
        return new ResponseVO(dataAnalysisService.coalFlowStatistics());
    }

    //本周需求订单统计
    @GetMapping("/increase/demandOrder")
    @ApiOperation("新增本周需求订单统计")
    public ResponseVO  getIncreaseDemandOrder(){
        return new ResponseVO(dataAnalysisService.increaseOfDemand());
    }

    //本周采购数量统计
    @GetMapping("/increase/demandProcurement")
    @ApiOperation("新增本周采购数量统计")
    public ResponseVO  getDemandProcurement(){
        return new ResponseVO(dataAnalysisService.increaseOfDemandProcurement());
    }

    //最近一次阳光用户新增时间
    @GetMapping("/increaseTime/sunUser")
    @ApiOperation("最近阳光用户新增时间")
    public ResponseVO getSunUserIncreaseTime(){
        return new ResponseVO(dataAnalysisService.getInsertRecentTime());
    }
}