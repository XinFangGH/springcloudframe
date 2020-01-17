package com.wbtang.common.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 返回结果枚举类
 *
 * @author TangWenBo
 * @date 2019/12/25
 */
@Getter
@AllArgsConstructor
public enum ResultCode {
    /**
     * 成功
     */
    SUCCESS(200, "操作成功"),
    /**
     * 失败
     */
    ERROR(500, "服务器系统异常"),
    /**
     * 业务异常
     */
    FAILURE(400, "业务异常"),
    UN_AUTHORIZED(401, "请求未授权"),
    PARAM_MISS(400, "缺少必要的请求参数"),
    PARAM_TYPE_ERROR(400, "请求参数类型错误"),
    PARAM_BIND_ERROR(400, "请求参数绑定错误"),
    PARAM_VALID_ERROR(400, "参数校验失败");

    private int code;
    private String msg;
}
