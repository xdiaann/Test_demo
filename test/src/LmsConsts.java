
import java.math.BigDecimal;
import java.util.Map;

public class LmsConsts {

    public static final String ADMIN = "admin";
    public static final String COMMA = ",";
    public static final String VERTICAL = "|";
    public static final String ANONYMOUS = "***";
    public static final String ROOT_DIMENSIONS = "10000";
    public static final Long ROOT_DOMAIN = 10001L;
    public static final String ROOT_COURSE_CATEGORY = "10002";  //课程根目录
    public static final String SYS_ROLE_STUDY = "002";   //学习管理角色id
    public static final String SYS_ROLE_TRAIN = "003";   //培训管理角色id
    public static final String ROOT_OUT_DOMAIN = "10001.10002";
    public static final String OUT_SOCIETY_DOMAIN = "10003";
    public static final Integer DEFAULT_SCALE = 2;
    public static final String XLS = ".xls";
    public static final String ROOT_IN_DOMAIN = "99998";
    public static final Short FIRST_ROW = 3;
    public static final Short END_ROW = 10000;
    public static final String SORT = "SEQ ASC";
    public static final String PC = "PC";//PC端
    public static final String APP = "APP";//APP端
    public static final int TOKEN_EXPIRE_TIME = 30;//token失效时间，单位分钟
    /**
     * 证书编号
     */
    public static String CERTIFICATE_NUMBER = "CERTIFICATE_NUMBER";

    public static final String CHARSET_UTF_8 = "UTF-8";

    public static final BigDecimal ZERO = new BigDecimal(0);
    public static final BigDecimal FIVE = new BigDecimal(5);
    public static final BigDecimal FIFTY = new BigDecimal(50);
    public static final BigDecimal NINETY = new BigDecimal(90);
    public static final BigDecimal HUNDRED = new BigDecimal(100);
    public static final BigDecimal ONE_MINUTE = new BigDecimal(60000);

    public static final String SEQ = "seq";

    public static final String OUTER_TEACHER_LOGINID_PREFIX = "outer";

    public static final BigDecimal MAX_NUMBER = new BigDecimal(99999999.99);

    public static final String USER_LOGIN_TOPIC = "user.login.topic";

//    public static Map<String, String> filterSort = Maps.newHashMap();
//    public static Map<String,String> coursePublishMap = Maps.newHashMap(); //课程发布状态枚举和文本值对照
//    public static Map<String,String> courseRegistStatusMap = Maps.newHashMap(); //课程注册状态枚举和文本值对照
//    public static Map<String,String> yesOrNoMap = Maps.newHashMap();
//    public static Map<QuestionType,String> examQuestionTypeMap = Maps.newHashMap(); //考试试题类型枚举和文本值对照

    public static final String SYSTEM_ERROR = "502";//系统错误
    public static final String PARAM_ERROR = "503";//入参错误
    public static final String REDEEM_NOT_EXISTS = "504";//兑换码不存在
    public static final String REDEEM_PAST = "505";//兑换码过期
    public static final String ALREADY_BUY = "506";//商品已兑换
    public static final String ERROR_LIST = "errorList";
    public static final String SUCCESS_LIST = "successList";
    public static final String AES_KEY = "fyu6puYeYxoesrtW";

//
//    static{
//        filterSort.put("STUDY_COUNT","STUDY_COUNT");
//        filterSort.put("COMPOSITE_AVG_SCORE","COMPOSITE_AVG_SCORE");
//        filterSort.put("id","id");
//        filterSort.put("PUBLISH_TIME","PUBLISH_TIME");
//        filterSort.put("INFO.PUBLISH_TIME","INFO.PUBLISH_TIME");
//        filterSort.put("createTime","createTime");
//        filterSort.put("p.createTime","p.create_Time");
//        filterSort.put("stick","stick");
//        filterSort.put("recommend","recommend");
//        filterSort.put("buyTime","buyTime");
//        filterSort.put("begin_time","begin_time");
//        filterSort.put("BROWSE_COUNT","BROWSE_COUNT");
//        filterSort.put("lastModifyTime","lastModifyTime");
//        filterSort.put("tpc.name","tpc.name");
//        filterSort.put("info.name","info.name");
//        filterSort.put("reg.USER_ID","reg.USER_ID");
//        filterSort.put("r.REGIST_TIME","r.REGIST_TIME");
//        filterSort.put("info.NAME","info.NAME");
//        filterSort.put("judgeTime","judgeTime");
//        filterSort.put("h.org_id","h.org_id");
//        filterSort.put("a.name","a.name");
//        filterSort.put("code","code");
//        filterSort.put("u.LAST_MODIFY_TIME","u.LAST_MODIFY_TIME");
//        filterSort.put("REGIST.REGIST_TIME","REGIST.REGIST_TIME");
//        filterSort.put("tpc.END_TIME","tpc.END_TIME");
//        filterSort.put("courseName","courseName");
//        filterSort.put("t.id","t.id");
//        filterSort.put("INFO.id","INFO.id");
//        filterSort.put("U.id","U.id");
//        filterSort.put("U.ID","U.ID");
//        filterSort.put("time","time");
//        filterSort.put("U.LAST_MODIFY_TIME","U.LAST_MODIFY_TIME");
//        filterSort.put("executionTime","executionTime");
//        filterSort.put("year","year");
//        filterSort.put("tpc.BEGIN_TIME","tpc.BEGIN_TIME");
//        filterSort.put("teu.create_time","teu.create_time");
//        filterSort.put("so.code","so.code");
//        filterSort.put("v.endTime","v.endTime");
//        filterSort.put("className","className");
//        filterSort.put("T.ID","T.ID");
//        filterSort.put("u.ANSWER_TIME","u.ANSWER_TIME");
//        filterSort.put("V.time","V.time");
//        filterSort.put("reply_Count","reply_Count");
//        filterSort.put("applyCount","applyCount");
//        filterSort.put("t.create_time","t.create_time");
//        filterSort.put("tnd.create_time","tnd.create_time");
//        filterSort.put("USER_NAME","USER_NAME");
//        filterSort.put("U.NAME","U.NAME");
//        filterSort.put("u.ID","u.ID");
//        filterSort.put("v.time","v.time");
//        filterSort.put("type","type");
//        filterSort.put("regist_time","regist_time");
//        filterSort.put("DOWNLOAD_COUNT","DOWNLOAD_COUNT");
//        filterSort.put("su.NAME","su.NAME");
//        filterSort.put("START_TIME","START_TIME");
//        filterSort.put("INFO.COMPOSITE_AVG_SCORE","INFO.COMPOSITE_AVG_SCORE");
//        filterSort.put("INFO.CREATE_TIME","INFO.CREATE_TIME");
//        filterSort.put("INFO.STUDY_COUNT","INFO.STUDY_COUNT");
//        filterSort.put("REGIST.IS_REQUIRED","REGIST.IS_REQUIRED");
//        filterSort.put("wfp.CREATE_TIME","wfp.CREATE_TIME");
//        filterSort.put("v.getTime","v.getTime");
//        filterSort.put("s.LAST_MODIFY_TIME","s.LAST_MODIFY_TIME");
//        filterSort.put("a.create_time","a.create_time");
//        filterSort.put("v.name","v.name");
//        filterSort.put("smm.create_time","smm.create_time");
//        filterSort.put("smm.send_time","smm.send_time");
//        filterSort.put("smm.business_begin_time","smm.business_begin_time");
//        filterSort.put("smm.business_end_time","smm.business_end_time");
//        filterSort.put("su.staff_id","su.staff_id");
//        filterSort.put("sod.full_name","sod.full_name");
//        filterSort.put("tpc.begin_time","tpc.begin_time");
//        filterSort.put("tpc.end_time","tpc.end_time");
//        filterSort.put("su.name","su.name");
//        filterSort.put("tl1.seq","tl1.seq");
//        filterSort.put("REGIST.ID","REGIST.ID");
//        filterSort.put("tcr.id","tcr.id");
//
//        coursePublishMap.put("Y","已发布");
//        coursePublishMap.put("N","未发布");
//        coursePublishMap.put("A","审核中");
//        coursePublishMap.put("P","发布中");
//
//        courseRegistStatusMap.put("WAIT_AUDIT","待审核");
//        courseRegistStatusMap.put("REFUSE","已拒绝");
//        courseRegistStatusMap.put("UNSTART","未开始");
//        courseRegistStatusMap.put("PROCESSING","学习中");
//        courseRegistStatusMap.put("WAIT_EXAM","待考试");
//        courseRegistStatusMap.put("EXAM_JUDGING","考试评卷中");
//        courseRegistStatusMap.put("EXAM_FAIL","考试失败");
//        courseRegistStatusMap.put("WAIT_TAG","待标记");
//        courseRegistStatusMap.put("FINISH","已完成");
//
//        yesOrNoMap.put("是","Y");
//        yesOrNoMap.put("否","N");
//
//        examQuestionTypeMap.put(QuestionType.SINGLE, "单选");
//        examQuestionTypeMap.put(QuestionType.MULTISELECT, "多选");
//        examQuestionTypeMap.put(QuestionType.MULTI, "不定项");
//        examQuestionTypeMap.put(QuestionType.JUDGE, "判断");
//        examQuestionTypeMap.put(QuestionType.FILL, "填空题");
//        examQuestionTypeMap.put(QuestionType.QUESTION, "问答题");
//        examQuestionTypeMap.put(QuestionType.PAIXU, "排序");
//        examQuestionTypeMap.put(QuestionType.YUEDU, "阅读理解");
//        examQuestionTypeMap.put(QuestionType.PEIWU, "连线");
//    }
//
//    public static String getFilterSort(String key) {
//        return filterSort.get(key);
//    }
//    public static String getCoursePublishStatusText(String key){
//        return coursePublishMap.get(key);
//    }
//    public static String getCourseRegistStatusText(String key){
//        return courseRegistStatusMap.get(key);
//    }

