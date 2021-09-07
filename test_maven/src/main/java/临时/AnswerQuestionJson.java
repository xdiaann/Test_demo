package 临时;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author heyi
 * @email 308068086@qq.com
 * @date 2018-01-24 13:24:38
 */

@Getter
@Setter
@ToString
public class AnswerQuestionJson {

    /**
     * 试卷ID
     */
    private String id;

    /**
     * 答案ID 多选逗号分割
     */
    private String answerId;

    /**
     * 是否评卷
     */
    private Boolean judgeFlag;

    /**
     * 是否答题
     */
    private Boolean answerFlag;

    /**
     * 试题评卷结果
     */
    private LmsConsts.Result result;

    /**
     * 试题得分
     */
    private BigDecimal score = new BigDecimal(0);

    /**
     * 客观题得分
     */
    private BigDecimal objectScore = new BigDecimal(0);

    /**
     * 主观题得分
     */
    private BigDecimal subjectScore = new BigDecimal(0);

    /**
     * 子试题答题结果
     */
    private List<AnswerQuestionJson> children;

    private LmsConsts.DifficultyType difficulty;

    /**
     * 答题（问答）拍照照片list
     */
//    private List<AnswerQuestionTakePhotoJson> takePhotos;
}
