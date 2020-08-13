package team1.deal.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team1.deal.model.po.QuotedPriceInfoPO;
import team1.deal.model.po.SaveQuotedPriceInfoPO;
import team1.deal.model.vo.MessageResponseVO;
import team1.deal.model.vo.ResponseVO;
import team1.deal.service.CreatQuotedPriceService;

@RestController
@Api(tags = "创建|保存报价")
@RequestMapping(value = "/creatQuotedPrice")
public class CeatQuotedPriceController {

    @Autowired
    private CreatQuotedPriceService creatQuotedPriceService;


    /**
     * 创建并提交报价
     * @param quotedPriceInfoPO
     * @return
     */
    @ApiOperation("报价点击创建")
    @PostMapping(value = "/buttonCreatQuotedPrice")
    public ResponseVO CreatQuotedPrice(@RequestBody @Validated QuotedPriceInfoPO quotedPriceInfoPO){
        creatQuotedPriceService.CreatQuotedPrice(quotedPriceInfoPO);
        return new MessageResponseVO(20007);
    }


    /**
     * 保存报价
     * @param saveQuotedPriceInfoPO
     * @return
     */
    @ApiOperation("报价点击保存")
    @PostMapping(value = "/buttonSaveQuotedPrice")
    public ResponseVO SaveQuotedPrice(@RequestBody @Validated SaveQuotedPriceInfoPO saveQuotedPriceInfoPO){
        creatQuotedPriceService.SaveQuotedPrice(saveQuotedPriceInfoPO);
        return new MessageResponseVO(20008);
    }


}
