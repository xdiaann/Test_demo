package 实现和继承Demo.abcde;

public enum E implements D {

    SUCCESS(true,10000,"操作成功！"),
    FAIL(false,11111,"操作失败！");

    //操作是否成功
    boolean success;
    //操作代码
    int code;
    //提示信息
    String message;

    private E(boolean success,int code, String message){
        this.success = success;
        this.code = code;
        this.message = message;
    }

    @Override
    public boolean success() {
        return success;
    }

    @Override
    public int code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }
}
