package team1.deal.controller.echo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import team1.deal.model.po.DemandOrderPO;
import team1.deal.service.EchoService;

import java.util.List;

@RestController
@Api(tags = "回显控制")
@RequestMapping("/Echo")
public class DemandEchoController {

    @Autowired
    private EchoService echoService;

    @ApiOperation("需求订单根据状态status回显")
    @PostMapping(value = "/DemandEcho")
    public List<DemandOrderPO> DemandEcho(@RequestParam Integer status){
        return echoService.get_by_status(status);
    }




}