    /**
     * 前台RoleId
     */
    public static final String USER_ROLE = "001";

    public enum BbsRankingListType {
        //周
        WEEK,
        //月
        MONTH
    }

    /**
     * 角色类型
     */
    public enum SysRoleType {
        //前段
        FRONT,
        //后台控制菜单
        BACKEND
    }

    public enum SysMenuType {
        //前段
        FRONT,
        //后台控制菜单
        BACKEND
    }

    public enum SysMenuClientType {
        //前段
        PC,
        //后台控制菜单
        APP
    }

    /**
     * 菜单性质类型
     */
    public enum MenuNatureType {
        //产品标准化
        STANDARD,
        //自定义
        CUSTOMIZE
    }

    /**
     * 菜单板块数据展示方式
     */
    public enum MenuDataDisplayMode {
        //单行
        SINGLE_LINE,
        //双行
        DOUBLE_LINE
    }

    /**
     * 菜单板块数据过滤类型
     */
    public enum MenuDataFilterType {
        //课程目录筛选数据
        COURSE_CATEGORY,
        //自定义数据
        CUSTOMIZE
    }

    /**
     * 菜单板块数据业务类型
     */
    public enum MenuDataBizType {
        //在线课程
        ONLINE_COURSE,
        //学习地图
        STUDY_MAP,
        //培训班级
        TRAIN_CLASS,
        //知识文档
        DOCUMENT,
        //考试活动
        EXAM,
        //调研活动
        SURVEY,
        //讲师
        TEACHER
    }

    /**培训计划总结类型*/
    public enum TrainPlanSummaryType{
        //学员
        STUDENT,
        //导师
        TEACHER,
        //经理
        MANAGER
    }

    public enum OutComesType {
        //日
        DAY,
        //月
        MONTH,
        //周
        WEEK,
    }

    public enum TrainSurveyTQTarget {
        //组织
        ORGANIZE,
        //调研
        SURVEY,
        //课程
        COURSE,
        //讲师
        TEACHER
    }

    public enum LoginTokenType {
        //工号
        STAFFID,
        //手机号
        MOBILE,
        //三一重起
        SAN_YI,
        //自然阳光
        NATURE_SUNSHINE
    }

    /**
     * 用户报名表状态
     */
    public enum ExamUserApplyStatus {
        //待审核
        AUDITING,
        //审核通过
        APPROVE,
        //审核拒绝
        REJECT
    }

    /**
     * 参与方式
     */
    public enum ExamJoinType {
        //指定
        APPOINT,
        //报名
        APPLY
    }

    public enum ExamMode {
        //指定
        NORMAL,
        //模拟
        SIMULATION,
        //模拟自考
        SELFTEST
    }

    public enum YES_OR_NO {
        //成功
        YES,
        //失败
        NO
    }

    /**
     * 直播注册用户状态
     */
    public enum TvLiveUserRegisterStatus {
        //未开始
        NOT_START,
        //进行中
        UNDER_WAY
    }

    /**
     * 学习专栏状态
     */
    public enum SpecialColumnStatus {
        //草稿
        DRAFT,
        //发布
        PUBLISH
    }

    /**
     * 关注类型
     */
    public enum AttentionType {
        //关注
        FOLLOWED,
        //取消关注
        UN_FOLLOWED
    }

    public enum LicenceType {
        //授权过期
        EXPIRED_TIME,
        //最大用户数量
        MAX_USER_COUNT,
        //是否购买了在线学习模块
        ONLINE_LEARN,
        //是否购买了线下培训活动模块
        PROJECT,
        //是否购买了考试活动模块
        EXAM
    }

    public enum CategoryType {
        //试题目录 1018
        QUESTION_CATEGORY,
        //试卷目录 7
        PAPER_CATEGORY,
        //策略目录 6
        POLICY_CATEGORY,
        //考试目录 10
        EXAM_CATEGORY,
        //班级目录 13
        TRAIN_PROJECT_CATEGORY,
        //所属系列 5
        PROJECT_SERIES,
        //培训班模版目录 1038
        TRAIN_PROJECT_TEMPLATE_CATEGORY,
        //课程目录 3
        COURSE_INFO,
        //论坛目录
        BBS_CATEGORY,
        //公共目录(主要用于一些目录共用一个目录)
        COMMON_CATEGORY,
        //故障目录(个性化需求)
        FAULT_CATEGORY,

        STUDY_CATEGORY,
        //知识库目录
        DOCUMENT_CATEGORY,
        //学习路径目录
        STUDY_PATH_CATEGORY,
        //职位类别
        SYS_JOB_TYPE,
        //标签类别
        SYS_CLASSIFY,
        //需求调研目录
        SURVEY_CATEGORY,
        //组织
        ORG,
        //设备类型目录
        EQUIPMENT_CATEGORY,
        //课件目录
        COURSE_SCORM,
        //培训项目
        PROJECT_TEMPLATE_CATEGORY,
        //讲师费用所属目录
        LECTURE_FEE_DIRECTORY_INFO,
        //商品目录
        GOODS,
    }

    public enum UserFrom {
        //内部人员
        INSIDER,
        //外部人员
        OUTSITE,
    }

    public enum DictionaryType {
        //国籍
        NATIONALITY,
        //民族
        NATION,
        //学历
        EDUCATION,
        //证件类型
        CREDENTIALS_TYPE,
        //英语等级
        ENGLISH_LEVEL,
        //菜单编码
        MENU_CODE,
        //职级
        LEVEL,
        //职等
        RANK,
        //关键文档类型
        DOC_IMPORTANT,
        //文档分类
        DOC_KIND,
        //消息模块
        MSG_MODULE,
        //职等类别
        GRADE_CATEGORY,
        //职等子类别
        GRADE_SUB_CATEGORY,
        //用工关系类型
        EMPLOY_RELATION_TYPE,
        //用工关系状态
        EMPLOY_RELATION_STATUS,
        //职层
        JOB_LEVEL,
        //职衔
        JOB_RANK,
        //职等表
        JOB_RANK_TABLE,
        //费用类型
        TRAIN_FEE_TYPE,
        //课程类型
        COURSE_TYPE,
        //课程级别
        COURSE_LEVEL,
        //培训类型
        TRAIN_TYPE,
        //培训班-评价方式
        EVALUATION_STYLE,
        //培训班课程-培训形式
        TRAINING_FORM,
        //年度、月度计划-考核方式
        TEST_METHOD,
        //辅导计划详情合格标准
        QUALIFIED_STANDARD,
        //考试类型
        EXAM_TYPE,
        //人员类型<大族>
        EMP_TYPE,
        //工作经验<大族>
        WORK_EXPERIENCE,
        //学历要求<大族>
        EDUCATION_CLAIM,
        //举报内容
        REPORT_CONTENT,
        //证书类型
        CERTIFICATE_TYPE,
        //积分规则类型
        INTEGRAL_RULE_TYPE,
        //培训需求类型
        TRAIN_NEEDS_TYPE,
        //系统规则说明
        RULE_DESCRIPTION_TYPE,
        //岗位类型
        POST_TYPE,
        //职业类型
        OCCUPATION_TYPE,
        //培训方式
        TRAIN_METHOD,
        //培训学分获得项目
        TRAIN_CREDIT_GET_PROJECT,
        //片区
        AREA,
        //办事处
        OFFICEPLACE,
        //课程来源
        COURSE_SOURCE_TYPE,
        //培训渠道
        TRAIN_CHANNEL,
        //学习方式
        LEARN_METHOD,
        //国内国外
        DOMESTIC_OR_FOREIGN,
        //学历
        EDUCATION_TYPE
    }

    public enum TrainPlanStatus {
        //草稿
        DRAFT,
        //发布
        PUBLISH,
        //启动
        START,
        //完成
        FINISH
    }

    public enum TrainPlanEndType {
        //自动
        AUTO,
        //手动
        MANUAL,
    }

    /**
     * 培训计划执行方式
     */
    public enum TrainPlanExecuteWay {
        //月度（默认）
        MONTH,
        //季度
        QUARTER,
        //年度
        YEAR,
        //次数
        FREQUENCY
    }

    //状态枚举
    public enum Status {
        //有效
        ON,
        //无效
        OFF
    }

    /**
     * 是或者否
     */
    public enum YesOrNo {
        //是
        Y,
        //否
        N
    }


    public enum YesOrNoOrAuditing {
        Y,
        N,
        A,  //Auditing
        P   //publishing
    }

    public enum CoursePublishRule {
        All,
        UnFinish
    }

    public enum SearchBusinessType {
        //考试活动
        EXAM,
        //培训
        TRAIN,
        //知识库
        DOC,
        //课程
        COURSE,
        //帖子
        BBS,
        //学习专栏
        SPECIAL_COLUMN,
        //讲师
        TEACHER
    }

    public enum BbsBusinessType {
        //共用
        PUBLIC,
        //学习
        STUDY,
        //培训
        TRAIN,
        //学习专栏
        SPECIAL_COLUMN
    }

    /**
     * 结果显示方式
     */
    public enum ViewResultStyle {
        //不显示成绩
        NONE,
        //只显示分数
        SCORE,
        //显示自己答案
        SELF_ANSWER,
        //显示标准答案
        STANDARD
    }

    /**
     * 试卷类型
     */
    public enum PaperType {
        //固定
        FIXED,
        //临时
        TEMP,
        //随机
        RANDOM
    }

    /**
     * 排序类型
     */
    public enum SortType {
        //试卷不打乱顺序
        PAGER_ORDER,
        //试题打乱顺序
        QUESTION_DISORDER,
        //选项打乱顺序
        OPTION_DISORDER,
        //试题选项打乱顺序
        QUESTION_OPTION_DISORDER
    }

