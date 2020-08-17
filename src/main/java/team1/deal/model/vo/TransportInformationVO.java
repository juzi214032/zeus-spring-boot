package team1.deal.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value="TransportInformationVO对象", description="用来接收运输方式的相关数据")
public class TransportInformationVO {
    @ApiModelProperty(value = "运输方式")
    private String type;
    @ApiModelProperty(value = "次数")
    private long value;

    public TransportInformationVO(String type, long value) {
        this.type = type;
        this.value = value;
    }

    public TransportInformationVO() {
    }
}
