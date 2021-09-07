package 临时;

import iinda.pojo.BaseDto;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class KingdeeZMOrgDto  {
    private Long id;
    private String deptId;
    private String parentId;
    private String deptCode;
    private String parentCode;
    private String deptName;
    private String disable;
    private Date opDate;

}