    /**
     * 试题类型枚举
     */
    public enum QuestionType {
        //单选	单选题
        SINGLE,
        //多选	多选,全部选对才给分
        MULTISELECT,
        //不定项	选择一个或多个 可设置少选是否给分
        MULTI,
        //判断	判断题
        JUDGE,
        //填空	填空题
        FILL,
        //问答	问答题
        QUESTION,
        //连线	连线题
        PEIWU,
        //阅读理解	阅读理解题
        YUEDU,
        //排序	排序
        PAIXU,
    }

    /**
     * 得分级别
     */
    public enum ScoreLevel {
        //不及格
        FAIL,
        //及格
        PASS,
        //中等
        MIDDLE,
        //优秀
        WELL
    }

    /**
     * 试题评卷结果
     */
    public enum Result {
        //正确
        RIGHT,
        //部分正确
        PART_RIGHT,
        //错误
        ERROR
    }

    /**
     * 直播状态
     */
    public enum TvlivePublishStatus {
        //草稿
        DRAFT,
        //发布中(废弃状态)
        PUBLISHING,
        //启用
        STARTING,
    }

    /**
     * 试题类型添加来源枚举
     */
    public enum ExamQuestionQuestionTypeAndGoType {
        //管理员添加
        BACKSTAGE,
        //个人中心考试闯关添加
        CORE
    }

    /**
     * 考试试题批量添加格式方案类型
     */
    public enum ExamQuestionBatchAddFormatType {
        //标准版
        STANDARD,
        //问卷星
        WJX
    }

    /**
     * 试题难易度
     */
    public enum DifficultyType {
        //低
        LOW,
        //中
        MIDDLE,
        //高
        HIGH
    }

    /**
     * 考试试题状态
     */
    public enum ExamStatus {
        //草稿
        DRAFT,
        //启用
        NORMAL,
        //审核中
        INREVIEW,
        //拒绝
        REJECTED
    }

    /**
     * 考试活动状态
     */
    public enum ExamActiveStatus {
        //草稿
        DRAFT,
        //发布中
        PUBLISHING,
        //启用
        STARTING,
        //结束
        FINISH,
    }

    /**
     * 论坛类型
     * BBS状态
     */
    public enum BbsStatus {
        //草稿
        DRAFT,
        //发布
        STARTING,
        //撤销
        CANCEL,
    }

    /**
     * 考试活动前台筛选状态
     */
    public enum ExamActiveFrontStatus {
        //未开始
        NOTSTARTED,
        //进行中
        UNDERWAY,
        //已完成
        DONE,
    }

    /**
     * 考试活动前台筛选状态
     */
    public enum ExamUserInfoStatus {
        //未开始
        NOTSTARTED,
        //已完成
        DONE,
    }

    /**
     * 评卷来源
     */
    public enum MarkFrom {
        //考生点击考试完成
        SUBMIT_FINISH,
        //评卷老师进行主观题评卷
        OBJECT_MARK,
    }

    /**
     * 证书类型(废弃)--》采用数据字典：CERTIFICATE_TYPE
     */
    public enum CertificateType {
        //课程证书
        COURSE,
        //考试证书
        EXAM
    }

    /**
     * 产品错误代码状态
     */
    public enum FaultCodeStatus {
        //草稿
        DRAFT,
        //启用
        NORMAL,
        //禁用
        DISABLED
    }

    /**
     * 考试活动类型
     */
    public enum ActiveType {
        //独立考试
        EXAM,
        //培训活动考试
        TRAIN,
        //在线学习考试
        ONLINE
    }

    /**
     * 评卷状态
     */
    public enum JudgeStatus {
        //未评卷
        NOTSTART,
        //评卷中
        JUDGEING,
        //已完成
        COMPLETED
    }

    /**
     * 语言配置归属
     */
    public enum LanguageStatus {
        //所有
        ALL,
        //前段
        FRONT,
        //服务
        SERVICE
    }

    /**
     * 类型
     */
    public enum BannerType {
        //富文本
        RICH_TEXT,
        //地址
        URL,
        //学习资源
        RESOURCE
    }

    /**
     * 资源类型
     */
    public enum BannerResourceType {
        //考试
        EXAM,
        //班级
        CLASS,
        //课程
        COURSE,
        //专栏
        SPECIAL_COLUMN,
        //年度计划
        YEARR_PLAN,
    }

    public enum BannerStatus {
        //草稿
        DRAFT,
        //启用
        STARTING,
    }

    /**
     * 培训计划反馈状态
     */
    public enum TrainPlanGroupDetailStatus {
        //为完成
        UNFINSIH,
        //已完成
        FINISH
    }

    /**
     * 培训计划角色枚举
     */
    public enum TrainPlanRoleType {
        //学员
        STUDENT,
        //导师
        TEACHER,
        //经理
        MANAGER
    }

    /**
     * 考试试题状态/试卷类型
     */
    public enum NatureType {
        //正式
        FORMAL,
        //临时
        TEMP
    }

    /**
     * 培训计划模板
     */
    public enum TrainPlainTemplateType {
        //学习
        STUDY,
        //辅导
        TUTORIAL,
        //行动计划
        ACTION
    }

    /**
     * 状态,0未开始 1进行中 2异常(关闭)退出 3中途保存后退出 6正常完成 7时间结束
     */
    public enum ExamRegisterStatus {
        //未开始
        NOTSTART,
        //进行中
        UNDERWAY,
        //中途保存后退出
        MIDSAVEEDEXIT,
        //正常完成
        NORMALFINISH,
        //时间结束
        TIMEOUT,
        //计算成绩中
        FINISH_CALC,
        //评卷中
        MARKING_CALC,
        //超时计算成绩中
        TIMEOUT_CALC,
        //切屏次数满提交完成
        FULL_SWITCH_SCREEN
    }

    /**
     * 评卷方式
     */
    public enum JudgeStyle {
        //试卷
        PAPER,
        //题型
        PAPERTYPE,
        //试卷
        QUESTION
    }

    /**
     * 讲师级别枚举
     * TrainTeacherLevel.type
     */
    public enum TeacherLevelType {
        //根目录
        ROOT,
        //讲师类别
        CATEGORY,
        //讲师级别
        LEVEL
    }

    /**
     * 上传文件协议类型
     * common_server_config.type
     */
    public enum UploadProtocolType {
        LOCAL("本地协议"),
        FTP("FTP协议"),
        QINIU_CLOUD("七牛云"),
        TENCENT_CLOUD("腾讯云"),
        ALIYUN_OSS("阿里云oss");
        String typeName;

        UploadProtocolType(String name) {
            this.typeName = name;
        }

        public String getTypeName() {
            return typeName;
        }
    }


    /**
     * 课程类型
     * course_info.type
     */
    public enum CourseType {
        //在线课程
        ONLINE,
        //面授课程
        OFFLINE,
        //系列课程
        PACKAGE,
        //其他
        OTHER,
    }

    /**
     * 放弃类型
     */
    public enum OverType {
        //随时可放弃
        ANYTIME,
        //不可放弃
        NOOVER,
        //间隔时间内可放弃
        OVERINTIME
    }

    /**
     * 维度的业务类型
     */
    public enum DimensionsType {
        //调研
        SURVEY,
        //评估
        ASSESS
    }

    /**
     * 问卷类型
     */
    public enum TrainSurveyTemplateType {
        //调研
        SURVEY,
        //评估
        ASSESS,
        //混合
        ALL
    }

    /**
     * 测评参与方式：train_evaluation.join_way
     */
    public enum EvaluationJoinWay {
        //指定测试
        APPOINT_TEST,
        //报名测试
        SIGNUP_TEST
    }

    /**
     * 测评方式：train_evaluation.evaluation_way
     */
    public enum EvaluationWay {
        //DISC
        DISC,
        //大五人格
        BIG_FIVE_PERSONALITY,
        //贝尔宾
        BELBIN
        //其他
        ,OTHER
    }

    /**
     * 测评状态：train_evaluation.status
     */
    public enum EvaluationStatus {
        //草稿
        DRAFT,
        //发布中
        PUBLISHING,
        //启用
        PUBLISH,
        //撤销
        CANCEL,
        //结束
        FINISH,
    }

    /**
     * 测评统计维度类型：train_evaluation.evaluation_stat_type
     */
    public enum EvaluationStatType {
        //按试题
        QUESITON,
        //按答案
        ANSWER,
        //按矩阵题干
        MATRIX_QUESTION
    }

    /**
     * 测评用户状态：train_evaluation_user.status
     */
    public enum EvaluationUserStatus {
        //待审核
        WAIT_AUDIT,
        //审核拒绝
        AUDIT_REFUSE,
        //未参加
        TODO,
        //已完成
        FINISH
    }

    public enum EvaluationListStatus {
        //未开始
        NOT_START,
        //进行中
        UNDER_WAY,
        //已完成
        FINISH
    }


    /**
     * 测评题目类型：train_evaluation_question.question_type
     */
    public enum EvaluationQuestionType {
        //单选
        SINGLE,
        //填空
        FILL,
        //矩阵单选
        MATRIX_SINGLE,
        //矩阵填空
        MATRIX_FILL,
    }

    /**
     * 讲师状态枚举
     * TRAIN_TEACHER.status
     */
    public enum TrainTeacherStatus {
        //激活
        ACTIVE,
        //休眠
        SLEEP,
        //解雇
        APPROVAL
    }

    /**
     * 外部培训机构状态枚举
     * TRAIN_TEACHER.status
     */
    public enum TrainExternalMechanismStatus {
        //激活
        ACTIVE,
        //休眠
        SLEEP,

    }

    /**
     * 婚姻状况
     * MaritalStatus
     */
    public enum MaritalStatus {
        //未婚
        UNMARRIED,
        //已婚
        MARRIED
    }

