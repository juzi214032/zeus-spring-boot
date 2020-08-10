package team1.deal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import team1.deal.mapper.ContractMapper;
import team1.deal.model.po.ContractPO;
import team1.deal.service.CreatContractService;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class CreatContractServiceImpl implements CreatContractService {

    @Autowired
    private ContractMapper contractMapper;
    //上传合同附件，创建合同，并保存到数据库中
    @Override
    public void CreatContract(MultipartFile file,ContractPO contractPO) throws IOException {
        //上传合同
        String url = null;
        //构建上传之后的地址
        String path = System.getProperty("user.dir") + "\\ContractFolder";
        //将当前时间转换成时间戳
        long longtime = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        //将时间戳和原名加一起，保证了名字的唯一性
        String fileName = longtime + file.getOriginalFilename();
        //判断路径是否存在，不存在则新创建一个
        File filepath = new File(path, fileName);
        if (!filepath.getParentFile().exists()) {
            filepath.getParentFile().mkdirs();
        }
        //将文件上传到指定的位置
        file.transferTo(new File(path + File.separator + fileName));
        //拼写完整的路径
        url = path + "\\" + fileName;
        //将url信息存入contractPO对象中
        contractPO.setUrl(url);


        //设置合同的初始状态
        contractPO.setStatus(0);
        //将合同存入数据库
        contractMapper.insert(contractPO);
    }


}
