package 实现和继承Demo.abcde;

public class B /*implements C */{

    //操作是否成功
    boolean success ;

    //操作代码
    int code /*= SUCCESS_CODE*/;

    //提示信息
    String message;

    public B(D d){
        this.success = d.success();
        this.code = d.code();
        this.message = d.message();

    }

}