    /**
     * 性别
     * Sex
     */
    public enum Sex {
        //男
        MALE,
        //女
        FEMALE
    }

    /**
     * 用户状态
     * UserStatus
     */
    public enum UserStatus {
        //禁用
        DISABLED,
        //启用
        ENABLED,
        //冻结
        FREEZE,
        //外部客户人员：待确认
        TOCONFIRM
    }

    /**
     * 用户类型
     * UserType
     */
    public enum UserType {
        //正式员工
        FORMALEMP,
        //临时员工
        TEMPEMP,
        //离职员工
        LEAVEEMP,
        //金蝶生态圈合作伙伴
        PARTNER
    }

    /**
     * 用户属性
     * UserType
     */
    public enum UserAttribute {
        //工程师
        ENGINEER,
        //经销商
        DEALER,
        //客户
        CUSTOMER,
        //其他
        OTHER
    }

    /**
     * 是否讲师
     * Sys_User.isTeacher
     */
    public enum UserIsTeacher {
        //是
        YES,
        //否
        NO;
    }

    /**
     * 消息类型
     * SYS_MESSAGE_TEMPLATE.messageTypeId
     */
    public enum MessageType {
        //站内消息
        STATION_MSG,
        //邮箱
        EMAIL,
        //短信
        SMS
    }

    /**
     * 消息模板配置状态
     * message_template_config.status
     */
    public enum MessageTemplateConfigStatus {
        //禁用
        DISABLED,
        //启用
        ENABLED,
        //自定义
        CUSTOMIZE
    }

    /**
     * 培训班状态
     * TrainProjectClassEntity.status
     */
    public enum TrainClassStatus {
        //草案
        DRAFT,
        //审批中
        AUDITING,
        //已发布
        PUBLISH,
        //开班中
        OPENCLASS,
        //结束
        FINISH,
        //班级结束中
        FINISHING,
        //撤销
        CANCLE,
    }

    /**
     * 月度计划关联培训班的状态
     * TrainProjectClassEntity.status
     */
    public enum MonthTrainClassStatus {
        //草案
        DRAFT,
        //审批中
        AUDITING,
        //已发布
        PUBLISH,
        //开班中
        OPENCLASS,
        //结束
        FINISH,
        //结束中
        FINISHING,
        //撤销
        CANCLE,
        //未实施
        NO_IMPLEMENTATION,
    }


    /**
     * 内外部类型
     * TrainProjectClassEntity.trainType,现在采用参数字典下拉选择
     */
    public enum InOuterType {
        //内部
        IN,
        //外部
        OUT
    }

    /**
     * 计划类型
     * TrainProjectClassEntity.planType
     */
    public enum PlanType {
        //计划内
        INSIDE,
        //计划外
        OUTSIDE
    }

    /**
     * 班级活动类型
     * TrainClassCourseEntity.type
     */
    public enum TrainClassCourseType {
        //面授课程
        FACE,
        //自学课程
        SELF,
        //其他活动
        OTHDER
    }

    /**
     * 课程来源
     */
    public enum TrainClassType {
        //月度计划
        MONTHPLAN,
        //新增
        ADDSOURCE,
        //基于课程创建
        COURSEBASE
    }

    /**
     * 缺勤异常类型
     */
    public enum AttendanceType {
        //未打卡
        UNPUNCH,
        //迟到
        LATE,
        //早退
        EARLY,
        //中途离场
        LEAVE,
        //缺卡
        LESS,
        //正常
        NORMAL,
        //不考勤
        NONEED,
        //请假
        ASKLEAVE
    }

    /**
     * 签到方式
     */
    public enum SignType {
        //定位
        LOCATION,
        //二维码
        QR_CODE,
        //拍照
        PHOTO
    }

    /**
     * 打卡类型
     */
    public enum PunchType {
        //签到
        SIGNIN,
        //签退
        SIGNOUT;
    }

    public enum TrainMonthPlanOrigin {
        //年度计划
        YEAR,
        //月度计划
        MONTH
    }

    /**
     * 评估方式
     */
    public enum AssessWay {
        //线上
        ONLINE,
        //线下
        OFFLINE,
        //混合
        BLEND
    }

    /**
     * 报名方式
     * train_class_user_info.user_source
     */
    public enum UserSource {
        //指定用户
        ASSIGN,
        //部门提报
        DEPART,
        //自主报名
        SELF
    }

    /**
     * 报名状态CONFIRM
     * train_class_user_info.status
     */
    public enum ApplyStatus {
        //待确认
        TOCONFIRM,
        //待审核
        TOAUDIT,
        //已确认
        CONFIRM,
        //已拒绝
        REFUSE,
        //已放弃
        ABANDOM
    }

    /**
     * 报名or确认
     */
    public enum ApplyOrConfirm {
        //确认
        CONFIRM,
        //报名
        APPLY
    }

    /**
     * 培训班审核人员
     */
    public enum ClassAuditOperate {
        //同意
        AGREE,
        //拒绝
        REFUSE,
        //放弃
        ABANDOM;
    }

    /**
     * 奖惩类型
     */
    public enum IncentiveType {
        //明白
        UNDERSTAND,
        //记过
        DEMERIT,
        //奖励
        AWARD,
        //评优
        APPRAISE
    }

    /**
     * 消息收发类型
     */
    public enum SendOrReceive {
        //发送
        SEND,
        //收取
        RECEIVE
    }

    /**
     * 消息状态
     */
    public enum NoticeState {
        //草稿
        DRAFT,
        //已发送
        SENDED,
    }

    public enum ReadState {
        //未读
        UNREAD,
        //已读
        READ
    }

    public enum MessageStatus {
        //正常
        NORMAL,
        //回收站
        SOFT_DELETE,
        //彻底删除
        HARD_DELETE,
    }

    public enum MessageStatusStatus {
        //回收站
        SOFT_DELETE,
        //彻底删除
        HARD_DELETE,
        //已读
        READ,
        //未读
        UNREAD
    }

    /**
     * 删除
     */
    public enum DeleteType {
        //软删除
        SOFT,
        //硬删除
        HARD
    }

    /**
     * 消息类型
     */
    public enum DataTypeName {
        //普通消息
        NORMAL,
        //班级报名
        CLASS_APPLY,
        //班级开班
        CLASS_OPEN,
        //班级关闭
        CLASS_CLOSE;
    }

    /**
     * 课程完成规则
     * COURSE_OFFERING.finishType
     */
    public enum CourseFinishType {
        //自动完成
        AUTO_FINISH,
        //管理员标记完成
        ADMIN_MARK_FINISH,
        //课后考试完成
        AFTER_COURSE_EXAM_FINISH
    }

    /**
     * 课程适用终端
     * COURSE_INFO.clientType
     */
    public enum CourseClientType {
        //电脑端
        PC,
        //APP端
        APP
    }

    /**
     * 课程课件类型
     */
    public enum CourseWareType {
        //Scorm 1.2
        SCORM,
        //文档
        DOC,
        //视频
        VIDEO,
        //url
        URL,
        //其他
        OTHER
    }

    public enum StudyStatus {
        //未开始
        NotStarted,
        //学习中
        Processing,
        //完成
        Completed,
        //失败
        Fail
    }

    /**
     * 课程课件章节类型
     * COURSE_SCORM_ITEM.type
     */
    public enum CourseScormItemType {
        ASSET,
        FILE,
        SCO
    }

    /**
     * 课程课件类型
     * COURSE_SCORM_INFO.type
     */
    public enum CourseScormType {
        SCORM,  //Scorm 1.2
        DOC,    //文档
        VIDEO,  //视频
        URL,    //URL
//      OTHER   //其他
    }

    /**
     * 外部课程供应商类型
     * COURSE_SUPPLIER.type
     */
    public enum CourseSupplierType {
        MAIDUO,  //麦朵
        ZHONGOU, //中欧
        SCHO,//思酷
        DDI,//DDI
    }

    public enum BeforeOrAfter {
        //之前
        BEFORE,
        //之后
        AFTER
    }

