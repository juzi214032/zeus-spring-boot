package team1.deal.controller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team1.deal.dao.DataAnalysisDao;
import team1.deal.model.vo.ResponseVO;

@RestController
@RequestMapping("/data")
@ApiModel("数据分析")
public class DataAnalysisController{
    @Autowired
    private DataAnalysisDao dataAnalysisDao;

    @GetMapping("/sunUserNumber")
    @ApiOperation("阳光用户数量")
    public ResponseVO getSunUser(){
        return new ResponseVO(dataAnalysisDao.countSunUserNumber());
    }

    //需求订单已经通过审核审批的数量
    @GetMapping("/CountDemand")
    @ApiOperation("需求订单数量")
    public ResponseVO getContDemand(){
        return new ResponseVO(dataAnalysisDao.countDemandNumber());
    }

    //所有需求订单采购数量总量
    @GetMapping("/CountDemandProcurement")
    @ApiOperation("购数量总量")
    public ResponseVO ContDemandProcurement(){
        return new ResponseVO(dataAnalysisDao.CountDemandProcurement());
    }

    //总交易额
    @GetMapping("/totalvolume")
    @ApiOperation("购数量总量")
    public ResponseVO totalvolume(){
        return new ResponseVO(dataAnalysisDao.totalvolume());
    }

}