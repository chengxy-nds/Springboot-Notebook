package com.fire.base;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * @author xiaofu
 * @description
 * @date 2020/7/24 15:36
 */
@Data
@Accessors(chain = true)
public class Resp<T> implements Serializable {

    /**
     * The constant serialVersionUID.
     */
    private static final long serialVersionUID = -1L;
    /**
     * The constant OK_CODE.
     */
    public static final Integer OK_CODE = 200;
    /**
     * The constant OK_MESSAGE.
     */
    public static final String OK_MESSAGE = "OK";
    /**
     * 结果代码（200：成功，-1000：参数验证不通过，其他：系统异常）
     */
    private Integer code;
    /**
     * 结果提示信息
     */
    private String message;
    /**
     * 结果数据
     */
    private T data;

    /**
     * Is ok boolean.
     * 是否成功
     * 2xx表示成功
     *
     * @return the boolean
     * @author xiaofu
     * @date 2019年02月22日 13时04分11秒
     */
    public boolean isOk() {
        return Integer.valueOf(2).equals(this.getCode() / 100);
    }

    /**
     * Ok resp.
     *
     * @param <D>  the type parameter
     * @param data the data
     * @return the ret
     * @author xiaofu
     * @date 2019年02月14日 19时15分30秒
     */
    public static <D> Resp<D> ok(D data) {
        return new Resp<D>()
                .setCode(OK_CODE)
                .setMessage(OK_MESSAGE)
                .setData(data);
    }
    /**
     * Error resp.
     *
     * @param <D>         the type parameter
     * @param code        the code
     * @param message     the message
     * @return the ret
     * @author xiaofu
     * @date 2019年02月14日 19时16分55秒
     */
    public static <D> Resp<D> error(Integer code, String message) {
        return new Resp<D>()
                .setCode(code)
                .setMessage(message);
    }

    /**
     * Of resp.
     *
     * @param <D>     the type parameter
     * @param code    the code
     * @param message the message
     * @param data    the data
     * @return the resp
     * @author xiaofu
     * @date 2019年02月28日 21时16分17秒
     */
    public static <D> Resp<D> of(Integer code, String message, D data) {
        return of(code, message, data);
    }

    /**
     * Error resp.
     *
     * @param <D>  the type parameter
     * @param resp the resp
     * @return the resp
     * @author xiaofu
     * @date 2019年03月14日 21时09分42秒
     */
    public static <D, E> Resp<D> error(Resp<E> resp) {
        return Resp.error(resp.getCode(), resp.getMessage());
    }
}
