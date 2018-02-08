package dto;

import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * @author  xieyucheng
 * @create  2018/2/8 15:24
 * @desc   返回结果封装
 **/
public class Result extends HashMap<String, Object> {

    public Result() {
        put("code", HttpStatus.OK.value());
    }

    public static Result error() {
        return error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "系统出现异常");
    }

    public static Result error(String msg) {
        return error(HttpStatus.INTERNAL_SERVER_ERROR.value(), msg);
    }

    public static Result error(int code, String msg) {
        Result r = new Result();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static Result ok(String msg) {
        Result r = new Result();
        r.put("msg", msg);
        return r;
    }

    public static Result ok(Map<String, Object> map) {
        Result r = new Result();
        r.putAll(map);
        return r;
    }

    public static Result ok() {
        return new Result();
    }

    public static Result buildSuccessData(Object value) {
        return ok().put("data", value);
    }

    public Result put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
