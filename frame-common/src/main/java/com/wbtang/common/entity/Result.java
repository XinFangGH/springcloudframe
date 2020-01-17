package com.wbtang.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 通用返回类
 *
 * @author TangWenBo
 * @date 2019/12/25
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    private int code;
    private String msg;
    private T data;

    private Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private Result(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
    }

    private Result(ResultCode resultCode, T data) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
        this.data = data;
    }


    /**
     * 快速构造成功信息
     *
     * @return com.wbtang.framecommon.entity.Result
     * @author TangWenBo
     * @date 2019/12/25 15:48
     */
    public static Result success() {
        return new Result(ResultCode.SUCCESS);
    }

    public static Result success(Object data) {
        return new Result<>(ResultCode.SUCCESS, data);
    }

    /**
     * 快速构造系统异常信息
     *
     * @return com.wbtang.framecommon.entity.Result
     * @author TangWenBo
     * @date 2019/12/25 15:49
     */
    public static Result error() {
        return new Result(ResultCode.ERROR);
    }

    /**
     * 快速构造业务异常信息
     *
     * @return com.wbtang.framecommon.entity.Result
     * @author TangWenBo
     * @date 2019/12/25 16:06
     */
    public static Result fail() {
        return new Result(ResultCode.FAILURE);
    }

    public static Result fail(String msg) {
        return new Result(ResultCode.FAILURE.getCode(), msg);
    }

    public static Result fail(int code, String msg) {
        return new Result(code, msg);
    }
}
