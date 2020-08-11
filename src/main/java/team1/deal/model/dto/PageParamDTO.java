package team1.deal.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "分页参数")
public class PageParamDTO {

    @ApiModelProperty("当前页码-从 1 开始")
    private Integer pageOn = 1;

    @ApiModelProperty("每页条数")
    private Integer pageSize = 10;

}
