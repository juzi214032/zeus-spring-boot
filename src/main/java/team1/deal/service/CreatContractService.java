package team1.deal.service;

import org.springframework.web.multipart.MultipartFile;
import team1.deal.model.po.ContractPO;

import java.io.IOException;

public interface CreatContractService {


    //上传合同附件，创建合同，并保存到数据库中
    public void CreatContract(MultipartFile file,ContractPO contractPO) throws IOException;


}
