import iinda.pojo.BaseDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ExamPhotoDto   {


    @ApiModelProperty("是否及格")
    private String activeId;
    @ApiModelProperty("是否及格")
    private String registerId;
    @ApiModelProperty("是否及格")
    private String userId;
    @ApiModelProperty("是否及格")
    private String examRegisterPhotoId;

    private String photo64;

    private BigDecimal examTime;

}
