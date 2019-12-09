package iinda.common;

import lombok.Data;

import java.io.Serializable;

/**
 *    通用响应体
 */
@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 4714328478455222345L;
    private T data; //服务端数据
    private int status = 200; //状态码，200：成功，-1：失败
    private String msg = ""; //描述信息

    public static Result isOk() {
        return new Result().msg("成功");
    }

    public static Result isFail() {
        return new Result().status(-1).msg("失败");
    }

    public static Result isFail(Throwable e) {
        return isFail().msg(e);
    }

    public Result msg(Throwable e) {
        this.setMsg(e.toString());
        return this;
    }

    public Result data(T data) {
        this.setData(data);
        return this;
    }

    public Result msg(String msg){
        this.setMsg(msg);
        return this;
    }

    public Result status(int status) {
        this.setStatus(status);
        return this;
    }
}
