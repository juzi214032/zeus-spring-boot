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
    private DataAnalysisDao dataAnalysisDao;
    @Autowired
    private DataAnalysisService dataAnalysisService;

    @GetMapping("/sunUserNumber")
    @ApiOperation("阳光用户数量")
    public ResponseVO getSunUser(){
        return new ResponseVO(dataAnalysisDao.countSunUserNumber());
    }

    //需求订单已经通过审核审批的数量
    @GetMapping("/CountDemand")
    @ApiOperation("需求订单数量")
    public ResponseVO getContDemand(){
        return new ResponseVO(dataAnalysisService.getContDemand());
    }

    //所有需求订单采购数量总量
    @GetMapping("/CountDemandProcurement")
    @ApiOperation("购数量总量")
    public ResponseVO ContDemandProcurement(){
        return new ResponseVO(dataAnalysisService.ContDemandProcurement());
    }

    //总交易额
    @GetMapping("/totalvolume")
    @ApiOperation("购数量总量")
    public ResponseVO totalvolume(){
        return new ResponseVO(dataAnalysisService.totalvolume());
    }

    //折线图,各种煤的总量集合
    @GetMapping("/aggregateOfAllKindsOfCoal")
    @ApiOperation("各种煤的总量集合")
    public ResponseVO aggregateOfAllKindsOfCoal(){
        return new ResponseVO(dataAnalysisService.aggregateOfAllKindsOfCoal());
    }
}