    /**
     * 消息模板code
     */
    public enum MessageTemplateCode {
        //以下所有消息通用参数 baseUrl：PC根目录, baseAppUrl: APP根目录
        //考试发布通知 name:考试活动名称,beginTime:考试活动开始时间,endTime:考试活动结束时间,testTime:考试时长,id:考试活动ID
        examMessage,
        //考试评卷通知 id:考试活动ID,name:考试活动名称
        examJudge,
        //考试成绩通知 id:考试活动ID,name:考试活动名称,score:成绩
        examScore,
        //考试成绩通知（不显示分数） id:考试活动ID,name:考试活动名称 passFlag：是否通过
        examScoreNoShowScore,
        //考试评卷完成通知 id:考试活动ID,name:考试活动名称,score:成绩
        examJudgeFinish,
        //考试活动开始前30分钟 name:考试活动名称,beginTime:考试活动开始时间,endTime:考试活动结束时间,testTime:考试时长,id:考试活动ID
        examStart30Minuts,
        //考试报名通知  name:考试活动名称,beginTime:考试活动开始时间,endTime:考试活动结束时间,testTime:考试时长,id:考试活动ID
        examApplyMessage,
        //考试报名通过通知 id:考试活动ID,name:考试活动名称
        examApplyApprove,
        //考试报名拒绝通知 id:考试活动ID,name:考试活动名称
        examApplyReject,
        //考试报名推送通知 id:考试活动ID,name:考试活动名称,data:文本框内容,subject:标题
        examApplyPushMessage,
        //考试注册推送通知 id:考试活动ID,name:考试活动名称,data:文本框内容,subject:标题
        examRegisterPushMessage,
        //评估项目通知 id:调研ID，name：调研名称,startTime：调研开始时间,endTime：调研结束时间
        trainAssessmentSendMessage,
        //课程催学 id:课程ID,name:课程名称
        courseUrgencyStudy,
        //课程修改通知
        courseModifyMessage,
        //课程推送 id:课程ID,name:课程名称,beginTime:开始时间,endTime结束时间
        coursePushNotice,
        //课程推送（合并版） name:推送名称
        coursePushUnionNotice,
        //培训报名通知 id:班级ID,name:班级名称,data:文本框内容,subject:标题
        trainClassSignNotice,
        //培训开班通知 id:班级ID,name:班级名称,data:文本框内容,subject:标题
        trainClassOpenNotice,
        //培训取消通知 id:班级ID,name:班级名称,data:文本框内容,subject:标题
        trainClassUndoNotice,
        //培训延期通知 id:班级ID,name:班级名称,data:文本框内容,subject:标题
        trainClassDenyNotice,
        //培训其他通知 id:班级ID,name:班级名称,data:文本框内容,subject:标题
        trainClassOtherNotice,
        //培训报名通知（触发）_公开 id:班级ID,name:班级名称,beginTime:开始时间,endTime结束时间
        trainClassSignNoticeTriggerStu,
        //培训报名通知（触发）_固定 id:班级ID,name:班级名称,beginTime:开始时间,endTime结束时间
        trainClassSignNoticeTriggerAssign,
        //培训报名通知（触发）_提报 id:班级ID,name:班级名称,beginTime:开始时间,endTime结束时间
        trainClassSignNoticeTriggerOrg,
        //培训开班通知（触发）_学员 id:班级ID,name:班级名称
        trainClassOpenNoticeTriggerStu,
        //培训结束通知 id:班级ID,name:班级名称
        trainClassEndNotice,
        //培训取消通知_触发 id:班级ID,name:班级名称
        trainClassUndoNoticeTrigger,
        //培训班审核通过通知 id:班级ID,name:班级名称,date:审核时间
        trainClassAuditPass,
        //培训班审核拒绝通知 id:班级ID,name:班级名称,date:审核时间
        trainClassAuditRefused,
        //调研项目通知 id,name,beginTime,endTime
        trainSurveySendMessage,
        //独立报名通知 id,title,beginTime,endTime
        aloneSignUpSendMessage,
        //调研项目催办 id,name,beginTime,endTime
        trainSurveyReminders,
        //测评项目通知
        trainEvaluationNotice,
        //系列课程发布通知 id:课程ID,name:课程名称
        studyPathPublishNotice,
        //密码修改通知 id:用户ID,name:用户名称
        passwordEdit,
        //课程发布通知 id:课程ID,name:课程名称
        coursePublicMessage,
        //课时学分任务通知
        hourCreditTaskMessage,
        //辅导计划导师通知
        tutorPlanTutorNoticeMessage,
        //辅导计划执行通知（执行人）
        tutorPlanExecExecerNoticeMessage,
        //辅导计划执行通知（辅导老师）
        tutorPlanExecTutorNoticeMessage,
        //辅导计划安排通知（执行人）
        tutorPlanArrangeExectorNoticeMessage,
        //辅导计划安排通知（辅导导师）
        tutorPlanArrangeTutorNoticeMessage,
        //辅导计划安排通知（部门经理）
        tutorPlanArrangeManagerNoticeMessage,
        //辅导计划启动通知（执行人）
        tutorPlanStarupExectorNoticeMessage,
        //辅导计划启动通知（辅导导师）
        tutorPlanStarupTutorNoticeMessage,
        //辅导计划启动通知（部门经理）
        tutorPlanStarupManagerNoticeMessage,
        //课程推送自定义通知
        coursePushCustomMessage,
        //讲师评卷消息
        teacherJudgeMessage,
        //培训结束通知（无评估，无行动计划） id:班级ID,name:班级名称
        trainClassEndNoAssessNoActionPlanNotice,
        //培训结束通知（无评估，有行动计划） id:班级ID,name:班级名称
        trainClassEndNoAssessHasActionPlanNotice,
        //培训结束通知（有评估，有行动计划） id:班级ID,name:班级名称
        trainClassEndHasAssessHasActionPlanNotice,
        //培训结束学员上级通知（有行动计划） id:班级ID,name:班级名称
        trainClassEndHasActionPlanForManagerNotice,

        //能力测评通知
        abilityAssessmentMessage,
        //被提报人通知/id,name,beginTime,endTime
        projectOrgUserMessage,
        //流程审批通知
        workflowNotice,
        //流程审批通过通知
        workflowPassNotice,
        //流程审批决绝/驳回通知
        workflowNotPassNotice,
        //外部人员档案新增通知
        outerPersonDataAddNotice,
        //部门负责人发送开班消息
        trainClassPublishToManagerNotice,
        //辅导计划安排通知（新人入职）
        tutorPlanArrangeNewEmployeeMessage,
        //讲师到期提醒
        trainTeacherReminderOfExpiryMessage,
        //系列课程发布人事专员提醒
        personnelCommissionerNotice,
        //兑换礼品,发送兑换码
        redeemCodeNotice
        //礼品兑换成功提醒
        ,redeemCodeSuccessNotice
        //礼品兑换失败
        ,redeemCodeErrorNotice
        //积分变更通知
        ,integralChangeNotice
        //徒弟候选人签定师徒协议通知
        ,candidateNotice
        //优秀生没有两个师傅的提醒通知
        ,excellentNotTwoMasterNotice
        //培养情况未填写提供通知
        ,trainSituationNotWriteNotice
    }

    /**
     * 管理员id
     */
    public static final String MANAGER_ID = "1";
    public static final Long DEFAULT_ORG_ID = 10001L;

    /**
     * 调研问卷状态
     */
    public enum TrainSurveyStatus {
        //草稿
        DRAFT,
        //已发布
        PUBLISH,
        //发布中
        PUBLISHING
    }

    public enum ScheduleStatus {
        /**
         * 正常
         */
        NORMAL,
        /**
         * 暂停
         */
        PAUSE
    }

    /**
     * 调研前端查询状态
     */
    public enum TrainSurveyFrontStatus {
        //待参加
        NOTSTARTED,
        //已完成
        DONE,
        //已过期
        EXPIRED
    }


    /**
     * 问卷答题状态
     */
    public enum TrainPaperStatus {
        //未参加
        TODO,
        //已完成
        FINISH
    }

    /**
     * 问卷注册类型
     */
    public enum TrainSurveyUserBusinessType {
        //评估
        ASSESS,
        //调研
        SURVEY
    }

    /**
     * 系列专题发布状态
     * COURSE_STUDY_PATH.status
     */
    public enum SeriesTopicsPublishStatus {
        //未发布
        UN_PUBLISHED,
        //已发布
        PUBLISHED,
        //过期
        EXPIRED
    }

    /**
     * 系列专题附件类型
     * COURSE_PATH_ENCLOSURE.type
     */
    public enum SeriesTopicsEnclosureType {
        //学员
        STUDENT,
        //讲师
        LECTURER,
        //管理员
        ADMIN
    }

    /**
     * 系列课程元素类型
     */
    public enum PackageItemType {
        //线上课程
        ONLINE_COURSE,
        //线下课程
        OFFLINE_COURSE,
        //考试
        EXAM,
        //作业
        HOMEWORK,
        //调研
        SURVEY,
        //评估
        ASSESSMENT,
        //文档（待拓展）
        DOCUMENT,
        //其他
        OTHER
    }


    /**
     * 系列专题注册学员是否完成
     * COURSE_PATH_APPLY.is_finish
     */
    public enum SeriesTopicsIsFinish {
        //未开始
        NO_START,
        //学习中
        STUDYING,
        //完成
        FINISHED,
        //已认证
        CERTIFIED,
        //已放弃
        ABANDONED,
    }

    /**
     * 工作角色关联账户的添加类型
     */
    public enum UserJobRoleType {
        //手动
        HAND,
        //自动
        AUTO
    }

    /**
     * 工作角色参数类型
     */
    public enum JobRoleValueType {
        //日期
        DATE,
        //字符串
        STRING,
        //整型
        INT
    }

    /**
     * 工作角色参数组件类型
     */
    public enum JobRoleValueInputType {
        //职位
        JOBSELECT,
        //职位类型
        JOBCATEGORY,
        //部门
        ORGSELECT,
        //日期
        DATE,
        //输入框
        INPUT,
        //职务族
        DUTY_FAMILY,
        //职务类
        DUTY_CATEGORY,
        //职务子类
        DUTY_SUB_CATEGORY,
        //职务
        DUTY,
        //职层
        JOB_LEVEL,
        //职等类别
        GRADE_CATEGORY,
        //职等子类别
        GRADE_SUB_CATEGORY,
        //职等表
        JOB_RANK_TABLE,
        //职等
        GRADE,
        //职衔
        JOB_RANK,
        //职级
        RANK,
        //用工关系类型
        EMPLOY_RELATION_TYPE,
        //用工关系状态
        EMPLOY_RELATION_STATUS,
        //职称
        TITLE,
        //外部职称
        OUT_TITLE,
        //学历
        EDUCATION
    }

    /**
     * 行动计划类型
     */
    public enum TutorPlanType {
        //能力计划
        ABILITY,
        //发展计划
        DEVELOP,
        //学习计划
        STUDY;
    }

    /**
     * 行动计划状态
     */
    public enum TutorPlanStatus {
        //草稿
        DRAFT,
        //启用
        USING
    }

    /**
     * 行动计划活动类型
     */
    public enum TutorPlanModuleType {
        //在线课程
        SELFCOURSE,
        //线下课程
        FACECOURSE,
        //系列课程
        STUDYPATH,
        //培训班级
        TRAINCLASS,
        //考试活动
        EXAM
    }

