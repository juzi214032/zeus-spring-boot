package team1.deal.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import team1.deal.model.po.UserPO;

import java.util.List;

@Data
@ApiModel(value="用户集合", description="将多个供应商封装到一起")
public class UserList {
    @ApiModelProperty(value = "供应商集合")
    private List<UserPO> userPOList;

}
