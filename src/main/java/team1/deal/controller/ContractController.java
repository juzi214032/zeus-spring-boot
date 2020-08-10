package team1.deal.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import team1.deal.model.po.ContractPO;
import team1.deal.model.vo.MessageResponseVO;
import team1.deal.model.vo.ResponseVO;
import team1.deal.service.CreatContractService;

import java.io.IOException;

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
    @PostMapping(value = "/CreatAndUpContract")
    public ResponseVO CreatContract(@RequestPart MultipartFile file,@RequestPart ContractPO contractPO) throws IOException {
        creatContractService.CreatContract(file,contractPO);

        return new MessageResponseVO(20009);
    }





}