    //行动计划反馈类型
    public enum TutorPlanFeedbackType {
        //学员反馈
        STUDENT,
        //讲师反馈
        TEACHER
    }

    /**
     * 行动计划学员状态
     */
    public enum TutorPlanUserStatus {
        //未启用
        NOTBEGIN,
        //学习中
        INSTUDY,
        //已完成
        FINISH
    }

    /**
     * 课程注册申请状态
     * COURSE_USER_REGIST.status
     */
    public enum CourseUserRegistStatus {
        //待审
        WAIT_AUDIT,
        //拒绝
        REFUSE,
        //审批成功-》学习未开始
        UNSTART,
        //学习中
        PROCESSING,
        // 学习完成->如果有考试
        WAIT_EXAM,
        // 考试失败
        EXAM_FAIL,
        // 学习完成（无考试） 考试成功
        WAIT_TAG,
        //完成
        FINISH,
        EXAM_JUDGING
    }

    /**
     * 课程注册申请状态
     * COURSE_USER_REGIST.status
     */
    public enum CourseUserExamStatus {
        //未开始
        UNSTART,
        //通过
        PASS,
        //失败
        FAIL
    }


    /**
     * 课程注册类型
     * COURSE_USER_REGIST.type
     */
    public enum CourseUserRegistType {
        //自主注册
        SELF_REGIST,
        //系列课程推送
        PACKAGE_PUSH,
        //班级课程
        CLASS_COURSE,
        //能力推送
        ABILITY_PUSH,
        //学习请求
        STUDY_REQUIRE,
        //推送规则
        PUSH_RULE,
        //职位推送
        JOB_PUSH,
        //工作角色推送
        JOB_ROLE_PUSH,
        //上级推送
        SUPERIOR_PUSH
    }

    /**
     * 系列专题申请状态
     * COURSE_PATH_APPLY.status
     */
    public enum CoursePathApplyStatus {
        APPLYING,//申请中
        PASS,//通过
        REFUSE,//拒绝
        CERTIFIED,//认证
        INVALID,//失效
        NO_CERTIFICATION,//不发证
        CERTIFIED_AUDIT_PASS,//认证审核通过
        APPLY_CERTIFICATION,//申请发证
    }

    /**
     * 课程系列专题申请类型
     * COURSE_PATH_APPLY.type
     */
    public enum CoursePathApplyType {
        APPLY,//申请
        POSITION_PUSH,//岗位推送
        RULE_PUSH,//规则推送
        IDP,//IDP人才发展计划
    }

    /**
     * sys_user_job.type
     * sys_user_position.type
     * 主次职位/岗位
     */
    public enum MainOrMinor {
        //主要
        MAIN,
        //次要
        MINOR,
    }

    /**
     * 排行榜类型
     */
    public enum RankingListType {
        //总榜
        TOTAL,
        //月榜
        MONTH,
    }

    /**
     * 受众对象业务类型
     * SysAccessEntity.AccessType
     */
    public enum AccessType {
        //考试
        EXAM,
        //班级
        CLASS,
        //学习路径
        STUDY_PATH,
        //知识库
        DOC_INFO,
        //课程
        COURSE,
        //调研
        SURVEY,
        //商品
        GOODS,
        //BANNER图
        BANNER,
        //专栏
        SPECIAL_COLUMN,
        //直播
        TV_LIVE,
        //故障代码
        FAULT_CODE,
        //工作流模板
        WORKFLOW_TEMPLATE,
        //消息
        MESSAGE,
        //独立报名
        ALONE_SIGN_UP,
        //课时学分任务
        HOUR_CREDIT_TASK,
        //项目测评（性格测评）
        EVALUATION
    }

    /**
     * 明细类型
     * SysAccessDetailEntity.detailType
     */
    public enum AccessDetailType {
        //工作角色
        ROLE,
        //职位
        JOB,
        //部门
        DOMAIN,
        //用户
        USER
    }

    /**
     * 菜单类型
     * sys_menu.type
     */
    public enum MenuType {
        //节点
        NODE,
        //菜单
        MENU,
    }

    /**
     * 评星业务类型
     */
    public enum CommentScoreType {
        //课程
        COURSE,
        //知识库
        LIBRARY,
        //系列专题
        SERIES_TOPICS,
    }

    /**
     * 系统用户默认密码
     */
    public static final String USER_DEFAULT_PWD = "123456";

    /**
     * 培训通知类型
     */
    public enum TrainMessageType {
        //报名
        APPLY,
        //开班
        OPENCLASS,
        //取消
        CANCLE,
        //延期
        DELAY,
        //其他
        OTHER
    }

    /**
     * 删除类型
     */
    public enum TrainDeleteType {
        //班级
        CLASS,
        //学员
        USER,
        //部门提报人员
        ORG_USER,
        //考勤异常
        ATTENDANCE,
        //签到点
        SIGNPLACE,
        //考勤规则
        PUNCH_RULE,
        //打卡记录
        PUNCH_RECORD,
        //其他费用
        OTHER_FEE,
        //奖惩记录
        INCENTIVERE_CODE,
        //附件
        ATTACH
    }

    /**
     * 培训附件类型
     */
    public enum TrainAttachType {
        //纸质签到表
        SIGNTABLE,
        //资源附件
        RESOURCE,
        //培训总结附件
        SUMMARY
    }

    /**
     * 用户职能类型表
     */
    public enum SysUserFunctionType {
        //职级
        RANK,
        //职务
        DUTY,
        //职务子类
        DUTY_SUB_CATEGORY,
        //职务类
        DUTY_CATEGORY,
        //职务族
        DUTY_FAMILY,
    }

    /**
     * 用户职能状态表
     */
    public enum SysUserFunctionStatus {
        //启用
        NORMAL,
        //禁用
        DISABLED
    }

    /**
     * 问卷类型
     */
    public enum TrainSurveyFrontTemplateType {
        //组织调研
        ORG_SURVEY,
        //课程调研
        COURSE_SURVEY,
        //课程评估
        COURSE_ASSESS,
        //讲师评估
        TEACHER_ASSESS,
        //组织评估
        ORG_ASSESS,
        //统一问卷
        UNITY
    }

    /**
     * 问卷查询类型
     */
    public enum TrainSurveyTemplateInputType {
        //调研问卷
        SURVEY,
        //组织评估
        ORG_ASSESS,
        //课程评估
        COURSE_ASSESS
    }

    /**
     * 文档类型
     */
    public enum DocType {
        //文档
        DOCUMENT,
        //富文本
        RICH_TEXT
    }

    /**
     * 文档类型
     */
    public enum CategoryRelationType {
        //文档
        DOCUMENT,
        //在线课程
        COURSE,
        //学习专栏
        SPECIAL_COLUMN
    }

    /**
     * 知识文档状态
     */
    public enum DocStatus {
        //已发布
        PUBLISH,
        //未发布
        UNPUBLISH,
        //审核拒绝
        REFUSED,
        //待审核
        WAIT_AUDIT
    }

    public enum TvMessageType {
        //消息
        MESSAGE,
        //问题
        QUESTION,
        //公告
        NOTICE,
    }

    /**
     * 文档转换状态
     */
    public enum DocTransferState {
        //待转换
        TOTRANSFER,
        //转换成功
        SUCCESS,
        //转换失败
        FAILURE
    }

    /**
     * 文档转换业务类型
     */
    public enum TransferBusinessType {
        //知识库
        DOC,
        //课件
        COURSEWARE;
    }

    /**
     * 前端知识操作类型
     */
    public enum DocRecordOperateType {
        //查看
        BROWSE,
        //下载
        DOWNLOAD,
        //收藏
        FAVORITE,
        //取消收藏
        UNFAVORITE;
    }

    /**
     * 文档查询类型
     */
    public enum DocQueryType {
        /**
         * 所有
         */
        ALL,
        /**
         * 知识文档
         */
        DOCUMENT,
        /**
         * 知识宝典
         */
        RICH_TEXT,
        /**
         * 我的收藏
         */
        FAVORITE,
        /**
         * 我的文档
         */
        MYDOCUMENT,
        /**
         * 我的下载
         */
        DOWNLOAD
    }

    /**
     * 调研类型
     */
    public enum TrainSurveyType {
        //组织
        ORG,
        //课程
        COURSE
    }

    /**
     * 评估方式
     */
    public enum CourseAssessType {
        //课程
        COURSE,
        //讲师
        TEACHER
    }

    public enum AssessmentPaperStyle {
        //分卷
        SEPARATE,
        //统一
        UNITY
    }

    /**
     * 评估类型
     */
    public enum ClassAssessType {
        //组织
        ORG,
        //课程
        COURSE,
        //讲师
        TEACHER
    }

    /**
     * 知识权限申请类型
     */
    public enum DocApplyType {
        //查看
        QUERY,
        //下载
        DOWNLOAD;
    }

    /**
     * 知识权限申请状态
     */
    public enum DocRequestStatus {
        //待审核
        TOAUDIT,
        //同意
        AGREE,
        //拒绝
        REFUSE
    }

    /**
     * 知识权限申请审核
     */
    public enum DocRequestOperateType {
        //同意
        AGREE,
        //拒绝
        REFUSE
    }

    /**
     * 事件类型，使用首字母大写的命名方式，以便命名Service
     */
    public enum EventType {
        //当学员学习情况改变时触发
        OnlineCourseRegisterChange,
        PackageCourseRegisterChange,
        OfflineCourseRegisterChange,
        //考试状态变
        ExamRegisterChange,
        //考试提交评卷中时触发
        ExamSubmitChange,
        //最优成绩改变
        ExamUserInfoChange,
        //培训结束
        TrainClassFinish
    }

    public enum FavoriteType {
        /**
         * 课程
         */
        COURSE
    }

    public enum TrainYearPlanStatus {
        //草稿
        DRAFT,
        //审批中
        INAUDIT,
        //通过
        PASSED,
        //取消计划
        CANCEL
    }

