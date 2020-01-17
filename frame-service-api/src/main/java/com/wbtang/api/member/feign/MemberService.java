package com.wbtang.api.member.feign;

import com.wbtang.api.member.MemberApi;
import com.wbtang.api.member.feign.hystrix.MemberHystrix;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * feign微服务
 *
 * @author TangWenBo
 * @date 2019/12/23
 */
@FeignClient(value = "member", fallback = MemberHystrix.class)
public interface MemberService extends MemberApi {
}
