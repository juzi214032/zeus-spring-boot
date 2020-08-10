package team1.deal.service;

import org.springframework.web.multipart.MultipartFile;
import team1.deal.model.po.ContractPO;

import java.io.IOException;
import java.text.ParseException;

public interface CreatContractService {


    //创建合同，并保存到数据库中
    public void CreatContract(ContractPO contractPO);



    //上传合同附件,并将合同的URL存如对应的字段
    public void UpContract(MultipartFile file, ContractPO contractPO) throws ParseException, IOException;

}