    /**
     * 年度培训计划详情-计划类型（欣锐定制）
     * TRAIN_YEAR_PLAN_DETAIL.PLAN_TYPE
     */
    public enum YearPlanDetailType {
        //固定执行
        FIXED_EXECUTE,
        //浮动执行
        FLOAT_EXECUTE
    }

    public enum TrainPlanTemplateStatus {
        //草稿
        DRAFT,
        //启用
        ENABLED
    }

    public enum TrainPlanTestMethod {
        //网络测试
        ONLINE_TEST,
        //书面考试
        PAPER_TEST,
        //提问交流李
        ASK_TEST,
        //现实操作
        OFFLINE_TEST,
        //情景演练
        SIMULATE,
        //案例报告
        DOC_REPORT,
        //综合评估
        SYNTHETIC,
        //其他
        OTHER
    }

    /**
     * 考生考试状态
     */
    public enum ExamActiveUserStatus {
        //未考试
        NOTSTARTED,
        //已通过
        PASS,
        //未通过
        NOPASS,
        //待评卷
        WAITJUDGE,
    }

    /**
     * 商品兑换方式
     */
    public enum AllotType {
        //自取
        SELF,
        //寄送
        MAIL,
        //柜机自取
        DISPLAY_SELF,
    }
    /**
     * 流程类型
     */
    public enum WorkFlowType {
        //标准流程
        STANDARD,
        //云之家
        YUNZHIJIA
    }

    public enum RECORD_STATUS {
        Pend,
        Process,
        Complete
    }

    public enum LiveStatus {
        //未开始
        NotStart,
        //直播中
        Living,
        //加载中
        Pending,
        //完成
        Completed
    }

    /**
     * 调研评估模板新增类型
     */
    public enum TrainSurveyTemplateAddType {
        //手动添加
        HAND,
        //拷贝
        COPY
    }

    /**
     * 班级二次编辑--修改关联业务类型
     */
    public enum ClassEditBizType {
        //课程
        COURSE,
        //调研
        SURVEY,
        //评估
        ASSESS,
        //考试
        EXAM
    }

    /**
     * 年度计划报名状态
     */
    public enum SignUpStatus {
        //未报名
        UNSIGNUP,
        //待确认
        UNCONFIRME,
        //已报名
        SIGNUPED
    }

    /**
     * 实施状态
     */
    public enum ImplementationStatus {
        //未实施
        UNIMPLEMENTATION,
        //已实施
        IMPLEMENTATIONED,
        //已规划(欣锐定制)
        PLANNED
    }

    public enum CodeGenerateBusinessType {
        //培训
        TRAIN,
        //讲师
        TEACHER,
    }

    public enum VisitType {
        //访问人数
        VISITNUM,
        //访问人次
        PERSONTIME,
    }

    public enum TimeType {
        //小时
        HOUR,
        //日
        DAY,
        //月
        MONTH,
        //年
        YEAR,
    }

    public enum WorkflowBusinessType {
        //administration
        YearPlan,
        MonthPlan,
        //培训开班审批
        OpenClass,
        //班级结束审批
        EndClass,
        //在线课程发布审批
        PublishOnlineCourse,
        //考试发布审批
        PublishExam,
        //直播申请审批
        PublishLive,
        //user
        //班级报名审批
        SignClass,
        //在线课程学习审批
        SignCourse,
        //知识上传审批
        UploadDocument,
        //知识下载审
        DownloadDocument,
        //外训申请审批
        OutTrainRequest,
        //培训需求申请
        TrainRequest,
        //内训师申请审批
        TeacherAudit,
        //内训师个人申请审批
        TeacherPersonAudit,
        //部门需求申请审批
        TrainNeedsAudit,
        //月度计划变更审批
        MonthPlanChange,
        //考勤请假审批
        AttendanceLeaveAudit,
        //课时学分积分申请
        SysHourCreditIntegralApply,
        //培训班级行动计划申请
        TrainClassActionPlanSubmit,
        //教室申请
        ClassRoomApply,
        //培训开班申请
        TrainOpenClassApply,
        //外派培训申请
        TrainOutApply,
        //讲师费用申请
        TrainTeacherFeeApply
    }

    public enum WorkflowBusinessTypeStatus {
        Operate, //拥有工作流就启用
        Required, //必须有工作流 否则报错
        Disabled //禁用

    }

    public enum WorkflowAuditType {
        //基础
        Basic,
        //并行
        Parallel,
        //会审
        Joint
    }

    public enum WorkflowProcessStatus {
        //进行中
        Process,
        //无人响应,
        NoResponse,
        //已催办
        Urge,
        //完成,
        Complete,
        //手动完成
        AdminComplete,
        //已驳回（只针对代办列表显示的状态）
        REJECT
    }

    //费用性质类型
    public enum FeeNatureType {
        //预算
        budgetFee,
        //实际/决算
        actualFee
    }

    //评估操作类型
    public enum AssessOpereateType {
        //进入
        ENTER,
        //查看
        VIEW,
        //不可操作
        NONE
    }

    /**
     * 独立报名状态
     */
    public enum AloneSignUpStatus {
        //已报名
        SIGNUPED,
        //未报名
        UNSIGNUP,
        //请假
        LEAVE
    }

    /**
     * 积分规则/30个
     */
    public enum IntegralRuleType {
        //每次系统登陆
        LOGIN,
        //参与学习
        JOIN_STUDY,
        //参与班级
        JOIN_PROJECT,
        //参与考试
        JOIN_EXAM,
        //查阅知识
        SEE_DOC,
        //参与直播
        JOIN_TV_LIVE,
        //参与调研
        JOIN_SURVEY,
        //发表讨论
        PUBLISH_COMMENT,
        //参与讨论
        JOIN_COMMENT,
        //讲师授课
        TEACHING,
        //在线课程(上传课程)
        UPLOAD_ONLINE_COURSE,
        //直播授课
        TV_LIVE_TEACHING,
        //班级管理员
        PROJECT_MANAGER,
        //积分打赏
        INTEGRAL_REWARD,
        //文档下载消耗积分
        DOCUMENT_DOWNLOAD,
        //积分兑换
        INTEGRAL_EXCHANGE,
        //积分悬赏
        OFFER_A_REWARD,
        //其他(积分初始化或者管理员手动增减)
        OTHER,
        //文档上传
        DOC_UPLOAD,
        //文档下载增加积分
        DOCUMENT_DOWNLOAD_ADD,
        //首次激活登陆账号
        FIRST_LOGIN,
        //连续登陆
        CONTINUE_LOGIN,
        //完成一次报名
        PROJECT_FINISH_SIGN,
        //报名后未出席培训
        SIGN_UP_BUT_UNATTENDANCE,
        //完成一次签到
        PROJECT_SIGN_IN,
        //给课程评星
        COURSE_INFO_RATE,
        //文档上传并通过审核
        DOC_UPLOAD_AND_PASS,
        //微课视频制作并上传
        VIDEO_UPLOAD,
        //文档或视频点击(实际就是进入在线课程详情就加一次)
        ONLINE_CLICK,
        //辅导老师对学员评估
        TRIAN_PLAN_SURVEY_TEACHER,
        //每日签到
        DAILY_CHECKIN,
        //课程点赞
        THUMBUP,
        //中外运额外积分
        ADD_INTEGRAL
    }

    /**
     * 积分动作
     */
    public enum IntegralAction {
        //获取
        ADD,
        //消耗
        REDUCE
    }

    /**
     * 课时学分任务状态
     */
    public enum HourCreditTaskStatus {
        //草稿
        DRAFT,
        //撤销
        CANCLE,
        //发布
        PUBLISH,
        //发布中
        PUBLISHING,
        //结束
        END
    }

    /**
     * 课时学分任务详情类型
     */
    public enum HourCreditTaskDetailType {
        //按课程目录要求
        COURSE_CATEGORY,
        //按课程类别要求
        COURSE_TYPE
    }

    /**
     * 课时学分任务注册完成状态
     */
    public enum HourCreditTaskRegisterStatus {
        //未完成
        UNFINSIH,
        //已完成
        FINISH
    }

    /**
     * 积分规则获取类型
     */
    public enum RuleType {
        //固定获取
        FIXED,
        //规则获取
        RULE
    }

    /**
     * 课程推送学员完成状态
     */
    public enum PushUserStatus {
        //未完成
        UNFINSIH,
        //已完成
        FINISH
    }

    /**
     * 课程推送学员添加类型
     */
    public enum PushUserAddType {
        //手动
        HAND,
        //自动
        AUTO
    }

    /**
     * 辅导计划阶段元素子项业务类型
     */
    public enum CoachPlanGroupDetailItemType {
        //课程
        COURSE,
        //文档
        DOCUMENT
    }

    //评估调研问卷保存方式
    public enum TrainSurveyPaperSaveType {
        //中途保存
        MIDSAVE,
        //提交
        SUBMIT
    }

    /**
     * 随即组卷模板发布状态
     */
    public enum ExamPolicyStatus {
        //草稿
        DRAFT,
        //发布
        PUBLISH
    }

    /**
     * 字段类型
     */
    public enum FiledType {
        //文本
        TEXTBOX,
        //下拉
        SELECT,
        //多选
        CHECKBOX,
        //单选
        RADIO,
        //数字框
        NUMBERBOX
    }

    /**
     * 人员审核状态
     */
    public enum UserAuditStatus {
        //待审核
        WAIT_AUDIT,
        //拒绝
        REFUSE,
        //通过
        PASS
    }

    /**
     * 广告或者通知
     */
    public enum BannerOrNotice {
        //广告
        BANNER,
        //通知
        NOTICE
    }

