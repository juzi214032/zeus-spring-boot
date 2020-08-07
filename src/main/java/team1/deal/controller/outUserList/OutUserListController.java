package team1.deal.controller.outUserList;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import team1.deal.model.dto.UserList;
import team1.deal.model.po.UserPO;
import team1.deal.model.vo.ResponseVO;

import java.util.List;

@RestController
@Api(tags = "子公司筛选名单")
@RequestMapping("/Subsidiary")
public class OutUserListController {


    @ApiOperation("子公司统一选择多个供应商")
    @PostMapping(value = "/outUserList")
    public List<UserPO> outUserList(@RequestBody UserList userList){
        return userList.getUserPOList();
    }

}
