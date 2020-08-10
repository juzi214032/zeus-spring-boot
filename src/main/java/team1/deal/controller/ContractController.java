package team1.deal.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import team1.deal.model.po.ContractPO;
import team1.deal.model.vo.MessageResponseVO;
import team1.deal.model.vo.ResponseVO;
import team1.deal.service.ContractService;
import team1.deal.service.CreatContractService;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.time.LocalDateTime;

@RestController
@Api(tags = "创建合同，以及上传合同附件")
@RequestMapping("/Contract")
public class ContractController {

    @Autowired
    private CreatContractService creatContractService;

    /**
     * 创建合同
     * @param contractPO
     * @return
     */
    @ApiOperation("创建合同")
    @PostMapping(value = "/CreatContract")
    public ResponseVO CreatContract(@RequestBody ContractPO contractPO){
        creatContractService.CreatContract(contractPO);

        return new MessageResponseVO(20010);
    }


    /**
     * 上传文件,并将合同的URL存如对应的字段
     * @param file
     * @param contractPO
     * @return
     * @throws IOException
     * @throws ParseException
     */
    @ApiOperation("上传合同附件")
    @PostMapping(value = "/UpContract")
    public ResponseVO UpContract(@RequestPart MultipartFile file,@RequestPart ContractPO contractPO) throws IOException, ParseException {
        creatContractService.UpContract(file,contractPO);

        return new MessageResponseVO(20009);
    }



}