    /**
     * 线索报备状态
     */
    public enum ClueStatus {
        //待核实
        WAIT_VERIFY,
        //有效
        EFFECTIVE,
        //无效
        INVALID
    }

    /**
     * 重复注册的情况
     */
    public enum RepeatMobileType {
        //已注册
        REGISTED,
        //待审核
        AUDITING,
        //允许注册
        NONE
    }

    /**
     * 是否需要审核的情况
     */
    public enum IsAuditStatus {
        //审核中
        AUDITING,
        //已审核
        AUDITED
    }

    /**
     * 注册方式
     */
    public enum RegisterType {
        //移动端
        APP,
        //电脑端
        PC
    }

    /**
     * 论坛类型
     */
    public enum BbsType {
        //文章
        ARTICLE,
        //提问
        QUESTION
    }

    /**
     * 专家状态枚举
     */
    public enum TrainExpertStatus {
        //激活
        ACTIVE,
        //休眠
        SLEEP,
        //解雇
        APPROVAL
    }

    /**
     * 讲师级别枚举
     * TrainTeacherLevel.type
     */
    public enum ExpertLevelType {
        //根目录
        ROOT,
        //专家类别
        CATEGORY,
        //专家级别
        LEVEL
    }

    /**
     * 人员招聘状态
     * SysUserRecruit.status
     */
    public enum SysUserRecruitStatus {
        //招聘中
        RECRUITMENT,
        //未发布
        UNPUBLISHED,
        //已下线
        OFFLINE
    }

    /**
     * 招聘简历投递状态
     * SysUserRecruitDelivery.status
     */
    public enum SysUserRecruitDeliveryStatus {
        //待审核
        WAIT_AUDIT,
        //通过
        PASS,
        //拒绝
        REFUSE
    }

    /**
     * 随即组卷模板发布状态
     */
    public enum ExamRedPackSendType {
        //自动发送
        AUTO,
        //管理员发送
        ADMIN
    }

    /**
     * 培训评估类型
     */
    public enum TrainAssessType {
        //组织
        ORG,
        //课程
        COURSE
    }

    /**
     * 学分获得的方式
     */
    public enum AddCreditType {
        //课程
        COURSE,
        //考试
        EXAM,
        //主动申请
        APPLY,
        //培训
        TRAIN
    }

    public enum TrainTeacherAuditStatus {
        //草稿
        DRAFT,
        //审批中
        AUDITING,
        //通过
        PASSED,
        //未通过
        REFUSE
    }

    public enum TeacherApplyType {
        //个人申请
        SELF,
        //部门申请
        ORG
    }

    /**
     * 申请业务类型：train_teacher_temp.apply_biz_type
     */
    public enum TeacherApplyBizType {
        //个人申请
        SELF_APPLY,
        //个人调级
        SELF_LEVELING
    }

    /**
     * 培训班级学员行动计划状态:TRAIN_CLASS_USER_ACTION_PLAN.status
     */
    public enum TrainClassActionPlanStatus {
        //未开始
        NO_START,
        //进行中
        PROCESSING,
        //审批中
        AUDITING,
        //审批拒绝
        AUDIT_REFUSE,
        //已完成
        FINISHED,
    }

    public enum TrainDeclarationAuditStatus {
        //草稿
        DRAFT,
        //审批中
        AUDITING,
        //通过
        PASSED,
        //未通过
        REFUSE
    }

    /**
     * 培训班级学员在线课程学习情况状态
     */
    public enum TrainClassOnlineCourseStudyCondiStatus {
        //未完成
        UNFINSIH,
        //部分完成
        PARTIALLY_COMPLETED,
        //完成
        FINISHED,
    }

    /**
     * 学习等级规则 关系
     */
    public enum OrAnd {
        //或
        OR_O,
        //且
        AND_A
    }

    /**
     * 短信平台对接培训系统名称
     */
    public enum SmsDockingSystem {
        //大族
        HANSLASER,
        //坚朗
        KINLONG,
        //中外运
        SINOTRANS
    }

    public enum TemplateFiledType {
        //活动
        active,
        checkbox,
        radio,
        textbox,
        select,
        upload,
        numberbox,

    }

    /**
     * 考勤请假状态 TRAIN_CLASS_ATTENDANCE_LEAVE.status
     */
    public enum AttendanceLeaveStatus {
        //未申请
        NOT_APPLIED,
        //审批中
        AUDITING,
        //通过
        PASSED,
        //拒绝
        REFUSE
    }


    /**
     * 学分课时积分申请状态：SYS_HOUR_CREDIT_INTEGRAL_APPLY.status
     */
    public enum SysHourCreditIntegralApplyStatus {
        //草稿
        DRAFT,
        //审批中
        AUDITING,
        //未通过
        NOT_PASS,
        //已完成
        FINISHED;
    }

    /**
     * 教室申请 TRAIN_CLASS_ATTENDANCE_LEAVE.status
     */
    public enum ClassRoomApplyStatus {
        //未申请
        DRAFT,
        //审批中
        AUDITING,
        //通过
        PASSED,
        //拒绝
        REFUSE
    }

    /**
     * 教室使用类型
     */
    public enum RoomUseType {
        //培训班使用
        TRAIN_CLASS_USE,
        //个人申请
        PERSONAL_USE
    }

    /**
     * 单点登录类型
     */
    public enum SsoType {
        //无
        NONE,
        //CAS单点
        CAS,
        //AD域单点
        AD,
        //SSO单点
        SSO,
    }

    /**
     * 上级类型
     */
    public enum LeaderType {
        //直接
        DIRECT,
        //间接
        INDIRECT
    }

    /**
     * 学习地图-组完成状态
     */
    public enum CourseInfoPackageGroupFinishStatus {
        //未完成
        UNFINISH,
        //已完成
        FINISH
    }

    /**
     * 学习地图-组元素完成状态
     */
    public enum CourseInfoPackageGroupItemFinishStatus {
        //未完成
        UNFINISH,
        //已完成
        FINISH
    }

    /**
     * 学分获得来源-舒华专用
     */
    public enum getSourceType {
        //在线学习
        ONLINE,
        //面授课程
        OFFLINE,
        //个人申请
        SELF_APPLY
    }

    /**
     * 我的任务类型分类
     */
    public enum myTasksType {
        //考试
        EXAM,
        //调研
        TRAINSURVEY,
        //培训班级
        TRAINPROJECTCLASS,
        //在线课程
        COURSE,
        //系列课程
        COURSELEARNING
    }

    /**
     * 培训开班申请
     */
    public enum TrainOpenClassApplyStatus {
        //草稿
        DRAFT,
        //审批中
        AUDITING,
        //未通过
        REFUSE,
        //已完成
        PASSED;
    }

    /**
     * 月度计划开展情况
     */
    public enum PlanDevelopmentSituation {
        //延期开展
        DELAY,
        //提前开展
        ADVANCE,
        //正常开展
        NORMAL,
    }

    /**
     * 外派培训概申请状态
     */
    public enum TrainOutApplyStatus {
        //草稿
        DRAFT,
        //审批中
        AUDITING,
        //未通过
        REFUSE,
        //已完成
        PASSED;
    }

    /**
     * 找回密码的方式
     */
    public enum RetrieveType {
        //邮箱
        EMAIL,
        //密码
        MOBILE,
    }

    /**
     * 找回密码返回状态值
     */
    public enum RetrieveStatus {
        //邮件或短信发送成功
        SUCCESS,
        //账号不存在
        USER_NOT_EXISTS,
        //链接有误
        URL_ERROR,
        //邮件激活链接超时，3小时内有效
        TIME_OUT,
        //邮件发送失败
        SEND_EMAIL_FAIL,
        //短信发送失败，可能未配置短信平台
        SEND_MESSAGE_FAIL,
        //图形验证码错误
        CAPTCHA_ERROR
    }

    /**
     * 登陆方式
     */
    public enum LoginWayType {
        //平台账号密码登陆
        LMS,
        //cas账号密码登陆
        CAS,
        //异构系统单点登陆
        SSO,
        //HTTP方式校验
        HTTP,
        //AD域
        AD
    }

    /**
     * 导出类型
     */
    public enum ExportType {
        EXCEL,
        HTML,
        DOC
    }
    /**
     * 学分来源
     */
    public enum CreditSourceType {
        //在线课程
        ONLINE,
        //面授课程
        OFFLINE,
        //考试活动
        EXAM,
        //自我申请
        SELF_APPLY;
    }
    /**
     * 培训详情学习状态
     */
    public enum TrainDetailStudyStatus {
        //未开始
        UNSTART,
        //学习中
        PROCESSING,
        //已完成
        FINISH,
        //开班中
        OPEN_CLASS;
    }
    /**
     * 腾讯云短信 TEMPLATE ID 类型
     */
    public enum SMSTemplateType {
        //兑换通知
        REDEEM_NOTICE,
        //已取货
        REDEEM_SUCCESS
        //兑换失败
        ,REDEEM_ERROR
    }


    public enum TrainTeacherFeeApplyAuditStatus {
        //草稿
        DRAFT,
        //审批中
        AUDITING,
        //通过
        PASSED,
        //未通过
        REFUSE
    }

    //师徒审核状态
    public enum MasterApprenticeStatus {
        //草稿
        DRAFT,
        //审批中
        AUDITING,
        //未通过
        REFUSE,
        //通过
        PASSED,
    }

    //徒弟性质
    public enum ApprenticeNature {
        //新入职(作废)
        NEW_JOB,
        //转岗(作废)
        TRANSFER,
        //校招员工
        SCHOOL_RECRUIT_EMP,
        //社招员工
        SOCIAL_RECRUIT_EMP,
        //内招员工
        INSIDE_RECRUIT_EMP
    }

    //师父类型
    public enum masterType {
        //业务导师
        BUSINESS,
        //管理导师
        MANAGEMENT
    }

}
