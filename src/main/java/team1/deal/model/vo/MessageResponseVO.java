package team1.deal.model.vo.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import team1.deal.model.vo.response.ResponseVO;

@Data
@EqualsAndHashCode(callSuper = true)
//消息返回视图无数据
public class MessageResponseVO extends ResponseVO<Void> {

    public MessageResponseVO(Integer code){
        super(code);
    }

    public MessageResponseVO(Integer code,String message){
        super(code,message);
    }
}
