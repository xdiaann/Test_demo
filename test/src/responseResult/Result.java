package responseResult;

import lombok.Data;

/**
 * @author MR.Z
 * @date 2019/12/18 10:44
 */
@Data
public final class Result<T> {
    private int code;
    private String msg;
    private T data;

    public Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result(T data) {
        this.data = data;
        this.code = 200;
        this.msg = "ok";
    }

    public static <T> Result<T> ok(T data) {
        return new Result<>(200, "ok", data);
    }
    public static <T> Result<T> ok() {
        return new Result<>(200, "ok", null);
    }
}
