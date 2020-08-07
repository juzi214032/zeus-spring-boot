package team1.deal.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team1.deal.model.po.DemandOrderPO;
import team1.deal.model.po.SaveDemandOrderPO;
import team1.deal.model.vo.MessageResponseVO;
import team1.deal.model.vo.ResponseVO;
import team1.deal.service.CreatDemandService;

@RestController
@Api(tags = "创建|保存需求")
@RequestMapping(value = "/creatDemand")
public class CreatDemandController {

    @Autowired
    private CreatDemandService creatDemandService;

    /**
     * 创建并提交
     * @param demandOrderPO
     * @return
     */
    @ApiOperation("需求点击创建")
    @PostMapping(value = "/buttonCreatDemand")
    public ResponseVO CreatDemand(@RequestBody DemandOrderPO demandOrderPO){
        creatDemandService.CreatDemand(demandOrderPO);
        return new MessageResponseVO(20005);
    }

    /**
     * 创建后保存
     * @param saveDemandOrderPO
     * @return
     */
    @ApiOperation("需求点击保存")
    @PostMapping(value = "/buttonSaveDemand")
    public ResponseVO SaveDemand(@RequestBody SaveDemandOrderPO saveDemandOrderPO){
        creatDemandService.SaveDemand(saveDemandOrderPO);
        return new MessageResponseVO(20006);
    }



}
